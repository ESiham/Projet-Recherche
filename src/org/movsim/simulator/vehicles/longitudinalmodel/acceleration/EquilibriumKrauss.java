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


/**
 * The Class EquilibriumKrauss.
 */
class EquilibriumKrauss extends EquilibriumPropertiesImpl {

    /**
     * Instantiates a new equilibrium gipps.
     * 
     * @param length
     *            the length
     * @param model
     *            the model
     */
    EquilibriumKrauss(double length, Krauss model) {
        super(length);

        calcEquilibrium(model);
        calcRhoQMax();

    }

    // Calculates equilibrium velocity of Gipps and Gipps with finite s0
    // and free-acc exponent delta
    // uses numeric iteration procedure

    /**
     * Calc equilibrium.
     * 
     * @param model
     *            the gipps model
     */
    private void calcEquilibrium(Krauss model) {

        // Find equilibrium velocities veqtab[ir] with simple relaxation
        // method: Just model for homogeneous traffic solved for
        // the velocity v_it of one arbitrary vehicle
        // (no brain, but stable and simple method...)

        double v_it = model.getDesiredSpeed(); // variable of the relaxation equation
        final int itmax = 100; // number of iteration steps in each relaxation
        final double dtmax = 2; // iteration time step (in s) changes from
        final double dtmin = 0.01; // dtmin (rho=rhomax) to dtmax (rho=0)

        // start with rho=0
        vEqTab[0] = model.getDesiredSpeed();

        for (int ir = 1; ir < vEqTab.length; ir++) {
            final double rho = rhoMax * ir / vEqTab.length;
            final double s = 1. / rho - 1. / rhoMax;

            // start iteration with equilibrium speed for previous localDensity
            v_it = vEqTab[ir - 1];
            for (int it = 1; it <= itmax; it++) {
                final double acc = model.calcAccSimple(s, v_it, 0.);
                // iteration step in [dtmin,dtmax]
                final double dtloc = dtmax * v_it / model.getDesiredSpeed() + dtmin;
                // actual relaxation
                v_it += dtloc * acc;
                if (v_it < 0) {
                    v_it = 0;
                }
            }
            vEqTab[ir] = v_it;
        }
    }
}
