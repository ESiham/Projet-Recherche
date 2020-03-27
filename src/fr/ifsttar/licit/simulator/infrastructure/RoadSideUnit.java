package fr.ifsttar.licit.simulator.infrastructure;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.movsim.autogen.CrossSection;
import org.movsim.autogen.Intersection;
import org.movsim.output.detector.LoopDetector;
import org.movsim.simulator.roadnetwork.RoadNetwork;
import org.movsim.simulator.roadnetwork.RoadSegment;

import fr.ifsttar.licit.simulator.agents.Agent;
import fr.ifsttar.licit.simulator.agents.communication.messages.Message;
import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;
import fr.ifsttar.licit.simulator.agents.perception.infrastructure.InitialRSUPerception;
import fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure.RSUDevice;
import fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure.RSULoopDetector;
import fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure.control.RSUController;



/**
 * A Road Side Unit is an interactive element of the environment able to communicate with intelligent vehicles.
 * 
 *  FIXME : link RSU with RoadSegment ??? or prefer set a world space position ???
 *  FIXME : how to deal with communication and perception ??? should messages be living objects ? or should communication be instantaneous ?
 * 
 * @author gueriau
 *
 */

/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="position" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="range" default="150.0" type="{}nonNegativeDouble" />
 *       &lt;attribute name="offset" default="0.0" type="{}nonNegativeDouble" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "RoadSideUnit")
public class RoadSideUnit extends Agent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     
	@XmlAttribute(name = "position", required = true)
	protected double position;

	
	@XmlAttribute(name = "range")
	protected double range;

	@XmlAttribute(name = "offset")
	protected double offset = 5;

	private double speedRecommandation = 25;

	//private RSUDevice rsuDevice;	@XmlElement(name = "Detector")
	protected List<CrossSection> detectors;

	@XmlElement(name = "Intersection")
	protected List<Intersection> intersections;
	
	@XmlElement(name = "id")
	protected long id = -1;
	
	protected static final int INITIAL_ID = 1;

    private static long nextId = INITIAL_ID;
	
    public final long getId() {
        return id;
	 }
	
	//protected ArrayList<Action> actions = new ArrayList<Action>();
	
	public List<CrossSection> getDetector() {
		if (detectors == null) {
			detectors = new ArrayList<CrossSection>();
		}
		return this.detectors;
	}

	public boolean isSetDetector() {
		return ((this.detectors!= null)&&(!this.detectors.isEmpty()));
	}

	public void unsetDetector() {
		this.detectors = null;
	}
	
	public List<Intersection> getIntersection() {
		if (intersections == null) {
			intersections = new ArrayList<Intersection>();
		}
		return this.intersections;
	}

	public boolean isSetIntersection() {
		return ((this.intersections!= null)&&(!this.intersections.isEmpty()));
	}

	public void unsetIntersection() {
		this.intersections = null;
	}



	/**
	 * External Learning
	 */
	//private ArrayList<Discretizer> discretizers  = new ArrayList<Discretizer>();

	//private Action lastAction = null;

	//private Class selectedClass;


	public RoadSideUnit(){
			
		
		this.perception = new MeasurementPerception();

		//this.rsuDevice = new RSUDevice();//(this.range);
		this.sensors.add( new RSUDevice());
		//this.sensors.add(new RSULoopDetector());//(this.range));

		
		//create the action set
		/*this.actions.add(new DoNothingAction());
		this.actions.add(new WarningMessageAction(WarningType.Laneclosure, 3, new CircularArea(1000, 500), true));
		this.actions.add(new WarningMessageAction(WarningType.Laneclosure, 3, new CircularArea(1000, 500), false));
		this.actions.add(new WarningMessageAction(WarningType.Laneclosure, 2, new CircularArea(1000, 500), true));
		this.actions.add(new WarningMessageAction(WarningType.Laneclosure, 2, new CircularArea(1000, 500), false));
		this.actions.add(new WarningMessageAction(WarningType.Laneclosure, 1, new CircularArea(1000, 500), true));
		this.actions.add(new WarningMessageAction(WarningType.Laneclosure, 1, new CircularArea(1000, 500), false));*/
	
	}

	public void initialize(RoadNetwork network){
		//this.sensors.add(new RSUBroadcaster(this.range));

		if(this.id == -1){
			this.id = nextId++;
		}
		
		this.initializeExternalControl();
		
		
		if(this.isExternalControl()){
			this.sensors.add(new RSUController());
		}
		
		for(RoadSegment segment : network){
			if(segment.getLoopDetectors() != null){
				List<LoopDetector> detectors = segment.getLoopDetectors().getDetectors();
				for(LoopDetector detector : detectors){
					for(CrossSection d : this.detectors){
						if(detector.getId()==d.getId()){
							this.sensors.add(new RSULoopDetector(detector));

							//Matching between sensors and discretisers						
							//if(this.externalControl){
							//	this.discretizers.add(new Discretizer(this.actions.size()));
							//}
						}
					}
				}
			}
		}
	} 


	public RoadSideUnit(double position){
		this();
		this.position = position;
	}

	@Override
	public void addSelfPerception() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return
	 */
	@Override
	protected AgentPerception getInitialPerception() {
		AgentPerception initialPerception = new InitialRSUPerception(this.id, this.position, this.intersections);
		return initialPerception;
	}
	
	//TODO extract perception computation from vehicle and put it into agent


	/**
	 * Obtient la valeur de la propriété position.
	 * 
	 */
	public double getPosition() {
		return position;
	}

	/**
	 * Obtient la valeur de la propriété position.
	 * 
	 */
	public double getRange() {
		return range;
	}

	/**
	 * Obtient la valeur de la propriété position.
	 * 
	 */
	public double getOffset() {
		return offset;
	}



	/**
	 * Définit la valeur de la propriété position.
	 * 
	 */
	public void setPosition(double value) {
		this.position = value;
	}

	public boolean isSetPosition() {
		return true;
	}

	public void handleMessages(double simulationTime) {

		while (this.getMailSize()>0){
			Message message = this.pickMessage();
			//System.out.println("RSU: " + message);
		
		}
		//finally, clear the messages to send list
		this.resetMessagesToSend();
	}
	
	protected Color color = Color.WHITE;
	
	public Color getColor(){
		return this.color;
	}
	
	public void setColor(Color color){
		this.color=color;
	}
	@Override
	public void makeDecision(double simulationTime, long iterationCount) {

		if(this.isExternalControl()){
			MeasurementPerception mperception = (MeasurementPerception) perception;
			mperception.setSelfId(this.id);
		//	sendMessage(new MessageRSU(this, "hello"));
		}
		
		//everything is finished for RSU, reset the perception
		this.perception=null;
		this.perception = new MeasurementPerception();
	}



	public double getSpeedRecommandation() {
		return speedRecommandation;
	}
	
}
