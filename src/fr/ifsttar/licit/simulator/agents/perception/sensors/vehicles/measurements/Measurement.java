package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements;

/**
 * 
 * @author mgueriau
 *
 * @param <T> is the class the sensed value is coming from
 */
public abstract class Measurement {
	
	/**
	 * Id of the vehicle holding this sensor
	 */
	protected long vehicleId; 
	
	public Measurement(long vehicleId){
		this.vehicleId = vehicleId;
	}
	
	public long getSenderId(){
		return this.vehicleId;
	}
	
}
