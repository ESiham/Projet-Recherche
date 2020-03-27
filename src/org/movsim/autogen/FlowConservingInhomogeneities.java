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
 *         &lt;element ref="{}Inhomogeneity" maxOccurs="unbounded" minOccurs="0"/>
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
    "inhomogeneity"
})
@XmlRootElement(name = "FlowConservingInhomogeneities")
public class FlowConservingInhomogeneities
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Inhomogeneity")
    protected List<Inhomogeneity> inhomogeneity;

    /**
     * Gets the value of the inhomogeneity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inhomogeneity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInhomogeneity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Inhomogeneity }
     * 
     * 
     */
    public List<Inhomogeneity> getInhomogeneity() {
        if (inhomogeneity == null) {
            inhomogeneity = new ArrayList<Inhomogeneity>();
        }
        return this.inhomogeneity;
    }

    public boolean isSetInhomogeneity() {
        return ((this.inhomogeneity!= null)&&(!this.inhomogeneity.isEmpty()));
    }

    public void unsetInhomogeneity() {
        this.inhomogeneity = null;
    }

}
