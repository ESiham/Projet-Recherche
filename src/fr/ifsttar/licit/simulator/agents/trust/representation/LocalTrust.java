package fr.ifsttar.licit.simulator.agents.trust.representation;

public class LocalTrust extends Trust {

	/**
	 * Default constructor, should not hide superclass constructor
	 */
	public LocalTrust(long vehicleID) {
		super(vehicleID);
	}
	
	
	@Override
	protected void mergeTrustValue(long vehicleID, TrustValue trustValue) {
		TrustValue oldTrustValue = this.getTrustValue(vehicleID);
		if(oldTrustValue==null){
			this.addTrustValue(vehicleID, trustValue);
		} else {
			trustValue.merge(oldTrustValue);	
		}
	}

	@Override
	public void initialize() {
		this.updateTrustValue(this.vehicleID, TrustValue.defaultValue());
	}

	
}
