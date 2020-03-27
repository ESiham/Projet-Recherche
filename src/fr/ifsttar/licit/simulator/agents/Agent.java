package fr.ifsttar.licit.simulator.agents;

import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import fr.ifsttar.licit.simulator.agents.communication.messages.Message;
import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensor;
import fr.ifsttar.licit.simulator.agents.trust.models.base.TrustModel;
import fr.ifsttar.licit.simulator.agents.trust.representation.Trust;
import fr.ifsttar.licit.simulator.network.connection.XMLSocketSimulationAgent;
import fr.ifsttar.licit.simulator.network.simulation.agents.SimulationAgent;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Agent")
public abstract class Agent {

    private AgentType type = AgentType.NONE;  
    
    /**
     * Trusts/Reputations of this agent
     * Trust must be initialized in subclasses constructor
     */
    protected Trust trust;
    
    /**
     * 
     */
    /** can be null */
    public TrustModel trustModel = null;    
    /**
     * 
     */
    public void setTrustModel(TrustModel trustModel) {
    	this.trustModel = trustModel;
	}
   
    
    public Trust getTrust() {
		return trust;
	}


	/**
     *  Messages received by this vehicle
     *  Represented as a FIFO list
     *  Messages are temporarily stored in the mail box if reading is not immediate
     *  @author gueriau
     */
    private LinkedList<Message> messageBox = new LinkedList<Message>();
    
    /**
        *  Messages ready to be sent by this vehicle
        *  Represented as a FIFO list
        *  @author gueriau
        */
    private LinkedList<Message> sendBox = new LinkedList<Message>();

    /** 
     *  Perception & sensors data of this vehicle
     *  
     */
    protected AgentPerception perception = null;
    protected ArrayList<Sensor> sensors = new ArrayList<Sensor>();
    
    
    public void addSensors(List<Sensor> sensors){
    	
    	if(sensors!=null)
    		this.sensors.addAll(sensors); 	
    }
    
    public void addSensor(Sensor s){
    	if(s!=null)
    		this.sensors.add(s);
    }
    
    /**
     * Returns this vehicle's type.
     * 
     * @return vehicle's type
     * 
     */
    public final AgentType type() {
        return type;
    }

    /**
     * Sets this vehicle's type.
     * 
     * @param type
     * 
     */
    public final void setType(AgentType type) {
        this.type = type;
    }
    
    public AgentType getType(){
    	return this.type;
    }
    
    

    /**
     * Network
     */
    protected SimulationAgent xmlSocketSimulationAgent;
    
    public SimulationAgent getXmlSocketSimulationAgent(){
    	return this.xmlSocketSimulationAgent;
    }
    
    @XmlAttribute(name = "externalControl")
	protected boolean externalControl;
   
    
    /**
     *  Makes possible to control an agent over network
     */
    public void setExternalControl(boolean externalControl){
    	this.externalControl = externalControl;
    }
    
    public boolean isExternalControl(){
    	return this.externalControl;
    }
    
    
    public Agent(){
    	
    }
    
    public Agent(AgentType type){
    	this();
    	this.type=type;
    }

    
	/**
	 *  Transfer messages from perception to mailbox
	 */
	public void recieveMessages(){
		this.messageBox.addAll(this.perception.getMessages());
	}
	
	/**
	 * Get the first message and remove it from the mail box
	 * 
	 * 
	 * @return the oldest message
	 */
	protected Message pickMessage() {
		return messageBox.removeFirst();
	}

	public void addMessage(Message message) {
		this.messageBox.add(message);
	}

	public int getMailSize() {
		return messageBox.size();
	}

	
	public void sendMessage(Message message) {
			this.sendBox.add(message);
			}
			
	public LinkedList<Message> getMessagesToSend() {
		LinkedList<Message> lm = (LinkedList<Message>) this.sendBox.clone();
	//	resetMessagesToSend();
		return lm;
	}
			
	public void resetMessagesToSend() {
		this.sendBox.clear();
	}
	/**
     * Reset the perception information of this Agent
     * 
     * @author gueriau
     */
	public void resetPerception() {
		this.perception = null;
	}

	 /**
     * Add new perception to existing one
     * 
     * @author gueriau
     */
	public void addPerception(AgentPerception p) {
		this.perception.merge(p);
		
		//if(this instanceof RoadSideUnit)
		//	System.out.println(this.perception.getMessages().size());
		
	}
	
	 /**
     * allow access to previously computer perception (for communication purpose)
     * 
     * @author gueriau
     */
	public AgentPerception getPerception() {
		return this.perception;
	}
	
	/**
	 * Return the initial state of the agent as a perception
	 * @return
	 */
	protected abstract AgentPerception getInitialPerception();
	
	/**
	 * Adds self parameters to current perception
	 */
	public abstract void addSelfPerception();
	
	
	/**
	 * Get the agent sensors 
	 * 
	 * @return the sensor list
	 */
	public List<Sensor> getSensors() {
		return this.sensors;
	}


	//public abstract void handleMessages(double simulationTime);

	public abstract void handleMessages(/*Vehicle vehicle, */double simulationTime);/* {
	// TODO Auto-generated method stub
	
}	*/


	/**
	 * This method enables an agent to be controlled over network if its parameters enables it
	 */
	public void initializeExternalControl() {

		if(this.externalControl){ 
			this.xmlSocketSimulationAgent = new XMLSocketSimulationAgent();
		}
				
	}
	/**
	 * @param simulationTime
	 */
	public void makeDecision(double simulationTime, long iterationCount) {
		// TODO Auto-generated method stub
		
	}


	
	/*public void handleSocket(Socket s){
		if(this.xmlSocketSimulationAgent !=null) {
			this.xmlSocketSimulationAgent.handleSocket(s);
		}
	}*/
	
}
