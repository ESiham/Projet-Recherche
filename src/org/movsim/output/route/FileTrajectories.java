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
package org.movsim.output.route;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import org.movsim.autogen.Trajectories;
import org.movsim.input.ProjectMetaData;
import org.movsim.output.fileoutput.FileOutputBase;
import org.movsim.roadmappings.RoadMapping;
import org.movsim.simulator.MovsimConstants;
import org.movsim.simulator.SimulationTimeStep;
import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.roadnetwork.routing.Route;
import org.movsim.simulator.vehicles.Vehicle;
import org.movsim.utilities.FileUtils;
import org.movsim.viewer.ui.charts.model.data.sets.SpaceTimeSpeedDataSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import fr.ifsttar.licit.simulator.agents.AgentType;
import fr.ifsttar.licit.simulator.util.units.Unit;

/**
 * The Class FileTrajectories.
 */
public class FileTrajectories extends FileOutputBase implements SimulationTimeStep {

    private static final String extensionFormat = ".traj.csv";//.route_%s.csv";
    private static final String outputHeading = COMMENT_CHAR
    //        + "     t[s], lane,       x[m],     v[m/s],   a[m/s^2],     gap[m],    dv[m/s], label,           id,  selfTrust, Gd, roadId, originId, infoComment, absTime, xWithOffset[m]";
    		+ "     t[s], lane,       x[m],     v[m/s],   a[m/s^2],     gap[m],    dv[m/s], label,           id,	roadId, originId, infoComment, absTime, xWithOffset[m]";
    //private static final String outputFormat = "%10.2f, %4d, %10.1f, %10.4f, %10.5f, %10.2f, %10.6f,  %s, %12d, %10.4f, %10.4f, %8d, %8d, %s, %s, %10.4f%n";
    private static final String outputFormat = "%10.2f, %4d, %10.1f, %10.4f, %10.5f, %10.2f, %10.6f,  %s, %12d, %8d, %8d, %s, %s, %10.4f%n";

    /** The Constant LOG. */
    private final static Logger logger = LoggerFactory.getLogger(FileTrajectories.class);

    private final double positionIntervalStart;
    private final double positionIntervalEnd;
    private double time;
    private double lastUpdateTime = 0;
    private final Route route;

    private final Trajectories traj;
    
    
    private SpaceTimeSpeedDataSet spaceTimeSpeedDataSet = null;
    
   /*private TravelTimesDataSet travelTimesDataSet = null;*/
    
	private String filename;
    public void removeSpaceTimeSpeedDataSet(){
    	if(spaceTimeSpeedDataSet!=null){
    		spaceTimeSpeedDataSet.clear();
    		spaceTimeSpeedDataSet=null;
    	}
    }
    /*
    public void removeTravelTimesDataSet(){
    	if(travelTimesDataSet!=null){
    		travelTimesDataSet.clear();
    		travelTimesDataSet=null;
    	}
    }
    */
    public int[] getLanes() {
    	RoadSegment roadSegment = route.iterator().next();
    	int[] lanes = new int[roadSegment.laneCount()];
    	int id = 0;
    	for(LaneSegment lane : roadSegment.laneSegments()){
    		lanes[id++] = lane.lane();
    	}
		return lanes;
	}
    
    public String getRouteName(){
    	return this.route.getName();
    }
    
    /**
     * Instantiates a new trajectories.
     * 
     * @param traj
     *            the trajectories input
     */
    public FileTrajectories(Trajectories traj, Route route) {
        super(ProjectMetaData.getInstance().getOutputPath(), ProjectMetaData.getInstance().getProjectName());
        this.traj = Preconditions.checkNotNull(traj);
        this.route = Preconditions.checkNotNull(route);
        positionIntervalStart = 0;
        positionIntervalEnd = route.getLength();

        logger.info("interval for output: timeStart=" + (traj.isSetStartTime() ? traj.getStartTime() : "--")
                + ", timeEnd=" + (traj.isSetEndTime() ? traj.getEndTime() : "--"));
        this.filename = path + File.separator + baseFilename + extensionFormat;//String.format(extensionFormat, route.getName());
        writer = createWriter(extensionFormat);//String.format(extensionFormat, route.getName()));
        writeHeader(route);
    }
    
   private void writeHeader(Route route) {
        //writer.println(String.format("%s %s", COMMENT_CHAR, route.toString()));
        if(writer!=null){
	        writer.println(outputHeading);
	        writer.flush();
        }
    }

    @Override
    public void timeStep(double dt, double simulationTime, long iterationCount) {
        this.time = simulationTime;
        if (isLargerThanStartTimeInterval() && isSmallerThanEndTimeInterval()) {
            if (iterationCount % 1000 == 0) {
                logger.info("time = {}, timestep= {}", time, dt);
            }
            if ((time - lastUpdateTime + MovsimConstants.SMALL_VALUE) >= traj.getDt()) {
                lastUpdateTime = time;
                String formattedTime = ProjectMetaData.getInstance().getFormatedTimeWithOffset(simulationTime);
                writeTrajectories(formattedTime);
            }
        }
    }


    private boolean isLargerThanStartTimeInterval() {
        if (!traj.isSetStartTime()) {
            return true;
        }
        return time >= traj.getStartTime();
    }

    private boolean isSmallerThanEndTimeInterval() {
        if (!traj.isSetEndTime()) {
            return true;
        }
        return time <= traj.getEndTime();
    }

    /**
     * Write trajectories.
     * 
     * @param roadSegment
     */
    private void writeTrajectories(String formattedTime) {
        double positionOnRoute = 0.0;
        for (final RoadSegment roadSegment : route) {
            for (LaneSegment laneSegment : roadSegment.laneSegments()) {
            	/***
            	 * 
            	 */
            	//if(!traj.isSetLane() || traj.getLane() == laneSegment.lane()){
            	/**
            	 * 
            	 */
	                for (final Vehicle vehicle : laneSegment) {
	                    if (vehicle.type() == AgentType.OBSTACLE) {
	                        continue;
	                    }
	                    if (!traj.isSetRandomFraction() || vehicle.getRandomFix() < traj.getRandomFraction()) {
	                        if (vehicle.getFrontPosition() >= positionIntervalStart
	                                && vehicle.getFrontPosition() <= positionIntervalEnd) {
	                        	
	                        	
	                        	 /**
	                             *  + compute Gd
	                             */
	                            //final double communicationRange = 150.0;
	                            //vehicle.setGd(this.computeGd(vehicle, communicationRange, roadSegment/*, network*/));
	                           
	                        	
	                            writeVehicleData(vehicle, positionOnRoute, laneSegment.frontVehicle(vehicle), formattedTime);
	                        }
	                    }
	                }
	            /**
	             * 
	             */
            	//}
            	/**
            	 * 
            	 */
            }
            positionOnRoute += roadSegment.roadLength();
        }
        
        if(this.spaceTimeSpeedDataSet!=null)
        	this.spaceTimeSpeedDataSet.fireDataChanged();
        /*
        if(this.travelTimesDataSet!=null)
        	this.travelTimesDataSet.fireDataChanged();
        */
    }

    private double computeGd(Vehicle me, double communicationRange, RoadSegment roadSegment/*, RoadNetwork roadNetwork*/) {
    	double gd = 0.0;
    	
    	final RoadMapping meRoadMapping = roadSegment.roadMapping();
		final RoadMapping.PolygonFloat mePolygon = meRoadMapping.mapFloat(me, 0.0);
		final double mePositionX = mePolygon.xPoints[0];
		final double mePositionY = mePolygon.yPoints[0];
		
		//for(RoadSegment segment : roadNetwork){
			for(Vehicle vehicle : roadSegment){
				if(vehicle!=null && vehicle.getId() != me.getId()){
					final RoadMapping roadMapping = roadSegment.roadMapping();
			        final RoadMapping.PolygonFloat polygon = roadMapping.mapFloat(vehicle, 0.0);
			        final double positionX = polygon.xPoints[0];
			        final double positionY = polygon.yPoints[0];
			        
			        final double distance = (Math.sqrt((positionX - mePositionX) * (positionX - mePositionX) + (positionY - mePositionY)*(positionY - mePositionY)));
			       
			        if(distance <= communicationRange){
			        	if(vehicle.lane()==me.lane()){
			        		gd += (me.getRelSpeed(vehicle) * me.getRelSpeed(vehicle));
			        	}
			        }
				}
		//	}
		}
		
		//System.out.println(" G_d of " +  me.getId() + " = " + gd);
		
		return gd;
	}
    
    /**
     * Write vehicle data.
     * 
     * @param me
     * @param positionOnRoute
     * @param frontVehicle
     */
    private void writeVehicleData(Vehicle me, double positionOnRoute, Vehicle frontVehicle, String formattedTime) {
        final double pos = me.getFrontPosition() + positionOnRoute;
        final double s = (frontVehicle == null || frontVehicle.type() == AgentType.OBSTACLE) ? 0 : me
                .getNetDistance(frontVehicle);
        final double dv = (frontVehicle == null || frontVehicle.type() == AgentType.OBSTACLE) ? 0 : me
                .getRelSpeed(frontVehicle);
        write(outputFormat, time, me.lane(), pos, me.getSpeed(), me.getAcc(), s, dv, me.getLabel(), me.getId(), //me.getTrust().getSelfTrustValue(), me.getGd(),
                me.roadSegmentId(), me.originRoadSegmentId(), me.getInfoComment(), formattedTime,
                pos + traj.getOffsetPosition());
        
        if(this.spaceTimeSpeedDataSet!=null && this.spaceTimeSpeedDataSet.getLane()==me.lane())
        	this.spaceTimeSpeedDataSet.addFloatingCarData(me.getId(), time, pos, Unit.convertValueFromTo(me.getSpeed(), Unit.MetersPerSecond, Unit.KilometersPerHour));
        
        /*
        if(this.travelTimesDataSet!=null){
        	if(pos < 20.0 ){
        		this.travelTimesDataSet.addStartTravelTimeData(me.getId(), time);
        	}
        	
        	if(pos > (route.getLength() - 20.0 )){
        		this.travelTimesDataSet.addEndTravelTimeData(me.getId(), time);
        	}
        }*/
        
    }

    
    
    
    /***
     * data Set !
     * @return
     */
    
    
	public SpaceTimeSpeedDataSet getSpaceTimeSpeedDataSet(int numLane) {
		if(this.spaceTimeSpeedDataSet == null){
			this.spaceTimeSpeedDataSet = this.createSpaceTimeSpeedDataSet(numLane);
		} else if(this.spaceTimeSpeedDataSet.getLane() != numLane){
			this.removeSpaceTimeSpeedDataSet();
			this.spaceTimeSpeedDataSet = this.createSpaceTimeSpeedDataSet(numLane);
		}
		
		return this.spaceTimeSpeedDataSet;
	}
	
	/*
	public TravelTimesDataSet getTravelTimesDataSet() {
		if(this.travelTimesDataSet == null){
			this.travelTimesDataSet = this.createTravelTimesDataSet();
		}
		return this.travelTimesDataSet;
	}
	*/
	
	private SpaceTimeSpeedDataSet createSpaceTimeSpeedDataSet(int numLane) {
		
		SpaceTimeSpeedDataSet dataSet = new SpaceTimeSpeedDataSet(numLane);
		
		// read data from csv file and add them to current dataset		
		
		BufferedReader reader = FileUtils.getReader(filename);
		
		//two firsts lines are dedicated to information
		try {
			reader.readLine();
			//reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				String[] tokens = line.split(",");
				//System.out.println(tokens.length);
				if(tokens.length==16){
					final int lane = Integer.parseInt(tokens[1].replace(" ", ""));
					if(lane == numLane){
						final int id = Integer.parseInt(tokens[8].replace(" ", ""));
						final double time = Double.parseDouble(tokens[0].replace(" ", ""));
						final double pos = Double.parseDouble(tokens[2].replace(" ", ""));
						final double vel = Unit.convertValueFromTo(Double.parseDouble(tokens[3].replace(" ", "")), Unit.MetersPerSecond, Unit.KilometersPerHour);
						dataSet.addFloatingCarData(id,time,pos,vel);
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
			
		return dataSet;
	}
	
	/*
	private TravelTimesDataSet createTravelTimesDataSet() {
		
		TravelTimesDataSet dataSet = new TravelTimesDataSet();
		
		//read data from csv file and add them to current dataset		
		
		BufferedReader reader = FileUtils.getReader(filename);
		
		//two firsts lines are dedicated to information
		try {
			reader.readLine();
			reader.readLine();
			String line = null;
			
			while((line=reader.readLine())!=null){
				String[] tokens = line.split(",");
				//System.out.println(tokens.length);
				if(tokens.length==14){
					
					final long id = Long.parseLong(tokens[8].replace(" ", ""));
					final double time = Double.parseDouble(tokens[0].replace(" ", ""));
					final double pos = Double.parseDouble(tokens[2].replace(" ", ""));
					
					if(pos<20.0){
						dataSet.addStartTravelTimeData(id, time);
					} else if(pos>route.getLength()-20.0){
						dataSet.addEndTravelTimeData(id, time);
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
			
		
		return dataSet;
	}
	*/
	
}
