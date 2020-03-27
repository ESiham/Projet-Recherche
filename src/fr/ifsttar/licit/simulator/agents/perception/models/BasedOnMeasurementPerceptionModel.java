package fr.ifsttar.licit.simulator.agents.perception.models;

import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;
import fr.ifsttar.licit.simulator.agents.trust.representation.Trust;

public interface BasedOnMeasurementPerceptionModel {

	public double calcAccUsingPerception(Vehicle me, MeasurementPerception perception, Trust trust);

	public double calcAccEurUsingPerception(Vehicle vehicle, MeasurementPerception perception, Trust trust, double alphaTLocal, double alphaV0Local, double alphaALocal);
	
}
