package maop;



import java.awt.Color;
import java.util.ArrayList;

import org.movsim.autogen.VehiclePrototypeConfiguration;
import org.movsim.simulator.vehicles.Vehicle;
import org.movsim.simulator.vehicles.lanechange.LaneChangeModel;
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.IDM;
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.LongitudinalModelBase;

import fr.ifsttar.licit.simulator.agents.communication.messages.MeasureMessage;
import fr.ifsttar.licit.simulator.agents.communication.messages.Message;
import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;
import fr.ifsttar.licit.simulator.agents.perception.representation.SensedVehicle;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.GPSMeasurement;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.Measurement;

public class MaopVehicle extends Vehicle{

	SensedVehicle immediateLeader = null;
	/*
	 * Constructor	
	 */

	/*
	 * used contructor.
	 */
	public String txt = null;
	public MaopVehicle(String label,
			LongitudinalModelBase accelerationModel,
			VehiclePrototypeConfiguration configuration,
			LaneChangeModel laneChangeModel) {
		super(label, accelerationModel, configuration, laneChangeModel);	
	}

	public MaopVehicle(Vehicle vehicle) {
		super(vehicle);
	}

	public MaopVehicle(double roadLength, double d, int laneNumber,
			double e, double f) {
		super(roadLength,d,laneNumber,e,f);
	}

	/*
	 * Initial Scenario
	 */
	/**
	 * vehicles stay on their lane and their desired speed is divided by 2 
	 */

	public void scenarioSlowVehicles(){

		modifyDesiredSpeed(-0.5);
	}

	/**
	 * vehicles change to right if they are on left and their desired speed is divided by 2 
	 */

	public void scenarioSlowVehiclesOnleft(){
		modifyDesiredSpeed(-0.5);
		modifiedDesiredLane(BehaviorEnum.leftToright);
	}



	public void createSensedVehicleByCommunication(MeasurementPerception measurementPerception) {

		

		double myPosition = this.getFrontPosition();
		// double myRearPosition = this.getRearPosition();
		double mySpeed = this.getSpeed();

		// add own measurements
		for (Measurement m : measurementPerception.getOwnMeasurements()) {
			// look for GPS positioning
			if (m instanceof GPSMeasurement) {
				GPSMeasurement gpsM = (GPSMeasurement) m;
				myPosition = gpsM.getPositionValue();
				mySpeed = gpsM.getSpeedValue();
			}
		}
		// read all previously received messages
		while (this.getMailSize() > 0) {

			// pick the next message from queued message 
			Message message = this.pickMessage();
			// check if the message has not expired
			if (!message.isOutDated()) {

				if (message instanceof MeasureMessage) {

					// cast the message to get more precise information
					MeasureMessage measureM = (MeasureMessage) message;

					// get embedded data
					final double absoluteX = measureM.getPositionMeasureValue();
					//final double deltaX = measureM.getDeltaXMeasureValue();
					final double deltaX = absoluteX-this.getFrontPosition();
					final double absoluteV = measureM.getVelocityMeasureValue();
					final double deltaV = absoluteV-this.getSpeed();

					// check if the vehicle looks forward or backward
					double localDeltaX = 0.0;

					localDeltaX = absoluteX - myPosition + deltaX;

					final double epsilon = this.getLength();

					if (Math.abs(localDeltaX) > epsilon) {
						double localDeltaV = Math.abs(measureM
								.getVelocityMeasureValue() - mySpeed)
								+ measureM.getDeltaVMeasureValue();

						if (frontVehicleId == message.getIdSender()) {
							immediateLeader = new SensedVehicle(frontVehicleId, localDeltaX, localDeltaV,
									absoluteX, measureM.getVelocityMeasureValue(),
									deltaX, deltaV);
						}else { 
							SensedVehicle sv = new SensedVehicle(message
									.getIdSender(), localDeltaX, localDeltaV,
									absoluteX, measureM.getVelocityMeasureValue(),
									deltaX, deltaV);
							
							getCommunicatingVehicles().put(sv.getSenderId(),sv);
						}
					}
				}//else if .MaopVehicle...

			}
		}
	
	}



	/**
	 * handles received messages
	 * 
	 */
	@Override
	public void handleMessages(double simulationTime) {

	
		
		// get its own current state				
		MeasurementPerception measurementPerception = (MeasurementPerception) this.perception;
	
		// get the state of close connected vehicles
	//	ArrayList<SensedVehicle> surroundingVehicles = 
		createSensedVehicleByCommunication(measurementPerception);

		// update the perception
	//	measurementPerception.setSurroundingVehicles(surroundingVehicles);
	
	}


	/*
	 * Vehicle decides of its behavior
	 * (non-Javadoc)
	 * @see fr.ifsttar.licit.simulator.agents.Agent#makeDecision(double, long)
	 */

	@Override
	public void makeDecision(double simulationTime, long iterationCount) {
	

	}



	/*
	 * increase or decrease its desired speed
	 */
	public void modifyDesiredSpeed(double ns){
		if (this.longitudinalModel instanceof IDM) {
			IDM IDMModel = (IDM) this.longitudinalModel;
			if (ns > 0 && IDMModel.getDesiredSpeed() < (160.0d/ 3.6d) ||
					(ns < 0 && IDMModel.getDesiredSpeed() > (10.0d/ 3.6d))
					){
				double currentDesiredSpeed = IDMModel.getDesiredSpeed() * (1 + ns); 
				IDMModel.setDesiredSpeed(currentDesiredSpeed);
			}
		}
	}

	public double getDesiredSpeed(){
		if (this.longitudinalModel instanceof IDM) {
			IDM IDMModel = (IDM) this.longitudinalModel;
			return IDMModel.getDesiredSpeed();
		}
		return Double.NaN;
	}


	/*
	 *change its desired lane
	 */
	protected void modifiedDesiredLane(BehaviorEnum behavior){
		switch (behavior){
		case leftToright: closedLaneAhead = 1; break;
		case rightToleft: closedLaneAhead = 2; break;
		default : closedLaneAhead = -1;
		}
	}
}
