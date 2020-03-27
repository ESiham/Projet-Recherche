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
 *       &lt;attribute name="t" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="q_per_hour" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="v" type="{}nonNegativeDouble" default="0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Inflow")
public class Inflow
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "t", required = true)
    protected double t;
    @XmlAttribute(name = "q_per_hour", required = true)
    protected double qPerHour;
    @XmlAttribute(name = "v")
    protected Double v;

    /**
     * Obtient la valeur de la propriété t.
     * 
     */
    public double getT() {
        return t;
    }

    /**
     * Définit la valeur de la propriété t.
     * 
     */
    public void setT(double value) {
        this.t = value;
    }

    public boolean isSetT() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété qPerHour.
     * 
     */
    public double getQPerHour() {
        return qPerHour;
    }

    /**
     * Définit la valeur de la propriété qPerHour.
     * 
     */
    public void setQPerHour(double value) {
        this.qPerHour = value;
    }

    public boolean isSetQPerHour() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété v.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getV() {
        if (v == null) {
            return  0.0D;
        } else {
            return v;
        }
    }

    /**
     * Définit la valeur de la propriété v.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setV(double value) {
        this.v = value;
    }

    public boolean isSetV() {
        return (this.v!= null);
    }

    public void unsetV() {
        this.v = null;
    }

}
