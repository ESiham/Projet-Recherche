package fr.ifsttar.licit.simulator.agents.perception;

import java.util.LinkedList;

import fr.ifsttar.licit.simulator.agents.communication.messages.Message;

public abstract class AgentPerception implements Perception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5567499261201811619L;
	
	/**
	 * Perceived messages
	 */
	protected LinkedList<Message> messages = new LinkedList<Message>();


	/**
	 * Merge the given perception with the current object
	 * 
	 *  @param perception
	 */
	public final void merge(AgentPerception perception){
		if(perception!=null){
			this.messages.addAll(perception.messages);
			this.mergeObjects(perception);
		}
	}
	
	/**
	 * 
	 * @param perception
	 */
	protected abstract void mergeObjects(AgentPerception perception);

	
	/**
	 * Add the message to current perception
	 * 
	 * @param message
	 */
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	
	/**
	 * Get all perceived messages
	 */
	public LinkedList<Message> getMessages(){
		return messages;
	}
	
}
