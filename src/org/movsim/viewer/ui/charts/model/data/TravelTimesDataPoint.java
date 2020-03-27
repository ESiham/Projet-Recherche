package org.movsim.viewer.ui.charts.model.data;

public class TravelTimesDataPoint {
	
	private double vehicleTic=0.0;
	private double vehicleToc=0.0;
	
	private double ticPosition=0.0;
	private double tocPosition=0.0;
	private double travelTime = 0.0;
	
	public TravelTimesDataPoint(double startingTime, double startingPosition){
		this.vehicleTic = startingTime;
		this.ticPosition = startingPosition;
	}
	
	public TravelTimesDataPoint(double startingTime, double startingPosition, double endingTime, double endingPosition){
		this.vehicleTic = startingTime;
		this.ticPosition = startingPosition;
		this.vehicleToc = endingTime;
		this.tocPosition = endingPosition;
	}
	
	public boolean hasTravelTime(){
		return ((this.vehicleToc>this.vehicleTic) || this.travelTime>0.0);
	}
	
	public double getTravelTime(){
		if(this.hasTravelTime()){
			if(this.travelTime<=0.0)
				this.travelTime  =  (this.vehicleToc - this.vehicleTic);
		} else {
			this.travelTime = 0.0;
		}
		
		return this.travelTime;
	}
	
	public double getTravelTime(double vehicleToc){
		this.vehicleToc = vehicleToc;
		return this.getTravelTime();
	}

	public void setTravelTime(double travelTime) {
		this.travelTime = travelTime;
	}
	
	public void setEnding(double time, double position) {
		this.vehicleToc = time;
		this.tocPosition = position;
	}

	public double getTicPosition() {
		return ticPosition;
	}

	public void setTicPosition(double ticPosition) {
		this.ticPosition = ticPosition;
	}

	public double getTocPosition() {
		return tocPosition;
	}

	public void setTocPosition(double tocPosition) {
		this.tocPosition = tocPosition;
	}

	
	

}
