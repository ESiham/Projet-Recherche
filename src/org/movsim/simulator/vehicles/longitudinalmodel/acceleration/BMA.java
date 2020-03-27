/*
 * 
 * @author gueriau
 */
package org.movsim.simulator.vehicles.longitudinalmodel.acceleration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.movsim.autogen.ModelParameterBMA;
import org.movsim.input.ProjectMetaData;
import org.movsim.simulator.vehicles.Vehicle;
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameterBMA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;
import fr.ifsttar.licit.simulator.agents.perception.models.BasedOnMeasurementPerceptionModel;
import fr.ifsttar.licit.simulator.agents.perception.representation.SensedVehicle;
import fr.ifsttar.licit.simulator.agents.trust.representation.Trust;
import fr.ifsttar.licit.simulator.agents.trust.representation.TrustValue;
import fr.ifsttar.licit.simulator.calibration.CalibrationData;

/**
 * The Class BMA.
 * 
 * <p>
 * Implementation of the 'Flocking Behavior'(BMA). 
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

public class BMA extends LongitudinalModelBase implements BasedOnMeasurementPerceptionModel {//BasedOnVehiclePerceptionModel{

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(BMA.class);

    private IModelParameterBMA param;

    BMA(IModelParameterBMA parameters) {
        super(ModelName.BMA);
        this.param = parameters;
        
        this.calibrate();
    }

    public double getCooperationThreshold(){
    	return this.param.getCT();
    }
    
    /**
     * Check if a good calibration file was provided and if so, pick randomly parameters for the model in this file
     */
    private void calibrate() {

    	if(this.param.getCalibration() != null && this.param.getCalibration() != ""){
    		
    		String calibrationFilename = param.getCalibration();
    		
    		CalibrationData calibrationData = ProjectMetaData.getInstance().getCalibrationData(calibrationFilename);
    		
    		if(calibrationData!=null){
    			
    			List<String[]> data = calibrationData.getData();
    			
    			int randomLine = (int) Math.floor(Math.random() * (data.size() - 2)) + 1 ;
        		
    			String[] line = data.get(randomLine);
    			
    			if(line.length == 6){

    				final double v0 = Double.parseDouble(line[1].replace(',', '.'));
    				final double a  = Double.parseDouble(line[0].replace(',', '.'));
    				final double b  = Double.parseDouble(line[2].replace(',', '.'));
    				final double s1 = Double.parseDouble(line[3].replace(',', '.'));
    				final double T  = Double.parseDouble(line[4].replace(',', '.'));
    				
    			    ModelParameterBMA modelParameterBMA = new ModelParameterBMA();
			        //modelParameterBMA.setV0(v0);
			        modelParameterBMA.setV0(Math.max(25.0,v0));//this.param.getV0());
			        modelParameterBMA.setA(a);
			        modelParameterBMA.setB(b);
			        modelParameterBMA.setT(T);
			        modelParameterBMA.setS0(this.param.getS0());
			        modelParameterBMA.setS1(s1);
			        modelParameterBMA.setDelta(this.param.getDelta());
			        modelParameterBMA.setCalibration(this.param.getCalibration());
			        modelParameterBMA.setC1(this.param.getC1());
			        modelParameterBMA.setC2(this.param.getC2());
			        this.param = modelParameterBMA;
    			}
    		}
    	}	
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
     * @param m
     *            the number of considered vehicles
     */
    public BMA(double v0, double a, double b, double T, double s0, double s1, String calibration, double c1, double c2, double ct) {
        super(ModelName.BMA);
        this.param = create(v0, a, b, T, s0, s1, calibration , c1, c2, ct);   
    }

    private static ModelParameterBMA create(double v0, double a, double b, double T, double s0, double s1, String calibration, double c1, double c2, double ct) {
        ModelParameterBMA modelParameterBMA = new ModelParameterBMA();
        modelParameterBMA.setV0(v0);
        modelParameterBMA.setA(a);
        modelParameterBMA.setB(b);
        modelParameterBMA.setT(T);
        modelParameterBMA.setS0(s0);
        modelParameterBMA.setS1(s1);
        modelParameterBMA.setDelta(modelParameterBMA.getDelta());
        modelParameterBMA.setCalibration(calibration);
        modelParameterBMA.setC1(c1);
        modelParameterBMA.setC2(c2);
        modelParameterBMA.setCT(ct);
        return modelParameterBMA;
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
   // @Override
   // public double calcAccUsingPerception(Vehicle me, VehiclePerception perception, Trust trust){
    	
   // 	double acc = 0.0;
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
   // 	return acc;
   // }
    
    /** @author gueriau
     * Cooperative Law !
     * 
     * FIXME TODO: generalize this pattern !
     * 
     * @param me
     * @param perception 
     * @return
     */
    /*@Override
    public double calcAccEurUsingPerception(Vehicle me, VehiclePerception perception, Trust trust, double alphaT, double alphaV0, double alphaA) {

    	final double coopThreshold = 0.7d;
    	
    	if(trust.getTrustValue(me.getId()).getValue()> coopThreshold){
	    	final double v = me.getSpeed();
	    	
	    	final double veq = perception.getVeq();
	    	final double deltaXeq = perception.getDeltaXeq();
	    	// interaction range
	    	final double r = 4.0 * deltaXeq;
	    	
	        final double sFront = me.getNetDistance(perception.getFrontVehicle());
	        
	        final double dvFront = me.getRelSpeed(perception.getFrontVehicle());
	
	        final double sRear = me.getNetDistance(perception.getRearVehicle());
	     
	        final double dvRear = me.getRelSpeed(perception.getRearVehicle());
	
	        
	        final double localT = alphaT * param.getT();
	        // consider external speedlimit
	        final double localV0;
	        if (me.getSpeedlimit() != 0.0) {
	            localV0 = Math.min(alphaV0 * getDesiredSpeed(), me.getSpeedlimit());
	        } else {
	            localV0 = alphaV0 * getDesiredSpeed();
	        }
	        final double localA = alphaA * param.getA();
	
	        final double PFront = 0.5 * (1 + Math.cos(Math.PI * (sFront / r)));
	        final double PRear = 0.5 * (1 + Math.cos(Math.PI * (sRear / r)));
	        
	        final double pFront = PFront / (PFront + PRear); 
	        final double pRear = PRear / (PFront + PRear); 
	        
	        double TFront = 1.0;
	        double TRear  = 1.0;
	        
	        if(perception.getFrontVehicle()!=null && trust.hasTrustValue(perception.getFrontVehicle().getId()))
	        	TFront =  trust.getTrustValue(perception.getFrontVehicle().getId()).getValue();
	        if(perception.getRearVehicle()!=null && trust.hasTrustValue(perception.getRearVehicle().getId()))
	        	TRear  = trust.getTrustValue(perception.getRearVehicle().getId()).getValue();
	        
	       // System.out.println(TFront + " - " + TRear);
	        
	        final double aFront = pFront * TFront;
	        final double aRear = pRear * TRear;
	        
	        final double cooperativeLaw = acc (aFront * sFront + aRear * sRear, v, aFront * dvFront + aRear * dvRear, localT, localV0, localA);
	        
	        final double cooperativeLawWithControlTerms = cooperativeLaw - param.getC1() * (v - veq) + param.getC2() * ((aFront * sFront + aRear * sRear) - deltaXeq);
	        
	        return cooperativeLawWithControlTerms;
    	
    	} else {
    		return this.calcAcc(me, perception.getFrontVehicle(), alphaT, alphaV0, alphaA);
    	}
        
	}*/
    
    /*
    @Override
    public double calcAccEurUsingPerception(Vehicle me, VehiclePerception perception, Trust trust, double alphaT, double alphaV0, double alphaA) {
    	
    	
	    	final double v = me.getSpeed();
	    	
	    	
	        final double sFront = me.getNetDistance(perception.getFrontVehicle());
	        
	        final double dvFront = me.getRelSpeed(perception.getFrontVehicle());
	
	        double sRear = Math.abs(me.getNetDistance(perception.getRearVehicle()));
	     
	        double dvRear = me.getRelSpeed(perception.getRearVehicle());
	
	        
	        final double criticalDistance = 20.0;// m*l + (m-1)*s0 in meters
	        
	        final double safeTimeGap = 3.0; // in seconds
	        
	        final double distance = Math.max(criticalDistance, param.getM1() * v * safeTimeGap);
	      
	        //sRear = Math.abs(sRear - distance);
	      
	        
	        //System.out.println(param.getM1() + " - " + param.getM2());
	    
	        
	
	        final double PFront = 0.5 * (1 + Math.cos(Math.PI * (sFront / distance)));
	        double PRear = 0.5 * (1 + Math.cos(Math.PI * (sRear / distance)));
	        
	        if(sRear> distance)
	        	PRear=0;
	        else	
	        	sRear = Math.abs(distance - sRear);
	        
	        
	        final double pFront = PFront / (PFront + PRear); 
	        final double pRear = PRear / (PFront + PRear); 
	        

	        final double aFront = pFront;
	        final double aRear = pRear;
	        
	        // TODO : vérifier ça :
	        System.out.println(aFront + "  -  " + aRear);
	        
	        final double cooperativeLaw = this.calcAccBMA (me, aFront * sFront + aRear * sRear, v,aFront * dvFront + aRear * dvRear, alphaT, alphaV0, alphaA);
	        
	        return cooperativeLaw;
  	
	        //return cooperativeLaw;
        
	}*/
    
	@Override
	public double calcAccUsingPerception(Vehicle me, MeasurementPerception perception, Trust trust) {

		//System.out.println(perception.getMeasurements().size());

		//final double cooperativeLaw = this.calcAccBMA (me, aFront * sFront + aRear * sRear, v,aFront * dvFront + aRear * dvRear, alphaT, alphaV0, alphaA);
        
        return 0.0;
		
	}

	@Override
	public double calcAccEurUsingPerception(Vehicle me, MeasurementPerception perception, Trust trust, double alphaT, double alphaV0, double alphaA) {

		/*final*/ double v = me.getSpeed();
		
		
		//System.out.println(perception.getSurroundingVehicles().size());
		
		/*
		double mePosition = 0.d;
		
		double sFront = Double.MAX_VALUE;
		double dvFront = 0.0;
		
		for(Measurement measurement : perception.getOwnMeasurements()){
			if(measurement instanceof TelemeterMeasurement){
				TelemeterMeasurement telemeterM = (TelemeterMeasurement) measurement;
				sFront = telemeterM.getDeltaXValue();
				dvFront = telemeterM.getDeltaVValue();
			} else if(measurement instanceof GPSMeasurement){
				GPSMeasurement gpsM = (GPSMeasurement) measurement;
				mePosition = gpsM.getPositionValue();
			}
		} */
		
		
		//final double criticalDistance = param.getM1() * (me.getLength() + param.getS0()); // m*l + m*s0 in meters
        
        //final double safeTimeGap = 10.0; // in seconds
        
        //final double consideredDistanceFront = Math.max((me.getLength() + param.getS0()) *  param.getM1(), param.getM1() * v * safeTimeGap  +  param.getM1() * param.getS0() + param.getM1()*me.getLength());
        //final double consideredDistanceRear = Math.max((me.getLength() + param.getS0()) *  param.getM2(), param.getM2() * v * safeTimeGap +  param.getM2() * param.getS0() + param.getM2()*me.getLength());
		
        //final double consideredDistanceFront = Math.max(30.0, v * safeTimeGap);
        //final double consideredDistanceRear  = Math.max(30.0,  v * safeTimeGap);
        
        
		// virtual vehicle relative distance
		double s = Double.MAX_VALUE;
		// virtual vehicle relative speed
		double dv = 0.0;
		
		
		ArrayList<SensedVehicle> vehicles = perception.getSurroundingVehicles();
		
		//System.out.println(vehicles.size());
		
		//keep only vehicles within consideredDistance
		/*Iterator<SensedVehicle> it = vehicles.iterator();
		while(it.hasNext()){
			SensedVehicle veh = it.next();
			if(veh.getRelativePosition() >=  0 && veh.getRelativePosition() > consideredDistanceFront ){
				it.remove();
			}
			if(veh.getRelativePosition()< 0 && Math.abs(veh.getRelativePosition()) >consideredDistanceRear){
				it.remove();
			}
		}*/
				
		//System.out.println(vehicles.size());
		
		//sort vehicles
		Collections.sort(vehicles);
		
		
		List<SensedVehicle> frontVehicles = new ArrayList<SensedVehicle>();
		List<SensedVehicle> rearVehicles = new ArrayList<SensedVehicle>();
		
		//System.out.println(vehicles.size());
		
		for(SensedVehicle vehicle : vehicles){
			if(vehicle.getRelativePosition() < 0){
				//very important for sorting rear vehicles
				if(vehicle.getSenderId()!=me.getId())
					rearVehicles.add(new SensedVehicle(vehicle.getSenderId(),Math.abs(vehicle.getRelativePosition()), vehicle.getRelativeVelocity(), 0.0, 0.0, vehicle.getDeltaX(), vehicle.getDeltaV()));
			} else {
				frontVehicles.add(vehicle);
			}
		}
		
		//sort vehicles
		Collections.sort(frontVehicles);
		Collections.sort(rearVehicles);


		//System.out.println("---------------");
		//System.out.println(me.getId() + " perception : " + vehicles.size());
		//System.out.println(vehicles.size());
		
	    //System.out.println(" front = " + frontVehicles.size());
	    //System.out.println(" rear = " + rearVehicles.size());
		
		//remove not considered vehicles (according to m1 and m2 params)
		
/*		if(frontVehicles.size()>=param.getM1())
			frontVehicles = (List<SensedVehicle>) frontVehicles.subList(0, param.getM1());
		if(rearVehicles.size()>=param.getM2())
			rearVehicles = (List<SensedVehicle>) rearVehicles.subList(0, param.getM2());
*/		
		
		//System.out.println(" front then = " + frontVehicles.size());
		//System.out.println(" rear then = " + rearVehicles.size());
		
		ArrayList<Long> vehicleIds = new ArrayList<Long>();
		ArrayList<Double> pProximities = new ArrayList<Double>();
		ArrayList<Double> sDistances = new ArrayList<Double>();
		ArrayList<Double> dVelocities = new ArrayList<Double>();
		
		//ArrayList<Double> velocities = new ArrayList<Double>();
		
		
		/*for(SensedVehicle veh : rearVehicles){
			frontVehicles.add(new SensedVehicle(Math.abs(consideredDistanceRear - veh.relativePosition) , - veh.relativeVelocity));
		}*/
		
		int number = 0;
		//int numberFront = 0;
		//int numberRear = 0;
		for(SensedVehicle veh : frontVehicles){
			number++;
			//numberFront++;
			
			final double sFront = veh.getRelativePosition(); 
			//final double distance = frontVehicles.get(frontVehicles.size()-1).relativePosition + 0.01;
			//final double pFront = 0.5 * (1 + Math.cos(Math.PI * (sFront / consideredDistance)));
			//final double pFront = 1.0 - Math.sqrt(1.0 - Math.pow(((sFront-consideredDistance)/consideredDistance), 2));
			double dvFront = veh.getRelativeVelocity();
			//double pFront = Math.sqrt(1.0/*consideredDistanceFront*//(sFront*sFront));//1.0 - Math.sqrt(1.0 - Math.pow(((sFront-consideredDistance)/consideredDistance), 2));
			/*if(dvFront == Double.NaN)
				dvFront = 0.0;
			
			if(dvFront == Double.MAX_VALUE)
				dvFront = 0.0;*/
			
			//double pFront = (dvFront* dvFront+ 1.0) / ( (param.getS0() - sFront) * (param.getS0() - sFront) ) ;
			
			
			//double pFront = (Math.pow(Math.abs(dvFront), 0.5)/* dvFront*/) / ( (Math.pow(Math.abs(sFront), 2.5)));
			
			//double pFront = ( 1.0 + (Math.pow(Math.abs(dvFront), 3.0))) / Math.pow(Math.abs(sFront - param.getS0()), 3.4) ;
					
			
			//double sInfluence = 1.0 / Math.pow(Math.abs(sFront - param.getS0()), 3.0);
			//double sInfluence = Math.sqrt(dvFront)*1.0 / Math.pow(Math.abs(sFront),2.0);
			
			/**
			 * 
			 */
			double sInfluence =  Math.pow(Math.abs(dvFront),0.3)   /*1.0*/ / Math.pow(Math.abs(sFront),2.0);
			/**
			 * 
			 */
			
			
			//System.out.println("front veh " + number + " sFront = " + sFront + "   factor = " + sInfluence);
			
			
			final double pFront = sInfluence;// * (Math.pow(Math.abs(dvFront), 1.0));
			
			//double pFront = (/*dvFront* dvFront+*/ 1.0) / ( Math.pow( Math.abs((param.getS0() - sFront)), (1.0 / (v + 0.01 ))  ) ) ;
			
			//if(pFront == Double.NaN)
			//	pFront=Double.MAX_VALUE;
			//if(pFront<0)
			//	pFront=0.0;
			//System.out.println(pFront);
			
			
			/**
			 * old code
			 */
			/*
			//pFront+=dvFront *dvFront * (Math.sqrt( Math.abs(dvFront + 0.000001)));
			pProximities.add(pFront);
			
			//if(number<=1){
		    sDistances.add(veh.getDeltaX());//sFront);
			//} else {
			//	sDistances.add(sFront - frontVehicles.get(0).getgetRelativePosition());
			//}
			//dVelocities.add(dvFront * 5.0);
			dVelocities.add(veh.getDeltaV());//dvFront);// *2.0);
			
			//System.out.println("PFront = " + pFront);
			
			vehicleIds.add(veh.getSenderId());
			*/
			/**
			 * new code
			 */
			
			//if(veh.getSenderId() == me.getId()){
			//	vehicleIds.add(veh.getSenderId());
			//	pProximities.add(1.0);
			//    sDistances.add(veh.getDeltaX());
			//	dVelocities.add(veh.getDeltaV());
			//} else {
				vehicleIds.add(veh.getSenderId());
				pProximities.add(pFront);
			    sDistances.add(veh.getDeltaX());
				dVelocities.add(veh.getDeltaV());
			//}
			
			
			/**
			 * Flocking
			 */
			//velocities.add(veh.getAbsoluteV());
		}
		
	
		
/*		for(SensedVehicle veh : rearVehicles){
			number++;
			//System.out.println("before " + veh.relativePosition);
			
			//final double sRear =  Math.abs(consideredDistanceRear - veh.getRelativePosition());
			final double sRear = Math.abs(veh.getRelativePosition()); //Math.abs(150.0 - veh.getRelativePosition());
			                    //-
			//System.out.println(sRear);
			
			//System.out.println(" after " + sRear);
			//final double PRear = 0.5 * (1 + Math.cos(Math.PI * (sRear / consideredDistance)));
			//final double distance = rearVehicles.get(rearVehicles.size()-1).relativePosition + 0.01;
			//double pRear = 0.1;//1.0 - Math.sqrt(1.0 - Math.pow(((veh.relativePosition-consideredDistanceRear)/consideredDistanceRear), 2));
			
			//double pRear =  Math.sqrt(consideredDistanceRear/(sRear));
			final double dvRear = Math.abs(veh.getRelativeVelocity());
			
			//double pRear = (1.0 / (veh.getRelativePosition()*veh.getRelativePosition()));
			//double pRear = 1.0 / ( (param.getS0() - sRear) * (param.getS0() - sRear) );
			
			//double pRear =  1.0 / ( (param.getS0() - sRear) * (param.getS0() - sRear) );
			
			//double pRear = Math.pow(Math.abs(dvRear), 0.5) / (Math.pow(Math.abs(sRear), 2.5)) ;
			
			//double pRear = ( 1.0 + (Math.pow(Math.abs(dvRear), 3.0))) / Math.pow(Math.abs(sRear - param.getS0()), 3.0) ;
			
			double pRear = 0.0005 * Math.sqrt(Math.abs(dvRear));//* 0.3 /  Math.pow(sRear,2.0);
			
			//double pRear = Math.pow(Math.abs(dvRear), 0.1);// /  Math.pow(Math.abs(sRear), 2.0);
			
			pProximities.add(pRear);
			//System.out.println(PRear);
			
			//sDistances.add(sRear);
			//dVelocities.add(dvRear);
			
			sDistances.add(Math.abs(150.0 - sRear));//veh.getDeltaX());
			
			//sDistances.add(veh.getDeltaX());//veh.getDeltaX());
			dVelocities.add(veh.getDeltaV());
			
			//System.out.println("PRear = " + PRear);
			vehicleIds.add(veh.getSenderId());
		}
*/
		
		for(SensedVehicle veh : rearVehicles){
			number++;
			//numberRear++;
			//System.out.println("before " + veh.relativePosition);
			
			//final double sRear =  Math.abs(consideredDistanceRear - veh.getRelativePosition());
			final double sRear = Math.abs(veh.getRelativePosition()); //Math.abs(150.0 - veh.getRelativePosition());
			                    //-
			//System.out.println(sRear);
			
			//System.out.println(" after " + sRear);
			//final double PRear = 0.5 * (1 + Math.cos(Math.PI * (sRear / consideredDistance)));
			//final double distance = rearVehicles.get(rearVehicles.size()-1).relativePosition + 0.01;
			//double pRear = 0.1;//1.0 - Math.sqrt(1.0 - Math.pow(((veh.relativePosition-consideredDistanceRear)/consideredDistanceRear), 2));
			
			//double pRear =  Math.sqrt(consideredDistanceRear/(sRear));
			final double dvRear = Math.abs(veh.getRelativeVelocity());
			
			//double pRear = (1.0 / (veh.getRelativePosition()*veh.getRelativePosition()));
			//double pRear = 1.0 / ( (param.getS0() - sRear) * (param.getS0() - sRear) );
			
			//double pRear =  1.0 / ( (param.getS0() - sRear) * (param.getS0() - sRear) );
			
			//double pRear = Math.pow(Math.abs(dvRear), 0.5) / (Math.pow(Math.abs(sRear), 2.5)) ;
			
			//double pRear = ( 1.0 + (Math.pow(Math.abs(dvRear), 3.0))) / Math.pow(Math.abs(sRear - param.getS0()), 3.0) ;
			
			//double pRear = 0.0005 * Math.sqrt(Math.abs(dvRear));//* 0.3 /  Math.pow(sRear,2.0);
			
			//double pRear =  0.1*param.getC1() * Math.pow(Math.abs(dvRear), param.getC2()) / Math.pow(Math.abs(sRear),2.0);
			double pRear =  /*param.getC1() * */ /*0.5*Math.abs(dvRear)*/ dvRear * 0.0 / Math.pow(Math.abs(sRear),/* param.getC2()*/ 2.0); // FIXME: HACK
			
			//double pRear = Math.pow(Math.abs(dvRear), 0.1);// /  Math.pow(Math.abs(sRear), 2.0);
			
			pProximities.add(pRear);
			//System.out.println(PRear);
			
			//sDistances.add(sRear);
			//dVelocities.add(dvRear);
			
			//sDistances.add(Math.abs(150.0 - sRear));//veh.getDeltaX());
			
			
			sDistances.add(/*80.0 - */veh.getDeltaX());//veh.getDeltaX());
			
			
			//dVelocities.add(-veh.getDeltaV());
			
			dVelocities.add(veh.getDeltaV());
			
			
			//System.out.println("PRear = " + PRear);
			vehicleIds.add(veh.getSenderId());
			
			/**
			 * Flocking
			 */
			//velocities.add(veh.getAbsoluteV());
		}
		
		//System.out.println(" ---------- Before Trust : ");
		
		//p normalization
		double pSum = 0.0;
		for(int k = 0; k<pProximities.size(); ++k){
			pSum+=pProximities.get(k).doubleValue();
		}
		
		
		/*//
		System.out.println(" ------ vehicle " + me.getId() + "---------");
		for(int i = 0 ; i< vehicleIds.size(); ++i){
			
			System.out.println(vehicleIds.get(i) + " - p = " + pProximities.get(i)/pSum);
		}
		//*/
		
		for(int k = 0; k<pProximities.size(); ++k){
			/**
			 * 
			 */
	//		System.out.println(k + " : " + pProximities.get(k) / pSum);
			// WITH TRUST
			final double trustValue = me.getTrust().getTrustValue(vehicleIds.get(k))!=null ? me.getTrust().getTrustValue(vehicleIds.get(k)).getValue() : TrustValue.defaultValue().getValue();
			pProximities.set(k, new Double(trustValue * (pProximities.get(k) / pSum)));
			/**
			 * 
			 */
			//WITHOUT TRUST
	//        pProximities.set(k, new Double(pProximities.get(k)/pSum));
		}
		
		//System.out.println(" --------- After Trust");
		// a normalization
		pSum = 0.0;
		for(int k = 0; k<pProximities.size(); ++k){
			pSum+=pProximities.get(k).doubleValue();
		}
		
		for(int k = 0; k<pProximities.size(); ++k){
			pProximities.set(k, new Double(pProximities.get(k)/pSum));
		   //System.out.println(k + " : " + pProximities.get(k) / pSum);
		}
	
		//System.out.println(" ----------- ");
		//System.out.println(" s = " + s);
		
		//System.out.println("   " +number);
		
		//double speeds =this.getDesiredSpeed();
		
		
		
		if(number>1 /*&& numberFront>numberRear*/ && sDistances.get(0) < 80.0 ){
			
			//System.out.println("act cooperatively  " + me.getId());
			
			s = 0; 
			dv= 0;
			/**
			 * Flocking 
			 */
			//v=0;
			//System.out.println("-----");
			
			for(int i=0; i<number; ++i){
				double p = pProximities.get(i);// / pSum;
				if(Double.isNaN(p))
					p=1.0;
				
				
				
				//if(p>1.0)
				//System.out.println(p);
				
				//pProximities.set(i, new Double(p));
				//System.out.println( i +" : " + p);
				
				
				//System.out.println(trustValue);
				
				final double a = p;
				
				//if(me.getId() == 1484)
				//System.out.println("vehicle " + i + " factor = " + a + " dist = " +  sDistances.get(i));
				
				s+= a * sDistances.get(i);
				
				dv+= a * dVelocities.get(i);
				
				/**
				 * Flocking
				 */
				//for(int k = 0;k<velocities.size();++k){
				//	v+= a * velocities.get(i);
				//}
				
				//if(dv>0){
				//	dv*=dv;
				//}
				
				//System.out.println(" v (" + i + ") : p = " + pProximities.get(i)+ "       a = " + a +  "     s = " + sDistances.get(i) + "    ;   dv = " + dVelocities.get(i));
			}
			
			//if(dv>0){
			//	dv*=dv;
			//}
			
			//s-=param.getS0();
			//dv/=number;
		} else if(number==1) {
			s =  sDistances.get(0);
			dv = dVelocities.get(0);
		} else {
			s = 80.0;
		    dv= 0;
		}
		
		 if(Double.isNaN(s)){
	        	s = param.getS0();
	     }
	      
		
		// System.out.println("number = " + number + " ; s = " + s + " ; dv = " + dv );
		 
		me.setVirtualVehicle(new SensedVehicle(me.getId(), s, v, 0, 0,0,0));
		//System.out.println(dv);
		
		//double desiredSpeed = speeds;
		
		//if(dv>0) // FIXME: HACK cheat
		//	dv*=2; // FIXME: HACK
		
		return this.calcAccBMA (me, s, v, dv, this.getDesiredSpeed(), alphaT, alphaV0, alphaA);
	}    
    
    public double calcAccBMA(Vehicle me, double s, double v, double dv, double desiredSpeed, double alphaT, double alphaV0, double alphaA) {

        //System.out.println("non coop s    = " + s);
        
        // space dependencies modeled by speedlimits, alpha's

    	/**
    	 * Flocking
    	 */
    	//desiredSpeed=me.getSharedSpeed()+5;
    	
    	/**
         * take in account speed recommandation from RSU
         */
        if(me.getSpeedRecommandation()>0){
        	desiredSpeed =  Math.min(desiredSpeed, me.getSpeedRecommandation());
        }
        
    	
    	
        final double localT = alphaT * param.getT();
        // consider external speedlimit
        final double localV0;
        if (me.getSpeedlimit() != 0.0) {
            localV0 = Math.min(alphaV0 * desiredSpeed, me.getSpeedlimit());//getDesiredSpeed(), me.getSpeedlimit());
        } else {
            localV0 = alphaV0 * desiredSpeed;//getDesiredSpeed();
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

        //System.out.println("non coop s    = " + s);
        
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

        if (sstar < s0 || Double.isNaN(sstar)) {
            sstar = s0;
        }

        final double aWanted = aLocal * (1.0 - Math.pow((v / v0Local), param.getDelta()) - (sstar / s) * (sstar / s));

        LOG.debug("aWanted = {}", aWanted);
     
        return aWanted; // limit to -bMax in Vehicle
    }

    @Override
    protected IModelParameterBMA getParameter() {
        return param;
    }


}
