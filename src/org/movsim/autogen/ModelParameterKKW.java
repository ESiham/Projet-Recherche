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
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameterKKW;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}BasicModelParameter">
 *       &lt;attribute name="k" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="pb0" use="required" type="{}probability" />
 *       &lt;attribute name="pb1" use="required" type="{}probability" />
 *       &lt;attribute name="pa1" use="required" type="{}probability" />
 *       &lt;attribute name="pa2" use="required" type="{}probability" />
 *       &lt;attribute name="vp" use="required" type="{}nonNegativeDouble" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ModelParameterKKW")
public class ModelParameterKKW
    extends BasicModelParameter
    implements Serializable, IModelParameterKKW
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "k", required = true)
    protected double k;
    @XmlAttribute(name = "pb0", required = true)
    protected double pb0;
    @XmlAttribute(name = "pb1", required = true)
    protected double pb1;
    @XmlAttribute(name = "pa1", required = true)
    protected double pa1;
    @XmlAttribute(name = "pa2", required = true)
    protected double pa2;
    @XmlAttribute(name = "vp", required = true)
    protected double vp;

    /**
     * Obtient la valeur de la propriété k.
     * 
     */
    @Override
	public double getK() {
        return k;
    }

    /**
     * Définit la valeur de la propriété k.
     * 
     */
    public void setK(double value) {
        this.k = value;
    }

    public boolean isSetK() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété pb0.
     * 
     */
    @Override
	public double getPb0() {
        return pb0;
    }

    /**
     * Définit la valeur de la propriété pb0.
     * 
     */
    public void setPb0(double value) {
        this.pb0 = value;
    }

    public boolean isSetPb0() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété pb1.
     * 
     */
    @Override
	public double getPb1() {
        return pb1;
    }

    /**
     * Définit la valeur de la propriété pb1.
     * 
     */
    public void setPb1(double value) {
        this.pb1 = value;
    }

    public boolean isSetPb1() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété pa1.
     * 
     */
    @Override
	public double getPa1() {
        return pa1;
    }

    /**
     * Définit la valeur de la propriété pa1.
     * 
     */
    public void setPa1(double value) {
        this.pa1 = value;
    }

    public boolean isSetPa1() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété pa2.
     * 
     */
    @Override
	public double getPa2() {
        return pa2;
    }

    /**
     * Définit la valeur de la propriété pa2.
     * 
     */
    public void setPa2(double value) {
        this.pa2 = value;
    }

    public boolean isSetPa2() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété vp.
     * 
     */
    @Override
	public double getVp() {
        return vp;
    }

    /**
     * Définit la valeur de la propriété vp.
     * 
     */
    public void setVp(double value) {
        this.vp = value;
    }

    public boolean isSetVp() {
        return true;
    }

}
