package fr.ifsttar.licit.simulator.agents.communication.messages;

import org.movsim.simulator.vehicles.Vehicle;

/**
 * AccMessage is a message holding the acceleration of the message sender
 * 
 * @author gueriau
 *
 */
public class AccMessage extends Message {

	private double acceleration=0.0;

	public AccMessage(Vehicle sender, double acceleration){
		super(sender);
		this.acceleration=acceleration;
		//System.out.println("Acc message from " + this.sender.getId() + " :  acc = " + acceleration );
	}
	
	public double getAcceleration() {
		return acceleration;
	}

	
}
