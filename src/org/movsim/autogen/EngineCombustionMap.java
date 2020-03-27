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
 *       &lt;attribute name="max_power_kW" type="{}nonNegativeDouble" default="90" />
 *       &lt;attribute name="cylinder_vol_l" type="{}nonNegativeDouble" default="1.4" />
 *       &lt;attribute name="idle_cons_rate_linvh" type="{}nonNegativeDouble" default="0.6" />
 *       &lt;attribute name="cspec_min_g_per_kwh" type="{}nonNegativeDouble" default="212" />
 *       &lt;attribute name="pe_min_bar" type="{}nonNegativeDouble" default="1" />
 *       &lt;attribute name="pe_max_bar" type="{}nonNegativeDouble" default="19" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "EngineCombustionMap")
public class EngineCombustionMap
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "max_power_kW")
    protected Double maxPowerKW;
    @XmlAttribute(name = "cylinder_vol_l")
    protected Double cylinderVolL;
    @XmlAttribute(name = "idle_cons_rate_linvh")
    protected Double idleConsRateLinvh;
    @XmlAttribute(name = "cspec_min_g_per_kwh")
    protected Double cspecMinGPerKwh;
    @XmlAttribute(name = "pe_min_bar")
    protected Double peMinBar;
    @XmlAttribute(name = "pe_max_bar")
    protected Double peMaxBar;

    /**
     * Obtient la valeur de la propriété maxPowerKW.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getMaxPowerKW() {
        if (maxPowerKW == null) {
            return  90.0D;
        } else {
            return maxPowerKW;
        }
    }

    /**
     * Définit la valeur de la propriété maxPowerKW.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxPowerKW(double value) {
        this.maxPowerKW = value;
    }

    public boolean isSetMaxPowerKW() {
        return (this.maxPowerKW!= null);
    }

    public void unsetMaxPowerKW() {
        this.maxPowerKW = null;
    }

    /**
     * Obtient la valeur de la propriété cylinderVolL.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getCylinderVolL() {
        if (cylinderVolL == null) {
            return  1.4D;
        } else {
            return cylinderVolL;
        }
    }

    /**
     * Définit la valeur de la propriété cylinderVolL.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCylinderVolL(double value) {
        this.cylinderVolL = value;
    }

    public boolean isSetCylinderVolL() {
        return (this.cylinderVolL!= null);
    }

    public void unsetCylinderVolL() {
        this.cylinderVolL = null;
    }

    /**
     * Obtient la valeur de la propriété idleConsRateLinvh.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getIdleConsRateLinvh() {
        if (idleConsRateLinvh == null) {
            return  0.6D;
        } else {
            return idleConsRateLinvh;
        }
    }

    /**
     * Définit la valeur de la propriété idleConsRateLinvh.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIdleConsRateLinvh(double value) {
        this.idleConsRateLinvh = value;
    }

    public boolean isSetIdleConsRateLinvh() {
        return (this.idleConsRateLinvh!= null);
    }

    public void unsetIdleConsRateLinvh() {
        this.idleConsRateLinvh = null;
    }

    /**
     * Obtient la valeur de la propriété cspecMinGPerKwh.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getCspecMinGPerKwh() {
        if (cspecMinGPerKwh == null) {
            return  212.0D;
        } else {
            return cspecMinGPerKwh;
        }
    }

    /**
     * Définit la valeur de la propriété cspecMinGPerKwh.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCspecMinGPerKwh(double value) {
        this.cspecMinGPerKwh = value;
    }

    public boolean isSetCspecMinGPerKwh() {
        return (this.cspecMinGPerKwh!= null);
    }

    public void unsetCspecMinGPerKwh() {
        this.cspecMinGPerKwh = null;
    }

    /**
     * Obtient la valeur de la propriété peMinBar.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getPeMinBar() {
        if (peMinBar == null) {
            return  1.0D;
        } else {
            return peMinBar;
        }
    }

    /**
     * Définit la valeur de la propriété peMinBar.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPeMinBar(double value) {
        this.peMinBar = value;
    }

    public boolean isSetPeMinBar() {
        return (this.peMinBar!= null);
    }

    public void unsetPeMinBar() {
        this.peMinBar = null;
    }

    /**
     * Obtient la valeur de la propriété peMaxBar.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getPeMaxBar() {
        if (peMaxBar == null) {
            return  19.0D;
        } else {
            return peMaxBar;
        }
    }

    /**
     * Définit la valeur de la propriété peMaxBar.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPeMaxBar(double value) {
        this.peMaxBar = value;
    }

    public boolean isSetPeMaxBar() {
        return (this.peMaxBar!= null);
    }

    public void unsetPeMaxBar() {
        this.peMaxBar = null;
    }

}
