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
package org.movsim.simulator.vehicles.longitudinalmodel.acceleration;


// TODO: Auto-generated Javadoc
/**
 * The Class EquilibriumNSM.
 */
class EquilibriumNSM extends EquilibriumPropertiesImpl {

    /**
     * Instantiates a new equilibrium nsm.
     * 
     * @param length
     *            the length
     * @param model
     *            the nsm model
     */
    EquilibriumNSM(double length, NSM model) {
        super(length);

        calcEquilibrium(model);
        calcRhoQMax();
    }

    /**
     * Calc equilibrium.
     * 
     * @param model
     *            the model
     */
    private void calcEquilibrium(NSM model) {
        double vIter = model.getDesiredSpeed(); // variable of the relaxation equation
        final int itMax = 100; // number of iteration steps in each relaxation
        final double dtMax = 2; // iteration time step (in s) changes from
        final double dtMin = 0.01; // dtmin (rho=rhomax) to dtmax (rho=0)

        vEqTab[0] = model.getDesiredSpeed(); // start with rho=0
        final int length = vEqTab.length;
        for (int ir = 1; ir < length; ir++) {
            final double rho = getRho(ir);
            final double s = getNetDistance(rho);
            // start iteration with equilibrium velocity for the previous
            // localDensity
            vIter = vEqTab[ir - 1];
            for (int it = 1; it <= itMax; it++) {
                final double acc = model.calcAccSimple(s, vIter, 0.);
                // interation step in [dtmin, dtmax]
                final double dtloc = dtMax * vIter / model.getDesiredSpeed() + dtMin;
                // actual relaxation
                vIter += dtloc * acc;
                if (vIter < 0) {
                    vIter = 0;
                }
            }
            vEqTab[ir] = vIter;
        }
    }
}
