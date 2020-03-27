package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements;

import fr.ifsttar.licit.simulator.util.units.Unit;

public class Measure {

	private double value;
	
	private Unit unit;
	
	public Measure(double value, Unit unit){
		this.value = value;
		this.unit = unit;
	}

	public double getValue() {
		return value;
	}

	public Unit getUnit() {
		return unit;
	}
	
	
}
