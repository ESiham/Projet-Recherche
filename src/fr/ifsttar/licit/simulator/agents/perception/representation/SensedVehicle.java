package fr.ifsttar.licit.simulator.agents.perception.representation;

import java.awt.Color;

public class SensedVehicle implements Comparable<SensedVehicle>, Cloneable {

	private/* final*/ long senderId;
	
	private double relativePosition;
	
	private double relativeVelocity;
	
	public void setRelativePosition(double relativePosition) {
		this.relativePosition = relativePosition;
	}


	public void setRelativeVelocity(double relativeVelocity) {
		this.relativeVelocity = relativeVelocity;
	}


	private double absoluteX;
	
	public void setAbsoluteX(double absoluteX) {
		this.absoluteX = absoluteX;
	}


	public void setAbsoluteV(double absoluteV) {
		this.absoluteV = absoluteV;
	}


	public void setDeltaX(double deltaX) {
		this.deltaX = deltaX;
	}


	public void setDeltaV(double deltaV) {
		this.deltaV = deltaV;
	}

	private double absoluteV;
	
	private double deltaX;
	
	private double deltaV;

	
	
	private SensedVehicle(){
		this.senderId = -1;
		this.relativePosition=-1;
		this.relativeVelocity=-1;
		this.absoluteX=-1;
		this.absoluteV=-1;
		this.deltaX = -1;
		this.deltaV = -1;
	}
	
	public SensedVehicle(long senderId, double deltaX, double deltaV, double absoluteX, double absoluteV, double deltaXglobal, double deltaVglobal){
		this.senderId = senderId;
		this.relativePosition=deltaX;
		this.relativeVelocity=deltaV;
		this.absoluteX=absoluteX;
		this.absoluteV=absoluteV;
		this.deltaX = deltaXglobal;
		this.deltaV = deltaVglobal;
	}
	
	public SensedVehicle(long senderId, double x, int rank){
		this();
		this.senderId = senderId;
		this.absoluteX=x;
		}
	
	public SensedVehicle(long senderId){
		this();
		this.senderId = senderId;
		}
	

@Override
	public String toString() {
		return "SensedVehicle [senderId=" + senderId + ", relativePosition="
				+ relativePosition + ", relativeVelocity=" + relativeVelocity
				+ ", absoluteX=" + absoluteX + ", absoluteV=" + absoluteV
				+ ", deltaX=" + deltaX + ", deltaV=" + deltaV + "]";
	}


	/*	@Override
	public String toString(){
		return "sendID:" + senderId + " absoluteX: "+absoluteX +" relativeVelocity:" + relativeVelocity;
	}
*/	
	public double getRelativePosition() {
		return relativePosition;
	}

	public double getRelativeVelocity() {
		return relativeVelocity;
	}

	@Override
	public int compareTo(SensedVehicle v1) {
		final double localDeltaX1 = v1.relativePosition; 
		final double localDeltaX2 = this.relativePosition;
		 if (localDeltaX1 > localDeltaX2)  return -1; 
	      else if(localDeltaX1 == localDeltaX2) return 0; 
	      else return 1; 
	}
	
	@Override 
	public SensedVehicle clone(){
		return new SensedVehicle(this.senderId, this.relativePosition, this.relativeVelocity, this.absoluteX, this.absoluteV, this.deltaX, this.deltaV);
	}


	public double getAbsoluteX() {
		return absoluteX;
	}


	public double getAbsoluteV() {
		return absoluteV;
	}


	public long getSenderId() {
		return senderId;
	}
	
	public void setSenderId(long id) {
		this.senderId=id;
	}


	public double getDeltaX() {
		return deltaX;
	}

	
	public double getDeltaV() {
		return deltaV;
	}

}
