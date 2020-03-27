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
 *         &lt;element ref="{}Columns"/>
 *         &lt;element ref="{}Conversions" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="inputfile" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="outputfile" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="model" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "columns",
    "conversions"
})
@XmlRootElement(name = "BatchData")
public class BatchData
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Columns", required = true)
    protected Columns columns;
    @XmlElement(name = "Conversions")
    protected Conversions conversions;
    @XmlAttribute(name = "inputfile", required = true)
    protected String inputfile;
    @XmlAttribute(name = "outputfile", required = true)
    protected String outputfile;
    @XmlAttribute(name = "model", required = true)
    protected String model;

    /**
     * Obtient la valeur de la propriété columns.
     * 
     * @return
     *     possible object is
     *     {@link Columns }
     *     
     */
    public Columns getColumns() {
        return columns;
    }

    /**
     * Définit la valeur de la propriété columns.
     * 
     * @param value
     *     allowed object is
     *     {@link Columns }
     *     
     */
    public void setColumns(Columns value) {
        this.columns = value;
    }

    public boolean isSetColumns() {
        return (this.columns!= null);
    }

    /**
     * Obtient la valeur de la propriété conversions.
     * 
     * @return
     *     possible object is
     *     {@link Conversions }
     *     
     */
    public Conversions getConversions() {
        return conversions;
    }

    /**
     * Définit la valeur de la propriété conversions.
     * 
     * @param value
     *     allowed object is
     *     {@link Conversions }
     *     
     */
    public void setConversions(Conversions value) {
        this.conversions = value;
    }

    public boolean isSetConversions() {
        return (this.conversions!= null);
    }

    /**
     * Obtient la valeur de la propriété inputfile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputfile() {
        return inputfile;
    }

    /**
     * Définit la valeur de la propriété inputfile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputfile(String value) {
        this.inputfile = value;
    }

    public boolean isSetInputfile() {
        return (this.inputfile!= null);
    }

    /**
     * Obtient la valeur de la propriété outputfile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputfile() {
        return outputfile;
    }

    /**
     * Définit la valeur de la propriété outputfile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputfile(String value) {
        this.outputfile = value;
    }

    public boolean isSetOutputfile() {
        return (this.outputfile!= null);
    }

    /**
     * Obtient la valeur de la propriété model.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Définit la valeur de la propriété model.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    public boolean isSetModel() {
        return (this.model!= null);
    }

}
