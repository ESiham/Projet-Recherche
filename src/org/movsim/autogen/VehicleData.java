//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.12.13 à 09:11:31 AM CET 
//


package org.movsim.autogen;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="mass" type="{}nonNegativeDouble" default="1500" />
 *       &lt;attribute name="cross_section_surface" type="{}nonNegativeDouble" default="2.2" />
 *       &lt;attribute name="cd_value" type="{}nonNegativeDouble" default="0.32" />
 *       &lt;attribute name="electric_power" type="{}nonNegativeDouble" default="2000" />
 *       &lt;attribute name="const_friction" type="{}nonNegativeDouble" default="0.0145" />
 *       &lt;attribute name="v_friction" type="{}nonNegativeDouble" default="0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "VehicleData")
public class VehicleData
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "mass")
    protected Double mass;
    @XmlAttribute(name = "cross_section_surface")
    protected Double crossSectionSurface;
    @XmlAttribute(name = "cd_value")
    protected Double cdValue;
    @XmlAttribute(name = "electric_power")
    protected Double electricPower;
    @XmlAttribute(name = "const_friction")
    protected Double constFriction;
    @XmlAttribute(name = "v_friction")
    protected Double vFriction;

    /**
     * Obtient la valeur de la propriété mass.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getMass() {
        if (mass == null) {
            return  1500.0D;
        } else {
            return mass;
        }
    }

    /**
     * Définit la valeur de la propriété mass.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMass(double value) {
        this.mass = value;
    }

    public boolean isSetMass() {
        return (this.mass!= null);
    }

    public void unsetMass() {
        this.mass = null;
    }

    /**
     * Obtient la valeur de la propriété crossSectionSurface.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getCrossSectionSurface() {
        if (crossSectionSurface == null) {
            return  2.2D;
        } else {
            return crossSectionSurface;
        }
    }

    /**
     * Définit la valeur de la propriété crossSectionSurface.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCrossSectionSurface(double value) {
        this.crossSectionSurface = value;
    }

    public boolean isSetCrossSectionSurface() {
        return (this.crossSectionSurface!= null);
    }

    public void unsetCrossSectionSurface() {
        this.crossSectionSurface = null;
    }

    /**
     * Obtient la valeur de la propriété cdValue.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getCdValue() {
        if (cdValue == null) {
            return  0.32D;
        } else {
            return cdValue;
        }
    }

    /**
     * Définit la valeur de la propriété cdValue.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCdValue(double value) {
        this.cdValue = value;
    }

    public boolean isSetCdValue() {
        return (this.cdValue!= null);
    }

    public void unsetCdValue() {
        this.cdValue = null;
    }

    /**
     * Obtient la valeur de la propriété electricPower.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getElectricPower() {
        if (electricPower == null) {
            return  2000.0D;
        } else {
            return electricPower;
        }
    }

    /**
     * Définit la valeur de la propriété electricPower.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setElectricPower(double value) {
        this.electricPower = value;
    }

    public boolean isSetElectricPower() {
        return (this.electricPower!= null);
    }

    public void unsetElectricPower() {
        this.electricPower = null;
    }

    /**
     * Obtient la valeur de la propriété constFriction.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getConstFriction() {
        if (constFriction == null) {
            return  0.0145D;
        } else {
            return constFriction;
        }
    }

    /**
     * Définit la valeur de la propriété constFriction.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setConstFriction(double value) {
        this.constFriction = value;
    }

    public boolean isSetConstFriction() {
        return (this.constFriction!= null);
    }

    public void unsetConstFriction() {
        this.constFriction = null;
    }

    /**
     * Obtient la valeur de la propriété vFriction.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getVFriction() {
        if (vFriction == null) {
            return  0.0D;
        } else {
            return vFriction;
        }
    }

    /**
     * Définit la valeur de la propriété vFriction.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVFriction(double value) {
        this.vFriction = value;
    }

    public boolean isSetVFriction() {
        return (this.vFriction!= null);
    }

    public void unsetVFriction() {
        this.vFriction = null;
    }

}
