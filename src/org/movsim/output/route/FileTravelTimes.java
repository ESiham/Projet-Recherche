/*
 * Copyright (C) 2010, 2011, 2012 by Arne Kesting, Martin Treiber, Ralph Germ, Martin Budden
 * <movsim.org@gmail.com>
 * -----------------------------------------------------------------------------------------
 * 
 * This file is part of
 * 
 * MovSim - the multi-model open-source vehicular-traffic simulator.
 * 
 * MovSim is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MovSim is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MovSim. If not, see <http://www.gnu.org/licenses/>
 * or <http://www.movsim.org>.
 * 
 * -----------------------------------------------------------------------------------------
 */
package org.movsim.output.route;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.movsim.autogen.TravelTimes;
import org.movsim.input.ProjectMetaData;
import org.movsim.output.fileoutput.FileOutputBase;
import org.movsim.simulator.MovsimConstants;
import org.movsim.simulator.SimulationTimeStep;
import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.roadnetwork.routing.Route;
import org.movsim.simulator.vehicles.Vehicle;
import org.movsim.viewer.ui.charts.model.data.sets.TravelTimesDataSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import fr.ifsttar.licit.simulator.agents.AgentType;

/**
 * The Class FileTravelTimes.
 */
public class FileTravelTimes extends FileOutputBase implements SimulationTimeStep {

    private static final String extensionFormat = ".TT.csv";//.route_%s.csv";
    private static final String outputHeading = COMMENT_CHAR
            + "id,  startTime[s], startPosition[m], endTime[s], endPosition[m], travelTime[s]";
    private static final String outputFormat = "%12d, %10.2f, %10.4f, %10.2f, %10.4f, %10.2f%n";

    /** The Constant LOG. */
    private final static Logger logger = LoggerFactory.getLogger(FileTravelTimes.class);

    private double positionIntervalStart;
    private double positionIntervalEnd;
    private double time;
    private double lastUpdateTime = 0;
    private final Route route;

    private final TravelTimes tts;
    
    
    private TravelTimesDataSet travelTimesDataSet = null;
    
	private String filename;
	private BufferedReader reader;
   
    public void removeTravelTimesDataSet(){
    	if(travelTimesDataSet!=null){
    		travelTimesDataSet.clear();
    		travelTimesDataSet=null;
    	}
    }
    
    public String getRouteName(){
    	return this.route.getName();
    }
    
    /**
     * Instantiates a new trajectories.
     * 
     * @param traj
     *            the trajectories input
     */
    public FileTravelTimes(TravelTimes tts, Route route) {
        super(ProjectMetaData.getInstance().getOutputPath(), ProjectMetaData.getInstance().getProjectName());
    
        this.tts = Preconditions.checkNotNull(tts);
        this.route = Preconditions.checkNotNull(route);
        positionIntervalStart = 0;
        positionIntervalEnd = route.getLength();

        if(tts.getEndPosition()>0.0 && tts.getEndPosition()<=route.getLength())
        	this.positionIntervalEnd=tts.getEndPosition();
        
        if(tts.getStartPosition()>=0.0 && tts.getStartPosition() < this.positionIntervalEnd)
        	this.positionIntervalStart=tts.getStartPosition();
        
        
        final double toleranceGap = 2.0;
        this.positionIntervalStart+=toleranceGap;
        this.positionIntervalEnd-=toleranceGap;
        
        this.filename = path + File.separator + baseFilename + extensionFormat;//String.format(extensionFormat, route.getName());
        writer = createWriter(extensionFormat);//String.format(extensionFormat, route.getName()));
        
        //System.out.println("writer ! ! ! " + writer);
        
        writeHeader(route);
    }

    private void writeHeader(Route route) {
        //writer.println(String.format("%s %s", COMMENT_CHAR, route.toString()));
        writer.println(outputHeading);
        writer.flush();
    }

    @Override
    public void timeStep(double dt, double simulationTime, long iterationCount) {
        this.time = simulationTime;
        
        if (iterationCount % 1000 == 0) {
            logger.info("time = {}, timestep= {}", time, dt);
        }
        if ((time - lastUpdateTime + MovsimConstants.SMALL_VALUE) >= tts.getDt()) {
            lastUpdateTime = time;
            String formattedTime = ProjectMetaData.getInstance().getFormatedTimeWithOffset(simulationTime);
            writeTravelTimes(formattedTime);
        }
        
    }


    /**
     * Write trajectories.
     * 
     * @param roadSegment
     */
    private void writeTravelTimes(String formattedTime) {
        double positionOnRoute = 0.0;
        for (final RoadSegment roadSegment : route) {
            for (LaneSegment laneSegment : roadSegment.laneSegments()) {
            	/***
            	 * 
            	 */
            	//if(!traj.isSetLane() || traj.getLane() == laneSegment.lane()){
            	/**
            	 * 
            	 */
	                for (final Vehicle vehicle : laneSegment) {
	                    if (vehicle.type() == AgentType.OBSTACLE) {
	                        continue;
	                    }
	                    //if (!tts.isSetRandomFraction() || vehicle.getRandomFix() < tts.getRandomFraction()) {
	                        if ((vehicle.getFrontPosition() + positionOnRoute) <= positionIntervalStart
	                               || (vehicle.getFrontPosition()+positionOnRoute) >= positionIntervalEnd) {
	                            writeVehicleData(vehicle, positionOnRoute,formattedTime);
	                        }
	                    //}
	                }
	            /**
	             * 
	             */
            	//}
            	/**
            	 * 
            	 */
            }
            positionOnRoute += roadSegment.roadLength();
        }
        
       
        if(this.travelTimesDataSet!=null)
        	this.travelTimesDataSet.fireDataChanged();
        
    }

    /**
     * Write vehicle data.
     * 
     * @param me
     * @param positionOnRoute
     * @param frontVehicle
     */
    private void writeVehicleData(Vehicle me, double positionOnRoute, String formattedTime) {
    	final double pos = me.getFrontPosition() + positionOnRoute;
    	
    	int line = findVehicleIdInFile(me.getId());
    	
    	File file = new File(filename);
		List<String> lines;
    	
		try {
			lines = org.apache.commons.io.FileUtils.readLines(file);
		
		
    	if(line<0){ //new vehicle
    		if(pos<positionIntervalEnd){
    			String stringLine =String.format(outputFormat.substring(0, outputFormat.length()-2), me.getId(), time, pos, 0.00d, 0.00d, 0.00d);// "" + me.getId() + "," + time + ","+ pos + ","+ 0.00d  + "," + 0.00d + "," + 0.00d+"\n" ;
    			lines.add(stringLine);
	    		org.apache.commons.io.FileUtils.writeLines(file, lines, false);
    			//writer.write(stringLine);
    			//write(outputFormat,  me.getId(), time, pos, 0.00d, 0.00d, 0.00d);
    			//System.out.println(">>>> write :  <<<<  " +  me.getId() + " , " +  time + "  , " + pos + "     vs.   " + positionIntervalEnd);
    		}
           
    	} else { //vehicle to update
    		
    		//System.out.println(" already existing ! " + line + " id = "  + me.getId());
    		
    	
				
				//System.out.println("before " + lines.size());
				
				String[] tokens = lines.get(line-1).split(",");
				//System.out.println(tokens.length);
				if(tokens.length==6){
					
					final long id = Long.parseLong(tokens[0].replaceAll("[^0-9.-]", ""));
					final double startTime = Double.parseDouble(tokens[1].replaceAll(" ", ""));
					final double startPosition = Double.parseDouble(tokens[2].replaceAll(" ", ""));
					
					//System.out.println("current pos = " + pos + " , start pos was = " + startPosition);
					
					if(pos > positionIntervalEnd){
						String stringLine = String.format(outputFormat.substring(0, outputFormat.length()-2),id, startTime, startPosition, time, pos, (time - startTime));//"" + id + "," + startTime + ","+ startPosition + ","+ time  + "," + pos + "," + (time - startTime);
						lines.set((line-1), stringLine);
			    		org.apache.commons.io.FileUtils.writeLines(file, lines, false);
			    		
			    		//System.out.println("after " + lines.size());
					}
				}
				
				
			
    		
    	}
    	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    
        
    }

    
    
    /**
     * Looks for the first line beginning by given id
     * @param id 
     * 
     * @return the corresponding number, -1 otherwise
     */
    private int findVehicleIdInFile(long vehicleId) {
    	int lane = -1;

    	//if(this.reader==null){
    		try {
				reader = new BufferedReader(new FileReader(filename));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// FileUtils.getReader(filename);
    	//}
		
    
    	//System.out.println(" ------------------- looking for vehicle number " + vehicleId);
    	
		//two firsts lines are dedicated to information
		try {
			
			String line = null;
			
			line=reader.readLine();
			//System.out.println(line);
			//line=reader.readLine();
			//System.out.println(line);
			
			int laneNum = 1;
		
			//System.out.println(" ------------------- looking for vehicle number " + vehicleId);
			
			while((line=reader.readLine())!=null && lane<0){
				laneNum++;
				//System.out.println(laneNum);
				String[] tokens = line.split(",");

				
				//System.out.println(tokens.length);
				if(tokens.length==6){
					
					//System.out.println("ID =" + tokens[0].replaceAll("[^0-9.-]", ""));
					
					final long id = Long.parseLong(tokens[0].replaceAll("[^0-9.-]", ""));
					if(vehicleId == id){
						lane = laneNum;
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

    	
    	
		return lane;
	}

	/***
     * data Set !
     * @return
     */
    
	public TravelTimesDataSet getTravelTimesDataSet() {
		if(this.travelTimesDataSet == null){
			this.travelTimesDataSet = this.createTravelTimesDataSet();
		}
		return this.travelTimesDataSet;
	}
	
	
	private TravelTimesDataSet createTravelTimesDataSet() {
		
		TravelTimesDataSet dataSet = new TravelTimesDataSet();
		
		//read data from csv file and add them to current dataset		
		//BufferedReader reader = FileUtils.getReader(filename);
		//if(this.reader==null){
    		try {
				reader = new BufferedReader(new FileReader(filename));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// FileUtils.getReader(filename);
    	//}
		
		//two firsts lines are dedicated to information
		try {
			reader.readLine();
			//reader.readLine();
			String line = null;
			
			while((line=reader.readLine())!=null){
				String[] tokens = line.split(",");
				//System.out.println(tokens.length);
				if(tokens.length==6){
					
					final long id = Long.parseLong(tokens[0].replace(" ", ""));
					final double startTime = Double.parseDouble(tokens[1].replace(" ", ""));
					final double startPosition = Double.parseDouble(tokens[2].replace(" ", ""));
					final double endTime = Double.parseDouble(tokens[3].replace(" ", ""));
					final double endPosition = Double.parseDouble(tokens[4].replace(" ", ""));
					final double travelTime = Double.parseDouble(tokens[5].replace(" ", ""));
					
					if(startPosition>=this.positionIntervalStart){
						dataSet.addStartTravelTimeData(id, startTime, startPosition);
					} 

					if(endPosition>this.positionIntervalStart){
						dataSet.addEndTravelTimeData(id, endTime, endPosition);
					}
					
					if(travelTime>0.0d){
						dataSet.setTravelTime(id,travelTime);
					}
					
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
			
		
		return dataSet;
	}
	
	
}
