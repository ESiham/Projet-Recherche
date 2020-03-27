package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements;

import fr.ifsttar.licit.simulator.util.units.Unit;

public class GPSMeasurement extends Measurement{

	public Measure position;
	public Measure speed;
	
	public GPSMeasurement(long vehicleId, double position, double speed, int lane) {
		super(vehicleId);
		this.position = new Measure(position, Unit.Meters);
		this.speed = new Measure(speed, Unit.MetersPerSecond);
	}
	
	public Measure getPosition() {
		return this.position;
	}
	
	public double getPositionValue(){
		return this.position.getValue();
	}
	
	public Measure getSpeed(){
		return this.speed;
	}
	
	public double getSpeedValue(){
		return this.speed.getValue();
	}

}
