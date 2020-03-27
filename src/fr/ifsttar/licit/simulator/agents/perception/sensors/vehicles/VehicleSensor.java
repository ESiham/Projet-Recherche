package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles;

import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.Agent;
import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensor;
import fr.ifsttar.licit.simulator.agents.perception.vehicles.VehiclePerception;
import fr.ifsttar.licit.simulator.environment.PerceptibleEnvironment;
import fr.ifsttar.licit.simulator.environment.PerceptiblePartition;


/**
 * This class represents a physical sensor embedded in a vehicle and able to sense its surrounding environment at each call
 * This sensor senses neighbors in the 1D space
 * 
 * 	TODO   : Imagine a separate execution time to deal with sensors rate of perception
 *  TODO 2 : Make sensors sense vehicles according to the world space instead of the road network space
 *   
 * @author gueriau
 *
 */
public abstract class VehicleSensor extends Sensor {
	
	protected double range = 150.0;
	
	public double getRange(){
		return range;
	}
	
	public void setRange(double range){
		this.range=Math.max(0.0, range);
	}
	
	public VehicleSensor(){
		super();
	}
	
	public VehicleSensor(double reliability){
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
	public AgentPerception percieve(Agent agent, PerceptiblePartition partition2, PerceptiblePartition partition1, PerceptibleEnvironment environment, double simulationTime){
		AgentPerception perception = null;
		
		if(agent instanceof Vehicle && partition2 instanceof LaneSegment && partition1 instanceof RoadSegment){
			perception = this.perceive((Vehicle) agent, (LaneSegment) partition2, (RoadSegment) partition1, simulationTime);
		}
		return perception;
	}
	
	/**
	 * Performs a perception loop from the given position
	 * 
	 * @param me
	 * @param laneSegment
	 * @param rightLane 
	 * @param leftLane 
	 * @return all the perceived objects in the Sensor surrounding environment, according to its properties (e.g. frustrum, perception range, ...)
	 */
	public abstract VehiclePerception perceive(Vehicle me, LaneSegment laneSegment, RoadSegment roadSegment, double simulationTime);

}
