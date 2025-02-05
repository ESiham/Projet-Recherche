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
 *       &lt;sequence>
 *         &lt;element ref="{}FloatingCar" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="n_timestep" type="{}positiveInteger" default="1" />
 *       &lt;attribute name="random_fraction" type="{}probability" default="0" />
 *       &lt;attribute name="route" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "floatingCar"
})
@XmlRootElement(name = "FloatingCarOutput")
public class FloatingCarOutput
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "FloatingCar")
    protected List<FloatingCar> floatingCar;
    @XmlAttribute(name = "n_timestep")
    protected Integer nTimestep;
    @XmlAttribute(name = "random_fraction")
    protected Double randomFraction;
    @XmlAttribute(name = "route", required = true)
    protected String route;

    /**
     * Gets the value of the floatingCar property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the floatingCar property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFloatingCar().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FloatingCar }
     * 
     * 
     */
    public List<FloatingCar> getFloatingCar() {
        if (floatingCar == null) {
            floatingCar = new ArrayList<FloatingCar>();
        }
        return this.floatingCar;
    }

    public boolean isSetFloatingCar() {
        return ((this.floatingCar!= null)&&(!this.floatingCar.isEmpty()));
    }

    public void unsetFloatingCar() {
        this.floatingCar = null;
    }

    /**
     * Obtient la valeur de la propriété nTimestep.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getNTimestep() {
        if (nTimestep == null) {
            return  1;
        } else {
            return nTimestep;
        }
    }

    /**
     * Définit la valeur de la propriété nTimestep.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNTimestep(int value) {
        this.nTimestep = value;
    }

    public boolean isSetNTimestep() {
        return (this.nTimestep!= null);
    }

    public void unsetNTimestep() {
        this.nTimestep = null;
    }

    /**
     * Obtient la valeur de la propriété randomFraction.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getRandomFraction() {
        if (randomFraction == null) {
            return  0.0D;
        } else {
            return randomFraction;
        }
    }

    /**
     * Définit la valeur de la propriété randomFraction.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRandomFraction(double value) {
        this.randomFraction = value;
    }

    public boolean isSetRandomFraction() {
        return (this.randomFraction!= null);
    }

    public void unsetRandomFraction() {
        this.randomFraction = null;
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

}
