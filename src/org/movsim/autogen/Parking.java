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
 *       &lt;attribute name="source_road_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="time_delay" type="{}positiveDouble" default="60" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Parking")
public class Parking
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "source_road_id", required = true)
    protected String sourceRoadId;
    @XmlAttribute(name = "time_delay")
    protected Double timeDelay;

    /**
     * Obtient la valeur de la propriété sourceRoadId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceRoadId() {
        return sourceRoadId;
    }

    /**
     * Définit la valeur de la propriété sourceRoadId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceRoadId(String value) {
        this.sourceRoadId = value;
    }

    public boolean isSetSourceRoadId() {
        return (this.sourceRoadId!= null);
    }

    /**
     * Obtient la valeur de la propriété timeDelay.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getTimeDelay() {
        if (timeDelay == null) {
            return  60.0D;
        } else {
            return timeDelay;
        }
    }

    /**
     * Définit la valeur de la propriété timeDelay.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTimeDelay(double value) {
        this.timeDelay = value;
    }

    public boolean isSetTimeDelay() {
        return (this.timeDelay!= null);
    }

    public void unsetTimeDelay() {
        this.timeDelay = null;
    }

}
