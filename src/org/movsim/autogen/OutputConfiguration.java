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
 *         &lt;element ref="{}FloatingCarOutput" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}SpatioTemporalConfiguration" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Trajectories" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Trusts" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}TravelTimes" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}ConsumptionCalculation" maxOccurs="unbounded" minOccurs="0"/>
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
    "floatingCarOutput",
    "spatioTemporalConfiguration",
    "trajectories",
    "trusts",
    "travelTimes",
    "consumptionCalculation"
})
@XmlRootElement(name = "OutputConfiguration")
public class OutputConfiguration
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "FloatingCarOutput")
    protected List<FloatingCarOutput> floatingCarOutput;
    @XmlElement(name = "SpatioTemporalConfiguration")
    protected List<SpatioTemporalConfiguration> spatioTemporalConfiguration;
    @XmlElement(name = "Trajectories")
    protected List<Trajectories> trajectories;
    @XmlElement(name = "Trusts")
    protected List<Trusts> trusts;
    @XmlElement(name = "TravelTimes")
    protected List<TravelTimes> travelTimes;
    @XmlElement(name = "ConsumptionCalculation")
    protected List<ConsumptionCalculation> consumptionCalculation;

    /**
     * Gets the value of the floatingCarOutput property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the floatingCarOutput property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFloatingCarOutput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FloatingCarOutput }
     * 
     * 
     */
    public List<FloatingCarOutput> getFloatingCarOutput() {
        if (floatingCarOutput == null) {
            floatingCarOutput = new ArrayList<FloatingCarOutput>();
        }
        return this.floatingCarOutput;
    }

    public boolean isSetFloatingCarOutput() {
        return ((this.floatingCarOutput!= null)&&(!this.floatingCarOutput.isEmpty()));
    }

    public void unsetFloatingCarOutput() {
        this.floatingCarOutput = null;
    }

    /**
     * Gets the value of the spatioTemporalConfiguration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spatioTemporalConfiguration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpatioTemporalConfiguration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpatioTemporalConfiguration }
     * 
     * 
     */
    public List<SpatioTemporalConfiguration> getSpatioTemporalConfiguration() {
        if (spatioTemporalConfiguration == null) {
            spatioTemporalConfiguration = new ArrayList<SpatioTemporalConfiguration>();
        }
        return this.spatioTemporalConfiguration;
    }

    public boolean isSetSpatioTemporalConfiguration() {
        return ((this.spatioTemporalConfiguration!= null)&&(!this.spatioTemporalConfiguration.isEmpty()));
    }

    public void unsetSpatioTemporalConfiguration() {
        this.spatioTemporalConfiguration = null;
    }

    /**
     * Gets the value of the trajectories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trajectories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrajectories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Trajectories }
     * 
     * 
     */
    public List<Trajectories> getTrajectories() {
        if (trajectories == null) {
            trajectories = new ArrayList<Trajectories>();
        }
        return this.trajectories;
    }

    public boolean isSetTrajectories() {
        return ((this.trajectories!= null)&&(!this.trajectories.isEmpty()));
    }

    public void unsetTrajectories() {
        this.trajectories = null;
    }

    
    /***
     * 
     * 
     *
     */
    
    
    public List<Trusts> getTrusts() {
        if (trusts == null) {
        	trusts = new ArrayList<Trusts>();
        }
        return this.trusts;
    }

    public boolean isSetTrusts() {
        return ((this.trusts!= null)&&(!this.trusts.isEmpty()));
    }

    public void unsetTrusts() {
        this.trusts = null;
    }

    
    /**
     * 
     */
    
    /**
     * Gets the value of the travelTimes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the travelTimes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTravelTimes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TravelTimes }
     * 
     * 
     */
    public List<TravelTimes> getTravelTimes() {
        if (travelTimes == null) {
            travelTimes = new ArrayList<TravelTimes>();
        }
        return this.travelTimes;
    }

    public boolean isSetTravelTimes() {
        return ((this.travelTimes!= null)&&(!this.travelTimes.isEmpty()));
    }

    public void unsetTravelTimes() {
        this.travelTimes = null;
    }

    /**
     * Gets the value of the consumptionCalculation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consumptionCalculation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsumptionCalculation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionCalculation }
     * 
     * 
     */
    public List<ConsumptionCalculation> getConsumptionCalculation() {
        if (consumptionCalculation == null) {
            consumptionCalculation = new ArrayList<ConsumptionCalculation>();
        }
        return this.consumptionCalculation;
    }

    public boolean isSetConsumptionCalculation() {
        return ((this.consumptionCalculation!= null)&&(!this.consumptionCalculation.isEmpty()));
    }

    public void unsetConsumptionCalculation() {
        this.consumptionCalculation = null;
    }

}
