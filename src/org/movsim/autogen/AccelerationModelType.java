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
 *       &lt;choice>
 *         &lt;element ref="{}ModelParameterIDM" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterACC" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterOVM_FVDM" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterGipps" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterKrauss" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterNewell" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterNSM" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterKKW" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterCCS" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterPTM" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterFB" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterBMA" minOccurs="0"/>
 *         &lt;element ref="{}ModelParameterCalibratedIDM" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "modelParameterIDM",
    "modelParameterACC",
    "modelParameterOVMFVDM",
    "modelParameterGipps",
    "modelParameterKrauss",
    "modelParameterNewell",
    "modelParameterNSM",
    "modelParameterKKW",
    "modelParameterCCS",
    "modelParameterPTM",
    "modelParameterFB",
    "modelParameterBMA",
    "modelParameterCalibratedIDM"
})
@XmlRootElement(name = "AccelerationModelType")
public class AccelerationModelType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "ModelParameterIDM")
    protected ModelParameterIDM modelParameterIDM;
    @XmlElement(name = "ModelParameterACC")
    protected ModelParameterACC modelParameterACC;
    @XmlElement(name = "ModelParameterOVM_FVDM")
    protected ModelParameterOVMFVDM modelParameterOVMFVDM;
    @XmlElement(name = "ModelParameterGipps")
    protected ModelParameterGipps modelParameterGipps;
    @XmlElement(name = "ModelParameterKrauss")
    protected ModelParameterKrauss modelParameterKrauss;
    @XmlElement(name = "ModelParameterNewell")
    protected ModelParameterNewell modelParameterNewell;
    @XmlElement(name = "ModelParameterNSM")
    protected ModelParameterNSM modelParameterNSM;
    @XmlElement(name = "ModelParameterKKW")
    protected ModelParameterKKW modelParameterKKW;
    @XmlElement(name = "ModelParameterCCS")
    protected ModelParameterCCS modelParameterCCS;
    @XmlElement(name = "ModelParameterPTM")
    protected ModelParameterPTM modelParameterPTM;
    @XmlElement(name = "ModelParameterFB")
    protected ModelParameterFB modelParameterFB;
    @XmlElement(name = "ModelParameterBMA")
    protected ModelParameterBMA modelParameterBMA;
    @XmlElement(name = "ModelParameterCalibratedIDM")
    protected ModelParameterCalibratedIDM modelParameterCalibratedIDM;
    
    /**
     * Obtient la valeur de la propriété modelParameterIDM.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterIDM }
     *     
     */
    public ModelParameterIDM getModelParameterIDM() {
        return modelParameterIDM;
    }

    /**
     * Définit la valeur de la propriété modelParameterIDM.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterIDM }
     *     
     */
    public void setModelParameterIDM(ModelParameterIDM value) {
        this.modelParameterIDM = value;
    }

    public boolean isSetModelParameterIDM() {
        return (this.modelParameterIDM!= null);
    }

    /**
     * Obtient la valeur de la propriété modelParameterACC.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterACC }
     *     
     */
    public ModelParameterACC getModelParameterACC() {
        return modelParameterACC;
    }

    /**
     * Définit la valeur de la propriété modelParameterACC.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterACC }
     *     
     */
    public void setModelParameterACC(ModelParameterACC value) {
        this.modelParameterACC = value;
    }

    public boolean isSetModelParameterACC() {
        return (this.modelParameterACC!= null);
    }

    /**
     * Obtient la valeur de la propriété modelParameterOVMFVDM.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterOVMFVDM }
     *     
     */
    public ModelParameterOVMFVDM getModelParameterOVMFVDM() {
        return modelParameterOVMFVDM;
    }

    /**
     * Définit la valeur de la propriété modelParameterOVMFVDM.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterOVMFVDM }
     *     
     */
    public void setModelParameterOVMFVDM(ModelParameterOVMFVDM value) {
        this.modelParameterOVMFVDM = value;
    }

    public boolean isSetModelParameterOVMFVDM() {
        return (this.modelParameterOVMFVDM!= null);
    }

    /**
     * Obtient la valeur de la propriété modelParameterGipps.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterGipps }
     *     
     */
    public ModelParameterGipps getModelParameterGipps() {
        return modelParameterGipps;
    }

    /**
     * Définit la valeur de la propriété modelParameterGipps.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterGipps }
     *     
     */
    public void setModelParameterGipps(ModelParameterGipps value) {
        this.modelParameterGipps = value;
    }

    public boolean isSetModelParameterGipps() {
        return (this.modelParameterGipps!= null);
    }

    /**
     * Obtient la valeur de la propriété modelParameterKrauss.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterKrauss }
     *     
     */
    public ModelParameterKrauss getModelParameterKrauss() {
        return modelParameterKrauss;
    }

    /**
     * Définit la valeur de la propriété modelParameterKrauss.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterKrauss }
     *     
     */
    public void setModelParameterKrauss(ModelParameterKrauss value) {
        this.modelParameterKrauss = value;
    }

    public boolean isSetModelParameterKrauss() {
        return (this.modelParameterKrauss!= null);
    }

    /**
     * Obtient la valeur de la propriété modelParameterNewell.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterNewell }
     *     
     */
    public ModelParameterNewell getModelParameterNewell() {
        return modelParameterNewell;
    }

    /**
     * Définit la valeur de la propriété modelParameterNewell.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterNewell }
     *     
     */
    public void setModelParameterNewell(ModelParameterNewell value) {
        this.modelParameterNewell = value;
    }

    public boolean isSetModelParameterNewell() {
        return (this.modelParameterNewell!= null);
    }

    /**
     * Obtient la valeur de la propriété modelParameterNSM.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterNSM }
     *     
     */
    public ModelParameterNSM getModelParameterNSM() {
        return modelParameterNSM;
    }

    /**
     * Définit la valeur de la propriété modelParameterNSM.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterNSM }
     *     
     */
    public void setModelParameterNSM(ModelParameterNSM value) {
        this.modelParameterNSM = value;
    }

    public boolean isSetModelParameterNSM() {
        return (this.modelParameterNSM!= null);
    }

    /**
     * Obtient la valeur de la propriété modelParameterKKW.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterKKW }
     *     
     */
    public ModelParameterKKW getModelParameterKKW() {
        return modelParameterKKW;
    }

    /**
     * Définit la valeur de la propriété modelParameterKKW.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterKKW }
     *     
     */
    public void setModelParameterKKW(ModelParameterKKW value) {
        this.modelParameterKKW = value;
    }

    public boolean isSetModelParameterKKW() {
        return (this.modelParameterKKW!= null);
    }

    /**
     * Obtient la valeur de la propriété modelParameterCCS.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterCCS }
     *     
     */
    public ModelParameterCCS getModelParameterCCS() {
        return modelParameterCCS;
    }

    /**
     * Définit la valeur de la propriété modelParameterCCS.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterCCS }
     *     
     */
    public void setModelParameterCCS(ModelParameterCCS value) {
        this.modelParameterCCS = value;
    }

    public boolean isSetModelParameterCCS() {
        return (this.modelParameterCCS!= null);
    }

    /**
     * Obtient la valeur de la propriété modelParameterPTM.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterPTM }
     *     
     */
    public ModelParameterPTM getModelParameterPTM() {
        return modelParameterPTM;
    }

    /**
     * Définit la valeur de la propriété modelParameterPTM.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterPTM }
     *     
     */
    public void setModelParameterPTM(ModelParameterPTM value) {
        this.modelParameterPTM = value;
    }

    public boolean isSetModelParameterPTM() {
        return (this.modelParameterPTM!= null);
    }

    /**
     * Obtient la valeur de la propriété modelParameterFB.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterFB }
     *     
     */
    public ModelParameterFB getModelParameterFB() {
        return modelParameterFB;
    }

    /**
     * Définit la valeur de la propriété modelParameterFB.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterFB }
     *     
     */
    public void setModelParameterFB(ModelParameterFB value) {
        this.modelParameterFB = value;
    }

    public boolean isSetModelParameterFB() {
        return (this.modelParameterFB!= null);
    }
    
    /**
     * Obtient la valeur de la propriété modelParameterBMA.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterBMA }
     *     
     */
    public ModelParameterBMA getModelParameterBMA() {
        return modelParameterBMA;
    }

    /**
     * Définit la valeur de la propriété modelParameterBMA.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterBMA }
     *     
     */
    public void setModelParameterBMA(ModelParameterBMA value) {
        this.modelParameterBMA = value;
    }

    public boolean isSetModelParameterBMA() {
        return (this.modelParameterBMA!= null);
    }
    
    /**
     * Obtient la valeur de la propriété modelParameterBMA.
     * 
     * @return
     *     possible object is
     *     {@link ModelParameterBMA }
     *     
     */
    public ModelParameterCalibratedIDM getModelParameterCalibratedIDM() {
        return modelParameterCalibratedIDM;
    }

    /**
     * Définit la valeur de la propriété modelParameterBMA.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelParameterBMA }
     *     
     */
    public void setModelParameterCalibratedIDM(ModelParameterCalibratedIDM value) {
        this.modelParameterCalibratedIDM = value;
    }

    public boolean isSetModelParameterCalibratedIDM() {
        return (this.modelParameterCalibratedIDM!= null);
    }

}
