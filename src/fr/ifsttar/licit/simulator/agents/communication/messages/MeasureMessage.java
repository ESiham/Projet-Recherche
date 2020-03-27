package fr.ifsttar.licit.simulator.agents.communication.messages;

import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;

public class MeasureMessage extends Message {

	private double positionMeasureValue;
	private double velocityMeasureValue;
	private double deltaXMeasureValue;
	private double deltaVMeasureValue;
	private double vehicleLength;
	
	public MeasureMessage(Vehicle sender, double positionMeasureValue, double velocityMeasureValue, double deltaXMeasureValue, double deltaVMeasureValue, double vehicleLength) {
		super(sender);
		this.positionMeasureValue = positionMeasureValue;
		this.velocityMeasureValue = velocityMeasureValue;
		this.deltaXMeasureValue = deltaXMeasureValue;
		this.deltaVMeasureValue = deltaVMeasureValue;
		this.vehicleLength = vehicleLength;
	}
	
		

	public double getPositionMeasureValue() {
		return positionMeasureValue;
	}

	public double getVelocityMeasureValue() {
		return velocityMeasureValue;
	}

	public double getDeltaXMeasureValue() {
		return deltaXMeasureValue;
	}

	public double getDeltaVMeasureValue() {
		return deltaVMeasureValue;
	}

	public double getVehicleLength() {
		return vehicleLength;
	}


}
