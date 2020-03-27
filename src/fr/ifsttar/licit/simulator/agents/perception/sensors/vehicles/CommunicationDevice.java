package fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.movsim.roadmappings.RoadMapping;
import org.movsim.simulator.roadnetwork.LaneSegment;
import org.movsim.simulator.roadnetwork.RoadNetwork;
import org.movsim.simulator.roadnetwork.RoadSegment;
import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.Agent;
import fr.ifsttar.licit.simulator.agents.communication.messages.MeasureMessage;
import fr.ifsttar.licit.simulator.agents.communication.messages.Message;
import fr.ifsttar.licit.simulator.agents.communication.messages.TrustMessage;
import fr.ifsttar.licit.simulator.agents.communication.messages.warning.WarningMessage;
import fr.ifsttar.licit.simulator.agents.communication.messages.warning.WarningType;
import fr.ifsttar.licit.simulator.agents.communication.messages.warning.area.CircularArea;
import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.agents.perception.MeasurementPerception;
import fr.ifsttar.licit.simulator.agents.perception.sensors.Sensor;
import fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure.RSUBroadcaster;
import fr.ifsttar.licit.simulator.agents.perception.sensors.infrastructure.RSUDevice;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.GPSMeasurement;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.Measurement;
import fr.ifsttar.licit.simulator.agents.perception.sensors.vehicles.measurements.TelemeterMeasurement;
import fr.ifsttar.licit.simulator.environment.PerceptibleEnvironment;
import fr.ifsttar.licit.simulator.environment.PerceptiblePartition;
import fr.ifsttar.licit.simulator.infrastructure.RoadSideUnit;

/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}Sensor">
 *    	&lt;attribute name="range" type="{}nonNegativeDouble" default="150.0"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "CommunicationDevice")
public class CommunicationDevice extends Sensor {

	/**
	 * Maximum 2D perception radius of this sensor in meters
	 */
	@XmlAttribute(name = "range", required = true)
	public double range = 150.d;
	
	public CommunicationDevice(){
		super();
	}
	
	public CommunicationDevice(double range){
		super();
		this.range = range;
	}
	
	public CommunicationDevice(double range, double reliability){
		super(reliability);
		this.range = range;
	}
	
	
	@Override
	public AgentPerception percieve(Agent agent, PerceptiblePartition partition2, PerceptiblePartition partition1, PerceptibleEnvironment environment, double simulationTime) {
		return this.perceive((Vehicle) agent, (LaneSegment) partition2, (RoadSegment) partition1 , (RoadNetwork) environment);
	}
	
	
	public MeasurementPerception perceive(Vehicle me, LaneSegment laneSegment, RoadSegment roadSegment, RoadNetwork roadNetwork) {
		MeasurementPerception perception = new MeasurementPerception();
		
		
		if(laneSegment!=null && roadSegment!=null && roadNetwork!=null && me!=null){		
			
			/*final RoadMapping segmentRoadMapping = roadSegment.roadMapping();
			final RoadMapping.PolygonFloat mePolygon = segmentRoadMapping.mapFloat(me, 0.0);
		*/	final double mePositionX;// = mePolygon.xPoints[0];
			final double mePositionY;// = mePolygon.yPoints[0];
		
			
			if (roadSegment.roadMapping().getPosTheta().theta() == 0){ // horizontal
				mePositionX = roadSegment.roadMapping().getX0() + me.getFrontPosition();
				mePositionY = roadSegment.roadMapping().getY0();
			}else{  //vertical
				mePositionX = roadSegment.roadMapping().getX0();
				mePositionY = roadSegment.roadMapping().getY0() + me.getFrontPosition();
				
			}
			//RSU information
			for(RoadSegment segment : roadNetwork) {
				for(RoadSideUnit rsu : segment.getRSUs()){
					
					final RoadMapping rsuSegmentRoadMapping = segment.roadMapping();
					final RoadMapping.PolygonFloat rsuPolygon = rsuSegmentRoadMapping.mapFloat(me, 0.0);
			        final double rsuPositionX = rsuPolygon.xPoints[0];
			        final double rsuPositionY = rsuPolygon.yPoints[0];
					
			        final double distance = (Math.sqrt((mePositionX - rsuPositionX) * (mePositionX - rsuPositionX) + (mePositionY - rsuPositionY)*(mePositionY - rsuPositionY)));
			        
					//broadcasted information
					for(Sensor s : rsu.getSensors()){
						if(s instanceof RSUBroadcaster){
							//if(Math.abs(me.getMidPosition() - rsu.getPosition()) <= ((RSUBroadcaster) s).getRange()){
							/**
							 * new 2D version
							 */
							if(distance <= ((RSUBroadcaster) s).getRange()){
								//perception.addMessage(new SpeedRecommendationMessage(rsu, rsu.getSpeedRecommandation()));
								this.addMessagesFromRSU(me, perception, ((RSUBroadcaster) s).getBroadcastedMessages());
							}
						}
						
						if(s instanceof RSUDevice){
								//if(Math.abs(me.getMidPosition() - rsu.getPosition()) <= ((RSUDevice) s).getRange()){
								/**
								 * new 2D version
								 */
								if(distance <= ((RSUDevice) s).getRange()){
								//get messages from vehicle message to sent
									for(Message m : rsu.getMessagesToSend()){
										perception.addMessage(m);
									}
								}
							}
						}
						
				}
			}
			
			/**
			 * new version bilateral only but gets position in worldspace
			 */
			
			for(RoadSegment segment : roadNetwork){
				for(Vehicle vehicle : segment){
					if(vehicle!=null && vehicle.getId() != me.getId()){
						final RoadMapping roadMapping = segment.roadMapping();
						double neighbourPositionX=0;
						double neighbourPositionY=0;
						if (segment.roadMapping().getPosTheta().theta() == 0){ 
							neighbourPositionX = roadSegment.roadMapping().getX0() + vehicle.getFrontPosition();
							neighbourPositionY = roadSegment.roadMapping().getY0();
						}else{  //vertical
							neighbourPositionX = segment.roadMapping().getX0();
							neighbourPositionX = segment.roadMapping().getY0() + vehicle.getFrontPosition();
							
						}
				        /**
				         *  1D perception
				         */
						 final double distance = (Math.sqrt((neighbourPositionX - mePositionX) * (neighbourPositionX - mePositionX) 
								 + (neighbourPositionY - mePositionY)*(neighbourPositionY - mePositionY)));
				        /**
				         * bilateral
				         */
				       // if(vehicle.lane()==me.lane() && distance <= this.range){
				        /**
				         * multi lateral
				         */
 				        if(distance <= this.range) {
					        	this.perceive(perception, me, vehicle);
 				        }
					        	} 
				}
			}
		}
		
		return perception;
	}
	
	private void addMessagesFromRSU(Vehicle me, MeasurementPerception perception, Collection<MeasureMessage> broadcastedMessages) {
		
		for(MeasureMessage message : broadcastedMessages){
			if(message.getIdSender()!=me.getId() && message.getLaneSender() == me.lane()){
				boolean found = false;
				for(Message perceptionMessage : perception.getMessages()){
					if((perceptionMessage instanceof MeasureMessage && perceptionMessage.getIdSender() ==message.getIdSender()))
						found=true;
				}
				if(!found)
					perception.addMessage(message);
			}
		}
	}

	private void perceive(MeasurementPerception perception, Vehicle me, Vehicle vehicle, double offset) {
		
		if(perception!=null && vehicle!=null && me!=null){
			
			for(Sensor s : vehicle.getSensors()){
				if(s!=null && s instanceof CommunicationDevice){
					//get messages from vehicle message to sent
					for(Message m : vehicle.getMessagesToSend()){
						perception.addMessage(m);
					}
					if(/* pas en communication me.lane()==vehicle.lane()  && */
					 vehicle.getPerception()!=null && vehicle.getPerception() instanceof MeasurementPerception){
					
						MeasurementPerception vehiclePerception = (MeasurementPerception) vehicle.getPerception();
						
						TelemeterMeasurement teleM = null;
						GPSMeasurement gpsM = null;
						for(Measurement m : vehiclePerception.getOwnMeasurements()){
							if(m instanceof TelemeterMeasurement){
								teleM = (TelemeterMeasurement) m;
							} else if(m instanceof GPSMeasurement){
								gpsM = (GPSMeasurement) m;
							}
						}
						
						//if(teleM.getDeltaXValue()<10)
						//System.out.println(teleM.getDeltaXValue());
						
						if(teleM!=null || gpsM!=null){
							//System.out.println(teleM.getDeltaXValue());
							if(teleM==null)
								teleM = new TelemeterMeasurement(vehicle.getId(), -1.0, 0.0);
							else if(gpsM==null)
								gpsM = new GPSMeasurement(vehicle.getId(), -1.0, -1.0, 0);
							
							
							perception.addMessage(new MeasureMessage(vehicle, gpsM.getPositionValue(), gpsM.getSpeedValue(), teleM.getDeltaXValue(), teleM.getDeltaVValue(), vehicle.getLength()));
						}
					}
				}
			}
		}
	}

	private void perceive(MeasurementPerception perception, Vehicle me, Vehicle vehicle) {
		if(perception!=null && vehicle!=null && me!=null){
	
			for(Sensor s : vehicle.getSensors()){
				if(s!=null && s instanceof CommunicationDevice){
					//get messages from vehicle message to sent
					for(Message m : vehicle.getMessagesToSend()){
						perception.addMessage(m);
					}
					if(/* pas en communication me.lane()==vehicle.lane()  && */
							vehicle.getPerception()!=null && vehicle.getPerception() instanceof MeasurementPerception){
					
						MeasurementPerception vehiclePerception = (MeasurementPerception) vehicle.getPerception();
						
						TelemeterMeasurement teleM = null;
						GPSMeasurement gpsM = null;
						for(Measurement m : vehiclePerception.getOwnMeasurements()){
							if(m instanceof TelemeterMeasurement){
								teleM = (TelemeterMeasurement) m;
							} else if(m instanceof GPSMeasurement){
								gpsM = (GPSMeasurement) m;
							}
						}
						
						if(teleM!=null || gpsM!=null){
							if(teleM==null)
								teleM = new TelemeterMeasurement(vehicle.getId(), -1.0, 0.0);
							else if(gpsM==null)
								gpsM = new GPSMeasurement(vehicle.getId(), -1.0, -1.0, 0);

							perception.addMessage(new MeasureMessage(vehicle, gpsM.getPositionValue(), gpsM.getSpeedValue(), teleM.getDeltaXValue(), teleM.getDeltaVValue(), vehicle.getLength()));
						}
					}
				}
			}
		}
	}

	public double getRange() {
		return this.range;
	}
}
