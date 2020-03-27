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
 *       &lt;attribute name="position" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="speed" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="lane" type="{}nonNegativeInteger" default="1" />
 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "MicroIC")
public class MicroIC
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "position", required = true)
    protected double position;
    @XmlAttribute(name = "speed", required = true)
    protected double speed;
    @XmlAttribute(name = "lane")
    protected Integer lane;
    @XmlAttribute(name = "label")
    protected String label;

    /**
     * Obtient la valeur de la propriété position.
     * 
     */
    public double getPosition() {
        return position;
    }

    /**
     * Définit la valeur de la propriété position.
     * 
     */
    public void setPosition(double value) {
        this.position = value;
    }

    public boolean isSetPosition() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété speed.
     * 
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Définit la valeur de la propriété speed.
     * 
     */
    public void setSpeed(double value) {
        this.speed = value;
    }

    public boolean isSetSpeed() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété lane.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getLane() {
        if (lane == null) {
            return  1;
        } else {
            return lane;
        }
    }

    /**
     * Définit la valeur de la propriété lane.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLane(int value) {
        this.lane = value;
    }

    public boolean isSetLane() {
        return (this.lane!= null);
    }

    public void unsetLane() {
        this.lane = null;
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
        if (label == null) {
            return "";
        } else {
            return label;
        }
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

}
