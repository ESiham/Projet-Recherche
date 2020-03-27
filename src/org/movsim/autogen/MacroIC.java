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
 *       &lt;attribute name="density_per_km" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="speed" type="{}nonNegativeDouble" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "MacroIC")
public class MacroIC
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "position", required = true)
    protected double position;
    @XmlAttribute(name = "density_per_km", required = true)
    protected double densityPerKm;
    @XmlAttribute(name = "speed")
    protected Double speed;

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
     * Obtient la valeur de la propriété densityPerKm.
     * 
     */
    public double getDensityPerKm() {
        return densityPerKm;
    }

    /**
     * Définit la valeur de la propriété densityPerKm.
     * 
     */
    public void setDensityPerKm(double value) {
        this.densityPerKm = value;
    }

    public boolean isSetDensityPerKm() {
        return true;
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
        return speed;
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

}
