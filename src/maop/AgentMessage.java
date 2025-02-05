package maop;

import java.util.HashMap;

import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.communication.messages.Message;

public class AgentMessage extends Message {
	
	private String subject;
	private String performative;
	private HashMap <String, Object> content;
	
	public AgentMessage(Vehicle sender, String subject, String performative, HashMap <String, Object> content){
		super(sender);
		this.subject = subject;
		this.performative = performative;
		if (content == null)
			this.content = new HashMap<String, Object>();
		else
			this.content = content; 
	}
	@Override
	public String toString() {
		return "AgentMessage [subject=" + subject + ", performative=" + performative + ", content=" + content
				+ ", idSender=" + idSender + ", laneSender=" + laneSender + ", positionSender=" + positionSender + "]";
	}
	public AgentMessage(Vehicle sender, String subject, String performative){
		this(sender,subject,performative,null);
	}
	
	public void addContent(String key, Object value) {
		content.put(key, value);
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPerformative() {
		return performative;
	}
	public void setPerformative(String performative) {
		this.performative = performative;
	}
	public HashMap<String, Object> getContent() {
		return content;
	}
	public void setContent(HashMap<String, Object> content) {
		this.content = content;
	}
	
	

}
