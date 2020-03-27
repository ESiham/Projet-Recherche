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
 *         &lt;element ref="{}BatchJobs" minOccurs="0"/>
 *         &lt;element ref="{}ConsumptionModels"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "batchJobs",
    "consumptionModels"
})
@XmlRootElement(name = "Consumption")
public class Consumption
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "BatchJobs")
    protected BatchJobs batchJobs;
    @XmlElement(name = "ConsumptionModels", required = true)
    protected ConsumptionModels consumptionModels;

    /**
     * Obtient la valeur de la propriété batchJobs.
     * 
     * @return
     *     possible object is
     *     {@link BatchJobs }
     *     
     */
    public BatchJobs getBatchJobs() {
        return batchJobs;
    }

    /**
     * Définit la valeur de la propriété batchJobs.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchJobs }
     *     
     */
    public void setBatchJobs(BatchJobs value) {
        this.batchJobs = value;
    }

    public boolean isSetBatchJobs() {
        return (this.batchJobs!= null);
    }

    /**
     * Obtient la valeur de la propriété consumptionModels.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionModels }
     *     
     */
    public ConsumptionModels getConsumptionModels() {
        return consumptionModels;
    }

    /**
     * Définit la valeur de la propriété consumptionModels.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionModels }
     *     
     */
    public void setConsumptionModels(ConsumptionModels value) {
        this.consumptionModels = value;
    }

    public boolean isSetConsumptionModels() {
        return (this.consumptionModels!= null);
    }

}
