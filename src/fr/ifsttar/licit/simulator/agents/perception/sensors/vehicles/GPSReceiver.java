package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles;

import java.util.Random;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadNetwork;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.GPSMeasurement;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.Measurement;
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
@XmlRootElement(name = "GPSReceiver")
public class GPSReceiver extends MeasurementSensor{

	public GPSReceiver(){
		super();
	}
	
	public GPSReceiver(double reliability){
		super(reliability);
	}

	@Override
	protected Measurement measure(Vehicle me, LaneSegment laneSegment,
			RoadSegment roadSegment, RoadNetwork roadNetwork, double simulationTime) {

//      ------------------------------------------------------------
//
		final double perfectMeasure = me.getFrontPosition();
		
		//System.out.println(this.reliability);
		
		final double error = (1.0 - this.reliability) * 30;
		
		final double standardDeviation = /*perfectMeasure* */error;
		
		final Random rnd = new Random();
		final double gaussianNoise = rnd.nextGaussian() * standardDeviation;
		

		final double position= perfectMeasure + gaussianNoise;
//
//      ------------------------------------------------------------
		
		
		//return new GPSMeasurement(me.getId(), me.getFrontPosition(), me.getSpeed(), me.lane());
		
		return new GPSMeasurement(me.getId(), position, me.getSpeed(), me.lane());
		
	}
	
	
}
