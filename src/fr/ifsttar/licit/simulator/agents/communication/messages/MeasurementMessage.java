package fr.ifsttar.licit.simulator.agents.communication.messages;

import org.movsim.simulator.vehicles.Vehicle;

/**
 * This message holds all exchanged information form vehicle sensors
 * 
 * @author mgueriau
 *
 */
public class MeasurementMessage extends Message {

	private double epsilonDeltaX=0.0;
	private double epsilonDeltaV=0.0;
	
	
	
	public MeasurementMessage(Vehicle sender, double deltaX, double deltaV){
		super(sender);
		this.epsilonDeltaX=deltaX;
		this.epsilonDeltaV=deltaV;
	}

	public double getEpsilonDeltaX() {
		return epsilonDeltaX;
	}

	public double getEpsilonDeltaV() {
		return epsilonDeltaV;
	}
	
	
	
}
