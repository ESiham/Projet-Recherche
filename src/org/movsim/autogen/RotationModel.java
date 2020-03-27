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
 *         &lt;element ref="{}GearRatio" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="idle_rotation_rate_invmin" type="{}nonNegativeDouble" default="1000" />
 *       &lt;attribute name="max_rotation_rate_invmin" type="{}nonNegativeDouble" default="6000" />
 *       &lt;attribute name="dynamic_tyre_radius" type="{}nonNegativeDouble" default="0.3113" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "gearRatio"
})
@XmlRootElement(name = "RotationModel")
public class RotationModel
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "GearRatio", required = true)
    protected List<GearRatio> gearRatio;
    @XmlAttribute(name = "idle_rotation_rate_invmin")
    protected Double idleRotationRateInvmin;
    @XmlAttribute(name = "max_rotation_rate_invmin")
    protected Double maxRotationRateInvmin;
    @XmlAttribute(name = "dynamic_tyre_radius")
    protected Double dynamicTyreRadius;

    /**
     * Gets the value of the gearRatio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gearRatio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGearRatio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GearRatio }
     * 
     * 
     */
    public List<GearRatio> getGearRatio() {
        if (gearRatio == null) {
            gearRatio = new ArrayList<GearRatio>();
        }
        return this.gearRatio;
    }

    public boolean isSetGearRatio() {
        return ((this.gearRatio!= null)&&(!this.gearRatio.isEmpty()));
    }

    public void unsetGearRatio() {
        this.gearRatio = null;
    }

    /**
     * Obtient la valeur de la propriété idleRotationRateInvmin.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getIdleRotationRateInvmin() {
        if (idleRotationRateInvmin == null) {
            return  1000.0D;
        } else {
            return idleRotationRateInvmin;
        }
    }

    /**
     * Définit la valeur de la propriété idleRotationRateInvmin.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIdleRotationRateInvmin(double value) {
        this.idleRotationRateInvmin = value;
    }

    public boolean isSetIdleRotationRateInvmin() {
        return (this.idleRotationRateInvmin!= null);
    }

    public void unsetIdleRotationRateInvmin() {
        this.idleRotationRateInvmin = null;
    }

    /**
     * Obtient la valeur de la propriété maxRotationRateInvmin.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getMaxRotationRateInvmin() {
        if (maxRotationRateInvmin == null) {
            return  6000.0D;
        } else {
            return maxRotationRateInvmin;
        }
    }

    /**
     * Définit la valeur de la propriété maxRotationRateInvmin.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxRotationRateInvmin(double value) {
        this.maxRotationRateInvmin = value;
    }

    public boolean isSetMaxRotationRateInvmin() {
        return (this.maxRotationRateInvmin!= null);
    }

    public void unsetMaxRotationRateInvmin() {
        this.maxRotationRateInvmin = null;
    }

    /**
     * Obtient la valeur de la propriété dynamicTyreRadius.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getDynamicTyreRadius() {
        if (dynamicTyreRadius == null) {
            return  0.3113D;
        } else {
            return dynamicTyreRadius;
        }
    }

    /**
     * Définit la valeur de la propriété dynamicTyreRadius.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDynamicTyreRadius(double value) {
        this.dynamicTyreRadius = value;
    }

    public boolean isSetDynamicTyreRadius() {
        return (this.dynamicTyreRadius!= null);
    }

    public void unsetDynamicTyreRadius() {
        this.dynamicTyreRadius = null;
    }

}
