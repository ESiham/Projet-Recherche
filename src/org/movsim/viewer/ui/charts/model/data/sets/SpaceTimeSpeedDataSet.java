package org.movsim.viewer.ui.charts.model.data.sets;

import java.util.ArrayList;
import java.util.Hashtable;

import org.movsim.input.ProjectMetaData;
import org.movsim.simulator.roadnetwork.Lanes;
import org.movsim.viewer.ui.charts.model.data.FloatingCarData;

import fr.ifsttar.licit.simulator.util.units.Unit;

public class SpaceTimeSpeedDataSet extends XYZDataSet {

	private static final long serialVersionUID = -5620279359158175121L;
	
	private ArrayList<FloatingCarData> cars = new ArrayList<FloatingCarData>();
	
	private Hashtable<Long, Integer> correspondingIDs = new Hashtable<Long, Integer>();
	
	private int lane = Lanes.MOST_INNER_LANE;

	public int getLane() {
		return lane;
	}
	
	public void setLane(int lane){
		if(this.lane != lane){
			this.lane=lane;
			this.title = "Vehicles Trajectories on lane " + lane + " " +ProjectMetaData.getInstance().getProjectName();
		}
		
	}

	/**
	 * update frequency in seconds
	 */ 
	//private double frequency = 1.0;
	
	public SpaceTimeSpeedDataSet(/*Simulator simulator, final RoadSegment roadSegment,*/ int lane){
		super(/*simulator, roadSegment, */"Vehicles Trajectories on lane " + lane + " " + /*simulator.generateScenarioName()*/ProjectMetaData.getInstance().getProjectName(), "Time", Unit.Second, "Position", Unit.Meters, "Speed", Unit.KilometersPerHour); ;
		this.lane=lane;
	}
	
	public SpaceTimeSpeedDataSet(){
		super("Vehicles trajectories", "Time", Unit.Second, "Position", Unit.Meters, "Speed", Unit.KilometersPerHour); ;
		this.lane=Lanes.MOST_INNER_LANE;
	}
	
	//public SpaceTimeSpeedDataSet(/*Simulator simulator, final RoadSegment roadSegment*/){
	//	super(/*simulator, roadSegment, */"Vehicles Trajectories on right lane" + simulator.generateScenarioName(), "Time", Unit.Second, "Position", Unit.Meters, "Speed", Unit.KilometersPerHour); ;
	//}ù
	
	public void addFloatingCarData(long vehicleID, double time, double position, double speed){
		
		if(!correspondingIDs.containsKey(new Long(vehicleID))){
			this.cars.add(new FloatingCarData(vehicleID));
			//System.out.println("Add car " + vehicleID);
			int index = this.cars.size()-1;
			this.correspondingIDs.put(vehicleID, index);
			//System.out.println(this.cars.size());
		}
		
		cars.get(correspondingIDs.get(vehicleID)).addFloatingCarDataPoint(time, position, speed);
	
	}
	
	public ArrayList<FloatingCarData> getCarsData(){
		return this.cars;
	}

	public void fireDataChanged(){
		super.fireDatasetChanged();
	}
	
	@Override
	public int getItemCount(int serie) {
		return cars.get(serie).getDataSize();
	}

	@Override
	public Number getX(int serie, int item) {
		return cars.get(serie).getFloatingCarDataPoint(item).getTime();
	}
	
	@Override
	public Number getY(int serie, int item) {
		return cars.get(serie).getFloatingCarDataPoint(item).getPosition();
		
	}
	
	@Override
	public Number getZ(int serie, int item) {
		return cars.get(serie).getFloatingCarDataPoint(item).getSpeed();
	}

	@Override
	public int getSeriesCount() {
		return cars.size();
	}

	@Override
	public Comparable<SpaceTimeSpeedDataSet> getSeriesKey(int serie) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	@Override
	public void updateDrawing(double simulationTime) {



		if((Math.floor(simulationTime * 10.0)) % (10.0*frequency) ==0){

			//System.out.println(simulationTime);

			for (final Vehicle vehicle : this.roadSegment) {
				if(vehicle.lane()==this.lane)
					this.addFloatingCarData(vehicle.getId(), simulationTime, vehicle.getFrontPosition(), vehicle.getSpeed()*3.6);
			}


			this.fireDatasetChanged();

		}


	}*/




	public void clear(){
		for(FloatingCarData data : this.cars){
			data.clear();
		}
		this.correspondingIDs.clear();
		this.cars.clear();
	}

}