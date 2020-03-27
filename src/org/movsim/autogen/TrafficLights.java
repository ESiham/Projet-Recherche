//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.12.13 à 09:11:31 AM CET 
//


package org.movsim.autogen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}ControllerGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="n_timestep" type="{}positiveInteger" default="1" />
 *       &lt;attribute name="logging" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "controllerGroup"
})
@XmlRootElement(name = "TrafficLights")
public class TrafficLights
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ControllerGroup")
    protected List<ControllerGroup> controllerGroup;
    @XmlAttribute(name = "n_timestep")
    protected Integer nTimestep;
    @XmlAttribute(name = "logging")
    protected Boolean logging;

    /**
     * Gets the value of the controllerGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controllerGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControllerGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ControllerGroup }
     * 
     * 
     */
    public List<ControllerGroup> getControllerGroup() {
        if (controllerGroup == null) {
            controllerGroup = new ArrayList<ControllerGroup>();
        }
        return this.controllerGroup;
    }

    public boolean isSetControllerGroup() {
        return ((this.controllerGroup!= null)&&(!this.controllerGroup.isEmpty()));
    }

    public void unsetControllerGroup() {
        this.controllerGroup = null;
    }

    /**
     * Obtient la valeur de la propriété nTimestep.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getNTimestep() {
        if (nTimestep == null) {
            return  1;
        } else {
            return nTimestep;
        }
    }

    /**
     * Définit la valeur de la propriété nTimestep.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNTimestep(int value) {
        this.nTimestep = value;
    }

    public boolean isSetNTimestep() {
        return (this.nTimestep!= null);
    }

    public void unsetNTimestep() {
        this.nTimestep = null;
    }

    /**
     * Obtient la valeur de la propriété logging.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isLogging() {
        if (logging == null) {
            return false;
        } else {
            return logging;
        }
    }

    /**
     * Définit la valeur de la propriété logging.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLogging(boolean value) {
        this.logging = value;
    }

    public boolean isSetLogging() {
        return (this.logging!= null);
    }

    public void unsetLogging() {
        this.logging = null;
    }

}
