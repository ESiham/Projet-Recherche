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
 *         &lt;element ref="{}TrafficLightState" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="duration" use="required" type="{}nonNegativeDouble" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "trafficLightState"
})
@XmlRootElement(name = "Phase")
public class Phase
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "TrafficLightState", required = true)
    protected List<TrafficLightState> trafficLightState;
    @XmlAttribute(name = "duration", required = true)
    protected double duration;

    /**
     * Gets the value of the trafficLightState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trafficLightState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrafficLightState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrafficLightState }
     * 
     * 
     */
    public List<TrafficLightState> getTrafficLightState() {
        if (trafficLightState == null) {
            trafficLightState = new ArrayList<TrafficLightState>();
        }
        return this.trafficLightState;
    }

    public boolean isSetTrafficLightState() {
        return ((this.trafficLightState!= null)&&(!this.trafficLightState.isEmpty()));
    }

    public void unsetTrafficLightState() {
        this.trafficLightState = null;
    }

    /**
     * Obtient la valeur de la propriété duration.
     * 
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Définit la valeur de la propriété duration.
     * 
     */
    public void setDuration(double value) {
        this.duration = value;
    }

    public boolean isSetDuration() {
        return true;
    }

}
