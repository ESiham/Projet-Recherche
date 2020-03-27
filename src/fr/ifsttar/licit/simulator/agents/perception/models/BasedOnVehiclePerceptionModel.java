package fr.ifsttar.licit.simulator.agents.perception.models;

import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.perception.vehicles.VehiclePerception;
import fr.ifsttar.licit.simulator.agents.trust.representation.Trust;

public interface BasedOnVehiclePerceptionModel {

	public double calcAccUsingPerception(Vehicle me, VehiclePerception perception, Trust trust);

	public double calcAccEurUsingPerception(Vehicle vehicle, VehiclePerception perception, Trust trust, double alphaTLocal, double alphaV0Local, double alphaALocal);
	
}
