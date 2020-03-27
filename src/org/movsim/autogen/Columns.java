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
 *       &lt;attribute name="time" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="speed" type="{http://www.w3.org/2001/XMLSchema}int" default="-1" />
 *       &lt;attribute name="acceleration" type="{http://www.w3.org/2001/XMLSchema}int" default="-1" />
 *       &lt;attribute name="gradient" type="{http://www.w3.org/2001/XMLSchema}int" default="-1" />
 *       &lt;attribute name="position" type="{http://www.w3.org/2001/XMLSchema}int" default="-1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Columns")
public class Columns
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "time", required = true)
    protected int time;
    @XmlAttribute(name = "speed")
    protected Integer speed;
    @XmlAttribute(name = "acceleration")
    protected Integer acceleration;
    @XmlAttribute(name = "gradient")
    protected Integer gradient;
    @XmlAttribute(name = "position")
    protected Integer position;

    /**
     * Obtient la valeur de la propriété time.
     * 
     */
    public int getTime() {
        return time;
    }

    /**
     * Définit la valeur de la propriété time.
     * 
     */
    public void setTime(int value) {
        this.time = value;
    }

    public boolean isSetTime() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété speed.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getSpeed() {
        if (speed == null) {
            return -1;
        } else {
            return speed;
        }
    }

    /**
     * Définit la valeur de la propriété speed.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSpeed(int value) {
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
     *     {@link Integer }
     *     
     */
    public int getAcceleration() {
        if (acceleration == null) {
            return -1;
        } else {
            return acceleration;
        }
    }

    /**
     * Définit la valeur de la propriété acceleration.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAcceleration(int value) {
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
     *     {@link Integer }
     *     
     */
    public int getGradient() {
        if (gradient == null) {
            return -1;
        } else {
            return gradient;
        }
    }

    /**
     * Définit la valeur de la propriété gradient.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGradient(int value) {
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
     *     {@link Integer }
     *     
     */
    public int getPosition() {
        if (position == null) {
            return -1;
        } else {
            return position;
        }
    }

    /**
     * Définit la valeur de la propriété position.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPosition(int value) {
        this.position = value;
    }

    public boolean isSetPosition() {
        return (this.position!= null);
    }

    public void unsetPosition() {
        this.position = null;
    }

}
