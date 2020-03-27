package fr.ifsttar.licit.simulator.agents.communication.messages.warning;

import org.movsim.simulator.vehicles.Vehicle;

import fr.ifsttar.licit.simulator.agents.communication.messages.Message;
import fr.ifsttar.licit.simulator.agents.communication.messages.warning.area.WarningArea;

public class WarningMessage extends Message {

	private final WarningType warningType;
	private final WarningArea area;
	private final int lane;
	private final boolean rebroadcast;
	
	public WarningMessage(Vehicle sender, WarningType type, int lane, WarningArea area) {
		super(sender);

		this.warningType=type;
		this.area=area;
		this.lane=lane;
		this.rebroadcast=false;
	}
	
	public WarningMessage(Vehicle sender, WarningType type, int lane, WarningArea area, long expiration) {
		super(sender, expiration);
		this.warningType=type;
		this.area=area;
		this.lane=lane;
		this.rebroadcast=false;
	}
	
	public WarningMessage(Vehicle sender, WarningType type, int lane, WarningArea area, boolean rebroadcast) {
		super(sender);

		this.warningType=type;
		this.area=area;
		this.lane=lane;
		this.rebroadcast=rebroadcast;
	}
	
	public WarningMessage(Vehicle sender, WarningType type, int lane, WarningArea area, long expiration, boolean rebroadcast) {
		super(sender, expiration);
		this.warningType=type;
		this.area=area;
		this.lane=lane;
		this.rebroadcast=rebroadcast;
	}
	
	public WarningArea getArea(){
		return this.area;
	}

	public int getLane(){
		return this.lane;
	}
	
	public WarningType getType(){
		return this.warningType;
	}
	
	public boolean isRebroadcastable(){
		return this.rebroadcast;
	}
	
}
