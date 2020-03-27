package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.perception.vehicles.VehiclePerception;

/**
 * Super Sensor represents an imaginary sensor able to perceive the first vehicle in current, right and left lanes of current vehicle
 * 
 * This sensor should evolve to a reality closer sensor (i.e. a laser telemeter)
 * 
 * @author gueriau
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
@XmlRootElement(name = "SuperSensor")
public class SuperSensor extends VehicleSensor{

	public SuperSensor(double reliability){
		super(reliability);
	}
	
	public SuperSensor(){
		super();
	}
	
	@Override
	public VehiclePerception perceive(Vehicle me, LaneSegment laneSegment, RoadSegment roadSegment, double simulationTime) {
		
		VehiclePerception perception = new VehiclePerception();
		
		perception.setFrontVehicle(laneSegment.frontVehicle(me));
		perception.setRearVehicle(laneSegment.rearVehicle(me.getRearPosition()-0.01));
		/*final LaneSegment leftLane = roadSegment.getLeftLane(me.lane());
		final LaneSegment rightLane = roadSegment.getRightLane(me.lane());
		
		if(leftLane!=null)
		perception.setLeftVehicle(leftLane.frontVehicle(me));
		if(rightLane!=null)
		perception.setRightVehicle(rightLane.frontVehicle(me));*/
		
		return perception;
	}

}
