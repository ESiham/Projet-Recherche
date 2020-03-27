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
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameterGipps;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}BasicModelParameter">
 *       &lt;attribute name="a" use="required" type="{}nonNegativeDouble" />
 *       &lt;attribute name="b" use="required" type="{}nonNegativeDouble" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ModelParameterGipps")
public class ModelParameterGipps
    extends BasicModelParameter
    implements Serializable, IModelParameterGipps
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "a", required = true)
    protected double a;
    @XmlAttribute(name = "b", required = true)
    protected double b;

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

}
