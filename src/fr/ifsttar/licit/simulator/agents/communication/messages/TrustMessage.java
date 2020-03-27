package fr.ifsttar.licit.simulator.agents.communication.messages;

import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.trust.representation.Tij;
import fr.ifsttar.licit.simulator.agents.trust.representation.TrustValue;

public class TrustMessage extends Message {

	private Tij tij;
	
	/*public TrustMessage(Vehicle sender, Tij relativeTrust) {
		super(sender);
		this.tij = relativeTrust;
	}*/
	
	public TrustMessage(Vehicle sender, long trusted, TrustValue trust) {
		super(sender);
		this.tij = new Tij(sender.getId(), trusted, trust);
	}
	

	public Tij getTij(){
		return this.tij;
	}
}
