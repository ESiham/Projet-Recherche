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
 *       &lt;attribute name="dt" type="{}nonNegativeDouble" default="60" />
 *       &lt;attribute name="dx" type="{}nonNegativeDouble" default="100" />
 *       &lt;attribute name="route" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "SpatioTemporalConfiguration")
public class SpatioTemporalConfiguration
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "dt")
    protected Double dt;
    @XmlAttribute(name = "dx")
    protected Double dx;
    @XmlAttribute(name = "route", required = true)
    protected String route;

    /**
     * Obtient la valeur de la propriété dt.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getDt() {
        if (dt == null) {
            return  60.0D;
        } else {
            return dt;
        }
    }

    /**
     * Définit la valeur de la propriété dt.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDt(double value) {
        this.dt = value;
    }

    public boolean isSetDt() {
        return (this.dt!= null);
    }

    public void unsetDt() {
        this.dt = null;
    }

    /**
     * Obtient la valeur de la propriété dx.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getDx() {
        if (dx == null) {
            return  100.0D;
        } else {
            return dx;
        }
    }

    /**
     * Définit la valeur de la propriété dx.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDx(double value) {
        this.dx = value;
    }

    public boolean isSetDx() {
        return (this.dx!= null);
    }

    public void unsetDx() {
        this.dx = null;
    }

    /**
     * Obtient la valeur de la propriété route.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoute() {
        return route;
    }

    /**
     * Définit la valeur de la propriété route.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoute(String value) {
        this.route = value;
    }

    public boolean isSetRoute() {
        return (this.route!= null);
    }

}
