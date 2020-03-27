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
import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameterNSM;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}BasicModelParameter">
 *       &lt;attribute name="p_slowdown" use="required" type="{}probability" />
 *       &lt;attribute name="p_slow_start" use="required" type="{}probability" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ModelParameterNSM")
public class ModelParameterNSM
    extends BasicModelParameter
    implements Serializable, IModelParameterNSM
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "p_slowdown", required = true)
    protected double pSlowdown;
    @XmlAttribute(name = "p_slow_start", required = true)
    protected double pSlowStart;

    /**
     * Obtient la valeur de la propriété pSlowdown.
     * 
     */
    @Override
	public double getPSlowdown() {
        return pSlowdown;
    }

    /**
     * Définit la valeur de la propriété pSlowdown.
     * 
     */
    public void setPSlowdown(double value) {
        this.pSlowdown = value;
    }

    public boolean isSetPSlowdown() {
        return true;
    }

    /**
     * Obtient la valeur de la propriété pSlowStart.
     * 
     */
    @Override
	public double getPSlowStart() {
        return pSlowStart;
    }

    /**
     * Définit la valeur de la propriété pSlowStart.
     * 
     */
    public void setPSlowStart(double value) {
        this.pSlowStart = value;
    }

    public boolean isSetPSlowStart() {
        return true;
    }

}
