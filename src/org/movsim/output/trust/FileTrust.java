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
package org.movsim.output.trust;

import org.movsim.autogen.Trusts;
import org.movsim.input.ProjectMetaData;
import org.movsim.output.fileoutput.FileOutputBase;
import org.movsim.simulator.MovsimConstants;
import org.movsim.simulator.SimulationTimeStep;
import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.roadnetwork.routing.Route;
import org.movsim.simulator.vehicles.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

import fr.ifsttar.licit.simulator.agents.AgentType;
import fr.ifsttar.licit.simulator.agents.trust.representation.Trust;

/**
 * The Class FileTrust.
 */
public class FileTrust extends FileOutputBase implements SimulationTimeStep {

    private static final String extensionFormat = ".trust.csv";//.route_%s.csv";
    private static final String outputHeading = COMMENT_CHAR
            + "     t[s],	truster_id,	trusted_id, trust_value";
    private static final String outputFormat = "%10.2f, %12d, %12d, %1.10f%n";

    /** The Constant LOG. */
    private final static Logger logger = LoggerFactory.getLogger(FileTrust.class);

    private final double positionIntervalStart;
    private final double positionIntervalEnd;
    private double lastUpdateTime = 0;
    private double time;

    private final Route route;

    private final Trusts trusts;
    
	//private String filename;
  
    public String getRouteName(){
    	return this.route.getName();
    }
    
    /**
     * Instantiates a new trajectories.
     * 
     * @param traj
     *            the trajectories input
     */
    public FileTrust(Trusts trusts, Route route) {
        super(ProjectMetaData.getInstance().getOutputPath(), ProjectMetaData.getInstance().getProjectName());
        this.trusts = Preconditions.checkNotNull(trusts);
        this.route = Preconditions.checkNotNull(route);
        positionIntervalStart = 0;
        positionIntervalEnd = route.getLength();

        logger.info("interval for output: timeStart=" + (trusts.isSetStartTime() ? trusts.getStartTime() : "--")
                + ", timeEnd=" + (trusts.isSetEndTime() ? trusts.getEndTime() : "--"));
        //this.filename = path + File.separator + baseFilename + extensionFormat;//String.format(extensionFormat, route.getName());
        writer = createWriter(extensionFormat);//String.format(extensionFormat, route.getName()));
        writeHeader(route);
    }
    
   private void writeHeader(Route route) {
        //writer.println(String.format("%s %s", COMMENT_CHAR, route.toString()));
        if(writer!=null){
	        writer.println(outputHeading);
	        writer.flush();
        }
    }

   @Override
   public void timeStep(double dt, double simulationTime, long iterationCount) {
      
	   this.time = simulationTime;
       if (isLargerThanStartTimeInterval() && isSmallerThanEndTimeInterval()) {
           if (iterationCount % 1000 == 0) {
               logger.info("time = {}, timestep= {}", time, dt);
           }
           if ((time - lastUpdateTime + MovsimConstants.SMALL_VALUE) >= trusts.getDt()) {
               lastUpdateTime = time;
               String formattedTime = ProjectMetaData.getInstance().getFormatedTimeWithOffset(simulationTime);
               writeTrusts(formattedTime);
           }
       }
   }



    private boolean isLargerThanStartTimeInterval() {
        if (!trusts.isSetStartTime()) {
            return true;
        }
        return time >= trusts.getStartTime();
    }

    private boolean isSmallerThanEndTimeInterval() {
        if (!trusts.isSetEndTime()) {
            return true;
        }
        return time <= trusts.getEndTime();
    }

    /**
     * Write trajectories.
     * 
     * @param roadSegment
     */
    private void writeTrusts(String formattedTime) {
      
        for (final RoadSegment roadSegment : route) {
            for (LaneSegment laneSegment : roadSegment.laneSegments()) {
                for (final Vehicle vehicle : laneSegment) {
                    if (vehicle.type() == AgentType.OBSTACLE) {
                        continue;
                    }
                    if (!trusts.isSetTypes() || this.typesMatch(trusts.getTypes(), vehicle.getLabel())) {
                        if (vehicle.getFrontPosition() >= positionIntervalStart
                                && vehicle.getFrontPosition() <= positionIntervalEnd) {
                        
                            writeVehicleData(vehicle, formattedTime);
                        }
                    }
                }
            }
        }  
    }

    
    /**
     * Check if the given label is in the given types list
     * @param types
     * @param label
     * @return true if found, false otherwise
     */
    private boolean typesMatch(String types, String label) {
    	
    	if(types=="")
    		return true;
    	
    	if(types.contains(label)){
    		return true;
    	}
    	
    	return false;
	}
    
	/**
     * Write vehicle data.
     * 
     * @param me
     * @param positionOnRoute
     * @param frontVehicle
     */
    private void writeVehicleData(Vehicle vehicle, String formattedTime) {

       Trust trust = vehicle.getTrust();
       
       if(trust!=null){
    	   //System.out.println(trust.getKeys().size());
	       for(Long id : trust.getKeys()){
	    	   if(id != vehicle.getId()) // do not write selfTrust here
	    	   write(outputFormat, time, vehicle.getId(), id,trust.getTrustValue(id).getValue());
	       }
	       
	       //if(trust.getKeys().size()>1){
	    	//   System.out.println("vehicle no : " + vehicle.getId() + " has " + trust.getKeys().size() + " trusted" );
	       //}
       }

    }
   
    
}
