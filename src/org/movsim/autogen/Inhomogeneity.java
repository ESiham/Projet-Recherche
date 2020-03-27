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
 *       &lt;attribute name="alpha_T" type="{}nonNegativeDouble" default="1" />
 *       &lt;attribute name="alpha_v0" type="{}nonNegativeDouble" default="1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Inhomogeneity")
public class Inhomogeneity
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "position", required = true)
    protected double position;
    @XmlAttribute(name = "alpha_T")
    protected Double alphaT;
    @XmlAttribute(name = "alpha_v0")
    protected Double alphaV0;

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
     * Obtient la valeur de la propriété alphaT.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getAlphaT() {
        if (alphaT == null) {
            return  1.0D;
        } else {
            return alphaT;
        }
    }

    /**
     * Définit la valeur de la propriété alphaT.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAlphaT(double value) {
        this.alphaT = value;
    }

    public boolean isSetAlphaT() {
        return (this.alphaT!= null);
    }

    public void unsetAlphaT() {
        this.alphaT = null;
    }

    /**
     * Obtient la valeur de la propriété alphaV0.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getAlphaV0() {
        if (alphaV0 == null) {
            return  1.0D;
        } else {
            return alphaV0;
        }
    }

    /**
     * Définit la valeur de la propriété alphaV0.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAlphaV0(double value) {
        this.alphaV0 = value;
    }

    public boolean isSetAlphaV0() {
        return (this.alphaV0 != null);
    }

    public void unsetAlphaV0() {
        this.alphaV0 = null;
    }

}
