package org.movsim.viewer.ui.charts.model.data.sets;

import org.jfree.data.xy.AbstractXYDataset;

import fr.ifsttar.licit.simulator.util.units.Unit;

public abstract class XYDataSet extends AbstractXYDataset/*  implements SimulationRunnable.UpdateDrawingCallback*/ {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6697152580177719783L;

	protected String XAxisLabel = "X label";
	protected Unit XAxisUnit = Unit.Unknown;
	
	protected String YAxisLabel = "Y label";
	protected Unit YAxisUnit = Unit.Unknown;

	protected String title = "Title";
	
	
	public XYDataSet(String title, String xString, Unit xUnit, String yString, Unit yUnit){
	
		this.title=title;
		this.XAxisLabel=xString;
		this.XAxisUnit=xUnit;
		this.YAxisLabel=yString;
		this.YAxisUnit=yUnit;

	}
	
	public String getXLabel(){
		return this.XAxisLabel + " ("+this.XAxisUnit.getAbbreviation()+")";
	}
	
	public String getYLabel(){
		return this.YAxisLabel + /*" ("+*/this.YAxisUnit.getAbbreviation()/*+")"*/;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	
}
