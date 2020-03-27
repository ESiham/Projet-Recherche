//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.12.13 à 09:11:31 AM CET 
//


package org.movsim.autogen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
 *       &lt;choice>
 *         &lt;element ref="{}Inflow" maxOccurs="unbounded"/>
 *         &lt;element ref="{}InflowFromFile"/>
 *       &lt;/choice>
 *       &lt;attribute name="logging" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "inflow",
    "inflowFromFile"
})
@XmlRootElement(name = "TrafficSource")
public class TrafficSource
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Inflow")
    protected List<Inflow> inflow;
    @XmlElement(name = "InflowFromFile")
    protected InflowFromFile inflowFromFile;
    @XmlAttribute(name = "logging")
    protected Boolean logging;

    /**
     * Gets the value of the inflow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inflow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInflow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Inflow }
     * 
     * 
     */
    public List<Inflow> getInflow() {
        if (inflow == null) {
            inflow = new ArrayList<Inflow>();
        }
        return this.inflow;
    }

    public boolean isSetInflow() {
        return ((this.inflow!= null)&&(!this.inflow.isEmpty()));
    }

    public void unsetInflow() {
        this.inflow = null;
    }

    /**
     * Obtient la valeur de la propriété inflowFromFile.
     * 
     * @return
     *     possible object is
     *     {@link InflowFromFile }
     *     
     */
    public InflowFromFile getInflowFromFile() {
        return inflowFromFile;
    }

    /**
     * Définit la valeur de la propriété inflowFromFile.
     * 
     * @param value
     *     allowed object is
     *     {@link InflowFromFile }
     *     
     */
    public void setInflowFromFile(InflowFromFile value) {
        this.inflowFromFile = value;
    }

    public boolean isSetInflowFromFile() {
        return (this.inflowFromFile!= null);
    }

    /**
     * Obtient la valeur de la propriété logging.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isLogging() {
        if (logging == null) {
            return false;
        } else {
            return logging;
        }
    }

    /**
     * Définit la valeur de la propriété logging.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLogging(boolean value) {
        this.logging = value;
    }

    public boolean isSetLogging() {
        return (this.logging!= null);
    }

    public void unsetLogging() {
        this.logging = null;
    }

}
