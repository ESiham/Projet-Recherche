package fr.ifsttar.licit.simulator.agents.trust.models.base;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import fr.ifsttar.licit.simulator.agents.trust.models.parameters.TrustModelParameterFire;
import fr.ifsttar.licit.simulator.agents.trust.models.parameters.TrustModelParameterNoTrust;
import fr.ifsttar.licit.simulator.agents.trust.models.parameters.TrustModelParameterTrustNet;


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
*         &lt;element ref="{}trustModelNoTrust" minOccurs="0"/>
*         &lt;element ref="{}trustModelTrustNet" minOccurs="0"/>
*         &lt;element ref="{}trustModelFire" minOccurs="0"/>
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
 "trustModelParameterNoTrust",
 "trustModelParameterTrustNet",
 "trustModelParameterFire"
})
@XmlRootElement(name = "TrustModelType")
public class TrustModelType
 implements Serializable
{

 private final static long serialVersionUID = 1L;
 @XmlElement(name = "TrustModelNoTrust")
 protected TrustModelParameterNoTrust trustModelParameterNoTrust;
 @XmlElement(name = "TrustModelTrustNet")
 protected TrustModelParameterTrustNet trustModelParameterTrustNet;
 @XmlElement(name = "TrustModelFire")
 protected TrustModelParameterFire trustModelParameterFire;
 
 
 
public TrustModelParameterNoTrust getTrustModelParameterNoTrust() {
	return trustModelParameterNoTrust;
}

public void setTrustModelNoTrust(TrustModelParameterNoTrust trustModelParameterNoTrust) {
	this.trustModelParameterNoTrust = trustModelParameterNoTrust;
}

public boolean isSetTrustModelNoTrust(){
	return (this.trustModelParameterNoTrust!= null);
}

public TrustModelParameterTrustNet getTrustModelParameterTrustNet() {
	return trustModelParameterTrustNet;
}

public void setTrustModelTrustNet(TrustModelParameterTrustNet trustModelParameterTrustNet) {
	this.trustModelParameterTrustNet = trustModelParameterTrustNet;
}

public boolean isSetTrustModelTrustNet(){
	return (this.trustModelParameterTrustNet!= null);
}

public TrustModelParameterFire getTrustModelFire() {
	return trustModelParameterFire;
}

public void setTrustModelFire(TrustModelParameterFire trustModelParameterFire) {
	this.trustModelParameterFire = trustModelParameterFire;
}

public boolean isSetTrustModelFire(){
	return (this.trustModelParameterFire!= null);
}

}
