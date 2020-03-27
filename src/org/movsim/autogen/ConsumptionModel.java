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
 *         &lt;element ref="{}VehicleData"/>
 *         &lt;choice>
 *           &lt;element ref="{}EngineCombustionMap"/>
 *           &lt;element ref="{}EngineConstantMap"/>
 *         &lt;/choice>
 *         &lt;element ref="{}RotationModel"/>
 *       &lt;/sequence>
 *       &lt;attribute name="label" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="output" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vehicleData",
    "engineCombustionMap",
    "engineConstantMap",
    "rotationModel"
})
@XmlRootElement(name = "ConsumptionModel")
public class ConsumptionModel
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "VehicleData", required = true)
    protected VehicleData vehicleData;
    @XmlElement(name = "EngineCombustionMap")
    protected EngineCombustionMap engineCombustionMap;
    @XmlElement(name = "EngineConstantMap")
    protected EngineConstantMap engineConstantMap;
    @XmlElement(name = "RotationModel", required = true)
    protected RotationModel rotationModel;
    @XmlAttribute(name = "label", required = true)
    protected String label;
    @XmlAttribute(name = "output")
    protected Boolean output;

    /**
     * Obtient la valeur de la propriété vehicleData.
     * 
     * @return
     *     possible object is
     *     {@link VehicleData }
     *     
     */
    public VehicleData getVehicleData() {
        return vehicleData;
    }

    /**
     * Définit la valeur de la propriété vehicleData.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleData }
     *     
     */
    public void setVehicleData(VehicleData value) {
        this.vehicleData = value;
    }

    public boolean isSetVehicleData() {
        return (this.vehicleData!= null);
    }

    /**
     * Obtient la valeur de la propriété engineCombustionMap.
     * 
     * @return
     *     possible object is
     *     {@link EngineCombustionMap }
     *     
     */
    public EngineCombustionMap getEngineCombustionMap() {
        return engineCombustionMap;
    }

    /**
     * Définit la valeur de la propriété engineCombustionMap.
     * 
     * @param value
     *     allowed object is
     *     {@link EngineCombustionMap }
     *     
     */
    public void setEngineCombustionMap(EngineCombustionMap value) {
        this.engineCombustionMap = value;
    }

    public boolean isSetEngineCombustionMap() {
        return (this.engineCombustionMap!= null);
    }

    /**
     * Obtient la valeur de la propriété engineConstantMap.
     * 
     * @return
     *     possible object is
     *     {@link EngineConstantMap }
     *     
     */
    public EngineConstantMap getEngineConstantMap() {
        return engineConstantMap;
    }

    /**
     * Définit la valeur de la propriété engineConstantMap.
     * 
     * @param value
     *     allowed object is
     *     {@link EngineConstantMap }
     *     
     */
    public void setEngineConstantMap(EngineConstantMap value) {
        this.engineConstantMap = value;
    }

    public boolean isSetEngineConstantMap() {
        return (this.engineConstantMap!= null);
    }

    /**
     * Obtient la valeur de la propriété rotationModel.
     * 
     * @return
     *     possible object is
     *     {@link RotationModel }
     *     
     */
    public RotationModel getRotationModel() {
        return rotationModel;
    }

    /**
     * Définit la valeur de la propriété rotationModel.
     * 
     * @param value
     *     allowed object is
     *     {@link RotationModel }
     *     
     */
    public void setRotationModel(RotationModel value) {
        this.rotationModel = value;
    }

    public boolean isSetRotationModel() {
        return (this.rotationModel!= null);
    }

    /**
     * Obtient la valeur de la propriété label.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Définit la valeur de la propriété label.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    public boolean isSetLabel() {
        return (this.label!= null);
    }

    /**
     * Obtient la valeur de la propriété output.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOutput() {
        if (output == null) {
            return false;
        } else {
            return output;
        }
    }

    /**
     * Définit la valeur de la propriété output.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutput(boolean value) {
        this.output = value;
    }

    public boolean isSetOutput() {
        return (this.output!= null);
    }

    public void unsetOutput() {
        this.output = null;
    }

}
