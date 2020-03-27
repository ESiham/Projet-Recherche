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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameter;


/**
 * <p>Classe Java pour BasicModelParameter complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="BasicModelParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="v0" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="s0" use="required" type="{}nonNegativeDouble" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasicModelParameter")
@XmlSeeAlso({
    ModelParameterPTM.class,
    ModelParameterCCS.class,
    ModelParameterKKW.class,
    ModelParameterNSM.class,
    ModelParameterNewell.class,
    ModelParameterKrauss.class,
    ModelParameterGipps.class,
    ModelParameterOVMFVDM.class,
    ModelParameterACC.class,
    ModelParameterIDM.class
})
public class BasicModelParameter
    implements Serializable, IModelParameter
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "v0", required = true)
    protected double v0;
    @XmlAttribute(name = "s0", required = true)
    protected double s0;

    /**
     * Obtient la valeur de la propriété v0.
     * 
     */
    @Override
	public double getV0() {
        return v0;
    }

    /**
     * Définit la valeur de la propriété v0.
     * 
     */
    public void setV0(double value) {
        this.v0 = value;
    }

    public boolean isSetV0() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété s0.
     * 
     */
    @Override
	public double getS0() {
        return s0;
    }

    /**
     * Définit la valeur de la propriété s0.
     * 
     */
    public void setS0(double value) {
        this.s0 = value;
    }

    public boolean isSetS0() {
        return true;
    }

}
