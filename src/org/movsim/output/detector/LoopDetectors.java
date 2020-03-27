/*
 * Copyright (C) 2010, 2011, 2012 by Arne Kesting, Martin Treiber, Ralph Germ, Martin Budden
 *                                   <movsim.org@gmail.com>
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
package org.movsim.output.detector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.movsim.autogen.CrossSection;
import org.movsim.simulator.SimulationTimeStep;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

/**
 * The Class LoopDetectors.
 */
public class LoopDetectors implements SimulationTimeStep {
    final static Logger logger = LoggerFactory.getLogger(LoopDetectors.class);

    /** The detectors. */
    private final List<LoopDetector> detectors = new ArrayList<>();

    /**
     * Constructor.
     * 
     * @param detectorInput
     *            the input
     */
    public LoopDetectors(RoadSegment roadSegment, org.movsim.autogen.Detectors detectorInput) {
        Preconditions.checkNotNull(detectorInput);
        final double dtSample = detectorInput.getSampleInterval();
        for (final PositionAndId detPositionAndId : getSortedPositionsAndIds(detectorInput.getCrossSection(), this)) {
            detectors.add(new LoopDetector(roadSegment, detPositionAndId.id, detPositionAndId.position, dtSample, detectorInput.isLogging(),
                    detectorInput.isLoggingLanes()));
        }
    }
   
    
    private class PositionAndId{
    	public int id;
    	public double position;
    	public PositionAndId(int id, double position){
    		this.id=id;
    		this.position=position;
    	}
    }
    
    private static List<PositionAndId> getSortedPositionsAndIds(List<CrossSection> crossSections, LoopDetectors ld) {
        
    	List<PositionAndId> sortedPositions = new ArrayList<>();
        for (final CrossSection crossSection : crossSections) {
        	PositionAndId posId = ld.new PositionAndId(crossSection.getId(),crossSection.getPosition());
            sortedPositions.add(posId);
            }

        Collections.sort(sortedPositions, new Comparator<PositionAndId>() {
            @Override
            public int compare(PositionAndId o1, PositionAndId o2) {
                final Double pos1 = new Double(o1.position);
                final Double pos2 = new Double(o2.position);
                return pos1.compareTo(pos2); // sort with increasing x
            }
        });
        return sortedPositions;
    }
    
    private static List<Double> getSortedPositions(List<CrossSection> crossSections) {
        List<Double> sortedPositions = new ArrayList<>();
        for (final CrossSection crossSection : crossSections) {
            sortedPositions.add(crossSection.getPosition());
            }

        Collections.sort(sortedPositions, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                final Double pos1 = new Double((o1).doubleValue());
                final Double pos2 = new Double((o2).doubleValue());
                return pos1.compareTo(pos2); // sort with increasing x
            }
        });
        return sortedPositions;
    }
    
    public List<LoopDetector> getDetectors(){
    	return this.detectors; 
    }

    @Override
    public void timeStep(double dt, double simulationTime, long iterationCount) {
        for (final LoopDetector detector : detectors) {
            detector.timeStep(dt, simulationTime, iterationCount);
        }
    }

}
