package fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure;

import org.movsim.autogen.CrossSection;
import org.movsim.output.detector.LoopDetector;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.Agent;
import fr.ifsttar.licit.simulator.agents.AgentType;
import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;
import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensor;
import fr.ifsttar.licit.simulator.environment.PerceptibleEnvironment;
import fr.ifsttar.licit.simulator.environment.PerceptiblePartition;
import fr.ifsttar.licit.simulator.infrastructure.RoadSideUnit;

public class RSULoopDetector extends Sensor {


	private LoopDetector detector;

	private double previousFlow = 0.0;
	private double previousSpeed = 0.0;
	
	public RSULoopDetector(LoopDetector detector){
		this.detector = detector;
	}

	@Override
	public AgentPerception percieve(Agent agent, PerceptiblePartition partition2,
			PerceptiblePartition partition1,
			PerceptibleEnvironment environment, double simulationTime) {
		
		return this.perceive((RoadSideUnit) agent, (RoadSegment) partition1, simulationTime);
	}
		
	
	public MeasurementPerception perceive(RoadSideUnit me, RoadSegment roadSegment, double simulationTime) {
	
		MeasurementPerception perception = new MeasurementPerception();
		
		if(this.detector!=null){
			final double speed = this.detector.getMeanSpeedAllLanes() * 3.6d;
			final double flow = this.detector.getFlowAllLanes() *3600.d;
			if(previousFlow!=flow && previousSpeed!=speed){
				previousSpeed=speed;
				previousFlow=flow;
				perception.addFLowSpeed(flow,speed);
			}
		}
					
		return perception;
	
	}
	
	/*public double range = 150.d;
	
	private double aggregationPeriod = 60;
	
	public RSULoopDetector(){
		super();
	}
	
	public RSULoopDetector(double range){
		super();
		this.range = range;
	}
	
	
	@Override
	public Perception percieve(Agent agent, PerceptiblePartition partition2, PerceptiblePartition partition1, PerceptibleEnvironment environment, double simulationTime) {
		return this.perceive((RoadSideUnit) agent, (RoadSegment) partition1, simulationTime);
	}
	
	public MeasurementPerception perceive(RoadSideUnit me, RoadSegment roadSegment, double simulationTime) {
		MeasurementPerception perception = new MeasurementPerception();
		
		double speedSum = 0.d;
		double meanSpeed = 0.d;
		//System.out.println("LOOP PERCEPTION");
		int number = 0;
		for(Vehicle vehicle : roadSegment){
			if( vehicle.getType()!=AgentType.OBSTACLE && (Math.abs(vehicle.getRearPosition() - me.getPosition())<=this.range)){
				number++;
				speedSum+=vehicle.getSpeed();
			}
		}
		
	    //System.out.println("num total = " + number);
		
		if(number > 0){
			meanSpeed = speedSum / (double) number;
		}
		
		
		if(simulationTime % aggregationPeriod ==0){
			
		perception.setNumberOfVehicles(number);
		perception.setMeanSpeed(meanSpeed);
		
		}
		
		return perception;
	}*/

}
