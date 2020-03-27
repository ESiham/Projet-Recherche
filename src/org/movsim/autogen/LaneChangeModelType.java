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
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence>
 *         &lt;element ref="{}ModelParameterMOBIL" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="european_rules" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="crit_speed_eur" type="{}nonNegativeDouble" default="25" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "modelParameterMOBIL"
})
@XmlRootElement(name = "LaneChangeModelType")
public class LaneChangeModelType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ModelParameterMOBIL")
    protected ModelParameterMOBIL modelParameterMOBIL;
    @XmlAttribute(name = "european_rules")
    protected Boolean europeanRules;
    @XmlAttribute(name = "crit_speed_eur")
    protected Double critSpeedEur;

    /**
     * Obtient la valeur de la propriété modelParameterMOBIL.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterMOBIL }
     *     
     */
    public ModelParameterMOBIL getModelParameterMOBIL() {
        return modelParameterMOBIL;
    }

    /**
     * Définit la valeur de la propriété modelParameterMOBIL.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterMOBIL }
     *     
     */
    public void setModelParameterMOBIL(ModelParameterMOBIL value) {
        this.modelParameterMOBIL = value;
    }

    public boolean isSetModelParameterMOBIL() {
        return (this.modelParameterMOBIL!= null);
    }

    /**
     * Obtient la valeur de la propriété europeanRules.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isEuropeanRules() {
        if (europeanRules == null) {
            return false;
        } else {
            return europeanRules;
        }
    }

    /**
     * Définit la valeur de la propriété europeanRules.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEuropeanRules(boolean value) {
        this.europeanRules = value;
    }

    public boolean isSetEuropeanRules() {
        return (this.europeanRules!= null);
    }

    public void unsetEuropeanRules() {
        this.europeanRules = null;
    }

    /**
     * Obtient la valeur de la propriété critSpeedEur.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getCritSpeedEur() {
        if (critSpeedEur == null) {
            return  25.0D;
        } else {
            return critSpeedEur;
        }
    }

    /**
     * Définit la valeur de la propriété critSpeedEur.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCritSpeedEur(double value) {
        this.critSpeedEur = value;
    }

    public boolean isSetCritSpeedEur() {
        return (this.critSpeedEur!= null);
    }

    public void unsetCritSpeedEur() {
        this.critSpeedEur = null;
    }

}
