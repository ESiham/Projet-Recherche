package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles;

import java.util.Random;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadNetwork;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.Measurement;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.TelemeterMeasurement;

/**
 * Telemeter sensor class. This is a sensor which senses the immediate distance from next leader
 * 
 * @author mgueriau
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
 *    	&lt;attribute name="range" type="{}nonNegativeDouble" default="80.0" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Telemeter")
public class Telemeter extends MeasurementSensor{

	/**
	 * Maximum linear perception range of this sensor in meters
	 */
	@XmlAttribute(name = "range")
	protected double range = 100.d;
	
	public Telemeter(){
		super();
		
		//System.out.println("Telemeter  = " + this.range );
	}
	
	public Telemeter(double range){
		super();
		this.range = range;
	}
	
	public Telemeter(double range, double reliability){
		super(reliability);
		this.range = range;
	}

	@Override
	protected Measurement measure(Vehicle me, LaneSegment laneSegment,
			RoadSegment roadSegment, RoadNetwork roadNetwork, double simulationTime) {
		
		final Vehicle frontVehicle = laneSegment.frontVehicle(me);
		
		double deltaX = this.range;
		double deltaV = 0.d;
		
		if(frontVehicle!=null && me.getNetDistance(frontVehicle)<this.range){
			
			
			final double perfectMeasure = me.getNetDistance(frontVehicle);
			
			final double error = (1.0 - this.reliability);
			
			final double standardDeviation = perfectMeasure*error;
			
			
			//final double random =  (0.5 - Math.random())*2;
			
			//final double randomError =  1.0 + random * error;
			
			final Random rnd = new Random();
			final double gaussianNoise = rnd.nextGaussian() * standardDeviation;
			
			//System.out.println(randomError);
			
			//System.out.println(" before = " + me.getNetDistance(frontVehicle));
			deltaX= perfectMeasure + gaussianNoise;// + me.getNetDistance(frontVehicle)* randomError;
			
			/*System.out.println(" ---- ");
			System.out.println("Perfect    = " + perfectMeasure);
			System.out.println("With noise = " + deltaX);
			System.out.println("Ratio      = " + (deltaX / perfectMeasure));
			System.out.println(" ---- ");*/
			
			//System.out.println(" after  = " + deltaX);
			deltaV=me.getRelSpeed(frontVehicle);
			
		}
		
		return new TelemeterMeasurement(me.getId(), deltaX, deltaV);
		
	}

	public double getRange() {
		return this.range;
	}


	

}
