package fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure;

import java.util.ArrayList;
import java.util.Collection;

import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.Agent;
import fr.ifsttar.licit.simulator.agents.communication.messages.MeasureMessage;
import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;
import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensor;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.CommunicationDevice;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.GPSMeasurement;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.Measurement;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.TelemeterMeasurement;
import fr.ifsttar.licit.simulator.environment.PerceptibleEnvironment;
import fr.ifsttar.licit.simulator.environment.PerceptiblePartition;
import fr.ifsttar.licit.simulator.infrastructure.RoadSideUnit;

public class RSUBroadcaster extends Sensor {

		/**
		 * Maximum 2D perception radius of this sensor in meters
		 */
		private double range = 150.0d;
		
		public double getRange(){
			return this.range;
		}
		
		public RSUBroadcaster(){
			super();
		}
		
		public RSUBroadcaster(double range){
			super();
			this.range = range;
		}
		
		public ArrayList<MeasureMessage> messagesToBroadcast = new ArrayList<MeasureMessage>();
		
		/*public RSUDevice(double range, double reliability){
			super(reliability);
			this.range = range;
		}*/
		
		
		@Override
		public AgentPerception percieve(Agent agent, PerceptiblePartition partition2, PerceptiblePartition partition1, PerceptibleEnvironment environment, double simulationTime) {
			return this.perceive((RoadSideUnit) agent, (RoadSegment) partition1);
		}
		
		
		public MeasurementPerception perceive(RoadSideUnit me, RoadSegment roadSegment) {
			MeasurementPerception perception = new MeasurementPerception();
			this.messagesToBroadcast.clear();
			
			//System.out.println(" RSUDevice perception " + perception.get);
			/**
			 * 
			 */
			
			// TODO : very computationally  heavy way ...
			
			
			for(Vehicle vehicle : roadSegment){
				if( (Math.abs(vehicle.getRearPosition() - me.getPosition())<=this.range)){
					this.perceive(perception, me, vehicle);
				}
			}
			
			//System.out.println(perception.getMessages().size());
	
			/**
			 * 
			 */
			
			return perception;
		}
		
		
		private void perceive(MeasurementPerception perception, RoadSideUnit me, Vehicle vehicle) {
			
			
			if(perception!=null && vehicle!=null && me!=null){
		
				for(Sensor s : vehicle.getSensors()){
					if(s instanceof CommunicationDevice){
						
						if(vehicle.getPerception()!=null && vehicle.getPerception() instanceof MeasurementPerception){
						
							MeasurementPerception vehiclePerception = (MeasurementPerception) vehicle.getPerception();
							
							TelemeterMeasurement teleM = null;
							GPSMeasurement gpsM = null;
							for(Measurement m : vehiclePerception.getOwnMeasurements()){
								if(m instanceof TelemeterMeasurement){
									teleM = (TelemeterMeasurement) m;
								} else if(m instanceof GPSMeasurement){
									gpsM = (GPSMeasurement) m;
								}
							}
							
							//if(teleM.getDeltaXValue()<10)
							//System.out.println(teleM.getDeltaXValue());
							
							if(teleM!=null && gpsM!=null){
								MeasureMessage message = new MeasureMessage(vehicle, gpsM.getPositionValue(), gpsM.getSpeedValue(), teleM.getDeltaXValue(), teleM.getDeltaVValue(), vehicle.getLength());
								perception.addMessage(message);
								messagesToBroadcast.add(message);
							}
						}
				
					}
				}
			}
		}


		/**
		 * 
		 * @return all messages received and broadcasted by RSU
		 */
		public Collection<MeasureMessage> getBroadcastedMessages() {
			return this.messagesToBroadcast;
		}
	
}
