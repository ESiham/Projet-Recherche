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

import org.movsim.autogen.ModelParameterFB;
import org.movsim.simulator.vehicles.Vehicle;
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameterFB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ifsttar.licit.simulator.agents.perception.models.BasedOnVehiclePerceptionModel;
import fr.ifsttar.licit.simulator.agents.perception.vehicles.VehiclePerception;
import fr.ifsttar.licit.simulator.agents.trust.representation.Trust;

/**
 * The Class FB.
 * 
 * <p>
 * Implementation of the 'Flocking Behavior'(FB). 
 * </p>
 * <p>
 * </p>
 * 
 * Model parameters:
 * <ul>
 * <li>safe time headway T (s)</li>
 * <li>minimum gap in standstill s0 (m)</li>
 * <li>maximum desired acceleration a (m/s^2)</li>
 * <li>comfortable (desired) deceleration (m/s^2)</li>
 * <li>acceleration exponent delta (1)</li>
 * <li>gap parameter s1 (m).</li>
 * </ul>
 * 
 * 
 */
// TODO reduce visibility
public class FB extends LongitudinalModelBase  implements BasedOnVehiclePerceptionModel{

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(FB.class);

    private final IModelParameterFB param;

    FB(IModelParameterFB parameters) {
        super(ModelName.FB);
        this.param = parameters;
    }

    /**
     * Constructor.
     * 
     * @param v0
     *            desired velocity, m/s
     * @param a
     *            maximum acceleration, m/s^2
     * @param b
     *            desired deceleration (comfortable braking), m/s^2
     * @param T
     *            safe time headway, seconds
     * @param s0
     *            bumper to bumper vehicle distance in stationary traffic, meters
     * @param s1
     *            gap parameter, meters
     */
    public FB(double v0, double a, double b, double T, double s0, double s1) {
        super(ModelName.FB);
        this.param = create(v0, a, b, T, s0, s1);
    }

    private static ModelParameterFB create(double v0, double a, double b, double T, double s0, double s1) {
        ModelParameterFB modelParameterFB = new ModelParameterFB();
        modelParameterFB.setV0(v0);
        modelParameterFB.setA(a);
        modelParameterFB.setB(b);
        modelParameterFB.setT(T);
        modelParameterFB.setS0(s0);
        modelParameterFB.setS1(s1);
        modelParameterFB.setDelta(modelParameterFB.getDelta());
        return modelParameterFB;
    }

    
    /** @author gueriau
     * Cooperative Law !
     * 
     * FIXME TODO: generalize this pattern !
     * 
     * @param me
     * @param perception 
     * @return
     */
    public double calcAccUsingPerception(Vehicle me, VehiclePerception perception){
    	
    	double acc = 0.0;
    	/*
    	//compute the repulsion behavior
    	
    	// Local dynamical variables
    	final double s = me.getNetDistance(perception.getFrontVehicle());    	
        final double v = me.getSpeed();
        final double dv = me.getRelSpeed(perception.getFrontVehicle());
    	
        final double s0 = getMinimumGap();

        double meanDv = me.getRelSpeed(perception.getFrontVehicle()) + me.getRelSpeed(perception.getRightVehicle()) +me.getRelSpeed(perception.getLeftVehicle());
        meanDv/=3.0;
        
        System.out.println(meanDv);
        
        acc = meanDv/param.getV0() + -Math.pow(Math.pow(v, 2)/(2*(s+s0)), 2)/param.getB();
        */
    	return acc;
    }
    
    /** @author gueriau
     * Cooperative Law !
     * 
     * FIXME TODO: generalize this pattern !
     * 
     * @param me
     * @param perception 
     * @return
     */
    public double calcAccEurUsingPerception(Vehicle me, VehiclePerception perception, double alphaT, double alphaV0, double alphaA) {
    	 // Local dynamical variables
        final double s = me.getNetDistance(perception.getFrontVehicle());
        final double v = me.getSpeed();
        final double dv = me.getRelSpeed(perception.getFrontVehicle());

        /*double meanS = me.getNetDistance(perception.getFrontVehicle())
  		      //+ me.getRelSpeed(perception.getRightVehicle())
  		     // + me.getRelSpeed(perception.getLeftVehicle())
  		      + me.getNetDistance(perception.getRearVehicle());
	    //meanDv/=4.0;
	    //meanS/=2.0;*/
        
        //double meanDv = me.getRelSpeed(perception.getFrontVehicle())
        		      //+ me.getRelSpeed(perception.getRightVehicle())
        		     // + me.getRelSpeed(perception.getLeftVehicle())
        //		      + me.getRelSpeed(perception.getRearVehicle());
        //meanDv/=4.0;
        //meanDv/=2.0;
        
        // space dependencies modeled by speedlimits, alpha's

        final double localT = alphaT * param.getT();
        // consider external speedlimit
        //double localV0 = alphaV0 * getDesiredSpeed();
        
        /*double localV0 = me.getRelSpeed(perception.getFrontVehicle())
		  		       + me.getRelSpeed(perception.getRightVehicle())
		  		       + me.getRelSpeed(perception.getLeftVehicle())
		  		       + me.getRelSpeed(perception.getRearVehicle());*/
        
        double localV0 = 0.0;
        int number = 0;
        if(perception.getFrontVehicle()!=null){
        	localV0+=perception.getFrontVehicle().getSpeed();
        	number++;
        }
        if(perception.getRightVehicle()!=null){
        	localV0+=perception.getRightVehicle().getSpeed();
        	number++;
        }
        if(perception.getLeftVehicle()!=null){
        	localV0+=perception.getLeftVehicle().getSpeed();
        	number++;
        }
        if(perception.getRearVehicle()!=null){
        	localV0+=perception.getRearVehicle().getSpeed();
        	number++;
        }
        
       /* double localV0 = perception.getFrontVehicle().getSpeed())
	  		       + me.getRelSpeed(perception.getRightVehicle())
	  		       + me.getRelSpeed(perception.getLeftVehicle())
	  		       + me.getRelSpeed(perception.getRearVehicle());*/
        
        if(number>0 || localV0<=0.0){
        	localV0/=number;
        	localV0 += 1.0;
        } else {
        	localV0 = alphaV0 * getDesiredSpeed();
        }
        
        if (me.getSpeedlimit() != 0.0) {
            localV0 = Math.min(localV0, me.getSpeedlimit());
        }
       
        final double localA = alphaA * param.getA();
        
      
        return acc(s, v, dv, localT, localV0, localA);
	}
    
    
    @Override
    public double calcAcc(Vehicle me, Vehicle frontVehicle, double alphaT, double alphaV0, double alphaA) {

        // Local dynamical variables
        final double s = me.getNetDistance(frontVehicle);
        final double v = me.getSpeed();
        final double dv = me.getRelSpeed(frontVehicle);

        // space dependencies modeled by speedlimits, alpha's

        final double localT = alphaT * param.getT();
        // consider external speedlimit
        final double localV0;
        if (me.getSpeedlimit() != 0.0) {
            localV0 = Math.min(alphaV0 * getDesiredSpeed(), me.getSpeedlimit());
        } else {
            localV0 = alphaV0 * getDesiredSpeed();
        }
        final double localA = alphaA * param.getA();

        return acc(s, v, dv, localT, localV0, localA);
    }

    @Override
    public double calcAccSimple(double s, double v, double dv) {
        return acc(s, v, dv, param.getT(), param.getV0(), param.getA());
    }

    /**
     * Acc.
     * 
     * @param s
     *            the s
     * @param v
     *            the v
     * @param dv
     *            the dv
     * @param TLocal
     *            the t local
     * @param v0Local
     *            the v0 local
     * @param aLocal
     *            the a local
     * @return the double
     */
    private double acc(double s, double v, double dv, double TLocal, double v0Local, double aLocal) {
        // treat special case of v0=0 (standing obstacle)
        if (v0Local == 0.0) {
            return 0.0;
        }

        final double s0 = getMinimumGap();
        double sstar = s0 + TLocal * v + param.getS1() * Math.sqrt((v + 0.0001) / v0Local) + (0.5 * v * dv)
                / Math.sqrt(aLocal * param.getB());

        if (sstar < s0) {
            sstar = s0;
        }

        final double aWanted = aLocal * (1.0 - Math.pow((v / v0Local), param.getDelta()) - (sstar / s) * (sstar / s));

        LOG.debug("aWanted = {}", aWanted);
        return aWanted; // limit to -bMax in Vehicle
    }

    @Override
    protected IModelParameterFB getParameter() {
        return param;
    }

	@Override
	public double calcAccUsingPerception(Vehicle me, VehiclePerception perception,
			Trust trust) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcAccEurUsingPerception(Vehicle vehicle,
			VehiclePerception perception, Trust trust, double alphaTLocal,
			double alphaV0Local, double alphaALocal) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
