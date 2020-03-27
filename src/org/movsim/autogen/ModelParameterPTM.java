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
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameterPTM;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}BasicModelParameter">
 *       &lt;attribute name="tau" type="{}nonNegativeDouble" default="0" />
 *       &lt;attribute name="weightMinus" type="{}positiveDouble" default="2" />
 *       &lt;attribute name="a0" type="{}nonNegativeDouble" default="1" />
 *       &lt;attribute name="gamma" type="{}nonNegativeDouble" default="0.3" />
 *       &lt;attribute name="weightCrash" type="{}positiveDouble" default="100000" />
 *       &lt;attribute name="tauMax" type="{}positiveDouble" default="4" />
 *       &lt;attribute name="alpha" type="{}positiveDouble" default="0.2" />
 *       &lt;attribute name="betaLogit" type="{}positiveDouble" default="2" />
 *       &lt;attribute name="tauCorrelation" type="{}positiveDouble" default="10" />
 *       &lt;attribute name="bMax" type="{}positiveDouble" default="8" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ModelParameterPTM")
public class ModelParameterPTM
    extends BasicModelParameter
    implements Serializable, IModelParameterPTM
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "tau")
    protected Double tau;
    @XmlAttribute(name = "weightMinus")
    protected Double weightMinus;
    @XmlAttribute(name = "a0")
    protected Double a0;
    @XmlAttribute(name = "gamma")
    protected Double gamma;
    @XmlAttribute(name = "weightCrash")
    protected Double weightCrash;
    @XmlAttribute(name = "tauMax")
    protected Double tauMax;
    @XmlAttribute(name = "alpha")
    protected Double alpha;
    @XmlAttribute(name = "betaLogit")
    protected Double betaLogit;
    @XmlAttribute(name = "tauCorrelation")
    protected Double tauCorrelation;
    @XmlAttribute(name = "bMax")
    protected Double bMax;

    /**
     * Obtient la valeur de la propriété tau.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
	public double getTau() {
        if (tau == null) {
            return  0.0D;
        } else {
            return tau;
        }
    }

    /**
     * Définit la valeur de la propriété tau.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTau(double value) {
        this.tau = value;
    }

    public boolean isSetTau() {
        return (this.tau!= null);
    }

    public void unsetTau() {
        this.tau = null;
    }

    /**
     * Obtient la valeur de la propriété weightMinus.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
	public double getWeightMinus() {
        if (weightMinus == null) {
            return  2.0D;
        } else {
            return weightMinus;
        }
    }

    /**
     * Définit la valeur de la propriété weightMinus.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeightMinus(double value) {
        this.weightMinus = value;
    }

    public boolean isSetWeightMinus() {
        return (this.weightMinus!= null);
    }

    public void unsetWeightMinus() {
        this.weightMinus = null;
    }

    /**
     * Obtient la valeur de la propriété a0.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
	public double getA0() {
        if (a0 == null) {
            return  1.0D;
        } else {
            return a0;
        }
    }

    /**
     * Définit la valeur de la propriété a0.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setA0(double value) {
        this.a0 = value;
    }

    public boolean isSetA0() {
        return (this.a0 != null);
    }

    public void unsetA0() {
        this.a0 = null;
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
            return  0.3D;
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
     * Obtient la valeur de la propriété weightCrash.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
	public double getWeightCrash() {
        if (weightCrash == null) {
            return  100000.0D;
        } else {
            return weightCrash;
        }
    }

    /**
     * Définit la valeur de la propriété weightCrash.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeightCrash(double value) {
        this.weightCrash = value;
    }

    public boolean isSetWeightCrash() {
        return (this.weightCrash!= null);
    }

    public void unsetWeightCrash() {
        this.weightCrash = null;
    }

    /**
     * Obtient la valeur de la propriété tauMax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
	public double getTauMax() {
        if (tauMax == null) {
            return  4.0D;
        } else {
            return tauMax;
        }
    }

    /**
     * Définit la valeur de la propriété tauMax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTauMax(double value) {
        this.tauMax = value;
    }

    public boolean isSetTauMax() {
        return (this.tauMax!= null);
    }

    public void unsetTauMax() {
        this.tauMax = null;
    }

    /**
     * Obtient la valeur de la propriété alpha.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
	public double getAlpha() {
        if (alpha == null) {
            return  0.2D;
        } else {
            return alpha;
        }
    }

    /**
     * Définit la valeur de la propriété alpha.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAlpha(double value) {
        this.alpha = value;
    }

    public boolean isSetAlpha() {
        return (this.alpha!= null);
    }

    public void unsetAlpha() {
        this.alpha = null;
    }

    /**
     * Obtient la valeur de la propriété betaLogit.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
	public double getBetaLogit() {
        if (betaLogit == null) {
            return  2.0D;
        } else {
            return betaLogit;
        }
    }

    /**
     * Définit la valeur de la propriété betaLogit.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBetaLogit(double value) {
        this.betaLogit = value;
    }

    public boolean isSetBetaLogit() {
        return (this.betaLogit!= null);
    }

    public void unsetBetaLogit() {
        this.betaLogit = null;
    }

    /**
     * Obtient la valeur de la propriété tauCorrelation.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
	public double getTauCorrelation() {
        if (tauCorrelation == null) {
            return  10.0D;
        } else {
            return tauCorrelation;
        }
    }

    /**
     * Définit la valeur de la propriété tauCorrelation.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTauCorrelation(double value) {
        this.tauCorrelation = value;
    }

    public boolean isSetTauCorrelation() {
        return (this.tauCorrelation!= null);
    }

    public void unsetTauCorrelation() {
        this.tauCorrelation = null;
    }

    /**
     * Obtient la valeur de la propriété bMax.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    @Override
	public double getBMax() {
        if (bMax == null) {
            return  8.0D;
        } else {
            return bMax;
        }
    }

    /**
     * Définit la valeur de la propriété bMax.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBMax(double value) {
        this.bMax = value;
    }

    public boolean isSetBMax() {
        return (this.bMax!= null);
    }

    public void unsetBMax() {
        this.bMax = null;
    }

}
