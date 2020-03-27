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
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameterCCS;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}BasicModelParameter">
 *       &lt;attribute name="mass" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="cw" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="A" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="friction" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="p0" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="v_c" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="p_herringbone" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="v_c_herringbone" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="T" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="b" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="b_maximum" use="required" type="{}nonNegativeDouble" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ModelParameterCCS")
public class ModelParameterCCS
    extends BasicModelParameter
    implements Serializable, IModelParameterCCS
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "mass", required = true)
    protected double mass;
    @XmlAttribute(name = "cw", required = true)
    protected double cw;
    @XmlAttribute(name = "A", required = true)
    protected double a;
    @XmlAttribute(name = "friction", required = true)
    protected double friction;
    @XmlAttribute(name = "p0", required = true)
    protected double p0;
    @XmlAttribute(name = "v_c", required = true)
    protected double vc;
    @XmlAttribute(name = "p_herringbone", required = true)
    protected double pHerringbone;
    @XmlAttribute(name = "v_c_herringbone", required = true)
    protected double vcHerringbone;
    @XmlAttribute(name = "T", required = true)
    protected double t;
    @XmlAttribute(name = "b", required = true)
    protected double b;
    @XmlAttribute(name = "b_maximum", required = true)
    protected double bMaximum;

    /**
     * Obtient la valeur de la propriété mass.
     * 
     */
    @Override
	public double getMass() {
        return mass;
    }

    /**
     * Définit la valeur de la propriété mass.
     * 
     */
    public void setMass(double value) {
        this.mass = value;
    }

    public boolean isSetMass() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété cw.
     * 
     */
    @Override
	public double getCw() {
        return cw;
    }

    /**
     * Définit la valeur de la propriété cw.
     * 
     */
    public void setCw(double value) {
        this.cw = value;
    }

    public boolean isSetCw() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété a.
     * 
     */
    @Override
	public double getA() {
        return a;
    }

    /**
     * Définit la valeur de la propriété a.
     * 
     */
    public void setA(double value) {
        this.a = value;
    }

    public boolean isSetA() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété friction.
     * 
     */
    @Override
	public double getFriction() {
        return friction;
    }

    /**
     * Définit la valeur de la propriété friction.
     * 
     */
    public void setFriction(double value) {
        this.friction = value;
    }

    public boolean isSetFriction() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété p0.
     * 
     */
    @Override
	public double getP0() {
        return p0;
    }

    /**
     * Définit la valeur de la propriété p0.
     * 
     */
    public void setP0(double value) {
        this.p0 = value;
    }

    public boolean isSetP0() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété vc.
     * 
     */
    @Override
	public double getVC() {
        return vc;
    }

    /**
     * Définit la valeur de la propriété vc.
     * 
     */
    public void setVC(double value) {
        this.vc = value;
    }

    public boolean isSetVC() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété pHerringbone.
     * 
     */
    @Override
	public double getPHerringbone() {
        return pHerringbone;
    }

    /**
     * Définit la valeur de la propriété pHerringbone.
     * 
     */
    public void setPHerringbone(double value) {
        this.pHerringbone = value;
    }

    public boolean isSetPHerringbone() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété vcHerringbone.
     * 
     */
    @Override
	public double getVCHerringbone() {
        return vcHerringbone;
    }

    /**
     * Définit la valeur de la propriété vcHerringbone.
     * 
     */
    public void setVCHerringbone(double value) {
        this.vcHerringbone = value;
    }

    public boolean isSetVCHerringbone() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété t.
     * 
     */
    @Override
	public double getT() {
        return t;
    }

    /**
     * Définit la valeur de la propriété t.
     * 
     */
    public void setT(double value) {
        this.t = value;
    }

    public boolean isSetT() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété b.
     * 
     */
    @Override
	public double getB() {
        return b;
    }

    /**
     * Définit la valeur de la propriété b.
     * 
     */
    public void setB(double value) {
        this.b = value;
    }

    public boolean isSetB() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété bMaximum.
     * 
     */
    @Override
	public double getBMaximum() {
        return bMaximum;
    }

    /**
     * Définit la valeur de la propriété bMaximum.
     * 
     */
    public void setBMaximum(double value) {
        this.bMaximum = value;
    }

    public boolean isSetBMaximum() {
        return true;
    }

}
