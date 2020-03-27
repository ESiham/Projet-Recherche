//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.12.13 à 09:11:31 AM CET 
//


package org.movsim.autogen;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensor;
import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensors;
import fr.ifsttar.licit.simulator.agents.trust.models.base.TrustModelType;


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
 *         &lt;element ref="{}AccelerationModelType"/>
 *         &lt;element ref="{}LaneChangeModelType" minOccurs="0"/>
 *         &lt;element ref="{}TrustModelType" minOccurs="0" maxOccurs="1"/>
 *         &lt;element ref="{}MemoryParameter" minOccurs="0"/>
 *         &lt;element ref="{}NoiseParameter" minOccurs="0"/>
 *         &lt;element ref="{}Sensors" minOccurs="0" maxOccurs="1"/>
 *       &lt;/sequence>
 *       &lt;attribute name="label" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="length" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="width" type="{}nonNegativeDouble" default="4.4" />
 *       &lt;attribute name="maximum_deceleration" type="{}nonNegativeDouble" default="10000" />
 *       &lt;attribute name="consumption_model_name" type="{http://www.w3.org/2001/XMLSchema}string" default="none" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accelerationModelType",
    "laneChangeModelType",
    "trustModelType",
    "memoryParameter",
    "noiseParameter",
    "sensors"
})
@XmlRootElement(name = "VehiclePrototypeConfiguration")
public class VehiclePrototypeConfiguration
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "AccelerationModelType", required = true)
    protected AccelerationModelType accelerationModelType;
    @XmlElement(name = "LaneChangeModelType")
    protected LaneChangeModelType laneChangeModelType;
    @XmlElement(name = "TrustModelType")
    protected TrustModelType trustModelType;
    @XmlElement(name = "MemoryParameter")
    protected MemoryParameter memoryParameter;
    @XmlElement(name = "NoiseParameter")
    protected NoiseParameter noiseParameter;
    @XmlAttribute(name = "externalControl")
	protected boolean externalControl = false;
    @XmlAttribute(name = "label", required = true)
    protected String label;
    @XmlAttribute(name = "length", required = true)
    protected double length;
    @XmlAttribute(name = "width")
    protected Double width;
    @XmlAttribute(name = "maximum_deceleration")
    protected Double maximumDeceleration;
    @XmlAttribute(name = "consumption_model_name")
    protected String consumptionModelName;
    @XmlElement(name = "Sensors")
    protected Sensors sensors;
    
    /**
     * Obtient la valeur de la propriété accelerationModelType.
     * 
     * @return
     *     possible object is
     *     {@link AccelerationModelType }
     *     
     */
    public AccelerationModelType getAccelerationModelType() {
        return accelerationModelType;
    }

    /**
     * Définit la valeur de la propriété accelerationModelType.
     * 
     * @param value
     *     allowed object is
     *     {@link AccelerationModelType }
     *     
     */
    public void setAccelerationModelType(AccelerationModelType value) {
        this.accelerationModelType = value;
    }

    public boolean isSetAccelerationModelType() {
        return (this.accelerationModelType!= null);
    }

    /**
     * Obtient la valeur de la propriété laneChangeModelType.
     * 
     * @return
     *     possible object is
     *     {@link LaneChangeModelType }
     *     
     */
    public LaneChangeModelType getLaneChangeModelType() {
        return laneChangeModelType;
    }

    /**
     * Définit la valeur de la propriété laneChangeModelType.
     * 
     * @param value
     *     allowed object is
     *     {@link LaneChangeModelType }
     *     
     */
    public void setLaneChangeModelType(LaneChangeModelType value) {
        this.laneChangeModelType = value;
    }

    public boolean isSetLaneChangeModelType() {
        return (this.laneChangeModelType!= null);
    }

    
    public boolean getExternalControl() {
    	return this.externalControl;
    }
    
    /**
     * 
     * @return
     */
    
    public TrustModelType getTrustModelType() {
        return trustModelType;
    }

    
    public void setTrustModelType(TrustModelType value) {
        this.trustModelType = value;
    }

    public boolean isSetTrustModelType() {
        return (this.trustModelType!= null);
    }
    
    /**
     * 
     */
    
    
    /**
     * Obtient la valeur de la propriété memoryParameter.
     * 
     * @return
     *     possible object is
     *     {@link MemoryParameter }
     *     
     */
    public MemoryParameter getMemoryParameter() {
        return memoryParameter;
    }

    /**
     * Définit la valeur de la propriété memoryParameter.
     * 
     * @param value
     *     allowed object is
     *     {@link MemoryParameter }
     *     
     */
    public void setMemoryParameter(MemoryParameter value) {
        this.memoryParameter = value;
    }

    public boolean isSetMemoryParameter() {
        return (this.memoryParameter!= null);
    }

    /**
     * Obtient la valeur de la propriété noiseParameter.
     * 
     * @return
     *     possible object is
     *     {@link NoiseParameter }
     *     
     */
    public NoiseParameter getNoiseParameter() {
        return noiseParameter;
    }

    /**
     * Définit la valeur de la propriété noiseParameter.
     * 
     * @param value
     *     allowed object is
     *     {@link NoiseParameter }
     *     
     */
    public void setNoiseParameter(NoiseParameter value) {
        this.noiseParameter = value;
    }

    public boolean isSetNoiseParameter() {
        return (this.noiseParameter!= null);
    }

    /**
     * Obtient la valeur de la propriété label.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Définit la valeur de la propriété label.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    public boolean isSetLabel() {
        return (this.label!= null);
    }

    /**
     * Obtient la valeur de la propriété length.
     * 
     */
    public double getLength() {
        return length;
    }

    /**
     * Définit la valeur de la propriété length.
     * 
     */
    public void setLength(double value) {
        this.length = value;
    }

    public boolean isSetLength() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété width.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getWidth() {
        if (width == null) {
            return  4.4D;
        } else {
            return width;
        }
    }

    /**
     * Définit la valeur de la propriété width.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWidth(double value) {
        this.width = value;
    }

    public boolean isSetWidth() {
        return (this.width!= null);
    }

    public void unsetWidth() {
        this.width = null;
    }

    /**
     * Obtient la valeur de la propriété maximumDeceleration.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getMaximumDeceleration() {
        if (maximumDeceleration == null) {
            return  10000.0D;
        } else {
            return maximumDeceleration;
        }
    }

    /**
     * Définit la valeur de la propriété maximumDeceleration.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaximumDeceleration(double value) {
        this.maximumDeceleration = value;
    }

    public boolean isSetMaximumDeceleration() {
        return (this.maximumDeceleration!= null);
    }

    public void unsetMaximumDeceleration() {
        this.maximumDeceleration = null;
    }

    /**
     * Obtient la valeur de la propriété consumptionModelName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsumptionModelName() {
        if (consumptionModelName == null) {
            return "none";
        } else {
            return consumptionModelName;
        }
    }

    /**
     * Définit la valeur de la propriété consumptionModelName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsumptionModelName(String value) {
        this.consumptionModelName = value;
    }

    public boolean isSetConsumptionModelName() {
        return (this.consumptionModelName!= null);
    }
    
 
    public List<Sensor> getSensors() {
       return this.sensors!=null ? this.sensors.getSensors() : null;
    }

   
}
