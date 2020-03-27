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
 *         &lt;element ref="{}Consumption" minOccurs="0"/>
 *         &lt;element ref="{}VehiclePrototypes" minOccurs="0"/>
 *         &lt;element ref="{}Scenario" minOccurs="0"/>
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
    "consumption",
    "vehiclePrototypes",
    "scenario"
})
@XmlRootElement(name = "Movsim")
public class Movsim
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Consumption")
    protected Consumption consumption;
    @XmlElement(name = "VehiclePrototypes")
    protected VehiclePrototypes vehiclePrototypes;
    @XmlElement(name = "Scenario")
    protected Scenario scenario;

    /**
     * Obtient la valeur de la propriété consumption.
     * 
     * @return
     *     possible object is
     *     {@link Consumption }
     *     
     */
    public Consumption getConsumption() {
        return consumption;
    }

    /**
     * Définit la valeur de la propriété consumption.
     * 
     * @param value
     *     allowed object is
     *     {@link Consumption }
     *     
     */
    public void setConsumption(Consumption value) {
        this.consumption = value;
    }

    public boolean isSetConsumption() {
        return (this.consumption!= null);
    }

    /**
     * Obtient la valeur de la propriété vehiclePrototypes.
     * 
     * @return
     *     possible object is
     *     {@link VehiclePrototypes }
     *     
     */
    public VehiclePrototypes getVehiclePrototypes() {
        return vehiclePrototypes;
    }

    /**
     * Définit la valeur de la propriété vehiclePrototypes.
     * 
     * @param value
     *     allowed object is
     *     {@link VehiclePrototypes }
     *     
     */
    public void setVehiclePrototypes(VehiclePrototypes value) {
        this.vehiclePrototypes = value;
    }

    public boolean isSetVehiclePrototypes() {
        return (this.vehiclePrototypes!= null);
    }

    /**
     * Obtient la valeur de la propriété scenario.
     * 
     * @return
     *     possible object is
     *     {@link Scenario }
     *     
     */
    public Scenario getScenario() {
        return scenario;
    }

    /**
     * Définit la valeur de la propriété scenario.
     * 
     * @param value
     *     allowed object is
     *     {@link Scenario }
     *     
     */
    public void setScenario(Scenario value) {
        this.scenario = value;
    }

    public boolean isSetScenario() {
        return (this.scenario!= null);
    }

}
