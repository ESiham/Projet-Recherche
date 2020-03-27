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
 *       &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *       &lt;attribute name="speed" type="{}positiveDouble" default="1" />
 *       &lt;attribute name="acceleration" type="{}positiveDouble" default="1" />
 *       &lt;attribute name="gradient" type="{}positiveDouble" default="1" />
 *       &lt;attribute name="position" type="{}positiveDouble" default="1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Conversions")
public class Conversions
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "time")
    protected String time;
    @XmlAttribute(name = "speed")
    protected Double speed;
    @XmlAttribute(name = "acceleration")
    protected Double acceleration;
    @XmlAttribute(name = "gradient")
    protected Double gradient;
    @XmlAttribute(name = "position")
    protected Double position;

    /**
     * Obtient la valeur de la propriété time.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        if (time == null) {
            return "";
        } else {
            return time;
        }
    }

    /**
     * Définit la valeur de la propriété time.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    public boolean isSetTime() {
        return (this.time!= null);
    }

    /**
     * Obtient la valeur de la propriété speed.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getSpeed() {
        if (speed == null) {
            return  1.0D;
        } else {
            return speed;
        }
    }

    /**
     * Définit la valeur de la propriété speed.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSpeed(double value) {
        this.speed = value;
    }

    public boolean isSetSpeed() {
        return (this.speed!= null);
    }

    public void unsetSpeed() {
        this.speed = null;
    }

    /**
     * Obtient la valeur de la propriété acceleration.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getAcceleration() {
        if (acceleration == null) {
            return  1.0D;
        } else {
            return acceleration;
        }
    }

    /**
     * Définit la valeur de la propriété acceleration.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAcceleration(double value) {
        this.acceleration = value;
    }

    public boolean isSetAcceleration() {
        return (this.acceleration!= null);
    }

    public void unsetAcceleration() {
        this.acceleration = null;
    }

    /**
     * Obtient la valeur de la propriété gradient.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getGradient() {
        if (gradient == null) {
            return  1.0D;
        } else {
            return gradient;
        }
    }

    /**
     * Définit la valeur de la propriété gradient.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGradient(double value) {
        this.gradient = value;
    }

    public boolean isSetGradient() {
        return (this.gradient!= null);
    }

    public void unsetGradient() {
        this.gradient = null;
    }

    /**
     * Obtient la valeur de la propriété position.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getPosition() {
        if (position == null) {
            return  1.0D;
        } else {
            return position;
        }
    }

    /**
     * Définit la valeur de la propriété position.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPosition(double value) {
        this.position = value;
    }

    public boolean isSetPosition() {
        return (this.position!= null);
    }

    public void unsetPosition() {
        this.position = null;
    }

}
