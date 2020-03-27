package fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure.control;

import java.util.HashMap;
import java.util.Iterator;

import org.movsim.roadmappings.RoadMapping;
import org.movsim.simulator.roadnetwork.RoadNetwork;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.Agent;
import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;
import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensor;
import fr.ifsttar.licit.simulator.environment.PerceptibleEnvironment;
import fr.ifsttar.licit.simulator.environment.PerceptiblePartition;
import fr.ifsttar.licit.simulator.infrastructure.RoadSideUnit;
import fr.ifsttar.licit.simulator.network.connection.XMLSocketSimulationAgent;

public class RSUController extends Sensor {

		/**
		 * The map of vehicles currently sensed by this sensor
		 */
		private HashMap<Long, Boolean> sensedVehicles;
	
		/**
		 * Maximum 2D perception radius of this sensor in meters
		 */
		private double range = 150.0d;
		
		public double getRange(){
			return this.range;
		}
		
		public RSUController(){
			super();
			this.sensedVehicles = new HashMap<Long, Boolean>();
		}
		
		public RSUController(double range){
			super();
			this.range = range;
			this.sensedVehicles = new HashMap<Long, Boolean>();
		}
		
		
		@Override
		public AgentPerception percieve(Agent agent, PerceptiblePartition partition2, PerceptiblePartition partition1, PerceptibleEnvironment environment, double simulationTime) {
			return this.perceive((RoadSideUnit) agent, (RoadSegment) partition1, (RoadNetwork) environment);
		}
		
		
		public MeasurementPerception perceive(RoadSideUnit me, RoadSegment roadSegment, RoadNetwork roadNetwork) {
			MeasurementPerception perception = new MeasurementPerception();

			
			final RoadMapping meRoadMapping = roadSegment.roadMapping();
			final RoadMapping.PolygonFloat mePolygon = meRoadMapping.mapFloat(me, 0.0);
			final double mePositionX = mePolygon.xPoints[0];
			final double mePositionY = mePolygon.yPoints[0];
			
			for(RoadSegment segment : roadNetwork){
				for(Vehicle vehicle : segment){
					if(vehicle!=null) {
						final RoadMapping roadMapping = segment.roadMapping();
				        final RoadMapping.PolygonFloat polygon = roadMapping.mapFloat(vehicle, 0.0);
				        final double positionX = polygon.xPoints[0];
				        final double positionY = polygon.yPoints[0];
				    
				        /**
				         *  2D perception
				         */
				        final double distance = (Math.sqrt((positionX - mePositionX) * (positionX - mePositionX) + (positionY - mePositionY)*(positionY - mePositionY)));
				       
				        if(distance <= this.range){

				        	// add message to perception
							// if the vehicle has not been detected yet
							if(!this.sensedVehicles.containsKey(vehicle.getId()) && vehicle.isExternalControl()){
								//perception.addMessage(new VehicleDetectedMessage(vehicle.getId()));
								perception.addDetectedVehicle(vehicle.getId());
							}
				        	// add the vehicle to map
							// even if the vehicle is already here
							this.sensedVehicles.put(vehicle.getId(), true);
							
				              	
				        }
					}
				}
			}
			

			// remove undetected vehicles and notify observers
			for(long id : this.sensedVehicles.keySet()){
				if(!this.sensedVehicles.get(id)){
					//perception.addMessage(new VehicleUndetectedMessage(id));
					perception.addUndetectedVehicle(id);
				}
			}
			
			
			
        	// if it has disapeared : add message to notify clients
			Iterator<Long> it = this.sensedVehicles.keySet().iterator();
			while (it.hasNext())
			{
				Long id = it.next();
				if(!this.sensedVehicles.get(id)){
					it.remove();
				} else {
					this.sensedVehicles.put(id,false);
				}
			}
		
			return perception;
		}

		/**
		 * @param vehicle
		 * @return
		 */
		private AgentPerception perceive(Vehicle vehicle) {
			
			
			// TODO Auto-generated method stub
			return null;
		}
		
	
	
}
