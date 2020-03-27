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
 *       &lt;attribute name="dt" type="{}nonNegativeDouble" default="1" />
 *       &lt;attribute name="start_time" type="{}nonNegativeDouble" />
 *       &lt;attribute name="end_time" type="{}nonNegativeDouble" />
 *       &lt;attribute name="route" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="types type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="offset_position" type="{}nonNegativeDouble" default="0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Trust")
public class Trusts
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "dt")
    protected Double dt;
    @XmlAttribute(name = "start_time")
    protected Double startTime;
    @XmlAttribute(name = "end_time")
    protected Double endTime;
    @XmlAttribute(name = "route", required = true)
    protected String route;
    @XmlAttribute(name = "random_fraction")
    protected String types;
    @XmlAttribute(name = "random_fraction")
    protected Double offsetPosition;

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
            return  1.0D;
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
     * Obtient la valeur de la propriété startTime.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getStartTime() {
        return startTime;
    }

    /**
     * Définit la valeur de la propriété startTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setStartTime(double value) {
        this.startTime = value;
    }

    public boolean isSetStartTime() {
        return (this.startTime!= null);
    }

    public void unsetStartTime() {
        this.startTime = null;
    }

    /**
     * Obtient la valeur de la propriété endTime.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getEndTime() {
        return endTime;
    }

    /**
     * Définit la valeur de la propriété endTime.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setEndTime(double value) {
        this.endTime = value;
    }

    public boolean isSetEndTime() {
        return (this.endTime!= null);
    }

    public void unsetEndTime() {
        this.endTime = null;
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
    
    
    /**
     * Obtient la valeur de la propriété route.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypes() {
        return types;
    }

    /**
     * Définit la valeur de la propriété route.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypes(String value) {
        this.types = value;
    }

    public boolean isSetTypes() {
        return (this.types!= null);
    }

    /**
     * Obtient la valeur de la propriété offsetPosition.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getOffsetPosition() {
        if (offsetPosition == null) {
            return  0.0D;
        } else {
            return offsetPosition;
        }
    }

    /**
     * Définit la valeur de la propriété offsetPosition.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOffsetPosition(double value) {
        this.offsetPosition = value;
    }

    public boolean isSetOffsetPosition() {
        return (this.offsetPosition!= null);
    }

    public void unsetOffsetPosition() {
        this.offsetPosition = null;
    }

}
