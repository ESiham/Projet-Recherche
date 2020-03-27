/**
 * 
 */
package fr.ifsttar.licit.simulator.agents.perception.vehicles;

import java.util.ArrayList;
import java.util.HashMap;

import org.movsim.simulator.vehicles.Vehicle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.agents.perception.representation.SensedVehicle;
import fr.ifsttar.licit.simulator.network.simulation.util.xml.XMLCodec;

/**
 * @author Maxime
 *
 */
public class VehicleSelfPerception extends AgentPerception implements
		XMLCodec.XMLEncodable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final long id;
	private final int lane;

	public int getLane() {
		return lane;
	}

	private double speed;
	private double distanceToSectionEnd;
	private double acc;
	private HashMap<Long,SensedVehicle> communicatingVehicles;
	private long roadId;
	private double position;

	@Override
	public String toString() {
		return "VehicleSelfPerception [id=" + id + ", lane=" + lane
				+ ", speed=" + getSpeed() + ", distanceToSectionEnd=" + distanceToSectionEnd + ", acc="
				+ acc + ", communicatingVehicles=" + communicatingVehicles
				+ ", roadId=" + roadId + ", position=" + position + "]";
	}

	public VehicleSelfPerception(long id, long roadId, double position,
			int lane, double speed, double acceleration,
			double distanceToRoadSegmentEnd) {// double interdistance, double
												// relativeSpeed){
		this.id = id;
		this.roadId = roadId;
		this.position = position;
		this.lane = lane;
		this.setSpeed(speed);
		this.distanceToSectionEnd = distanceToRoadSegmentEnd;
		// this.interdistance=interdistance;
		// this.relativeSpeed=relativeSpeed;
	}

	public VehicleSelfPerception(Vehicle v) {
		this.id = v.getId();
		this.lane = v.getLane();
		this.setSpeed(v.getSpeed());
		this.acc = v.getAcc();
		// add for tp : approximation
		this.position = v.getFrontPositionOld();
		this.communicatingVehicles = v.getCommunicatingVehicles();

		// this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.ifsttar.licit.simulator.agents.perception.Perception#mergeObjects(
	 * fr.ifsttar.licit.simulator.agents.perception.Perception)
	 */
	@Override
	protected void mergeObjects(AgentPerception perception) {
		// TODO Auto-generated method stub

	}

	/**
	 * Encodes the contents of this perception object to the right XML format,
	 * according to the protocol description.
	 */
	public void encodeToXML(Element target) {

		// System.out.println("VehicleSelfPerception encode to xml perception measurement");

		/*
		 * <simulation step="X"/>
		 */
		Element elSimulation = target.getOwnerDocument().createElement(
				"simulation");
		elSimulation.setAttribute("step", String.valueOf(1));
		target.appendChild(elSimulation);

		// Info about self
		Document doc = target.getOwnerDocument();
		Element elSelf = doc.createElement("speed");
		elSelf.setAttribute("value", String.valueOf(getSpeed()));
		target.appendChild(elSelf);
		elSelf = doc.createElement("lane");
		elSelf.setAttribute("value", String.valueOf(lane));
		target.appendChild(elSelf);
		elSelf = doc.createElement("position");
		elSelf.setAttribute("value", String.valueOf(position));
		target.appendChild(elSelf);

		// info about other
		Element svL = doc.createElement("surroudingVehicles");
		int k = 0;
		for (SensedVehicle sv : communicatingVehicles.values()) {
			String st[] = sv.toString().split(":");
			Element svE = doc.createElement("sensedVehicle");
			svE.setAttribute("value", sv.toString());
			svL.appendChild(svE);
		}
		target.appendChild(svL);
		// remise à zero une fois ajouté
		communicatingVehicles.clear();
	}

	public HashMap<Long, SensedVehicle> getCommunicationVehicles() {
		return communicatingVehicles;

	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

}
