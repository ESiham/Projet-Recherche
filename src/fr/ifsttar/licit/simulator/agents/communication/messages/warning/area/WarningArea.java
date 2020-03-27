package fr.ifsttar.licit.simulator.agents.communication.messages.warning.area;

public abstract class WarningArea {

	public abstract boolean isRelevant(double myPosition);
	
	public abstract double getDistanceTo(double myPosition);
	
	public abstract double getBroadcastDistance(double myPosition);
	
}
