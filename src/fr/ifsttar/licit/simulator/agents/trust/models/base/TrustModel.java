package fr.ifsttar.licit.simulator.agents.trust.models.base;

import java.util.ArrayList;

import fr.ifsttar.licit.simulator.agents.communication.messages.TrustMessage;
import fr.ifsttar.licit.simulator.agents.perception.representation.SensedVehicle;
import fr.ifsttar.licit.simulator.agents.trust.representation.Trust;

/**
 * 
 * This class is the super class of Trust models implementation.
 * It is designed to provide the agents a specific framework dedicated to trust management 
 *   
 * 
 * @author Maxime
 *
 */
public abstract class TrustModel {

	/**
	 * Clear all variables and restore the model for a new trust computation
	 */
	public abstract void clean();
	
	public abstract void handleTrustMessage(TrustMessage trustMessage, long thisId, ArrayList<Long> sensedVehiclesIds);

	public abstract void compareDirectInformation(Trust trust, SensedVehicle immediateFollower, double myPosition, double simulationTime);

	public abstract void computeTrust(Trust trust, long thisId);

	
}
