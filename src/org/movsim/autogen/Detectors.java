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
 *         &lt;element ref="{}CrossSection" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sample_interval" type="{}positiveDouble" default="60" />
 *       &lt;attribute name="logging" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="logging_lanes" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "crossSection"
})
@XmlRootElement(name = "Detectors")
public class Detectors
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "CrossSection")
    protected List<CrossSection> crossSection;
    @XmlAttribute(name = "sample_interval")
    protected Double sampleInterval;
    @XmlAttribute(name = "logging")
    protected Boolean logging;
    @XmlAttribute(name = "logging_lanes")
    protected Boolean loggingLanes;
 
    
    /**
     * Gets the value of the crossSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crossSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrossSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrossSection }
     * 
     * 
     */
    public List<CrossSection> getCrossSection() {
        if (crossSection == null) {
            crossSection = new ArrayList<CrossSection>();
        }
        return this.crossSection;
    }

    public boolean isSetCrossSection() {
        return ((this.crossSection!= null)&&(!this.crossSection.isEmpty()));
    }

    public void unsetCrossSection() {
        this.crossSection = null;
    }

    /**
     * Obtient la valeur de la propriété sampleInterval.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getSampleInterval() {
        if (sampleInterval == null) {
            return  60.0D;
        } else {
            return sampleInterval;
        }
    }

    /**
     * Définit la valeur de la propriété sampleInterval.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSampleInterval(double value) {
        this.sampleInterval = value;
    }

    public boolean isSetSampleInterval() {
        return (this.sampleInterval!= null);
    }

    public void unsetSampleInterval() {
        this.sampleInterval = null;
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

    /**
     * Obtient la valeur de la propriété loggingLanes.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isLoggingLanes() {
        if (loggingLanes == null) {
            return false;
        } else {
            return loggingLanes;
        }
    }

    /**
     * Définit la valeur de la propriété loggingLanes.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLoggingLanes(boolean value) {
        this.loggingLanes = value;
    }

    public boolean isSetLoggingLanes() {
        return (this.loggingLanes!= null);
    }

    public void unsetLoggingLanes() {
        this.loggingLanes = null;
    }

}
