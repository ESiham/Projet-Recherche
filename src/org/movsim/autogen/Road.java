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

import fr.ifsttar.licit.simulator.infrastructure.RoadSideUnits;


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
 *         &lt;element ref="{}TrafficComposition" minOccurs="0"/>
 *         &lt;element ref="{}InitialConditions" minOccurs="0"/>
 *         &lt;element ref="{}TrafficSource" minOccurs="0"/>
 *         &lt;element ref="{}TrafficSink" minOccurs="0"/>
 *         &lt;element ref="{}FlowConservingInhomogeneities" minOccurs="0"/>
 *         &lt;element ref="{}SimpleRamp" minOccurs="0"/>
 *         &lt;element ref="{}Detectors" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "trafficComposition",
    "initialConditions",
    "trafficSource",
    "trafficSink",
    "flowConservingInhomogeneities",
    "simpleRamp",
    "detectors",
    "roadsideunits"
})
@XmlRootElement(name = "Road")
public class Road
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "TrafficComposition")
    protected TrafficComposition trafficComposition;
    @XmlElement(name = "InitialConditions")
    protected InitialConditions initialConditions;
    @XmlElement(name = "TrafficSource")
    protected TrafficSource trafficSource;
    @XmlElement(name = "TrafficSink")
    protected TrafficSink trafficSink;
    @XmlElement(name = "FlowConservingInhomogeneities")
    protected FlowConservingInhomogeneities flowConservingInhomogeneities;
    @XmlElement(name = "SimpleRamp")
    protected SimpleRamp simpleRamp;
    @XmlElement(name = "Detectors")
    protected Detectors detectors;
    @XmlElement(name = "RoadSideUnits")
    protected RoadSideUnits roadsideunits;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "logging")
    protected Boolean logging;

    /**
     * Obtient la valeur de la propriété trafficComposition.
     * 
     * @return
     *     possible object is
     *     {@link TrafficComposition }
     *     
     */
    public TrafficComposition getTrafficComposition() {
        return trafficComposition;
    }

    /**
     * Définit la valeur de la propriété trafficComposition.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficComposition }
     *     
     */
    public void setTrafficComposition(TrafficComposition value) {
        this.trafficComposition = value;
    }

    public boolean isSetTrafficComposition() {
        return (this.trafficComposition!= null);
    }

    /**
     * Obtient la valeur de la propriété initialConditions.
     * 
     * @return
     *     possible object is
     *     {@link InitialConditions }
     *     
     */
    public InitialConditions getInitialConditions() {
        return initialConditions;
    }

    /**
     * Définit la valeur de la propriété initialConditions.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialConditions }
     *     
     */
    public void setInitialConditions(InitialConditions value) {
        this.initialConditions = value;
    }

    public boolean isSetInitialConditions() {
        return (this.initialConditions!= null);
    }

    /**
     * Obtient la valeur de la propriété trafficSource.
     * 
     * @return
     *     possible object is
     *     {@link TrafficSource }
     *     
     */
    public TrafficSource getTrafficSource() {
        return trafficSource;
    }

    /**
     * Définit la valeur de la propriété trafficSource.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficSource }
     *     
     */
    public void setTrafficSource(TrafficSource value) {
        this.trafficSource = value;
    }

    public boolean isSetTrafficSource() {
        return (this.trafficSource!= null);
    }

    /**
     * Obtient la valeur de la propriété trafficSink.
     * 
     * @return
     *     possible object is
     *     {@link TrafficSink }
     *     
     */
    public TrafficSink getTrafficSink() {
        return trafficSink;
    }

    /**
     * Définit la valeur de la propriété trafficSink.
     * 
     * @param value
     *     allowed object is
     *     {@link TrafficSink }
     *     
     */
    public void setTrafficSink(TrafficSink value) {
        this.trafficSink = value;
    }

    public boolean isSetTrafficSink() {
        return (this.trafficSink!= null);
    }

    /**
     * Obtient la valeur de la propriété flowConservingInhomogeneities.
     * 
     * @return
     *     possible object is
     *     {@link FlowConservingInhomogeneities }
     *     
     */
    public FlowConservingInhomogeneities getFlowConservingInhomogeneities() {
        return flowConservingInhomogeneities;
    }

    /**
     * Définit la valeur de la propriété flowConservingInhomogeneities.
     * 
     * @param value
     *     allowed object is
     *     {@link FlowConservingInhomogeneities }
     *     
     */
    public void setFlowConservingInhomogeneities(FlowConservingInhomogeneities value) {
        this.flowConservingInhomogeneities = value;
    }

    public boolean isSetFlowConservingInhomogeneities() {
        return (this.flowConservingInhomogeneities!= null);
    }

    /**
     * Obtient la valeur de la propriété simpleRamp.
     * 
     * @return
     *     possible object is
     *     {@link SimpleRamp }
     *     
     */
    public SimpleRamp getSimpleRamp() {
        return simpleRamp;
    }

    /**
     * Définit la valeur de la propriété simpleRamp.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleRamp }
     *     
     */
    public void setSimpleRamp(SimpleRamp value) {
        this.simpleRamp = value;
    }

    public boolean isSetSimpleRamp() {
        return (this.simpleRamp!= null);
    }

    /**
     * Obtient la valeur de la propriété detectors.
     * 
     * @return
     *     possible object is
     *     {@link Detectors }
     *     
     */
    public Detectors getDetectors() {
        return detectors;
    }

    /**
     * Définit la valeur de la propriété detectors.
     * 
     * @param value
     *     allowed object is
     *     {@link Detectors }
     *     
     */
    public void setDetectors(Detectors value) {
        this.detectors = value;
    }

    public boolean isSetDetectors() {
        return (this.detectors!= null);
    }
    
    /**
     * Obtient la valeur de la propriété detectors.
     * 
     * @return
     *     possible object is
     *     {@link Detectors }
     *     
     */
    public RoadSideUnits getRoadSideunits() {
        return roadsideunits;
    }

    /**
     * Définit la valeur de la propriété detectors.
     * 
     * @param value
     *     allowed object is
     *     {@link Detectors }
     *     
     */
    public void setRoadSideUnits(RoadSideUnits value) {
        this.roadsideunits = value;
    }

    public boolean isSetRoadSideUnits() {
        return (this.roadsideunits!= null);
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
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
