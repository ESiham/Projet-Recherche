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
 *       &lt;attribute name="tau" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="alpha_T" use="required" type="{}positiveDouble" />
 *       &lt;attribute name="alpha_v0" use="required" type="{}positiveDouble" />
 *       &lt;attribute name="alpha_a" type="{}positiveDouble" default="1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "MemoryParameter")
public class MemoryParameter
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "tau", required = true)
    protected double tau;
    @XmlAttribute(name = "alpha_T", required = true)
    protected double alphaT;
    @XmlAttribute(name = "alpha_v0", required = true)
    protected double alphaV0;
    @XmlAttribute(name = "alpha_a")
    protected Double alphaA;

    /**
     * Obtient la valeur de la propriété tau.
     * 
     */
    public double getTau() {
        return tau;
    }

    /**
     * Définit la valeur de la propriété tau.
     * 
     */
    public void setTau(double value) {
        this.tau = value;
    }

    public boolean isSetTau() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété alphaT.
     * 
     */
    public double getAlphaT() {
        return alphaT;
    }

    /**
     * Définit la valeur de la propriété alphaT.
     * 
     */
    public void setAlphaT(double value) {
        this.alphaT = value;
    }

    public boolean isSetAlphaT() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété alphaV0.
     * 
     */
    public double getAlphaV0() {
        return alphaV0;
    }

    /**
     * Définit la valeur de la propriété alphaV0.
     * 
     */
    public void setAlphaV0(double value) {
        this.alphaV0 = value;
    }

    public boolean isSetAlphaV0() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété alphaA.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getAlphaA() {
        if (alphaA == null) {
            return  1.0D;
        } else {
            return alphaA;
        }
    }

    /**
     * Définit la valeur de la propriété alphaA.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAlphaA(double value) {
        this.alphaA = value;
    }

    public boolean isSetAlphaA() {
        return (this.alphaA!= null);
    }

    public void unsetAlphaA() {
        this.alphaA = null;
    }

}
