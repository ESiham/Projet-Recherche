package fr.ifsttar.licit.simulator.agents.perception.sensors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import fr.ifsttar.licit.simulator.agents.Agent;
import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.environment.PerceptibleEnvironment;
import fr.ifsttar.licit.simulator.environment.PerceptiblePartition;

/**
 * The most generic sensor class, suitable for every sensor
 * 
 * @author mgueriau
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
 *       &lt;attribute name="reliability" type="{}probability"  default="1.0" />
 *       &lt;attribute name="frequency" type="{}nonNegativeDouble" default="0.1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sensor")
public abstract class Sensor {


	/**
	 * represents the degree of reliability of this sensor (i.e. the proportion for providing good measurments)
	 */
	@XmlAttribute(name = "reliability")
	protected double reliability = 1.0;	
	
	@XmlAttribute(name = "frequency")
	private double frequency = 0.1;	
	
	//private double lastUpdateTime = -1;
	
	public Sensor(){
		this.reliability = 1.0;
	}
	
	public Sensor(double reliability){
		if(reliability <= 0.0)
			this.reliability = 0.001;
		else
			this.reliability = reliability;
	}
	
	
	public double getReliability(){
		return this.reliability;
	}
	
	public double getFrequency(){
		return this.frequency;
	}
	
	
	/**
	 * 
	 * compute the perception (perceived elements) of given agent in the current partition of the environment
	 * 
	 * @param agent
	 * @param partition
	 * @param environment
	 * @return
	 */
	public AgentPerception percieve(Agent agent, PerceptiblePartition partition2, PerceptiblePartition partition1,  PerceptibleEnvironment environment) {
		return this.percieve(agent, partition2, partition1, environment,0.0);
	}

	public abstract AgentPerception percieve(Agent agent, PerceptiblePartition partition2, PerceptiblePartition partition1,  PerceptibleEnvironment environment, double simulationTime);//{
	//	if(simulationTime >= (lastUpdateTime+ this.frequency)){
			//this.lastUpdateTime=simulationTime;
	//		System.out.println(this.getClass() + " perceive at time " + simulationTime);
	//		return this.percieve(agent, partition2, partition1, environment);
	//	} else {
	//		return null;
	//	}
	//}
}
