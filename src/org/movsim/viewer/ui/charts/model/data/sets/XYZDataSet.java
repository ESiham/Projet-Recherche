package org.movsim.viewer.ui.charts.model.data.sets;

import org.jfree.data.xy.AbstractXYZDataset;

import fr.ifsttar.licit.simulator.util.units.Unit;

public abstract class XYZDataSet extends AbstractXYZDataset/*  implements SimulationRunnable.UpdateDrawingCallback*/ {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6697152580177719783L;

	protected String XAxisLabel = "X label";
	protected Unit XAxisUnit = Unit.Unknown;
	
	protected String YAxisLabel = "Y label";
	protected Unit YAxisUnit = Unit.Unknown;
	
	protected String ZAxisLabel = "Z label";
	protected Unit ZAxisUnit = Unit.Unknown;
	
	protected String title = "Title";
	
	
	//protected final RoadSegment roadSegment;

	//private SimulationRunnable simulationRunnable;
	
	public XYZDataSet(/*Simulator simulator, final RoadSegment roadSegment, */String title, String xString, Unit xUnit, String yString, Unit yUnit, String zString, Unit zUnit){
		
		//this.simulationRunnable = simulator.getSimulationRunnable();
		//simulationRunnable.addUpdateDrawingCallback(this);
		//this.roadSegment = roadSegment;
		
		
		this.title=title;
		this.XAxisLabel=xString;
		this.XAxisUnit=xUnit;
		this.YAxisLabel=yString;
		this.YAxisUnit=yUnit;
		this.ZAxisLabel=zString;
		this.ZAxisUnit=zUnit;
	}
	
	//public void removeDataSet(){
	//	simulationRunnable.removeUpdateDrawingCallback(this);
	//}
	
	
	public String getXLabel(){
		return this.XAxisLabel + " ("+this.XAxisUnit.getAbbreviation()+")";
	}
	
	public String getYLabel(){
		return this.YAxisLabel + " ("+this.YAxisUnit.getAbbreviation()+")";
	}
	
	public String getZLabel(){
		return this.ZAxisLabel + " ("+this.ZAxisUnit.getAbbreviation()+")";
	}
	
	/*public String getXAxisLabel() {
		return XAxisLabel;
	}
	public Unit getXAxisUnit() {
		return XAxisUnit;
	}
	public String getYAxisLabel() {
		return YAxisLabel;
	}
	public Unit getYAxisUnit() {
		return YAxisUnit;
	}
	public String getZAxisLabel() {
		return ZAxisLabel;
	}
	public Unit getZAxisUnit() {
		return ZAxisUnit;
	}*/
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	
}
