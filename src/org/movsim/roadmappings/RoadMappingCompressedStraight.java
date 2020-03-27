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

package org.movsim.roadmappings;


/**
 * This is a WORK IN PROGRESS and not yet ready for use.
 */
public class RoadMappingCompressedStraight extends RoadMappingLine {

    protected double compressionFactor;

    /**
     * Constructor.
     * 
     * @param laneCount
     *            number of lanes in road mapping
     * @param x0
     *            x-position of start of line
     * @param y0
     *            y-position of start of line
     * @param x1
     *            x-position of end of line
     * @param y1
     *            y-position of end of line
     * @param compressionFactor
     */
    RoadMappingCompressedStraight(int laneCount, double x0, double y0, double x1, double y1,
            double compressionFactor) {
        super(laneCount, x0, y0, x1, y1);
        this.compressionFactor = compressionFactor;
    }

    @Override
    public RoadMapping.PosTheta map(double roadPos, double lateralOffset) {
        getPosTheta().x = getX0() + roadPos * getPosTheta().cosTheta * compressionFactor;
        getPosTheta().y = getY0() + roadPos * getPosTheta().sinTheta * compressionFactor;
        // lateralOffset offset is perpendicular to road
        final double laneOffset = lateralOffset;
        getPosTheta().x -= laneOffset * getPosTheta().sinTheta;
        getPosTheta().y += laneOffset * getPosTheta().cosTheta;
        return getPosTheta();
    }
}
