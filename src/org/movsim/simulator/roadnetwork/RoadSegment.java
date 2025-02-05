/*
 * Copyright (C) 2010, 2011, 2012 by Arne Kesting, Martin Treiber, Ralph Germ, Martin Budden
 * <movsim.org@gmail.com>
 * -----------------------------------------------------------------------------------------
 * 
 * This file is part of
 * 
 * MovSim - the multi-model open-source vehicular-traffic simulator.
 * 
 * MovSim is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MovSim is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MovSim. If not, see <http://www.gnu.org/licenses/>
 * or <http://www.movsim.org>.
 * 
 * -----------------------------------------------------------------------------------------
 */

package org.movsim.simulator.roadnetwork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.movsim.network.autogen.opendrive.Lane.Speed;
import org.movsim.network.autogen.opendrive.OpenDRIVE.Road.ElevationProfile;
import org.movsim.output.detector.LoopDetectors;
import org.movsim.roadmappings.RoadMapping;
import org.movsim.simulator.MovsimConstants;
import org.movsim.simulator.trafficlights.TrafficLightLocation;
import org.movsim.simulator.vehicles.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import fr.ifsttar.licit.simulator.agents.AgentType;
import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensor;
import fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure.RSUBroadcaster;
import fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure.RSUDevice;
import fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure.RSULoopDetector;
import fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure.control.RSUController;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.CommunicationDevice;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.MeasurementSensor;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.VehicleSensor;
import fr.ifsttar.licit.simulator.environment.PerceptiblePartition;
import fr.ifsttar.licit.simulator.infrastructure.RoadSideUnit;
import maop.MaopVehicle;

/**
 * <p>
 * A RoadSegment is a unidirectional stretch of road that contains a number of lane segments. A bidirectional stretch of road may be created
 * by combining two road segments running in opposite directions.
 * </p>
 * <p>
 * RoadSegments may be combined to form a road network.
 * </p>
 * <p>
 * A RoadSegment is normally connected to two other road segments: a source road from which vehicles enter the road segment and a sink road
 * to which vehicles exit. RoadSegments at the edge of the network will normally be connected to only one other road segment: traffic inflow
 * and outflow will be controlled directly by source and sink objects.
 * </p>
 * <p>
 * RoadSegments are connected to each other on a lane-wise basis: each sink (outgoing) lane of a road segment may be connected to a source
 * (incoming) lane of another road segment. This allows the forking and merging of road segments, the creation of on-ramps and off-ramps. By
 * connecting the lanes of a number of road segments in this way, complex junctions and interchanges may be created.
 * </p>
 * <p>
 * A RoadSegment is a logical entity, not a physical one. That is a RoadSegment does not know if it is straight or winding, it just knows
 * about the vehicles it contains and what it is connected to. A vehicle's coordinates on a RoadsSegment are given by the vehicle's position
 * relative to the start of the RoadSegment and the vehicle's lane.
 * </p>
 * <p>
 * A RoadSegment has <code>laneCount</code> lanes. Lanes within a RoadSegment are represented by the LaneSegment class.
 * </p>
 * <p>
 * The mapping from a position on a RoadSegment to coordinates in physical space is determined by a RoadSegment's RoadMapping. Although the
 * RoadMapping is primarily used by software that draws the road network and the vehicles upon it, elements of the RoadMapping may influence
 * vehicle behavior, in particular a road's curvature and its gradient.
 * </p>
 */
// TODO avoid iterating also over AgentType.OBSTACLE at lane ends.
public class RoadSegment extends DefaultWeightedEdge implements Iterable<Vehicle>, PerceptiblePartition {

    private static final long serialVersionUID = -2991922063982378462L;

    private static final Logger LOG = LoggerFactory.getLogger(RoadSegment.class);

    public static final int ID_NOT_SET = -1;
    public static final int INITIAL_ID = 1;
    private static int nextId = INITIAL_ID;

    /** the id is an internally used unique identifier for the road. */
    private final int id;
    /** the userId is the id specified in the .xodr and .xml files. */
    private String userId;
    /** road name specified in the openDrive .xodr network file. */
    private String roadName;

    private final double roadLength;
    /** total length of road up to start of segment. */
    private final double cumulativeRoadLength = -1.0;
    private final int laneCount;
    private final LaneSegment laneSegments[];
    private LoopDetectors loopDetectors;
    
    /**
     * 
     */
    private List<RoadSideUnit> rsus = new ArrayList<RoadSideUnit>();
    public List<RoadSideUnit> getRSUs(){
    	return this.rsus;
    }
    /**
     * 
     */
    private FlowConservingBottlenecks flowConservingBottlenecks;
    private SortedSet<TrafficLightLocation> trafficLightLocations = new TreeSet<>(
            new Comparator<TrafficLightLocation>() {
                @Override
                public int compare(TrafficLightLocation a, TrafficLightLocation b) {
                    if (a != b && Double.compare(a.position(), b.position()) == 0) {
                        throw new IllegalStateException("cannot have identical trafficlight positions=" + a.position());
                    }
                    return Double.compare(a.position(), b.position());
                }
            });

    private SpeedLimits speedLimits;
    private Slopes slopes;
    private VariableMessageSigns variableMessageSigns;

    // Sources and Sinks
    private AbstractTrafficSource trafficSource = null;
    private TrafficSink sink;
    private RoadMapping roadMapping;

    /** simple ramp with dropping mechanism */
    private SimpleRamp simpleRamp;

    public static class TestCar {
        public double s = 0.0; // distance
        public double vdiff = 0.0; // approaching rate
        public double vel = 0.0; // velocity
        public double acc = 0.0; // acceleration
    }

    /**
     * Resets the next id.
     */
    public static void resetNextId() {
        nextId = INITIAL_ID;
    }

    /**
     * Returns the number of road segments that have been created. Used for instrumentation.
     * 
     * @return the number of road segment that have been created
     */
    public static int count() {
        return nextId - INITIAL_ID;
    }

    /**
     * Constructor.
     * 
     * @param roadLength
     *            road length, in meters.
     * @param laneCount
     *            number of lanes in this road segment
     */
    public RoadSegment(double roadLength, int laneCount) {
        assert roadLength > 0.0;
        assert laneCount >= 1;
        laneSegments = new LaneSegment[laneCount];
        for (int index = 0; index < laneCount; ++index) {
            laneSegments[index] = new LaneSegment(this, index + 1);
        }
        id = nextId++;
        assert roadLength > 0;
        this.roadLength = roadLength;
        this.laneCount = laneCount;
    }

    /**
     * Convenience constructor, creates road segment based on a given road mapping.
     * 
     * @param roadMapping
     */
    public RoadSegment(RoadMapping roadMapping) {
        this(roadMapping.roadLength(), roadMapping.laneCount());
        assert roadMapping.trafficLaneMin() == Lanes.LANE1;
        assert roadMapping.trafficLaneMax() == laneCount;
        this.roadMapping = roadMapping;
    }

    /**
     * Sets a default sink for this road segment.
     */
    public final void addDefaultSink() {
        sink = new TrafficSink(this);
    }

    /**
     * Returns this road segment's id
     * 
     * @return this road segment's id
     */
    public final int id() {
        return id;
    }

    /**
     * Set this road segment's userId
     * 
     * @param userId
     * 
     */
    public final void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Returns this road segment's userId. The userId is the road's id as set in the .xodr and .xml files.
     * 
     * @return this road segment's userId
     */
    public final String userId() {
        return userId == null ? Integer.toString(id) : userId;
    }

    /**
     * Returns this road segment's road mapping.
     * 
     * @return this road segment's road mapping
     */
    public final RoadMapping roadMapping() {
        assert roadMapping != null;
        return roadMapping;
    }

    /**
     * Sets this road segment's road mapping.
     * 
     * @param roadMapping
     */
    public final void setRoadMapping(RoadMapping roadMapping) {
        this.roadMapping = roadMapping;
    }

    /**
     * Returns the traffic source (upstream boundary) for this road segment.
     * 
     * @return the traffic source
     */
    public final AbstractTrafficSource trafficSource() {
        return trafficSource;
    }

    /**
     * Sets the traffic source (upstream boundary) for this road segment.
     * 
     * @param trafficSource
     *            the traffic source
     */
    public final void setTrafficSource(AbstractTrafficSource trafficSource) {
        /*Preconditions.checkArgument(this.trafficSource == null, "roadSegment=" + id()
                + " already has a traffic source.");*/
        this.trafficSource = trafficSource;
    }

    /**
     * Returns the traffic sink for this road segment.
     * 
     * @return the traffic sink
     */
    public final TrafficSink sink() {
        return sink;
    }

    /**
     * Sets the traffic sink for this road segment.
     * 
     * @param sink
     *            the traffic sink
     */
    public final void setSink(TrafficSink sink) {
        this.sink = sink;
    }

    /**
     * Returns this road segment's length.
     * 
     * @return road segment length in meters
     */
    public final double roadLength() {
        return roadLength;
    }

    public final double cumulativeRoadLength() {
        // if (cumulativeRoadLength >= 0.0) {
        // return cumulativeRoadLength;
        // }
        // final RoadSegment sourceRoadSegment = sourceRoadSegment(trafficLaneMax() - 1);
        // cumulativeRoadLength = sourceRoadSegment == null ? 0.0 : sourceRoadSegment.cumulativeRoadLength() +
        // sourceRoadSegment.roadLength();
        return cumulativeRoadLength;
    }

    /**
     * Returns the number of lanes in this road segment.
     * 
     * @return number of lanes
     */
    public final int laneCount() {
        return laneCount;
    }

    /**
     * Sets the type of the given lane.
     * 
     * @param lane
     * @param laneType
     */
    public void setLaneType(int lane, Lanes.Type laneType) {
        laneSegments[lane - 1].setType(laneType);
        if (roadMapping != null) {
            roadMapping.setTrafficLaneMin(trafficLaneMin());
            roadMapping.setTrafficLaneMax(trafficLaneMax());
        }
    }

    /**
     * Returns the type of the given lane.
     * 
     * @param lane
     * 
     * @return type of lane
     */
    public Lanes.Type laneType(int lane) {
        return laneSegments[lane].type();
    }

    /**
     * Returns the minimum traffic lane (that is not an entry or exit lane).
     * 
     * @return the minimum traffic lane
     */
    public int trafficLaneMin() {
        int trafficLaneMin = Lanes.MOST_INNER_LANE;
        while (laneSegments[trafficLaneMin - 1].type() != Lanes.Type.TRAFFIC) {
            ++trafficLaneMin;
        }
        return trafficLaneMin;
    }

    /**
     * Returns the maximum traffic lane (that is not an entry or exit lane).
     * 
     * @return the maximum traffic lane
     */
    public int trafficLaneMax() {
        int trafficLaneMax = laneCount;
        while (laneSegments[trafficLaneMax - 1].type() != Lanes.Type.TRAFFIC) {
            --trafficLaneMax;
        }
        return trafficLaneMax;
    }

    public final LaneSegment laneSegment(int lane) {
        Preconditions.checkArgument(lane >= Lanes.LANE1 && lane <= laneCount, "lane=" + lane);
        //System.out.println("laneCount = " + laneCount + " , lane1 = " + Lanes.LANE1);
        return laneSegments[lane - 1];
    }

    public final void setSourceLaneSegmentForLane(LaneSegment sourceLaneSegment, int lane) {
        Preconditions.checkArgument(lane >= Lanes.LANE1 && lane <= laneCount);
        laneSegments[lane - 1].setSourceLaneSegment(sourceLaneSegment);
    }

    public final LaneSegment sourceLaneSegment(int lane) {
        Preconditions.checkArgument(lane >= Lanes.LANE1 && lane <= laneCount);
        return laneSegments[lane - 1].sourceLaneSegment();
    }

    public final RoadSegment sourceRoadSegment(int lane) {
        Preconditions.checkArgument(lane >= Lanes.LANE1 && lane <= laneCount);
        if (laneSegments[lane - 1].sourceLaneSegment() == null) {
            return null;
        }
        return laneSegments[lane - 1].sourceLaneSegment().roadSegment();
    }

    public final int sourceLane(int lane) {
        Preconditions.checkArgument(lane >= Lanes.LANE1 && lane <= laneCount);
        if (laneSegments[lane - 1].sourceLaneSegment() == null) {
            return Lanes.NONE;
        }
        return laneSegments[lane - 1].sourceLaneSegment().lane();
    }

    public final void setSinkLaneSegmentForLane(LaneSegment sinkLaneSegment, int lane) {
        Preconditions.checkArgument(lane >= Lanes.LANE1 && lane <= laneCount);
        laneSegments[lane - 1].setSinkLaneSegment(sinkLaneSegment);
    }

    public final LaneSegment sinkLaneSegment(int lane) {
        Preconditions.checkArgument(lane >= Lanes.LANE1 && lane <= laneCount);
        return laneSegments[lane - 1].sinkLaneSegment();
    }

    public final RoadSegment sinkRoadSegment(int lane) {
        Preconditions.checkArgument(lane >= Lanes.LANE1 && lane <= laneCount, "lane=" + lane + " but lanecount="
                + laneCount);
        if (laneSegments[lane - 1].sinkLaneSegment() == null) {
            return null;
        }
        return laneSegments[lane - 1].sinkLaneSegment().roadSegment();
    }

    public final int sinkLane(int lane) {
        Preconditions.checkArgument(lane >= Lanes.LANE1 && lane <= laneCount);
        if (laneSegments[lane - 1].sinkLaneSegment() == null) {
            return Lanes.NONE;
        }
        return laneSegments[lane - 1].sinkLaneSegment().lane();
    }

    public boolean exitsOnto(int exitRoadSegmentId) {
        for (final LaneSegment laneSegment : laneSegments) {
            if (laneSegment.type() == Lanes.Type.EXIT) {
                if (laneSegment.sinkLaneSegment().roadSegment().id() == exitRoadSegmentId) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Clears this road segment of any vehicles.
     */
    public void clearVehicles() {
        for (final LaneSegment laneSegment : laneSegments) {
            laneSegment.clearVehicles();
        }
    }

    /**
     * Returns the number of vehicles on this road segment, all lanes.
     * 
     * @return the total number of vehicles on this road segment
     */
    public int getVehicleCount() {
        int vehicleCount = 0;
        for (final LaneSegment laneSegment : laneSegments) {
            vehicleCount += laneSegment.vehicleCount();
        }
        return vehicleCount;
    }

    public int getStoppedVehicleCount() {
        int stoppedVehicleCount = 0;
        for (final LaneSegment laneSegment : laneSegments) {
            stoppedVehicleCount += laneSegment.stoppedVehicleCount();
        }
        return stoppedVehicleCount;
    }

    /**
     * Returns the number of obstacle vehicles on this road segment, all lanes.
     * 
     * @return the total number of vehicles on this road segment
     */
    public int getObstacleCount() {
        int obstacleCount = 0;
        for (final LaneSegment laneSegment : laneSegments) {
            obstacleCount += laneSegment.obstacleCount();
        }
        return obstacleCount;
    }

    /**
     * Returns the number of vehicles in the given lane on this road segment.
     * 
     * @param lane
     * 
     * @return the number of vehicles in the given lane on this road segment
     */
    public int getVehicleCount(int lane) {
        Preconditions.checkArgument(lane >= Lanes.LANE1 && lane <= laneCount);
        return laneSegments[lane - 1].vehicleCount();
    }

    /**
     * Returns the total travel time of all vehicles on this road segment, all lanes.
     * 
     * @return the total vehicle travel time
     */
    protected double totalVehicleTravelTime() {
        double totalVehicleTravelTime = 0;
        for (final LaneSegment laneSegment : laneSegments) {
            totalVehicleTravelTime += laneSegment.totalVehicleTravelTime();
        }
        return totalVehicleTravelTime;
    }

    /**
     * Returns the total travel distance of all vehicles on this road segment, all lanes.
     * 
     * @return the total vehicle travel distance
     */
    protected double totalVehicleTravelDistance() {
        double totalVehicleTravelDistance = 0;
        for (final LaneSegment laneSegment : laneSegments) {
            totalVehicleTravelDistance += laneSegment.totalVehicleTravelDistance();
        }
        return totalVehicleTravelDistance;
    }

    /**
     * Returns the total fuel used by all vehicles on this road segment, all lanes.
     * 
     * @return the total vehicle fuel used
     */
    protected double totalVehicleFuelUsedLiters() {
        double totalVehicleFuelUsedLiters = 0;
        for (final LaneSegment laneSegment : laneSegments) {
            totalVehicleFuelUsedLiters += laneSegment.totalVehicleFuelUsedLiters();
        }
        return totalVehicleFuelUsedLiters;
    }

    protected double instantaneousConsumptionLitersPerSecond() {
        double vehicleFuelUsedLiters = 0;
        for (final LaneSegment laneSegment : laneSegments) {
            vehicleFuelUsedLiters += laneSegment.instantaneousFuelUsedLitersPerS();
        }
        return vehicleFuelUsedLiters;
    }

    public double meanSpeed() {
        double sumSpeed = 0;
        int vehCount = 0;
        for (final LaneSegment laneSegment : laneSegments) {
            for (Vehicle veh : laneSegment) {
                if (veh.type() == AgentType.OBSTACLE) {
                    continue;
                }
                sumSpeed += veh.getSpeed();
                ++vehCount;
            }
        }
        return (vehCount > 0) ? sumSpeed / vehCount : MovsimConstants.FREE_SPEED;
    }

    /**
     * Returns the instantaneous travel time defined by the road element length and current mean speed of all vehicles.
     * An adhoc free speed is assumed in case of an empty road.
     * 
     * @return instantantaneous travel time with adhoc assumed travel time if road is empty
     */
    public double instantaneousTravelTime() {
        return roadLength / meanSpeed();
    }

    /**
     * Returns the number of obstacles on this road segment.
     * 
     * @return the number of obstacles on this road segment
     */
    protected int obstacleCount() {
        int obstacleCount = 0;
        for (final LaneSegment laneSegment : laneSegments) {
            obstacleCount += laneSegment.obstacleCount();
        }
        return obstacleCount;
    }

    /**
     * <p>
     * Returns the vehicle at the given index in the given lane.
     * </p>
     * 
     * <p>
     * In each lane vehicles are sorted in order of decreasing position:
     * </p>
     * 
     * <p>
     * V[n+1].pos < V[n].pos < V[n-1].pos ... < V[1].pos < V[0].pos
     * </p>
     * 
     * @param lane
     * @param index
     * 
     * @return vehicle at given index in the given lane
     */
    public Vehicle getVehicle(int lane, int index) {
        return laneSegments[lane - 1].getVehicle(index);
    }

    /**
     * Removes the front vehicle on the given lane.
     * 
     * @param lane
     */
    public void removeFrontVehicleOnLane(int lane) {
        laneSegments[lane - 1].removeFrontVehicleOnLane();
    }

    /**
     * Removes any vehicles that have moved past the end of this road segment.
     * 
     * @return the number of vehicles removed
     */
    public int removeVehiclesPastEnd() {
        int removedVehicleCount = 0;
        for (final LaneSegment laneSegment : laneSegments) {
            removedVehicleCount += laneSegment.removeVehiclesPastEnd(sink);
        }
        return removedVehicleCount;
    }

    /**
     * Returns all vehicles that have moved past the end of this road segment.
     * 
     * @return the number of vehicles removed
     */
    public Iterable<Vehicle> getVehiclesPastEnd() {
        ArrayList<Vehicle> vehiclesPastEnd = new ArrayList<>();
        for (final LaneSegment laneSegment : laneSegments) {
            vehiclesPastEnd.addAll(laneSegment.getVehiclesPastEnd(sink));
        }
        return vehiclesPastEnd;
    }

    /**
     * Adds an obstacle to this road segment.
     * 
     * @param obstacle
     */
    public void addObstacle(Vehicle obstacle) {
        assert obstacle.type() == AgentType.OBSTACLE;
        obstacle.setRoadSegment(id, roadLength);
        addVehicle(obstacle);
    }

    /**
     * Adds a vehicle to this road segment.
     * 
     * @param vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        vehicle.setRoadSegment(id, roadLength);
        laneSegments[vehicle.lane() - 1].addVehicle(vehicle);
    }

    /**
     * Adds a vehicle to the start of this road segment.
     * 
     * @param vehicle
     */
    public void appendVehicle(Vehicle vehicle) {
        vehicle.setRoadSegment(id, roadLength);
        laneSegments[vehicle.lane() - 1].appendVehicle(vehicle);
    }

    /**
     * Updates the road conditions.
     * 
     * @param dt
     *            delta-t, simulation time interval, seconds
     * @param simulationTime
     *            current simulation time, seconds
     * @param iterationCount
     *            the number of iterations that have been executed
     */
    public void updateRoadConditions(double dt, double simulationTime, long iterationCount) {
        applySpeedLimits();
        applySlopes();
        applyVariableMessageSigns();
    }

    /**
     * finds the next traffic light in downstream direction relative to the given position. Returns null if there is no
     * traffic light located.
     * 
     * @param position
     * @return the next downstream traffic or null
     */
    TrafficLightLocation getNextDownstreamTrafficLight(double position) {
        for (TrafficLightLocation trafficLightLocation : trafficLightLocations) {
            double distance = trafficLightLocation.position() - position;
            if (distance > 0) {
                // !!! assume that traffic lights are sorted with increasing position
                // so that first traffic light can be considered as the next downstream one
                return trafficLightLocation;
            }
        }
        return null;
    }

    // TODO profiling ... lookup done quite often even w/o any trafficlights
    public TrafficLightLocationWithDistance getNextDownstreamTrafficLight(double position, int lane,
            double maxLookAheadDistance) {
        TrafficLightLocation trafficLightLocation = getNextDownstreamTrafficLight(position);
        double distance = (trafficLightLocation != null) ? trafficLightLocation.position() - position : roadLength
                - position;
        RoadSegment segment = this;
        while (trafficLightLocation == null && distance < maxLookAheadDistance) {
            segment = segment.sinkRoadSegment(Math.min(lane, segment.laneCount));
            if (segment == null) {
                break;
            }
            trafficLightLocation = segment.getNextDownstreamTrafficLight(0);
            distance += (trafficLightLocation != null) ? trafficLightLocation.position() : segment.roadLength();
        }
        return trafficLightLocation == null ? null : new TrafficLightLocationWithDistance(trafficLightLocation,
                distance);
    }

    private void applySpeedLimits() {
        if (speedLimits != null && speedLimits.isEmpty() == false) {
            for (final LaneSegment laneSegment : laneSegments) {
                for (final Vehicle vehicle : laneSegment) {
                    assert vehicle.roadSegmentId() == id;
                    speedLimits.apply(vehicle);
                }
            }
        }
    }

    private void applySlopes() {
        if (slopes != null && slopes.isEmpty() == false) {
            for (final LaneSegment laneSegment : laneSegments) {
                for (final Vehicle vehicle : laneSegment) {
                    assert vehicle.roadSegmentId() == id;
                    slopes.apply(vehicle);
                }
            }
        }
    }

    private void applyVariableMessageSigns() {
        if (variableMessageSigns != null && variableMessageSigns.isEmpty() == false) {
            for (final LaneSegment laneSegment : laneSegments) {
                for (final Vehicle vehicle : laneSegment) {
                    assert vehicle.roadSegmentId() == id;
                    variableMessageSigns.apply(vehicle, this);
                }
            }
        }
    }

    public void addVariableMessageSign(VariableMessageSignBase variableMessageSign) {
        if (variableMessageSigns == null) {
            variableMessageSigns = new VariableMessageSigns();
        }
        variableMessageSigns.add(variableMessageSign);
        for (final LaneSegment laneSegment : laneSegments) {
            for (final Vehicle vehicle : laneSegment) {
                assert vehicle.roadSegmentId() == id;
                variableMessageSign.apply(vehicle, this);
            }
        }
    }

    public void removeVariableMessageSign(VariableMessageSignBase variableMessageSign) {
        assert variableMessageSigns != null;
        for (final LaneSegment laneSegment : laneSegments) {
            for (final Vehicle vehicle : laneSegment) {
                assert vehicle.roadSegmentId() == id;
                variableMessageSign.cancel(vehicle, this);
            }
        }
        variableMessageSigns.remove(variableMessageSign);
    }

    /**
     * 
     * 
     * 
     * @param dt
     * 		 delta-t, simulation time interval, seconds
     * @param simulationTime
     * 		 current simulation time, seconds
     * @param iterationCount
     * 		the number of iterations that have been executed
     * 
     * @author gueriau
     */
    public void computePerception(RoadNetwork network, double simulationTime/*double dt, double simulationTime, long iterationCount*/) {
    	 for (final LaneSegment laneSegment : laneSegments) {
             assert laneSegment.laneIsSorted();
             assert laneSegment.assertInvariant();
     
             for (final Vehicle vehicle : laneSegment) {
                 //final double x = vehicle.getFrontPosition();
                 //final double alphaT = (flowConservingBottlenecks == null) ? 1 : flowConservingBottlenecks.alphaT(x);
                 //final double alphaV0 = (flowConservingBottlenecks == null) ? 1 : flowConservingBottlenecks.alphaV0(x);
                
     
                 vehicle.resetPerception();
                 
                 
                 
         
                 // agreggate perception computed by each sensor
                 for(Sensor sensor : vehicle.getSensors()){
                	 //System.out.println(sensor.getClass());
                	 if(sensor instanceof VehicleSensor){
                		 vehicle.addPerception(sensor.percieve(vehicle, laneSegment, this, network, simulationTime));
                	 } else if (sensor instanceof MeasurementSensor){
                		 vehicle.addPerception(sensor.percieve(vehicle, laneSegment, this, network, simulationTime));
                	 }
                 }
                 
                 vehicle.addSelfPerception();
                 
                 //transfer received messages to vehicle message box
                 //vehicle.recieveMessages();
  
             }
             
         }
    	 
    	 for(final RoadSideUnit rsu : this.rsus){
	     	for(Sensor sensor : rsu.getSensors()){
	           	 if(sensor instanceof RSULoopDetector){
	           		 rsu.addPerception(((RSULoopDetector)sensor).perceive(rsu, this, simulationTime));
	           	 } else if ( sensor instanceof RSUController) {
	           		 rsu.addPerception(((RSUController)sensor).perceive(rsu, this, network));
	           	 }
	        }
	     }
	}
    
    /**
     * 
     * @param network
     */
    public void computeCommunication(RoadNetwork network, double simulationTime) {
   	 
    	/**
    	 * Two steps are needed : 
    	 * first, infrastructure gather information, and then vehicles get it
    	 */
    	for(final RoadSegment roadSegment : network) {
	    	for(final RoadSideUnit rsu : roadSegment.rsus){
		     	for(Sensor sensor : rsu.getSensors()){
		           	 if(sensor instanceof RSUDevice){
		           		rsu.addPerception(((RSUDevice)sensor).perceive(rsu, this, roadSegment));
		           	 } else if(sensor instanceof RSUBroadcaster){
		           		rsu.addPerception(((RSUBroadcaster)sensor).perceive(rsu, this));
		           	 }
		        }
		     }
    	}
    	
    	
    	for (final LaneSegment laneSegment : laneSegments) {
            assert laneSegment.laneIsSorted();
            assert laneSegment.assertInvariant();
            
            
            for (final Vehicle vehicle : laneSegment) {
                // agreggate perception computed by each sensor
                for(Sensor sensor : vehicle.getSensors()){
		           	 if(sensor instanceof CommunicationDevice){
		           		 vehicle.addPerception(sensor.percieve(vehicle, laneSegment, this, network, simulationTime));
		           	 }
                }
                
             
                
            }
           
        }
	}
 

	public LaneSegment getRightLane(final int currentLane){
    	LaneSegment rightLane = null;
    	if (currentLane + Lanes.TO_RIGHT <= this.trafficLaneMax()) {
    	   	 rightLane = this.laneSegment(currentLane + Lanes.TO_RIGHT);
    	}
    	return rightLane;
    }
    
    public LaneSegment getLeftLane(final int currentLane){
    	LaneSegment leftLane = null;
        
        if (currentLane + Lanes.TO_LEFT >= Lanes.MOST_INNER_LANE) {
       	 leftLane = this.laneSegment(currentLane + Lanes.TO_LEFT);
        }
    	return leftLane;
    }
    
    
    /**
     * 
     * 
     * 
     * @param dt
     * 		 delta-t, simulation time interval, seconds
     * @param simulationTime
     * 		 current simulation time, seconds
     * @param iterationCount
     * 		the number of iterations that have been executed
     * 
     * @author gueriau
     */
    public void handleCommunication(/*double dt,*/ double simulationTime/*, long iterationCount*/) {
   	 for (final LaneSegment laneSegment : laneSegments) {
            assert laneSegment.laneIsSorted();
            assert laneSegment.assertInvariant();
    
            for (final Vehicle vehicle : laneSegment) {
   
                //transfer received messages to vehicle message box
                vehicle.recieveMessages();
 
                //handle received messages
                vehicle.setFrontVehicleId(laneSegment.frontVehicle(vehicle));//cheat
                vehicle.handleMessages(/*laneSegment.frontVehicle(vehicle) , */simulationTime);
            }
            
          
        }
   	 
	     for(final RoadSideUnit rsu : this.rsus){
	    	 //transfer received messages to vehicle message box
	    	 rsu.recieveMessages();
	
	         //handle received messages
	    	 rsu.handleMessages(/*null, */simulationTime);
	     }
	     
	}

    
    
    /**
     * Lanes change.
     * <p>
     * For each vehicle check if a lane change is desired and safe and, if so, make the lane change.
     * </p>
     * 
     * <p>
     * <code>makeLaneChanges</code> preserves the vehicle sort order, since only lateral movements of vehicles are made.
     * </p>
     * 
     * @param dt
     *            delta-t, simulation time interval, seconds
     * @param simulationTime
     *            current simulation time, seconds
     * @param iterationCount
     *            the number of iterations that have been executed
     */
    public void makeLaneChanges(double dt, double simulationTime, long iterationCount) {
        if (laneCount < 2) {
            // need at least 2 lanes for lane changing
            return;
        }
        // TODO assure priority for lane changes from slow to fast lanes
        for (final LaneSegment laneSegment : laneSegments) {
            assert laneSegment.assertInvariant();
            for (Iterator<Vehicle> vehIterator = laneSegment.iterator(); vehIterator.hasNext();) {
                Vehicle vehicle = vehIterator.next();
                assert vehicle.roadSegmentId() == id;
                if (vehicle.considerLaneChange(dt, this)) {
                    final int targetLane = vehicle.getTargetLane();
                    assert targetLane != Lanes.NONE;
                    assert laneSegments[targetLane - 1].type() != Lanes.Type.ENTRANCE;
                    // iteratorRemove avoids ConcurrentModificationException
                    vehIterator.remove();
                    vehicle.setLane(targetLane);
                    laneSegments[targetLane - 1].addVehicle(vehicle);
                }
            }
        }
    }

	public void makeDecisions(double dt, double simulationTime,
			long iterationCount) {
		
		
		for(RoadSideUnit rsu : this.getRSUs()){
			rsu.makeDecision(simulationTime, iterationCount);
		}
		
		for (final LaneSegment laneSegment : laneSegments) {
            assert laneSegment.laneIsSorted();
            assert laneSegment.assertInvariant();
           
            for (final Vehicle vehicle : laneSegment) {
            	vehicle.makeDecision(simulationTime,iterationCount);
            }
		}
	}
    
    /**
     * Accelerate.
     * 
     * @param dt
     *            delta-t, simulation time interval, seconds
     * @param simulationTime
     *            current simulation time, seconds
     * @param iterationCount
     *            the number of iterations that have been executed
     */
    public void updateVehicleAccelerations(double dt, double simulationTime, long iterationCount) {
       
    	
	    	for (final LaneSegment laneSegment : laneSegments) {
	            assert laneSegment.laneIsSorted();
	            assert laneSegment.assertInvariant();
	            // final int leftlane = laneSegment.getLaneIndex()+MovsimConstants.TO_LEFT;
	            final LaneSegment leftLaneSegment = null; // TODO get left laneIndex ( leftLaneIndex < vehContainers.size() ) ?
	                                                      // vehContainers.get(leftLaneIndex) : null;
	            for (final Vehicle vehicle : laneSegment) {
	                final double x = vehicle.getFrontPosition();
	                final double alphaT = (flowConservingBottlenecks == null) ? 1 : flowConservingBottlenecks.alphaT(x);
	                final double alphaV0 = (flowConservingBottlenecks == null) ? 1 : flowConservingBottlenecks.alphaV0(x);
	                // LOG.debug("i={}, x_pos={}", i, x);
	                // LOG.debug("alphaT={}, alphaV0={}", alphaT, alphaV0);
	                // TODO hack for testing acceleration behavior to exit
	                vehicle.updateAcceleration(dt, this, laneSegment, leftLaneSegment, alphaT, alphaV0);
	            }
	        }
    	
    }
    
    /**
     * Accelerate using perception (this includes reading and acting according to recently received messages)
     * 
     * @param dt
     *            delta-t, simulation time interval, seconds
     * @param simulationTime
     *            current simulation time, seconds
     * @param iterationCount
     *            the number of iterations that have been executed
     *            
     * @author gueriau
     */
    public void updateVehicleAccelerationsUsingPerception(double dt, double simulationTime, long iterationCount) {
       
    	
	    	
    	for (final LaneSegment laneSegment : laneSegments) {
            assert laneSegment.laneIsSorted();
            assert laneSegment.assertInvariant();
           
            
            final LaneSegment leftSegment = this.getLeftLane(laneSegment.lane());
           
            for (final Vehicle vehicle : laneSegment) {
            	
            	//if(this.id()!=2){ // FIXME: HACK
            		
	                final double x = vehicle.getFrontPosition();
	                final double alphaT = (flowConservingBottlenecks == null) ? 1 : flowConservingBottlenecks.alphaT(x);
	                final double alphaV0 = (flowConservingBottlenecks == null) ? 1 : flowConservingBottlenecks.alphaV0(x);
	
	               
	                vehicle.updateAccelerationUsingPerception(dt, this, laneSegment, leftSegment, alphaT, alphaV0);
            	//} else { // FIXME: HACK
            	//		vehicle.cheat(110.0 / 3.6d, 0.0); // FIXME: HACK
            	//} //FIXME: HACK

            }
        }
	    	
    }
    
    
    

    /**
     * Update the vehicle positions and velocities by calling vehicle.updatePositionAndSpeed for each vehicle.
     * 
     * @param dt
     *            delta-t, simulation time interval, seconds
     * @param simulationTime
     *            current simulation time, seconds
     * @param iterationCount
     *            the number of iterations that have been executed
     */
    public void updateVehiclePositionsAndSpeeds(double dt, double simulationTime, long iterationCount) {
        for (final LaneSegment laneSegment : laneSegments) {
            assert laneSegment.laneIsSorted();
            for (final Vehicle vehicle : laneSegment) {
                vehicle.updatePositionAndSpeed(dt);
            }
        }
    }

    /**
     * If there is a traffic sink, use it to perform any traffic outflow.
     * 
     * @param dt
     *            delta-t, simulation time interval, seconds
     * @param simulationTime
     *            current simulation time, seconds
     * @param iterationCount
     *            the number of iterations that have been executed
     */
    public void outFlow(double dt, double simulationTime, long iterationCount) {
        for (final LaneSegment laneSegment : laneSegments) {
            laneSegment.outFlow(dt, simulationTime, iterationCount);
            assert laneSegment.assertInvariant();
        }
        if (sink != null) {
            sink.timeStep(dt, simulationTime, iterationCount);
        }
    }

    /**
     * If there is a traffic source, use it to perform any traffic inflow.
     * 
     * @param dt
     *            delta-t, simulation time interval, seconds
     * @param simulationTime
     *            current simulation time, seconds
     * @param iterationCount
     *            the number of iterations that have been executed
     */
    public void inFlow(double dt, double simulationTime, long iterationCount) {
        assert eachLaneIsSorted();
        if (trafficSource != null) {
            trafficSource.timeStep(dt, simulationTime, iterationCount);
            assert assertInvariant();
        }
        if (simpleRamp != null) {
            simpleRamp.timeStep(dt, simulationTime, iterationCount);
        }
    }

    /**
     * Updates the detectors, if there are any.
     * 
     * @param dt
     *            delta-t, simulation time interval, seconds
     * @param simulationTime
     *            current simulation time, seconds
     * @param iterationCount
     *            the number of iterations that have been executed
     */
    public void updateDetectors(double dt, double simulationTime, long iterationCount) {
        if (loopDetectors != null) {
            loopDetectors.timeStep(dt, simulationTime, iterationCount);
        }
    }

    /**
     * Returns the rear vehicle on the given lane.
     * 
     * @param lane
     * @return the rear vehicle on the given lane
     */
    public Vehicle rearVehicleOnLane(int lane) {
        return laneSegments[lane - 1].rearVehicle();
    }

    /**
     * Finds the vehicle in the given lane immediately at or behind the given position.
     * 
     * @param lane
     *            lane in which to search
     * @return reference to the rear vehicle
     */
    public Vehicle rearVehicle(int lane, double vehiclePos) {
        return laneSegments[lane - 1].rearVehicle(vehiclePos);
    }

    public Vehicle rearVehicleOnSinkLanePosAdjusted(int lane) {
        return laneSegments[lane - 1].rearVehicleOnSinkLanePosAdjusted();
    }

    Vehicle secondLastVehicleOnSinkLanePosAdjusted(int lane) {
        return laneSegments[lane - 1].secondLastVehicleOnSinkLanePosAdjusted();
    }

    /**
     * Returns the front vehicle on the given lane.
     * 
     * @param lane
     * @return the front vehicle on the given lane
     */
    public Vehicle frontVehicleOnLane(int lane) {
        return laneSegments[lane - 1].frontVehicle();
    }

    /**
     * Returns the vehicle in front of the given vehicle in its lane.
     * 
     * @param vehicle
     * @return the next downstream vehicle in the lane
     */
    public Vehicle frontVehicleOnLane(Vehicle vehicle) {
        return laneSegments[vehicle.lane() - 1].frontVehicle(vehicle);
    }

    /**
     * Finds the vehicle in the given lane immediately in front of the given position. That is a vehicle such that
     * vehicle.positon() > vehicePos (strictly greater than). The vehicle whose position equals vehiclePos is deemed to
     * be in the rear.
     * 
     * @param lane
     *            lane in which to search
     * @return reference to the front vehicle
     */
    public Vehicle frontVehicle(int lane, double vehiclePos) {
        return laneSegments[lane - 1].frontVehicle(vehiclePos);
    }

    /**
     * Sets the speed limits for this road segment for all lanes (openDrive defines speed limits per lane)
     * 
     * @param list
     */
    public void setSpeedLimits(List<Speed> list) {
        this.speedLimits = new SpeedLimits(list);
    }

    /**
     * Returns an iterable over all the speed limits in the road segment.
     * 
     * @return an iterable over all the speed limits in the road segment
     */
    public Iterable<SpeedLimit> speedLimits() {
        return speedLimits;
    }

    /**
     * Sets the slopes for this road segment.
     * 
     * @param slopes
     */
    public void setElevationProfile(ElevationProfile elevationProfile) {
        this.slopes = new Slopes(elevationProfile.getElevation());

    }

    /**
     * Returns an iterable over all the slopes in the road segment.
     * 
     * @return an iterable over all the slopes in the road segment
     */
    public Iterable<Slope> slopes() {
        return slopes == null ? null : slopes;
    }

    /**
     * Returns an iterable over all the traffic lights in the road segment.
     * 
     * @return an iterable over all the traffic lights in the road segment
     */
    public Iterable<TrafficLightLocation> trafficLightLocations() {
        return trafficLightLocations;
    }

    /**
     * Returns true if each lane in the vehicle array is sorted.
     * 
     * @return true if each lane in the vehicle array is sorted
     */
    public boolean eachLaneIsSorted() {
        for (final LaneSegment laneSegment : laneSegments) {
            if (laneSegment.laneIsSorted() == false) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("synthetic-access")
    private class VehicleIterator implements Iterator<Vehicle>, Iterable<Vehicle> {
        int laneIndex;
        int index;
        int count;

        public VehicleIterator() {
        }

        @Override
        public boolean hasNext() {
            if (index < laneSegments[laneIndex].vehicleCount()) {
                return true;
            }
            int nextLane = laneIndex + 1;
            while (nextLane < laneCount) {
                if (laneSegments[nextLane].vehicleCount() > 0) {
                    return true;
                }
                ++nextLane;
            }
            final int vc = getVehicleCount();
            if (vc != count) {
                assert false;
            }
            return false;
        }

        @Override
        public Vehicle next() {
            if (index < laneSegments[laneIndex].vehicleCount()) {
                // get the next vehicle in the current lane
                ++count;
                return laneSegments[laneIndex].getVehicle(index++);
            }
            int nextLane = laneIndex + 1;
            while (nextLane < laneCount) {
                if (laneSegments[nextLane].vehicleCount() > 0) {
                    laneIndex = nextLane;
                    index = 0;
                    ++count;
                    return laneSegments[laneIndex].getVehicle(index++);
                }
                ++nextLane;
            }
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() not implemented.");
        }

        @Override
        public Iterator<Vehicle> iterator() {
            return new VehicleIterator();
        }
    }

    /**
     * Returns an iterator over all the vehicles in this road segment.
     * 
     * @return an iterator over all the vehicles in this road segment
     */
    @Override
    public final Iterator<Vehicle> iterator() {
        return new VehicleIterator();
    }

    /**
     * Check for inconsistencies.
     * 
     * @param iterationCount
     *            the iteration count
     * @param time
     *            the time
     * @param isWithCrashExit
     *            the is with crash exit
     */
    public void checkForInconsistencies(double time, long iterationCount, boolean isWithCrashExit) {
        for (final LaneSegment laneSegment : laneSegments) {
            int index = -1;
            for (Vehicle vehicle : laneSegment) {
                index++;
                if (vehicle.type() == AgentType.OBSTACLE) {
                    continue;
                }
                final Vehicle vehFront = laneSegment.frontVehicle(vehicle);
                final double netDistance = vehicle.getNetDistance(vehFront);
                if (netDistance < 0) {
                    LOG.error("Crash happened!!!");
                    final StringBuilder sb = new StringBuilder("\n");
                    sb.append(String.format("Crash of Vehicle i=%d (id=%d) at x=%.4f ", index, vehicle.getId(),
                            vehicle.getFrontPosition()));
                    if (vehFront != null) {
                        sb.append(String.format("with veh (id=%d) in front at x=%.4f on lane=%d\n", vehFront.getId(),
                                vehFront.getFrontPosition(), vehicle.lane()));
                    }
                    sb.append("roadID=").append(id);
                    sb.append(", user roadID=").append(userId);
                    sb.append(", net distance=").append(netDistance);
                    sb.append(", lane=").append(laneSegment.lane());
                    sb.append(", container.size=").append(laneSegment.vehicleCount());
                    sb.append(", obstacles=").append(laneSegment.obstacleCount());
                    sb.append("\n");

                    for (int j = Math.max(0, index - 8), M = laneSegment.vehicleCount(); j <= Math
                            .min(index + 8, M - 1); j++) {
                        final Vehicle veh = laneSegment.getVehicle(j);
                        sb.append(String
                                .format("veh=%d, pos=%6.2f, speed=%4.2f, accModel=%4.3f, acc=%4.3f, length=%3.1f, lane=%d, id=%d%n",
                                        j, veh.getFrontPosition(), veh.getSpeed(), veh.accModel(), veh.getAcc(),
                                        veh.getLength(), veh.lane(), veh.getId()));
                    }
                    LOG.error(sb.toString());
                    if (isWithCrashExit) {
                        //LOG.error(" !!! exit after crash !!! ");
                    	LOG.error(" !!!crash !!! ");
                       // System.exit(-99);
                    	vehFront.cheat(0.0, 0.0);
                    	vehicle.cheat(0.0, 0.0);
                    }
                }
            }
        }
    }

    @SuppressWarnings("synthetic-access")
    private class LaneSegmentIterator implements Iterator<LaneSegment> {
        int index;

        public LaneSegmentIterator() {
        }

        @Override
        public boolean hasNext() {
            if (index < laneCount) {
                return true;
            }
            return false;
        }

        @Override
        public LaneSegment next() {
            if (index < laneCount) {
                // get the next lane segment
                return laneSegments[index++];
            }
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() not implemented.");
        }
    }

    /**
     * Returns an iterator over all the lane segments in this road segment.
     * 
     * @return an iterator over all the lane segments in this road segment
     */
    public final Iterator<LaneSegment> laneSegmentIterator() {
        return new LaneSegmentIterator();
    }

    /**
     * Returns an iterable over all the lane segments in this road segment.
     * 
     * @return an iterable over all the lane segments in this road segment
     */
    public Iterable<LaneSegment> laneSegments() {
        return ImmutableList.copyOf(laneSegmentIterator());
    }

    public final LoopDetectors getLoopDetectors() {
        return loopDetectors;
    }

    public void setLoopDetectors(LoopDetectors loopDetectors) {
        this.loopDetectors = loopDetectors;
    }

    public void setFlowConservingBottlenecks(FlowConservingBottlenecks flowConservingBottlenecks) {
        Preconditions.checkNotNull(flowConservingBottlenecks);
        this.flowConservingBottlenecks = flowConservingBottlenecks;
    }

    /**
     * Asserts the road segment's class invariant. Used for debugging.
     */
    public boolean assertInvariant() {
        final RoadMapping roadMapping = roadMapping();
        if (roadMapping != null) {
            assert roadMapping.laneCount() == laneCount();
            assert roadMapping.trafficLaneMax() == trafficLaneMax();
            assert roadMapping.trafficLaneMin() == trafficLaneMin();
            assert Math.abs(roadMapping.roadLength() - roadLength()) < 0.1;
        }
        for (final LaneSegment laneSegment : laneSegments) {
            laneSegment.assertInvariant();
        }
        return true;
    }

    public void setSimpleRamp(SimpleRamp simpleRamp) {
        this.simpleRamp = simpleRamp;
    }

    /**
     * Returns true if the {@code RoadSegment} is connected in downstream direction to the provided argument and false
     * otherwise. Connection exists if at least one {@code LaneSegment} is connected.
     * 
     * @param upstreamRoadSegment
     * @return
     */
    public boolean isDownstreamLink(RoadSegment upstreamRoadSegment) {
        Preconditions.checkNotNull(upstreamRoadSegment);
        for (final LaneSegment laneSegment : laneSegments) {
            if (laneSegment.sourceLaneSegment() != null
                    && upstreamRoadSegment.equals(laneSegment.sourceLaneSegment().roadSegment())) {
                return true;
            }
        }
        return false;
    }

    // TODO not yet used
    public void setUserRoadname(String name) {
        this.roadName = name;
    }

    /**
     * Adds the {@code TrafficLightLocation} to the {@code RoadSegment} and performs a sorting to assure ascending order
     * of positions along the road stretch.
     * <p>
     * The caller has to assure that trafficlight id is unique in the whole network.
     * </p>
     * 
     * @param trafficLightLocation
     */
    public void addTrafficLightLocation(TrafficLightLocation trafficLightLocation) {
        Preconditions.checkArgument(trafficLightLocation.position() >= 0
                && trafficLightLocation.position() <= roadLength, "inconsistent input data: traffic light position="
                + trafficLightLocation.position() + " does not fit onto road-id=" + id() + " with length="
                + roadLength());
        trafficLightLocations.add(trafficLightLocation);
    }

    public final class TrafficLightLocationWithDistance {
        public final TrafficLightLocation trafficLightLocation;
        public final double distance;

        public TrafficLightLocationWithDistance(TrafficLightLocation location, double distance) {
            this.trafficLightLocation = Preconditions.checkNotNull(location);
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "TrafficLightLocationWithDistance [trafficLightLocation=" + trafficLightLocation + ", distance="
                    + distance + "]";
        }
    }

    public enum NodeType {
        ORIGIN, DESTINATION;
    }

    EnumMap<NodeType, Long> nodeIds = new EnumMap<>(NodeType.class);

    public Long getNode(NodeType nodeType) {
        return nodeIds.get(nodeType);
    }

    public void setNode(NodeType nodeType, Long nodeId) {
        Preconditions.checkNotNull(nodeId);
        if (getNode(nodeType) != null && getNode(nodeType).longValue() != nodeId.longValue()) {
            throw new IllegalArgumentException("nodetype=" + nodeType.toString() + " of RoadSegment="
                + userId() + " already set=" + getNode(nodeType));
        }
        nodeIds.put(nodeType, nodeId);
    }

    @Override
    public String toString() {
        return "RoadSegment [id=" + id + ", userId=" + userId + ", roadName=" + roadName + ", roadLength=" + roadLength
                + ", laneCount=" + laneCount + ", nodeIds=" + nodeIds + "]";
    }

	public void setRoadSideUnits(List<RoadSideUnit> roadSideUnit, RoadNetwork roadNetwork) {
		this.rsus = roadSideUnit;
		
		for(RoadSideUnit rsu : this.rsus){
			rsu.initialize(roadNetwork);
		}
	}



	
}
