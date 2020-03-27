package maop;

import java.awt.Color;
import java.util.ArrayList;

import org.movsim.autogen.VehiclePrototypeConfiguration;
import org.movsim.simulator.vehicles.Vehicle;
import org.movsim.simulator.vehicles.lanechange.LaneChangeModel;
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.LongitudinalModelBase;

import fr.ifsttar.licit.simulator.agents.communication.messages.MeasureMessage;
import fr.ifsttar.licit.simulator.agents.communication.messages.Message;
import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;
import fr.ifsttar.licit.simulator.agents.perception.representation.SensedVehicle;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.GPSMeasurement;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.Measurement;

public class MaopVehicleCorrection extends MaopVehicle{
	
	private Color initialColor;
	
	public MaopVehicleCorrection(double roadLength, double d, int laneNumber, double e, double f) {
		super(roadLength, d, laneNumber, e, f);
	
	}

	public MaopVehicleCorrection(String label, LongitudinalModelBase accelerationModel,
			VehiclePrototypeConfiguration configuration, LaneChangeModel laneChangeModel) {
		super(label, accelerationModel, configuration, laneChangeModel);
		
	}

	public MaopVehicleCorrection(Vehicle vehicle) {
		super(vehicle);
	}


	public void createSensedVehicleByCommunication(MeasurementPerception measurementPerception) {

		//ArrayList<SensedVehicle> surroundingVehicles = new ArrayList<SensedVehicle>();

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
							if (getCommunicatingVehicles().containsKey(message.getIdSender())) { 
								((SensedVehicleAgent) getCommunicatingVehicles().get(message.getIdSender())).addMessage(message);
								
								((SensedVehicleAgent) getCommunicatingVehicles().get(message.getIdSender())).
								completeSensedVehicle(localDeltaX, localDeltaV, absoluteX, measureM.getVelocityMeasureValue(),deltaX, deltaV);
							}
							else {
								SensedVehicleAgent sv = new SensedVehicleAgent(message
										.getIdSender(), localDeltaX, localDeltaV,
										absoluteX, measureM.getVelocityMeasureValue(),
										deltaX, deltaV);
								sv.addMessage(message);
								getCommunicatingVehicles().put(sv.getSenderId(),sv);
							}
						}
					}
				}// end MeasureMessage
				else if (message instanceof AgentMessage) {
					if (getCommunicatingVehicles().containsKey(message.getIdSender())) 
						((SensedVehicleAgent) getCommunicatingVehicles().get(message.getIdSender())).addMessage(message);
					else {
						SensedVehicleAgent sv = new SensedVehicleAgent(message.getIdSender());
						sv.addMessage(message);
						getCommunicatingVehicles().put(sv.getSenderId(),sv);
					}

				}

			}
		}
//		return surroundingVehicles;
	}


	@Override
	public void handleMessages(double simulationTime) {
		resetMessagesToSend();

		// emission
				AgentMessage mc = new AgentMessage(this, "color", "request");
				mc.addContent("colorValue", this.colorObject());
				mc.addContent("roadId", roadSegmentId());
				sendMessage(mc);

			super.handleMessages(simulationTime);
	}


	/*
	 * Vehicle decides of its behavior
	 * (non-Javadoc)
	 * @see fr.ifsttar.licit.simulator.agents.Agent#makeDecision(double, long)
	 */

	@Override
	public void makeDecision(double simulationTime, long iterationCount) {
		// Protocole Couleur

		// identify the maximum position on the same Road

		Message m2 = null;
		double positionMax = this.getFrontPosition();
		System.out.println("MD current vehicle: " + this.getId());

		for (SensedVehicle sv : getCommunicatingVehicles().values())
			// pick the next message from queued message 

			if (sv instanceof SensedVehicleAgent) {
				for (Message m : ((SensedVehicleAgent)sv).getMessages()) {
					System.out.println(m.getIdSender()+ ":" + m + " time :" + m.getTime());					
					if (m instanceof AgentMessage) {
						if (((AgentMessage) m).getSubject().equals("color") && ((AgentMessage) m).getPerformative().equals("request")) {
							if ( ((AgentMessage) m).getContent().get("roadId") == (Integer)roadSegmentId() && m.getLaneSender() == this.getLane()) {
								if (m.getPositionSender() > positionMax) {
									m2 = m;
									positionMax = m.getPositionSender();
								}
							}

						}
					}
				}
			}
		if (m2 != null) {
			System.out.println("Leader : " + m2.getIdSender());
			Color c = (Color) ((AgentMessage) m2).getContent().get("colorValue");
			if (c != (Color) colorObject()) {
				initialColor = (Color) colorObject();
				setColorObject(c);
			}
		}else 
			if (initialColor != null)
				setColorObject(initialColor);	
		getCommunicatingVehicles().clear();
		
	}


}
