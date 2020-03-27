package maop;

import java.util.ArrayList;

import fr.ifsttar.licit.simulator.agents.communication.messages.Message;
import fr.ifsttar.licit.simulator.agents.perception.representation.SensedVehicle;

public class SensedVehicleAgent extends SensedVehicle {

	private ArrayList<Message> messages;
	
	public SensedVehicleAgent(long senderId, double deltaX, double deltaV, double absoluteX, double absoluteV,
			double deltaXglobal, double deltaVglobal) {
		super(senderId, deltaX, deltaV, absoluteX, absoluteV, deltaXglobal, deltaVglobal);
	messages = new ArrayList<Message>();
	}
	
	public SensedVehicleAgent(long senderId) {
		super(senderId);
	messages = new ArrayList<Message>();
	}
	
	public void completeSensedVehicle( double deltaX, double deltaV, double absoluteX, double absoluteV,
			double deltaXglobal, double deltaVglobal) {
		setRelativePosition(deltaX);
		setRelativeVelocity(deltaV);
		setAbsoluteX(absoluteX);
		setAbsoluteV(absoluteV);
		setDeltaX(deltaXglobal);
		setDeltaV(deltaVglobal);
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}
	
	public void addMessage(Message m) {
		messages.add(m);
	}

}
