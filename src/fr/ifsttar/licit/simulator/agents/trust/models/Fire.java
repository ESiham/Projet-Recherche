package fr.ifsttar.licit.simulator.agents.trust.models;

import java.util.ArrayList;

import fr.ifsttar.licit.simulator.agents.communication.messages.TrustMessage;
import fr.ifsttar.licit.simulator.agents.perception.representation.SensedVehicle;
import fr.ifsttar.licit.simulator.agents.trust.models.base.TrustModel;
import fr.ifsttar.licit.simulator.agents.trust.models.parameters.TrustModelParameterFire;
import fr.ifsttar.licit.simulator.agents.trust.representation.Trust;
import fr.ifsttar.licit.simulator.agents.trust.representation.experience.ExperienceTrustValue;

public class Fire extends TrustModel {

	public Fire(TrustModelParameterFire trustModelParameterFire) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
	}

	@Override
	public void handleTrustMessage(TrustMessage trustMessage, long thisId, ArrayList<Long> sensedVehiclesIds) {
		// do nothing (trust messages are for witness information)
	}

	@Override
	public void compareDirectInformation(Trust trust, SensedVehicle immediateFollower,
			double myPosition, double simulationTime) {
		
		final double DTij = this.computeDirectTrustValue(immediateFollower, myPosition);
		
		if(trust.hasTrustValue(immediateFollower.getSenderId())){
			ExperienceTrustValue trustValue = (ExperienceTrustValue) trust.getTrustValue(immediateFollower.getSenderId());
			trustValue.addExperience(DTij, simulationTime);
		} else {
			trust.setTrustValue(immediateFollower.getSenderId(), new ExperienceTrustValue(DTij, simulationTime));
		}
	}

	@Override
	public void computeTrust(Trust trust, long thisId) {
		
	}

	private Double computeDirectTrustValue(SensedVehicle immediateFollower, double myPosition) {
    	
		final double GPSDeltaX = Math.abs(immediateFollower.getAbsoluteX() - myPosition);
		
		final double TelemeterDeltaX = Math.abs(immediateFollower.getRelativePosition());
		
	
		double error = Math.abs(TelemeterDeltaX-GPSDeltaX) / GPSDeltaX;
		
		double directTrustValue = 1.0 - error;
		
		if(directTrustValue<0)
			directTrustValue=0.0;
		
    	return directTrustValue;
	}

}
