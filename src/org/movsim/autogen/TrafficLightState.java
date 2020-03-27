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
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="status" type="{}TrafficLightStatus" />
 *       &lt;attribute name="condition" type="{}TrafficLightCondition" default="none" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "TrafficLightState")
public class TrafficLightState
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "status")
    protected TrafficLightStatus status;
    @XmlAttribute(name = "condition")
    protected TrafficLightCondition condition;

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Obtient la valeur de la propriété status.
     * 
     * @return
     *     possible object is
     *     {@link TrafficLightStatus }
     *     
     */
    public TrafficLightStatus getStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficLightStatus }
     *     
     */
    public void setStatus(TrafficLightStatus value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Obtient la valeur de la propriété condition.
     * 
     * @return
     *     possible object is
     *     {@link TrafficLightCondition }
     *     
     */
    public TrafficLightCondition getCondition() {
        if (condition == null) {
            return TrafficLightCondition.NONE;
        } else {
            return condition;
        }
    }

    /**
     * Définit la valeur de la propriété condition.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficLightCondition }
     *     
     */
    public void setCondition(TrafficLightCondition value) {
        this.condition = value;
    }

    public boolean isSetCondition() {
        return (this.condition!= null);
    }

}
