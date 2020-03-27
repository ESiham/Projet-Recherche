package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements;

import fr.ifsttar.licit.simulator.util.units.Unit;

public class TelemeterMeasurement extends Measurement{

	private Measure deltaX;
	
	private Measure deltaV;
	
	public TelemeterMeasurement(long vehicleId, Measure deltaX, Measure deltaV){
		super(vehicleId);
		this.deltaX = deltaX;
		this.deltaV= deltaV;
	}
	
	public TelemeterMeasurement(long vehicleId, double deltaX, double deltaV){
		super(vehicleId);
		this.deltaX = new Measure(deltaX, Unit.Meters);
		this.deltaV= new Measure(deltaV, Unit.MetersPerSecond);
	}

	public Measure getDeltaX() {
		return this.deltaX;
	}

	public Measure getDeltaV() {
		return this.deltaV;
	}
	
	public double getDeltaXValue(){
		return this.deltaX.getValue();
	}
	
	public double getDeltaVValue(){
		return this.deltaV.getValue();
	}
	
}
