package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles;

import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.communication.messages.MeasurementMessage;
import fr.ifsttar.licit.simulator.agents.communication.messages.TrustMessage;
import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensor;
import fr.ifsttar.licit.simulator.agents.perception.vehicles.VehiclePerception;
import fr.ifsttar.licit.simulator.agents.trust.representation.TrustValue;

/**
 * Wireless Receiver perceive all messages sent by front vehicle
 * 
 * FIXME : the messages should be sent and propagated through communication environment (or emitted at a differed time)
 * FIXME 2 : the receiver IS NOT SUPPOSED TO ASK A VEHICLE TO COMMUNICATE !
 * 
 * @author gueriau
 *
 */
public class WirelessReceiver extends VehicleSensor {

	@Override
	public VehiclePerception perceive(Vehicle me, LaneSegment laneSegment, RoadSegment roadSegment, double simulationTime) {
		
		VehiclePerception perception = new VehiclePerception();
		
		Vehicle frontVehicle = laneSegment.frontVehicle(me);
		Vehicle rearVehicle = laneSegment.rearVehicle(me);
		
		final LaneSegment leftLane = roadSegment.getLeftLane(me.lane());
		final LaneSegment rightLane = roadSegment.getRightLane(me.lane());
		
		
		double myReliability = 1.0;
		
		for(Sensor s : me.getSensors()){
			if(s instanceof SuperSensor){
				SuperSensor ss  =  ((SuperSensor) s);
				myReliability = ss.getReliability();
			}
		}
	
		myReliability+=(Math.random()-0.5)*0.1;
		
		// FIXME  : consider a communication radius instead of a fixed set of 4 surrounding vehicles
		
		/*Vehicle leftVehicle = null;
		if(leftLane!=null)
			leftVehicle = leftLane.frontVehicle(me);
		Vehicle rightVehicle = null;
		if(rightLane!=null)
			rightVehicle = rightLane.frontVehicle(me);*/
		if(frontVehicle!=null){
			// FIXME : the receiver IS NOT SUPPOSED TO ASK A VEHICLE TO COMMUNICATE !
			// FIXME : values should come from the communicating vehicle itself (same thing for reliability) ...
			
			double frontReliability = 1.0;
			
			for(Sensor s : frontVehicle.getSensors()){
				if(s instanceof SuperSensor){
					SuperSensor ss  =  ((SuperSensor) s);
					frontReliability = ss.getReliability();
				} else if (s instanceof WirelessReceiver){
					
					perception.addMessage(new MeasurementMessage(frontVehicle, Math.abs(me.getNetDistance(frontVehicle)*myReliability - frontVehicle.getNetDistanceToRearVehicle(me)*frontReliability) ,  Math.abs(me.getRelSpeed(frontVehicle)*myReliability - frontVehicle.getRelSpeed(me)*frontReliability)));
					
					//perception.addMessage(new MeasurementMessage(frontVehicle, Math.abs(me.getNetDistance(frontVehicle) - frontVehicle.getNetDistanceToRearVehicle(me)) ,  Math.abs(me.getRelSpeed(frontVehicle) - frontVehicle.getRelSpeed(me))));
					
					/*TrustValue trustValueInMe = frontVehicle.getTrust().getTrustValue(me.getId());
					if(trustValueInMe!=null){
						//System.out.println("front as a trust in me");
						perception.addMessage(new TrustMessage(frontVehicle, me.getId(), trustValueInMe));
						//System.out.println("not null !");
					}
					
					this.shareTrustValues(perception, me, frontVehicle);*/
				}
			}
			
			
		}
		if(rearVehicle!=null){
			
			double rearReliability = 1.0;
			
			for(Sensor s : rearVehicle.getSensors()){
				if(s instanceof SuperSensor){
					SuperSensor ss  =  ((SuperSensor) s);
					rearReliability = ss.getReliability();
				} else if (s instanceof WirelessReceiver){
					
					//perception.addMessage(new MeasurementMessage(rearVehicle, Math.abs(me.getNetDistance(rearVehicle)*myReliability - rearVehicle.getNetDistanceToRearVehicle(me)*rearReliability) ,  Math.abs(me.getRelSpeed(rearVehicle)*myReliability - rearVehicle.getRelSpeed(me)*rearReliability)));
					
					perception.addMessage(new MeasurementMessage(rearVehicle, Math.abs(me.getNetDistance(rearVehicle)*myReliability - rearVehicle.getNetDistanceToRearVehicle(me)*rearReliability) ,  Math.abs(me.getRelSpeed(rearVehicle)*myReliability - rearVehicle.getRelSpeed(me)*rearReliability)));
					//perception.addMessage(new MeasurementMessage(rearVehicle, Math.abs(me.getNetDistance(rearVehicle) - rearVehicle.getNetDistanceToRearVehicle(me)) ,  Math.abs(me.getRelSpeed(rearVehicle) - rearVehicle.getRelSpeed(me))));
					/*
					TrustValue trustValueInMe = rearVehicle.getTrust().getTrustValue(me.getId());
					if(trustValueInMe!=null){
						//System.out.println("rear as a trust in me");
						perception.addMessage(new TrustMessage(rearVehicle, me.getId(), trustValueInMe));	
					}
					
					this.shareTrustValues(perception, me, rearVehicle);*/
				}
			}
			
		
		}
		
		//forward
		frontVehicle = laneSegment.frontVehicle(me);
		while(frontVehicle!=null && (Math.abs(me.getNetDistance(frontVehicle))<=this.range) ){
			this.perceive(perception, me, frontVehicle);
			frontVehicle=laneSegment.frontVehicle(frontVehicle);
		}
		

		//backward
		rearVehicle = laneSegment.rearVehicle(me.getRearPosition()-0.01);
		while(rearVehicle!=null  && (Math.abs(me.getNetDistanceToRearVehicle(rearVehicle))<=this.range) ){
		
			this.perceive(perception, me, rearVehicle);
			rearVehicle=laneSegment.rearVehicle(rearVehicle.getRearPosition()-0.01);
		}
		
		
		if(leftLane!=null){
			Vehicle leftVehicle = null;
			// forward
			leftVehicle = leftLane.frontVehicle(me);
			while(leftVehicle!=null && (Math.abs(me.getNetDistance(leftVehicle))<=this.range) ){
				this.perceive(perception, me, leftVehicle);
				leftVehicle=leftLane.frontVehicle(leftVehicle);
			}
			// backward
			leftVehicle = leftLane.rearVehicle(me.getRearPosition()-0.01);
			while(leftVehicle!=null && (Math.abs(me.getNetDistanceToRearVehicle(leftVehicle))<=this.range) ){
				this.perceive(perception, me, leftVehicle);
				leftVehicle=leftLane.rearVehicle(leftVehicle.getRearPosition()-0.01);
			}
		}
		
		if(rightLane!=null){
			Vehicle rightVehicle = null;
			// forward
			rightVehicle = rightLane.frontVehicle(me);
			while(rightVehicle!=null && (Math.abs(me.getNetDistance(rightVehicle))<=this.range) ){
				this.perceive(perception, me, rightVehicle);
				rightVehicle=rightLane.frontVehicle(rightVehicle);
			}
			// backward
			rightVehicle = rightLane.rearVehicle(me.getRearPosition()-0.01);
			while(rightVehicle!=null && (Math.abs(me.getNetDistanceToRearVehicle(rightVehicle))<=this.range) ){
				this.perceive(perception, me, rightVehicle);
				rightVehicle=rightLane.rearVehicle(rightVehicle.getRearPosition()-0.01);
			}
		}
		
		/*if(leftVehicle!=null){
			// FIXME : the receiver IS NOT SUPPOSED TO ASK A VEHICLE TO COMMUNICATE !
			//share Trust !
			
			for(Sensor s : leftVehicle.getSensors()){
				if(s instanceof WirelessReceiver){
					TrustValue trustValueInMe = leftVehicle.getTrust().getTrustValue(me.getId());
					if(trustValueInMe!=null){
						//System.out.println("left as a trust in me");
						perception.addMessage(new TrustMessage(leftVehicle, me.getId(), trustValueInMe));
					}
					this.shareTrustValues(perception, me, leftVehicle);
				}
			}
			
			
		}
		if(rightVehicle!=null){
			// FIXME : the receiver IS NOT SUPPOSED TO ASK A VEHICLE TO COMMUNICATE !
			//share Trust !
			for(Sensor s : rightVehicle.getSensors()){
				if(s instanceof WirelessReceiver){
					TrustValue trustValueInMe = rightVehicle.getTrust().getTrustValue(me.getId());
					if(trustValueInMe!=null){
						//System.out.println("right as a trust in me");
						perception.addMessage(new TrustMessage(rightVehicle, me.getId(), trustValueInMe));
					}
					this.shareTrustValues(perception, me, rightVehicle);
				}
			}
		}*/
			
		return perception;
	}
	
	private void perceive(VehiclePerception perception, Vehicle me, Vehicle vehicle) {
		if(perception!=null && vehicle!=null && me!=null){
	
			for(Sensor s : vehicle.getSensors()){
				if(s instanceof WirelessReceiver){
					TrustValue trustValueInMe = vehicle.getTrust().getTrustValue(me.getId());
					if(trustValueInMe!=null){
						//System.out.println("left as a trust in me");
						perception.addMessage(new TrustMessage(vehicle, me.getId(), trustValueInMe));
					}
					this.shareTrustValues(perception, me, vehicle);
				}
			}
		}
	}

	private void shareTrustValues(VehiclePerception perception, Vehicle me, Vehicle vehicle){
		if(perception!=null && me!=null && vehicle!=null){
			
			for(Long vehicleID : vehicle.getTrust().getKeys()){
				if(vehicleID != me.getId()){
					TrustValue trustValue = vehicle.getTrust().getTrustValue(vehicleID);
					if(trustValue!=null)
						perception.addMessage(new TrustMessage(vehicle, vehicleID, trustValue));
				}
			}
			
		}
	}

}
