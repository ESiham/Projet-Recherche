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
 *       &lt;attribute name="safe_deceleration" type="{}nonNegativeDouble" default="4.0" />
 *       &lt;attribute name="minimum_gap" type="{}nonNegativeDouble" default="2.0" />
 *       &lt;attribute name="threshold_acceleration" type="{http://www.w3.org/2001/XMLSchema}double" default="0.2" />
 *       &lt;attribute name="right_bias_acceleration" type="{http://www.w3.org/2001/XMLSchema}double" default="0.25" />
 *       &lt;attribute name="politeness" type="{http://www.w3.org/2001/XMLSchema}double" default="0.1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ModelParameterMOBIL")
public class ModelParameterMOBIL
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "safe_deceleration")
    protected Double safeDeceleration;
    @XmlAttribute(name = "minimum_gap")
    protected Double minimumGap;
    @XmlAttribute(name = "threshold_acceleration")
    protected Double thresholdAcceleration;
    @XmlAttribute(name = "right_bias_acceleration")
    protected Double rightBiasAcceleration;
    @XmlAttribute(name = "politeness")
    protected Double politeness;

    /**
     * Obtient la valeur de la propriété safeDeceleration.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getSafeDeceleration() {
        if (safeDeceleration == null) {
            return  4.0D;
        } else {
            return safeDeceleration;
        }
    }

    /**
     * Définit la valeur de la propriété safeDeceleration.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSafeDeceleration(double value) {
        this.safeDeceleration = value;
    }

    public boolean isSetSafeDeceleration() {
        return (this.safeDeceleration!= null);
    }

    public void unsetSafeDeceleration() {
        this.safeDeceleration = null;
    }

    /**
     * Obtient la valeur de la propriété minimumGap.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getMinimumGap() {
        if (minimumGap == null) {
            return  2.0D;
        } else {
            return minimumGap;
        }
    }

    /**
     * Définit la valeur de la propriété minimumGap.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMinimumGap(double value) {
        this.minimumGap = value;
    }

    public boolean isSetMinimumGap() {
        return (this.minimumGap!= null);
    }

    public void unsetMinimumGap() {
        this.minimumGap = null;
    }

    /**
     * Obtient la valeur de la propriété thresholdAcceleration.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getThresholdAcceleration() {
        if (thresholdAcceleration == null) {
            return  0.2D;
        } else {
            return thresholdAcceleration;
        }
    }

    /**
     * Définit la valeur de la propriété thresholdAcceleration.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setThresholdAcceleration(double value) {
        this.thresholdAcceleration = value;
    }

    public boolean isSetThresholdAcceleration() {
        return (this.thresholdAcceleration!= null);
    }

    public void unsetThresholdAcceleration() {
        this.thresholdAcceleration = null;
    }

    /**
     * Obtient la valeur de la propriété rightBiasAcceleration.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getRightBiasAcceleration() {
        if (rightBiasAcceleration == null) {
            return  0.25D;
        } else {
            return rightBiasAcceleration;
        }
    }

    /**
     * Définit la valeur de la propriété rightBiasAcceleration.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRightBiasAcceleration(double value) {
        this.rightBiasAcceleration = value;
    }

    public boolean isSetRightBiasAcceleration() {
        return (this.rightBiasAcceleration!= null);
    }

    public void unsetRightBiasAcceleration() {
        this.rightBiasAcceleration = null;
    }

    /**
     * Obtient la valeur de la propriété politeness.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getPoliteness() {
        if (politeness == null) {
            return  0.1D;
        } else {
            return politeness;
        }
    }

    /**
     * Définit la valeur de la propriété politeness.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPoliteness(double value) {
        this.politeness = value;
    }

    public boolean isSetPoliteness() {
        return (this.politeness!= null);
    }

    public void unsetPoliteness() {
        this.politeness = null;
    }

}
