package org.movsim.viewer.ui.charts.model.data.sets;

import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.commons.math3.stat.Frequency;
import org.movsim.input.ProjectMetaData;
import org.movsim.viewer.ui.charts.model.data.TravelTimesDataPoint;

import fr.ifsttar.licit.simulator.util.units.Unit;

public class TravelTimesDataSet extends XYDataSet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8053453241700426467L;

	private Hashtable<Long,TravelTimesDataPoint> travelTimes = new Hashtable<Long,TravelTimesDataPoint>();
	
	private ArrayList<CFDTravelTime> cfdTravelTimes = new ArrayList<CFDTravelTime>();

	private int numberOfTT, previousNumberOfTT = 0;

	public TravelTimesDataSet(){
		super("Travel times distribution " + ProjectMetaData.getInstance().getProjectName(), "Travel Time", Unit.Second, "Frequency", Unit.Probability);
	}
	
	
	public void addStartTravelTimeData(long vehicleID, double time, double startPosition){
		travelTimes.put(vehicleID, new TravelTimesDataPoint(time, startPosition));
		//System.out.println("adding vehicle " + vehicleID);
	}
	
	public void addEndTravelTimeData(long vehicleID, double time, double endPosition){
		
		if(travelTimes.containsKey(vehicleID)){
			travelTimes.get(vehicleID).setEnding(time, endPosition);
			//System.out.println(" Finished ! =>  " + travelTimes.get(vehicleID).getTravelTime());
			this.numberOfTT = this.getNumberOfTravelTimes();
		}
	}
	
	public void setTravelTime(long vehicleID, double travelTime) {
		travelTimes.get(vehicleID).setTravelTime(travelTime);
	}
	

	public void fireDataChanged(){
		
		//if CFD is not up to date
		// update CFD
		if(this.numberOfTT!=previousNumberOfTT){
			//update CFD
			this.computeTT_CFD();
			this.previousNumberOfTT=this.numberOfTT;
		}
		
		
		super.fireDatasetChanged();
	}
	
	private int getNumberOfTravelTimes() {
		int number = 0;
		for(TravelTimesDataPoint p : this.travelTimes.values()){
			if(p.hasTravelTime())
				number++;
		}
		
		return number;
	}


	private void computeTT_CFD() {
		
		this.cfdTravelTimes.clear();
		
		Frequency f = new Frequency();
		
		int min = -1;
		int max = -1;
		double number = 0.0;
		
		for(TravelTimesDataPoint p : this.travelTimes.values()){
			if(p.hasTravelTime()){
				int value = (int) p.getTravelTime();
				if(min<0)
					min=value;
				if(max<0)
					min=value;
				if(value<min)
					min = value;
				if(value>max)
					max=value;
				f.addValue(value);
				number++;
			}
		}
		
		for(int i = min ; i<max; ++i){
			this.cfdTravelTimes.add(new CFDTravelTime(i, (f.getCount(i)/ number)));
		}
		
	}


	@Override
	public int getItemCount(int serie) {
		return cfdTravelTimes.size();
	}

	@Override
	public Number getX(int serie, int item) {
		return cfdTravelTimes.get(item).getValue();
	}
	
	@Override
	public Number getY(int serie, int item) {
		return cfdTravelTimes.get(item).getFrequency();
		
	}

	@Override
	public int getSeriesCount() {
		return 1;
	}

	@Override
	public Comparable<TravelTimesDataSet> getSeriesKey(int serie) {
		// TODO Auto-generated method stub
		return null;
	}


	public void clear(){
		this.cfdTravelTimes.clear();
		this.travelTimes.clear();
	}

	
	
	public class CFDTravelTime {
		

		private double value;
		private double frequency;

		public CFDTravelTime(double value, double frequency){
			this.value = value;
			this.frequency = frequency;
		}
		
		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public double getFrequency() {
			return frequency;
		}

		public void setFrequency(double frequency) {
			this.frequency = frequency;
		}

	}



	

}