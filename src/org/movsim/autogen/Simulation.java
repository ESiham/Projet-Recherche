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
 *         &lt;element ref="{}ExternalControl" maxOccurs="1"/>
 *         &lt;element ref="{}TrafficComposition"/>
 *         &lt;element ref="{}Road" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="timestep" use="required" type="{}positiveDouble" />
 *       &lt;attribute name="duration" type="{http://www.w3.org/2001/XMLSchema}double" default="-1" />
 *       &lt;attribute name="with_seed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="seed" type="{http://www.w3.org/2001/XMLSchema}int" default="42" />
 *       &lt;attribute name="crash_exit" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="time_offset" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
	"externalControl",
    "trafficComposition",
    "road"
})
@XmlRootElement(name = "Simulation")
public class Simulation
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    
    @XmlElement(name = "ExternalControl")
    protected ExternalControl externalControl;
    @XmlElement(name = "TrafficComposition", required = true)
    protected TrafficComposition trafficComposition;
    @XmlElement(name = "Road")
    protected List<Road> road;
    @XmlAttribute(name = "timestep", required = true)
    protected double timestep;
    @XmlAttribute(name = "duration")
    protected Double duration;
    @XmlAttribute(name = "with_seed")
    protected Boolean withSeed;
    @XmlAttribute(name = "seed")
    protected Integer seed;
    @XmlAttribute(name = "crash_exit")
    protected Boolean crashExit;
    @XmlAttribute(name = "time_offset")
    protected String timeOffset;

    
    /**
     * Obtient la valeur de la propriété ExternalControl.
     * 
     * @return
     *     possible object is
     *     {@link ExternalControl }
     *     
     */
    public ExternalControl getExternalControl() {
        return externalControl;
    }
    
    /**
     * Définit la valeur de la propriété ExternalControl.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalControl }
     *     
     */
    public void setExternalControl(ExternalControl value) {
        this.externalControl = value;
    }

    public boolean isSetExternalControl() {
        return (this.externalControl!= null);
    }
    
    /**
     * Obtient la valeur de la propriété trafficComposition.
     * 
     * @return
     *     possible object is
     *     {@link TrafficComposition }
     *     
     */
    public TrafficComposition getTrafficComposition() {
        return trafficComposition;
    }

    /**
     * Définit la valeur de la propriété trafficComposition.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficComposition }
     *     
     */
    public void setTrafficComposition(TrafficComposition value) {
        this.trafficComposition = value;
    }

    public boolean isSetTrafficComposition() {
        return (this.trafficComposition!= null);
    }

    /**
     * Gets the value of the road property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the road property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Road }
     * 
     * 
     */
    public List<Road> getRoad() {
        if (road == null) {
            road = new ArrayList<Road>();
        }
        return this.road;
    }

    public boolean isSetRoad() {
        return ((this.road!= null)&&(!this.road.isEmpty()));
    }

    public void unsetRoad() {
        this.road = null;
    }

    /**
     * Obtient la valeur de la propriété timestep.
     * 
     */
    public double getTimestep() {
        return timestep;
    }

    /**
     * Définit la valeur de la propriété timestep.
     * 
     */
    public void setTimestep(double value) {
        this.timestep = value;
    }

    public boolean isSetTimestep() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété duration.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getDuration() {
        if (duration == null) {
            return -1.0D;
        } else {
            return duration;
        }
    }

    /**
     * Définit la valeur de la propriété duration.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDuration(double value) {
        this.duration = value;
    }

    public boolean isSetDuration() {
        return (this.duration!= null);
    }

    public void unsetDuration() {
        this.duration = null;
    }

    /**
     * Obtient la valeur de la propriété withSeed.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isWithSeed() {
        if (withSeed == null) {
            return true;
        } else {
            return withSeed;
        }
    }

    /**
     * Définit la valeur de la propriété withSeed.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWithSeed(boolean value) {
        this.withSeed = value;
    }

    public boolean isSetWithSeed() {
        return (this.withSeed!= null);
    }

    public void unsetWithSeed() {
        this.withSeed = null;
    }

    /**
     * Obtient la valeur de la propriété seed.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getSeed() {
        if (seed == null) {
            return  42;
        } else {
            return seed;
        }
    }

    /**
     * Définit la valeur de la propriété seed.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeed(int value) {
        this.seed = value;
    }

    public boolean isSetSeed() {
        return (this.seed!= null);
    }

    public void unsetSeed() {
        this.seed = null;
    }

    /**
     * Obtient la valeur de la propriété crashExit.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCrashExit() {
        if (crashExit == null) {
            return true;
        } else {
            return crashExit;
        }
    }

    /**
     * Définit la valeur de la propriété crashExit.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrashExit(boolean value) {
        this.crashExit = value;
    }

    public boolean isSetCrashExit() {
        return (this.crashExit!= null);
    }

    public void unsetCrashExit() {
        this.crashExit = null;
    }

    /**
     * Obtient la valeur de la propriété timeOffset.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeOffset() {
        return timeOffset;
    }

    /**
     * Définit la valeur de la propriété timeOffset.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeOffset(String value) {
        this.timeOffset = value;
    }

    public boolean isSetTimeOffset() {
        return (this.timeOffset!= null);
    }

}
