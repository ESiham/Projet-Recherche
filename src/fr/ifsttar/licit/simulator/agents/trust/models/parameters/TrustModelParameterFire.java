package fr.ifsttar.licit.simulator.agents.trust.models.parameters;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrustModelFire")
public class TrustModelParameterFire  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7649769238245146457L;

}

//
//Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
//Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//Généré le : 2013.12.13 à 09:11:31 AM CET 
//

//
//package org.movsim.autogen;
//
//import java.io.Serializable;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;
//import org.movsim.simulator.vehicles.longitudinalmodel.acceleration.parameter.IModelParameterIDM;
//
//
///**
//* <p>Classe Java pour anonymous complex type.
//* 
//* <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
//* 
//* <pre>
//* &lt;complexType>
//*   &lt;complexContent>
//*     &lt;extension base="{}BasicModelParameter">
//*       &lt;attribute name="s1" type="{}nonNegativeDouble" default="0" />
//*       &lt;attribute name="T" use="required" type="{}nonNegativeDouble" />
//*       &lt;attribute name="a" use="required" type="{}nonNegativeDouble" />
//*       &lt;attribute name="b" use="required" type="{}nonNegativeDouble" />
//*       &lt;attribute name="delta" type="{}nonNegativeDouble" default="4" />
//*     &lt;/extension>
//*   &lt;/complexContent>
//* &lt;/complexType>
//* </pre>
//* 
//* 
//*/
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "")
//@XmlRootElement(name = "ModelParameterIDM")
//public class ModelParameterIDM
// extends BasicModelParameter
// implements Serializable, IModelParameterIDM
//{
//
// private final static long serialVersionUID = 1L;
// @XmlAttribute(name = "s1")
// protected Double s1;
// @XmlAttribute(name = "T", required = true)
// protected double t;
// @XmlAttribute(name = "a", required = true)
// protected double a;
// @XmlAttribute(name = "b", required = true)
// protected double b;
// @XmlAttribute(name = "delta")
// protected Double delta;
//
// /**
//  * Obtient la valeur de la propriété s1.
//  * 
//  * @return
//  *     possible object is
//  *     {@link Double }
//  *     
//  */
// public double getS1() {
//     if (s1 == null) {
//         return  0.0D;
//     } else {
//         return s1;
//     }
// }
//
// /**
//  * Définit la valeur de la propriété s1.
//  * 
//  * @param value
//  *     allowed object is
//  *     {@link Double }
//  *     
//  */
// public void setS1(double value) {
//     this.s1 = value;
// }
//
// public boolean isSetS1() {
//     return (this.s1 != null);
// }
//
// public void unsetS1() {
//     this.s1 = null;
// }
//
// /**
//  * Obtient la valeur de la propriété t.
//  * 
//  */
// public double getT() {
//     return t;
// }
//
// /**
//  * Définit la valeur de la propriété t.
//  * 
//  */
// public void setT(double value) {
//     this.t = value;
// }
//
// public boolean isSetT() {
//     return true;
// }
//
// /**
//  * Obtient la valeur de la propriété a.
//  * 
//  */
// public double getA() {
//     return a;
// }
//
// /**
//  * Définit la valeur de la propriété a.
//  * 
//  */
// public void setA(double value) {
//     this.a = value;
// }
//
// public boolean isSetA() {
//     return true;
// }
//
// /**
//  * Obtient la valeur de la propriété b.
//  * 
//  */
// public double getB() {
//     return b;
// }
//
// /**
//  * Définit la valeur de la propriété b.
//  * 
//  */
// public void setB(double value) {
//     this.b = value;
// }
//
// public boolean isSetB() {
//     return true;
// }
//
// /**
//  * Obtient la valeur de la propriété delta.
//  * 
//  * @return
//  *     possible object is
//  *     {@link Double }
//  *     
//  */
// public double getDelta() {
//     if (delta == null) {
//         return  4.0D;
//     } else {
//         return delta;
//     }
// }
//
// /**
//  * Définit la valeur de la propriété delta.
//  * 
//  * @param value
//  *     allowed object is
//  *     {@link Double }
//  *     
//  */
// public void setDelta(double value) {
//     this.delta = value;
// }
//
// public boolean isSetDelta() {
//     return (this.delta!= null);
// }
//
// public void unsetDelta() {
//     this.delta = null;
// }
//
//}

