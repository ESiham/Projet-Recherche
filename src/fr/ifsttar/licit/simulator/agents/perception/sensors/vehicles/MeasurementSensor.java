package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles;

import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadNetwork;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.Agent;
import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;
import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensor;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.Measurement;
import fr.ifsttar.licit.simulator.environment.PerceptibleEnvironment;
import fr.ifsttar.licit.simulator.environment.PerceptiblePartition;


public abstract class MeasurementSensor extends Sensor {

	
	public MeasurementSensor(){
		super();
	}
	
	public MeasurementSensor(double reliability){
		super(reliability);
	}

	/**
	 * 
	 * compute the perception (perceived elements) of given agent in the current partition of the environment
	 * 
	 * @param agent
	 * @param partition
	 * @param environment
	 * @return all the perceived objects in the Sensor surrounding environment, according to its properties (e.g. frustrum, perception range, ...)
	 */
	@Override
	public AgentPerception percieve(Agent agent, PerceptiblePartition partition1, PerceptiblePartition partition2, PerceptibleEnvironment environment, double simulationTime){
		AgentPerception perception = null;
		
		if(agent instanceof Vehicle && partition1 instanceof LaneSegment && partition2 instanceof RoadSegment){
			perception = this.perceive((Vehicle) agent, (LaneSegment) partition1, (RoadSegment) partition2, (RoadNetwork) environment, simulationTime);
		}
		return perception;
	}
	
	/**
	 * Performs a perception loop from the given position
	 * 
	 * @param me
	 * @param laneSegment
	 * @param roadNetwork 
	 * @param rightLane 
	 * @param leftLane 
	 * @return all the perceived objects in the Sensor surrounding environment, according to its properties (e.g. frustrum, perception range, ...)
	 */
	public MeasurementPerception perceive(Vehicle me, LaneSegment laneSegment, RoadSegment roadSegment, RoadNetwork roadNetwork, double simulationTime){
		MeasurementPerception perception = new MeasurementPerception();

		perception.addOwnMeasurement(this.measure(me, laneSegment, roadSegment, roadNetwork, simulationTime));
		
		return perception;
	}
	
	/**
	 * 
	 * @param me
	 * @param laneSegment
	 * @param roadSegment
	 * @param roadNetwork 
	 * @return
	 */
	protected abstract Measurement measure(Vehicle me, LaneSegment laneSegment, RoadSegment roadSegment, RoadNetwork roadNetwork, double simulationTime);

}
