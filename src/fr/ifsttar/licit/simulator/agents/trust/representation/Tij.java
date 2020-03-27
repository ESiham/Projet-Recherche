package fr.ifsttar.licit.simulator.agents.trust.representation;

/**
 * 
 * 
 * @author mgueriau
 *
 */
public class Tij {

	private long iID;
	private long jID;
	private TrustValue value;

	public Tij(long i, long j, TrustValue value){
		this.iID=i;
		this.jID=j;
		this.value=value.clone();
	}
	
	public boolean isSelfTrust(){
		return (this.iID==this.jID);
	}
	
	public long geti() {
		return iID;
	}

	public long getj() {
		return jID;
	}

	public TrustValue getTrustValue() {
		return value;
	}
	
}
