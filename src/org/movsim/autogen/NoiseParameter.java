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
 *       &lt;attribute name="tau" type="{}nonNegativeDouble" default="0" />
 *       &lt;attribute name="fluct_strength" use="required" type="{}nonNegativeDouble" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "NoiseParameter")
public class NoiseParameter
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "tau")
    protected Double tau;
    @XmlAttribute(name = "fluct_strength", required = true)
    protected double fluctStrength;

    /**
     * Obtient la valeur de la propriété tau.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getTau() {
        if (tau == null) {
            return  0.0D;
        } else {
            return tau;
        }
    }

    /**
     * Définit la valeur de la propriété tau.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTau(double value) {
        this.tau = value;
    }

    public boolean isSetTau() {
        return (this.tau!= null);
    }

    public void unsetTau() {
        this.tau = null;
    }

    /**
     * Obtient la valeur de la propriété fluctStrength.
     * 
     */
    public double getFluctStrength() {
        return fluctStrength;
    }

    /**
     * Définit la valeur de la propriété fluctStrength.
     * 
     */
    public void setFluctStrength(double value) {
        this.fluctStrength = value;
    }

    public boolean isSetFluctStrength() {
        return true;
    }

}
