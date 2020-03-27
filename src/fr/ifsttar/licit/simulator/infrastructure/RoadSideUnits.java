package fr.ifsttar.licit.simulator.infrastructure;

//
//Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
//Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//Généré le : 2013.12.13 à 09:11:31 AM CET 
//


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
*         &lt;element ref="{}RoadSideUnit" maxOccurs="unbounded" minOccurs="0"/>
*       &lt;/sequence>
*       &lt;attribute name="sample_interval" type="{}positiveDouble" default="60" />
*       &lt;attribute name="logging" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
*       &lt;attribute name="logging_lanes" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
 "rsu"
})
@XmlRootElement(name = "RoadSideUnits")
public class RoadSideUnits
 implements Serializable
{

 private final static long serialVersionUID = 1L;
 @XmlElement(name = "RoadSideUnit")
 protected List<RoadSideUnit> rsu;
 /*@XmlAttribute(name = "position")
 protected Double position;
 @XmlAttribute(name = "range")
 protected Double range;
 @XmlAttribute(name = "externalControl")
 protected boolean externalControl;*/

 /**
  * Gets the value of the rsu property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the JAXB object.
  * This is why there is not a <CODE>set</CODE> method for the rsu property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getRoadSideUnit().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link RoadSideUnit }
  * 
  * 
  */
 public List<RoadSideUnit> getRoadSideUnit() {
     if (rsu == null) {
         rsu = new ArrayList<RoadSideUnit>();
     } else {
    	 
     }
     return this.rsu;
 }

 public boolean isSetRoadSideUnit() {
     return ((this.rsu!= null)&&(!this.rsu.isEmpty()));
 }

 public void unsetRoadSideUnit() {
     this.rsu = null;
 }

 /**
  * Obtient la valeur de la propriété sampleInterval.
  * 
  * @return
  *     possible object is
  *     {@link Double }
  *     
  */
 /*public double getPosition() {
     if (position == null) {
         return  0.0D;
     } else {
         return position;
     }
 }*/

 /**
  * Définit la valeur de la propriété sampleInterval.
  * 
  * @param value
  *     allowed object is
  *     {@link Double }
  *     
  */
 /*public void setPosition(double value) {
     this.position = value;
 }

 public boolean isSetPosition() {
     return (this.position!= null);
 }

 public void unsetPosition() {
     this.position = null;
 }*/
 
 /**
  * Obtient la valeur de la propriété sampleInterval.
  * 
  * @return
  *     possible object is
  *     {@link Double }
  *     
  */
/* public double getRange() {
     if (range == null) {
         return  0.0D;
     } else {
         return range;
     }
 }*/

 /**
  * Définit la valeur de la propriété sampleInterval.
  * 
  * @param value
  *     allowed object is
  *     {@link Double }
  *     
  */
 /*public void setRange(double value) {
     this.range = value;
 }

 public boolean isSetRange() {
     return (this.range!= null);
 }

 public void unsetRange() {
     this.range = null;
 }
 */
 /**
  * Définit la valeur de la propriété sampleInterval.
  * 
  * @param value
  *     allowed object is
  *     {@link Double }
  *     
  */
 /*public void setExternalControl(boolean externalControl) {
     this.externalControl = externalControl;
 }

 public boolean isSetExternalControl() {
     return (this.externalControl!= true);
 }

 public void unsetExternalControl() {
     this.externalControl = false;
 }*/


}
