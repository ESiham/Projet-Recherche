package fr.ifsttar.licit.simulator.agents.communication.messages.warning.area;

public class CircularArea extends WarningArea {

	private final double position;
	
	private final double radius;
	
	public CircularArea(double position, double radius){
		this.position=position;
		this.radius=radius;
	}

	@Override
	public boolean isRelevant(double myPosition) {
	
		return (((position - myPosition) > 0) &&  (Math.abs(myPosition - position) < radius) );
	}

	
	@Override
	public double getDistanceTo(double myPosition) {
		return (Math.abs(myPosition - position));
	}

	@Override
	public double getBroadcastDistance(double myPosition) {
		if(isRelevant(myPosition)){
			return 0;
		} else {
			return Math.abs((getDistanceTo(myPosition) - radius));
		}	
	}


}
