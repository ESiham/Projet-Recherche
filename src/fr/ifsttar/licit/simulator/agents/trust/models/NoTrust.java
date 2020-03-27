package fr.ifsttar.licit.simulator.agents.trust.models;

import java.util.ArrayList;

import fr.ifsttar.licit.simulator.agents.communication.messages.TrustMessage;
import fr.ifsttar.licit.simulator.agents.perception.representation.SensedVehicle;
import fr.ifsttar.licit.simulator.agents.trust.models.base.TrustModel;
import fr.ifsttar.licit.simulator.agents.trust.models.parameters.TrustModelParameterNoTrust;
import fr.ifsttar.licit.simulator.agents.trust.representation.Trust;

public class NoTrust extends TrustModel {

	public NoTrust(TrustModelParameterNoTrust trustModelParameterNoTrust) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleTrustMessage(TrustMessage trustMessage, long thisId, ArrayList<Long> sensedVehiclesIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void compareDirectInformation(Trust trust, SensedVehicle immediateFollower,
			double myPosition, double simulationTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void computeTrust(Trust trust, long thisId) {
		// TODO Auto-generated method stub
		
	}

}
