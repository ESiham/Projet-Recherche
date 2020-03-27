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
 *         &lt;element ref="{}Simulation"/>
 *         &lt;element ref="{}TrafficLights" minOccurs="0"/>
 *         &lt;element ref="{}Routes" minOccurs="0"/>
 *         &lt;element ref="{}OutputConfiguration" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="network_filename" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "simulation",
    "trafficLights",
    "routes",
    "outputConfiguration"
})
@XmlRootElement(name = "Scenario")
public class Scenario
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Simulation", required = true)
    protected Simulation simulation;
    @XmlElement(name = "TrafficLights")
    protected TrafficLights trafficLights;
    @XmlElement(name = "Routes")
    protected Routes routes;
    @XmlElement(name = "OutputConfiguration")
    protected OutputConfiguration outputConfiguration;
    @XmlAttribute(name = "network_filename", required = true)
    protected String networkFilename;

    /**
     * Obtient la valeur de la propriété simulation.
     * 
     * @return
     *     possible object is
     *     {@link Simulation }
     *     
     */
    public Simulation getSimulation() {
        return simulation;
    }

    /**
     * Définit la valeur de la propriété simulation.
     * 
     * @param value
     *     allowed object is
     *     {@link Simulation }
     *     
     */
    public void setSimulation(Simulation value) {
        this.simulation = value;
    }

    public boolean isSetSimulation() {
        return (this.simulation!= null);
    }

    /**
     * Obtient la valeur de la propriété trafficLights.
     * 
     * @return
     *     possible object is
     *     {@link TrafficLights }
     *     
     */
    public TrafficLights getTrafficLights() {
        return trafficLights;
    }

    /**
     * Définit la valeur de la propriété trafficLights.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficLights }
     *     
     */
    public void setTrafficLights(TrafficLights value) {
        this.trafficLights = value;
    }

    public boolean isSetTrafficLights() {
        return (this.trafficLights!= null);
    }

    /**
     * Obtient la valeur de la propriété routes.
     * 
     * @return
     *     possible object is
     *     {@link Routes }
     *     
     */
    public Routes getRoutes() {
        return routes;
    }

    /**
     * Définit la valeur de la propriété routes.
     * 
     * @param value
     *     allowed object is
     *     {@link Routes }
     *     
     */
    public void setRoutes(Routes value) {
        this.routes = value;
    }

    public boolean isSetRoutes() {
        return (this.routes!= null);
    }

    /**
     * Obtient la valeur de la propriété outputConfiguration.
     * 
     * @return
     *     possible object is
     *     {@link OutputConfiguration }
     *     
     */
    public OutputConfiguration getOutputConfiguration() {
        return outputConfiguration;
    }

    /**
     * Définit la valeur de la propriété outputConfiguration.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputConfiguration }
     *     
     */
    public void setOutputConfiguration(OutputConfiguration value) {
        this.outputConfiguration = value;
    }

    public boolean isSetOutputConfiguration() {
        return (this.outputConfiguration!= null);
    }

    /**
     * Obtient la valeur de la propriété networkFilename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetworkFilename() {
        return networkFilename;
    }

    /**
     * Définit la valeur de la propriété networkFilename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetworkFilename(String value) {
        this.networkFilename = value;
    }

    public boolean isSetNetworkFilename() {
        return (this.networkFilename!= null);
    }

}
