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
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameterOVMFVDM;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}BasicModelParameter">
 *       &lt;attribute name="tau" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="transition_width" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="beta" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="gamma" type="{}nonNegativeDouble" default="0" />
 *       &lt;attribute name="optimal_speed_function" type="{}OptimalVelocityFunctionEnum" default="bando" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ModelParameterOVM_FVDM")
public class ModelParameterOVMFVDM
    extends BasicModelParameter
    implements Serializable, IModelParameterOVMFVDM
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "tau", required = true)
    protected double tau;
    @XmlAttribute(name = "transition_width", required = true)
    protected double transitionWidth;
    @XmlAttribute(name = "beta", required = true)
    protected double beta;
    @XmlAttribute(name = "gamma")
    protected Double gamma;
    @XmlAttribute(name = "optimal_speed_function")
    protected OptimalVelocityFunctionEnum optimalSpeedFunction;

    /**
     * Obtient la valeur de la propriété tau.
     * 
     */
    @Override
	public double getTau() {
        return tau;
    }

    /**
     * Définit la valeur de la propriété tau.
     * 
     */
    public void setTau(double value) {
        this.tau = value;
    }

    public boolean isSetTau() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété transitionWidth.
     * 
     */
    @Override
	public double getTransitionWidth() {
        return transitionWidth;
    }

    /**
     * Définit la valeur de la propriété transitionWidth.
     * 
     */
    public void setTransitionWidth(double value) {
        this.transitionWidth = value;
    }

    public boolean isSetTransitionWidth() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété beta.
     * 
     */
    @Override
	public double getBeta() {
        return beta;
    }

    /**
     * Définit la valeur de la propriété beta.
     * 
     */
    public void setBeta(double value) {
        this.beta = value;
    }

    public boolean isSetBeta() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété gamma.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
	public double getGamma() {
        if (gamma == null) {
            return  0.0D;
        } else {
            return gamma;
        }
    }

    /**
     * Définit la valeur de la propriété gamma.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGamma(double value) {
        this.gamma = value;
    }

    public boolean isSetGamma() {
        return (this.gamma!= null);
    }

    public void unsetGamma() {
        this.gamma = null;
    }

    /**
     * Obtient la valeur de la propriété optimalSpeedFunction.
     * 
     * @return
     *     possible object is
     *     {@link OptimalVelocityFunctionEnum }
     *     
     */
    @Override
	public OptimalVelocityFunctionEnum getOptimalSpeedFunction() {
        if (optimalSpeedFunction == null) {
            return OptimalVelocityFunctionEnum.BANDO;
        } else {
            return optimalSpeedFunction;
        }
    }

    /**
     * Définit la valeur de la propriété optimalSpeedFunction.
     * 
     * @param value
     *     allowed object is
     *     {@link OptimalVelocityFunctionEnum }
     *     
     */
    public void setOptimalSpeedFunction(OptimalVelocityFunctionEnum value) {
        this.optimalSpeedFunction = value;
    }

    public boolean isSetOptimalSpeedFunction() {
        return (this.optimalSpeedFunction!= null);
    }

}
