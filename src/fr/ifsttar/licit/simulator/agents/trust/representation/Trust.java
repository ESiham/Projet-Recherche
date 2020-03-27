package fr.ifsttar.licit.simulator.agents.trust.representation;

import java.util.Collection;
import java.util.Hashtable;

/**
 * 
 * Trust is a conceptual generic representation of trust or reputation
 * 
 * @author gueriau
 *
 */
public abstract class Trust {

	
	protected long vehicleID = Long.MAX_VALUE;
	
	/**
	 * trustValues are the numerical values already computed and keept in agent memory
	 */
	private Hashtable<Long, TrustValue> trustValues = new Hashtable<Long, TrustValue>();

	/**
	 * Default constructor, forces initialization
	 */
	public Trust(long vehicleID){
		this.vehicleID = vehicleID;
		this.initialize();
	}
	
	/**
	 * Initialize the trust values (usually with self-trust)
	 */
	public abstract void initialize();
	
	/**
	 * 
	 * @param vehicleID
	 * @return true if the given vehicle is know by current vehicle, false otherwise
	 */
	public boolean hasTrustValue(long vehicleID){
		return this.trustValues.containsKey(new Long(vehicleID));
	}
	
	/**
	 * 
	 * @param vehicleID
	 * @return the trust value corresponding to given vehicle
	 */
	public TrustValue getTrustValue(long vehicleID){
		if(hasTrustValue(vehicleID))
			return this.trustValues.get(new Long(vehicleID));
		else
			return null;
	}
	
	/**
	 * Erases the trust value corresponding to given vehicle
	 */
	public void setTrustValue(long vehicleID, TrustValue trustValue){
		this.trustValues.put(new Long(vehicleID), trustValue);
	}
	
	/**
	 * Erase the self trust parameter
	 * 
	 * @param selfTrust
	 */
	public void setSelfTrust(TrustValue selfTrust) {
		if(selfTrust!=null)
			this.trustValues.put(new Long(this.vehicleID), selfTrust);
	}
	
	
	public double getSelfTrustValue(){
		return this.trustValues.get(this.vehicleID).getValue();
	}
	
	/**
	 * 
	 * @param vehicleID
	 * @param trustValue
	 */
	protected void addTrustValue(long vehicleID, TrustValue trustValue){
		this.trustValues.put(new Long(vehicleID), trustValue);
	}
	
	/**
	 * 
	 * @param vehicleID
	 * @param trustValue
	 */
	protected void updateTrustValue(long vehicleID, TrustValue trustValue){
		if(this.hasTrustValue(vehicleID))
			this.addTrustValue(vehicleID, trustValue);
		else
			this.mergeTrustValue(vehicleID, trustValue);
	}

	/**
	 * Merges two trust values
	 * 
	 * @param vehicleID
	 * @param trustValue
	 */
	protected abstract void mergeTrustValue(long vehicleID, TrustValue trustValue);

	public Collection<Long> getKeys() {
		return this.trustValues.keySet();
	}

	
}
