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
 *       &lt;attribute name="label" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fraction" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="relative_v0_randomization" type="{}nonNegativeDouble" default="1.0" />
 *       &lt;attribute name="relative_s0_randomization" type="{}nonNegativeDouble" default="1.0" />
 *       &lt;attribute name="v0_distribution_type" type="{}DistributionTypeEnum" default="uniform" />
 *       &lt;attribute name="route_label" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "VehicleType")
public class VehicleType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "label", required = true)
    protected String label;
    @XmlAttribute(name = "fraction", required = true)
    protected double fraction;
    @XmlAttribute(name = "relative_v0_randomization")
    protected Double relativeV0Randomization;
    @XmlAttribute(name = "relative_s0_randomization")
    protected Double relativeS0Randomization;
    @XmlAttribute(name = "v0_distribution_type")
    protected DistributionTypeEnum v0DistributionType;
    @XmlAttribute(name = "route_label")
    protected String routeLabel;

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
     * Obtient la valeur de la propriété fraction.
     * 
     */
    public double getFraction() {
        return fraction;
    }

    /**
     * Définit la valeur de la propriété fraction.
     * 
     */
    public void setFraction(double value) {
        this.fraction = value;
    }

    public boolean isSetFraction() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété relativeV0Randomization.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getRelativeV0Randomization() {
        if (relativeV0Randomization == null) {
            return  0.0D;
        } else {
            return relativeV0Randomization;
        }
    }
    
    /**
     * Obtient la valeur de la propriété relativeS0Randomization.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     *    @author gueriau
     */
    public double getRelativeS0Randomization() {
        if (relativeS0Randomization == null) {
            return  0.0D;
        } else {
            return relativeS0Randomization;
        }
    }


    /**
     * Définit la valeur de la propriété relativeV0Randomization.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRelativeV0Randomization(double value) {
        this.relativeV0Randomization = value;
    }

    public boolean isSetRelativeV0Randomization() {
        return (this.relativeV0Randomization!= null);
    }

    public void unsetRelativeV0Randomization() {
        this.relativeV0Randomization = null;
    }

    /**
     * Obtient la valeur de la propriété v0DistributionType.
     * 
     * @return
     *     possible object is
     *     {@link DistributionTypeEnum }
     *     
     */
    public DistributionTypeEnum getV0DistributionType() {
        if (v0DistributionType == null) {
            return DistributionTypeEnum.UNIFORM;
        } else {
            return v0DistributionType;
        }
    }

    /**
     * Définit la valeur de la propriété v0DistributionType.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributionTypeEnum }
     *     
     */
    public void setV0DistributionType(DistributionTypeEnum value) {
        this.v0DistributionType = value;
    }

    public boolean isSetV0DistributionType() {
        return (this.v0DistributionType!= null);
    }

    /**
     * Obtient la valeur de la propriété routeLabel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteLabel() {
        if (routeLabel == null) {
            return "";
        } else {
            return routeLabel;
        }
    }

    /**
     * Définit la valeur de la propriété routeLabel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteLabel(String value) {
        this.routeLabel = value;
    }

    public boolean isSetRouteLabel() {
        return (this.routeLabel!= null);
    }

}
