package fr.ifsttar.licit.simulator.agents.trust.representation;

/**
 * 
 * A trust value is represented by a value giving the trust an agent as in an agent "trustedID"
 * 
 * @author mgueriau
 *
 */
public class TrustValue {
	
	private static double DEFAULT_VALUE = 1.0d;
	
	protected double value;

	public TrustValue(){
		this(DEFAULT_VALUE);
	}
	
	public TrustValue(double value){
		this.value=value;
	}
	
	public TrustValue(TrustValue trustValue) {
		this(trustValue.value);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = this.clamp01(value);
	}
	
	
	private double clamp01(double value) {
		
		double clampedValue = value;
		
		if(clampedValue<0.0d)
			clampedValue=0.0d;
		else if(clampedValue>1.0d)
			clampedValue=1.0d;
			
		return clampedValue ;
	}

	/**
	 * Merges two trusts values
	 * 
	 * @param trustValue
	 */
	public void merge(TrustValue trustValue) {
		this.value = (this.value + trustValue.value) / 2.0;
	}

	public static TrustValue defaultValue() {
		return new TrustValue();
	}
	
	@Override
	public TrustValue clone(){
		return new TrustValue(this);
	}
}
