package fr.ifsttar.licit.simulator.agents.communication.messages;

import java.util.Date;

import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.Agent;
import fr.ifsttar.licit.simulator.infrastructure.RoadSideUnit;

/**
 * 
 * Message is an object holding an information sent by an agent at a given time step.
 * 
 * TODO : add many comments
 * 
 * @author gueriau
 *
 */
public abstract class Message {

	/**
	 * The message send
	 */
protected long idSender = -1;
protected int  laneSender = -1;
protected double positionSender = -1;
	
	/**
	 * The time when the message was created
	 */
	protected Date time = new Date();

	/**
	 * The time when the message will be outdated
	 */
	private Date expiration = new Date();
	
	public Message(){
		
	}
	
	/**
	 * 
	 * @param sender
	 */
	public Message(Vehicle sender){
		idSender = sender.getId();
		laneSender = sender.getLane();
		this.expiration.setTime(Long.MAX_VALUE);
		positionSender = sender.getFrontPosition();
	}
	
	/**
	 * 
	 * @param sender
	 * @param expiration
	 */
	public Message(Vehicle sender, Date expiration){
		this(sender);
		this.expiration = expiration;
	}
	
	/**
	 * 
	 * @param sender
	 * @param expirationInMilliseconds
	 */
	public Message(Vehicle sender, long expirationInMilliseconds){
		this(sender);
		this.expiration.setTime(this.expiration.getTime()+ expirationInMilliseconds);
	}
	
	public Message(RoadSideUnit sender) {
		idSender = sender.getId();
		this.expiration.setTime(Long.MAX_VALUE);

	}

	/**
	 * Get the message creation time
	 * 
	 * @return the message creation time
	 */
	
	public int getLaneSender(){
		return laneSender;
	}
	
	public double getPositionSender(){
		return positionSender;
	}
	
	public Date getTime() {
		return time;
	}

	/**
	 * 
	 * @return the message sender
	 */
/*	public Vehicle getSender() {
		return sender;
	}
*/	
	public boolean isOutDated(){
		return this.time.after(this.expiration);
	}

	public long getIdSender() {
		// TODO Auto-generated method stub
		return idSender;
	}
		
}
