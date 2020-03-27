package fr.ifsttar.licit.simulator.agents.perception.sensors;

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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.CommunicationDevice;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.Driver;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.GPSReceiver;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.SuperSensor;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.Telemeter;


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
*         &lt;element ref="{}Telemeter" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element ref="{}GPSReceiver" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element ref="{}CommunicationDevice" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element ref="{}SuperSensor" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element ref="{}Driver" maxOccurs="unbounded" minOccurs="0"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlSeeAlso({
	 Telemeter.class,
	 GPSReceiver.class,
     CommunicationDevice.class,
     SuperSensor.class,
     Driver.class
})
@XmlRootElement(name = "Sensors")
public class Sensors
 implements Serializable
{

 private final static long serialVersionUID = 1L;
 
 
 @XmlElement(name = "Telemeter")
 protected List<Telemeter> telemeters;

 @XmlElement(name = "GPSReceiver")
 protected List<GPSReceiver> gpsReceivers;
 
 @XmlElement(name = "CommunicationDevice")
 protected List<CommunicationDevice> communicationDevices;
 
 @XmlElement(name = "SuperSensor")
 protected List<SuperSensor> superSensors;
 
 @XmlElement(name = "Driver")
 protected List<Driver> drivers;
 
 
 public List<Sensor> getSensors(){
	 List<Sensor> sensors = new ArrayList<Sensor>();
	 
	 if(this.telemeters!=null)
		 sensors.addAll(telemeters);
	 
	 if(this.gpsReceivers!=null)
		 sensors.addAll(gpsReceivers);
	 
	 if(this.communicationDevices!=null)
		 sensors.addAll(communicationDevices);
	 
	 if(this.superSensors!=null)
		 sensors.addAll(superSensors);
	 
	 if(this.drivers!=null)
		 sensors.addAll(drivers);
	 
	 return sensors;
 }
 

}
