package fr.ifsttar.licit.simulator.agents.perception.vehicles;

import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;

/**
 * Perception is a local and partial representation of a Vehicle surrounding environment at a given time step of the simulation
 * This object holds all the entities perceived by the vehicle sensors 
 * 
 * FIXME: we should better use a partial representation of perceived vehicles (like a light class) instead of the Vehicle class which holds almost everything that should not be visible by other vehicles 
 * 
 * @author gueriau
 *
 */
public class VehiclePerception extends AgentPerception {
	
	/**
	 * All the perceived Vehicles
	 */
	//FIXME : we may use a generic list of vehicles instead of only few fixed slots
	//private List<Vehicle> vehicles = new LinkedList<Vehicle>();
	private Vehicle currentVehicle = null;
	private Vehicle frontVehicle = null;
	private Vehicle leftVehicle = null;
	private Vehicle rightVehicle = null;
	private Vehicle rearVehicle = null;
	private double deltaXeq = 20.0;
	private double veq = 3.6;
	
	
	/**
	 * Add the given vehicle to the current perception
	 * @param vehicle
	 */
	/*public void addVehicle(Vehicle vehicle){
		this.vehicles.add(vehicle);
	}*/
	
	/**
	 * 
	 * @return the perceived self vehicle
	 */
	public Vehicle getCurrentVehicle() {
		return currentVehicle;
	}

	/**
	 * Add the current vehicle to current perception
	 * 
	 * @param currentVehicle
	 */
	public void setCurrentVehicle(Vehicle currentVehicle) {
		this.currentVehicle = currentVehicle;
	}
	
	/**
	 * 
	 * @return the perceived immediate front vehicle
	 */
	public Vehicle getFrontVehicle() {
		return frontVehicle;
	}

	/**
	 * Add the front vehicle to current perception
	 * 
	 * @param frontVehicle
	 */
	public void setFrontVehicle(Vehicle frontVehicle) {
		this.frontVehicle = frontVehicle;
	}

	/**
	 * 
	 * @return the perceived immediate left vehicle
	 */
	public Vehicle getLeftVehicle() {
		return leftVehicle;
	}

	/**
	 * Add the left vehicle to current perception
	 * 
	 * @param leftVehicle
	 */
	public void setLeftVehicle(Vehicle leftVehicle) {
		this.leftVehicle = leftVehicle;
	}

	/**
	 * 
	 * @return the perceived immediate right vehicle
	 */
	public Vehicle getRightVehicle() {
		return rightVehicle;
	}

	/**
	 * Add the right vehicle to current perception
	 * 
	 * @param rightVehicle
	 */
	public void setRightVehicle(Vehicle rightVehicle) {
		this.rightVehicle = rightVehicle;
	}


	
	/**
	 * Merge the given perception with the current object
	 * (Simply adds all new perceived objects to current object)
	 * 
	 * @param perception
	 */
	@Override
	public void mergeObjects(AgentPerception perception) {
		
		if(perception instanceof VehiclePerception){
		
			VehiclePerception vehiclePerception = (VehiclePerception) perception;
			
			if(this.currentVehicle==null)
				this.currentVehicle=vehiclePerception.currentVehicle;
			
			if(this.frontVehicle==null)
				this.frontVehicle=vehiclePerception.frontVehicle;
			
			if(this.leftVehicle==null)
				this.leftVehicle=vehiclePerception.leftVehicle;
			
			if(this.rightVehicle==null)
				this.rightVehicle=vehiclePerception.rightVehicle;
			
			if(this.rearVehicle==null)
				this.rearVehicle=vehiclePerception.rearVehicle;
		} 
			
	}	
	

	public Vehicle getRearVehicle() {
		return rearVehicle;
	}

	public void setRearVehicle(Vehicle rearVehicle) {
		this.rearVehicle = rearVehicle;
	}

	public double getDeltaXeq() {
		return this.deltaXeq;
	}
	
	public void setDeltaXeq(double deltaXeq) {
		this.deltaXeq = deltaXeq;
	}

	public double getVeq() {
		return this.veq;
	}
	
	public void setVeq(double veq) {
		this.veq = veq;
	}


	
	
}
