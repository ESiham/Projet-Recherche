package fr.ifsttar.licit.simulator.agents.perception;

import java.util.ArrayList;

import org.movsim.simulator.vehicles.Vehicle;
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.IDM;
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameterIDM;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.ifsttar.licit.simulator.agents.perception.representation.SensedVehicle;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.Measurement;
import fr.ifsttar.licit.simulator.network.simulation.util.xml.XMLCodec;

public class MeasurementPerception extends AgentPerception implements XMLCodec.XMLEncodable {

	
	/*public ArrayList<SensedVehicle> frontVehicles = new ArrayList<SensedVehicle>();
	
	public ArrayList<SensedVehicle> rearVehicles = new ArrayList<SensedVehicle>();*/
	
	
	public long id;
	/**
	 * 
	 */
	private static final long serialVersionUID = 151493725924778942L;

	private ArrayList<Measurement> ownMeasurements = new ArrayList<Measurement>();
	
	private ArrayList<SensedVehicle> surroundingVehicles = new ArrayList<SensedVehicle>();
	
	private ArrayList<Long> detectedVehicles = new ArrayList<Long>();
	private ArrayList<Long> undetectedVehicles = new ArrayList<Long>();
	
	/*
	 * add for TP
	 */
	private static int numberVehicleArea = 0;	
	public static int getNumberVehicleArea() {
		return numberVehicleArea;
	}
////////////////////////////
	public void addDetectedVehicle(long id){
		this.detectedVehicles.add(id);
	}
	
	public void addUndetectedVehicle(long id){
		this.undetectedVehicles.add(id);
	}
	/*private double meanFlow = 0;
	
	private double meanSpeed = 0;*/
	
	public void setSelfId(long id){
		this.id=id;
	}
	
	private ArrayList<Double> flows = new ArrayList<Double>();
	private ArrayList<Double> speeds = new ArrayList<Double>();
	
	@Override
	protected void mergeObjects(AgentPerception perception) {

		if(perception!=null && perception instanceof MeasurementPerception){
			
			this.id = ((MeasurementPerception) perception).getId();
			
			this.ownMeasurements.addAll(((MeasurementPerception) perception).getOwnMeasurements());
			this.surroundingVehicles.addAll(((MeasurementPerception) perception).getSurroundingVehicles());
						
			this.flows.addAll(((MeasurementPerception) perception).getFlows());
			this.speeds.addAll(((MeasurementPerception) perception).getSpeeds());
			
			if(((MeasurementPerception) perception).getDeltaXeq()!=0.0 && ((MeasurementPerception) perception).getVeq()!=0.0 ){
				this.deltaXeq=((MeasurementPerception) perception).getDeltaXeq();
				this.veq= ((MeasurementPerception) perception).getVeq();
			}
			
			this.detectedVehicles.addAll(((MeasurementPerception) perception).detectedVehicles);
			this.undetectedVehicles.addAll(((MeasurementPerception) perception).undetectedVehicles);
		}
	}
	
	

	/**
	 * @return
	 */
	private long getId() {
		return this.id;
	}

	/**
	 * Add vehicles in front of current vehicles. 
	 * Sensed vehicles must be added from nearest to farther 
	 * 
	 * @param deltaX
	 * @param deltaV
	 */	
	public ArrayList<Double> getSpeeds() {
		return this.speeds;
	}
	
	public ArrayList<Double> getFlows() {
		return this.flows;
	}

	/**
	 * Add vehicles in front of current vehicles. 
	 * Sensed vehicles must be added from nearest to farther 
	 * 
	 * @param deltaX
	 * @param deltaV
	 */
	
	public ArrayList<Measurement> getOwnMeasurements() {
		return this.ownMeasurements;
	}

	/**
	 * Add shared measurements from other vehicles
	 *
	 * @param deltaX
	 * @param deltaV
	 */
	public void addOwnMeasurement(Measurement measurement){
		this.ownMeasurements.add(measurement);
	}

	public ArrayList<SensedVehicle> getSurroundingVehicles() {
		return surroundingVehicles;
	}

	public void setSurroundingVehicles(ArrayList<SensedVehicle> surroundingVehicles) {
		this.surroundingVehicles = surroundingVehicles;
	}

	private double deltaXeq=0.0;
	private double veq=0.0;


	public double getDeltaXeq() {
		return this.deltaXeq;
	}
	
	public void setDeltaXeq(double deltaXeq) {
		this.deltaXeq = deltaXeq;
	}

	public double getVeq() {
		return this.veq;
	}
	
	public void setVeq(double veq) {
		this.veq = veq;
	}

	public void addFLowSpeed(double flow, double speed) {
		this.flows.add(new Double(flow));
		this.speeds.add(new Double(speed));
	}



	/**
	 * Encodes the contents of this perception object to the right XML format,
	 * according to the protocol description.
	 */
	public void encodeToXML(Element target) {

		//System.out.println("encode to xml perception measurement");
		
		/*
		 * <simulation step="X"/>
		 */
		Element elSimulation = target.getOwnerDocument().createElement("simulation");
		elSimulation.setAttribute("step", String.valueOf(1));
		target.appendChild(elSimulation);
		
		// Info about self
		Document doc = target.getOwnerDocument();
		Element elSelf = doc.createElement("self");
		elSelf.setAttribute("name", "RSU"+this.id);
		target.appendChild(elSelf);
		
		Element elVehicles = doc.createElement("vehicles");
	
		for(long id : this.detectedVehicles){
			Element elVehicle = doc.createElement("enteringVehicle");
			elVehicle.setAttribute("id", String.valueOf(id));
			elVehicles.appendChild(elVehicle);
		}
		for(long id : this.undetectedVehicles) {
			Element elVehicle = doc.createElement("quittingVehicle");
			elVehicle.setAttribute("id", String.valueOf(id));
			elVehicles.appendChild(elVehicle);
		}
		target.appendChild(elVehicles);
		/*
		 * add for TP
		 */
		numberVehicleArea += (detectedVehicles.size() - undetectedVehicles.size());
		Element nbVehicleArea = doc.createElement("numberVehicleArea");
		nbVehicleArea.setAttribute("value", String.valueOf(numberVehicleArea));	
	//	System.out.println(numberVehicleArea+ " entrant: " + detectedVehicles.size() 
	//			+ " sortant: " +  undetectedVehicles.size());
	//comment for tp
	//	target.appendChild(nbVehicleArea);
	}
	
}
