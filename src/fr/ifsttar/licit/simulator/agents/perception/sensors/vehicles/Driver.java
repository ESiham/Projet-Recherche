package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.perception.vehicles.VehiclePerception;

/***
 * Senses the immediate front leader
 * 
 * FIXME : should not get full information from leader vehicle (only deltaV, deltaX)
 * 
 * @author Maxime
 *
 */
/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}Sensor">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Driver")
public class Driver extends VehicleSensor {

	
	@Override
	public VehiclePerception perceive(Vehicle me, LaneSegment laneSegment, RoadSegment roadSegment, double simulationTime) {
		
		VehiclePerception perception = new VehiclePerception();
		
		perception.setFrontVehicle(laneSegment.frontVehicle(me));
		
		return perception;
		
	}

}
