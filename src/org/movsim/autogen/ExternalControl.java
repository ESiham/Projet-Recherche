package org.movsim.autogen;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Maxime Gu�riau
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ExternalControl")
public class ExternalControl implements Serializable
{

	 @XmlAttribute(name = "agent_port")
	 protected int agentPort = 12300;
	 @XmlAttribute(name = "backlog_port")
	 protected int backLogPort = 10;
	 
	 
	 /**
     * Obtient la valeur de la propriété agentPort.
     * 
     */
	public int getAgentPort() {
        return agentPort;
    }

    /**
     * Définit la valeur de la propriété agentPort.
     * 
     */
    public void setAgentPort(int value) {
        this.agentPort = value;
    }

    public boolean isSetAgentPort() {
        return true;
    }
    
    /**
     * Obtient la valeur de la propriété BackLogPort.
     * 
     */
	public int getBackLogPort() {
        return backLogPort;
    }

    /**
     * Définit la valeur de la propriété agentPort.
     * 
     */
    public void setBackLogPort(int value) {
        this.backLogPort = value;
    }

    public boolean isSetBackLogPort() {
        return true;
    }
	
}
