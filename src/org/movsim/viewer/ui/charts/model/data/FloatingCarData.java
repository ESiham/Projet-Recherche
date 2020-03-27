package org.movsim.viewer.ui.charts.model.data;

import java.util.ArrayList;

import org.movsim.viewer.ui.charts.model.FloatingCarDataPoint;

/**
 * FloatingCarData represents a serie of car Data
 * 
 * @author mgueriau
 *
 */
public class FloatingCarData {

	/**
	 * Vehicle Reference ID
	 */
	private long vehicleID;
	
	private ArrayList<FloatingCarDataPoint> floatingCarDataPoints = new ArrayList<FloatingCarDataPoint>();
	
	public FloatingCarData(long vehicleID){
		this.vehicleID=vehicleID;
	}
	
	public int getDataSize(){
		return this.floatingCarDataPoints.size();
	}
	
	public long getVehicleID() {
		return this.vehicleID;
	}
	
	public void addFloatingCarDataPoint(double time, double position, double speed/*, double acc*/){
		this.floatingCarDataPoints.add(new FloatingCarDataPoint(time, position, speed/*, acc*/));
	}
	
	public FloatingCarDataPoint getFloatingCarDataPoint(int index){
		return this.floatingCarDataPoints.get(index);
	}
	
	public ArrayList<FloatingCarDataPoint> getFloatingCarDataPoints(){
		return this.floatingCarDataPoints;
	}
	
	public void clear(){
		this.floatingCarDataPoints.clear();
	}
}
