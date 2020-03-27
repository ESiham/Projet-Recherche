package fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure;

import org.movsim.roadmappings.RoadMapping;
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
import fr.ifsttar.licit.simulator.agents.communication.messages.Message;
public class RSUDevice extends Sensor {

		/**
		 * Maximum 2D perception radius of this sensor in meters
		 */
		private double range = 150.0d;
		
		public double getRange(){
			return this.range;
		}
		
		public RSUDevice(){
			super();
		}
		
		public RSUDevice(double range){
			super();
			this.range = range;
		}
		
		/*public RSUDevice(double range, double reliability){
			super(reliability);
			this.range = range;
		}*/
		
		
		@Override
		public AgentPerception percieve(Agent agent, PerceptiblePartition partition2, PerceptiblePartition partition1, PerceptibleEnvironment environment, double simulationTime) {
			return this.perceive((RoadSideUnit) agent, (RoadSegment) partition1, null);
		}
		
		
		public MeasurementPerception perceive(RoadSideUnit me, RoadSegment roadSegment, RoadSegment rsuSegment) {
			MeasurementPerception perception = new MeasurementPerception();
			
			
			//System.out.println(" RSUDevice perception");
			/**
			 * 
			 */
			
			// TODO : very computationally  heavy way ...
			
			
			/*//
			for(Vehicle vehicle : roadSegment){
				if( (Math.abs(vehicle.getRearPosition() - me.getPosition())<=this.range)){
					this.perceive(perception, me, vehicle);
				}
			}
			//*/
			
			/**
			 * 2D perception
			 */
			final RoadMapping rsuSegmentRoadMapping = rsuSegment.roadMapping();
			final RoadMapping.PolygonFloat rsuPolygon = rsuSegmentRoadMapping.mapFloat(me, 0.0);
	        final double rsuPositionX = rsuPolygon.xPoints[0];
	        final double rsuPositionY = rsuPolygon.yPoints[0];
			
			
			final RoadMapping segmentRoadMapping = roadSegment.roadMapping();
			
			for(Vehicle vehicle : roadSegment){
				final RoadMapping.PolygonFloat mePolygon = segmentRoadMapping.mapFloat(vehicle, 0.0);
				final double vehiclePositionX = mePolygon.xPoints[0];
				final double vehiclePositionY = mePolygon.yPoints[0];
				
				final double distance = (Math.sqrt((vehiclePositionX - rsuPositionX) * (vehiclePositionX - rsuPositionX) + (vehiclePositionY - rsuPositionY)*(vehiclePositionY - rsuPositionY)));
				
				if(distance<=this.range){
					//System.out.println("RSU @ " + rsuPositionX + ";" + rsuPositionY + " -> " + " vehicle n° " + vehicle.getId() + " @ " + vehiclePositionX + " ; " + vehiclePositionY);
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
						//get messages from vehicle message to sent
												for(Message m : vehicle.getMessagesToSend()){
													perception.addMessage(m);
												}
						
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
							
							if(teleM!=null && gpsM!=null){
								perception.addMessage(new MeasureMessage(vehicle, gpsM.getPositionValue(), gpsM.getSpeedValue(), teleM.getDeltaXValue(), teleM.getDeltaVValue(),vehicle.getLength()));
							}
						}
				
					}
				}
			}
		}
	
}
