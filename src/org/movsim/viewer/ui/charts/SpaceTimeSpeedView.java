package org.movsim.viewer.ui.charts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JCheckBoxMenuItem;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.movsim.output.route.FileTrajectories;
import org.movsim.viewer.ui.charts.model.FloatingCarDataPoint;
import org.movsim.viewer.ui.charts.model.data.FloatingCarData;
import org.movsim.viewer.ui.charts.model.data.sets.SpaceTimeSpeedDataSet;
import org.movsim.viewer.ui.charts.util.GradientPaintScale;

public class SpaceTimeSpeedView extends ChartView {

	private static final long serialVersionUID = -9103041401880018405L;

	private SpaceTimeSpeedDataSet dataSet;
	
	private FileTrajectories traj;
	
	private int numLanes = 0;
	
	public SpaceTimeSpeedView(SpaceTimeSpeedDataSet dataSet, JCheckBoxMenuItem cb, FileTrajectories traj, int[] lanes) {
		super(cb,traj.getRouteName(), lanes);
		this.traj=traj;
		this.numLanes=lanes.length;
		
		//this.initialize();
		
		if(dataSet!=null){
			this.dataSet = dataSet;
		} else {
			this.setLane(lanes[lanes.length-1]);
		}
		
		this.setTitle("SpatioTemporalDiagram");
	
	
		this.setSize(540, 360);
		this.setLocation(740, 0);
	}
	
	public SpaceTimeSpeedView(SpaceTimeSpeedDataSet dataSet) {
		super(null,"route",null);
		//this.traj=traj;
		//this.numLanes=lanes.length;
		
		//this.initialize();
		
		//if(dataSet!=null){
			this.dataSet = dataSet;
		//} else {
		//	this.setLane(lanes[lanes.length-1]);
		//
		
		this.setTitle("SpatioTemporalDiagram");
		
		
		this.initialize();
		
		//System.out.println(this.dataSet.getCarsData().size());
	}


	@Override
	protected JFreeChart createChart() {
	
        final NumberAxis xAxis = new NumberAxis(this.dataSet.getXLabel()); 
        // xAxis.setLabelFont(getFont().deriveFont(Font.BOLD));
        //xAxis.setRange(0, cols);

        final NumberAxis yAxis = new NumberAxis(this.dataSet.getYLabel());
        // yAxis.setLabelFont(getFont().deriveFont(Font.BOLD));
        //yAxis.setRange(0, rows);

        //xyzSet = new XYZArrayDataset(data);
        //final XYPlot plot = new XYPlot(xyzSet, xAxis, yAxis, null);
        final XYPlot plot = new XYPlot(dataSet, xAxis, yAxis, null);
        
        /*final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(createYTickUnits());

        final NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setStandardTickUnits(createXTickUnits());
*/
        final XYBlockRenderer r = new XYBlockRenderer();

        // Use own implementation of a gradient paintScale
        final PaintScale ps = new GradientPaintScale(-0.001, 90.0);
        r.setPaintScale(ps);
        r.setBlockHeight(3.0f);
        r.setBlockWidth(3.0f);

        plot.setRenderer(r);

        final JFreeChart chart = new JFreeChart(null, JFreeChart.DEFAULT_TITLE_FONT, plot, false);

        
        chart.setBackgroundPaint(getBackground());

        // color scale
        final NumberAxis scaleAxis = new NumberAxis(this.dataSet.getZLabel()); // TODO Legend sp
        //scaleAxis.setTickLabelFont(getFont().deriveFont());
        // scaleAxis.setLabelFont(getFont().deriveFont(Font.BOLD));

        final PaintScaleLegend legend = new PaintScaleLegend(ps, scaleAxis);
        legend.setAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        legend.setPadding(new RectangleInsets(10, 10, 10, 10));
        legend.setStripWidth(15);
        legend.setPosition(RectangleEdge.RIGHT);
        legend.setBackgroundPaint(getBackground());

        chart.addSubtitle(legend);

        chart.setTitle(this.dataSet.getTitle());
        
        return chart;
	}


	@Override
	protected void saveData(File dataFile) {
		try
		{
		    FileWriter writer = new FileWriter(dataFile);
	 
		    writer.append("Vehicle ID");
			writer.append(";");
			writer.append("Time (s)");
			writer.append(";");
			writer.append("Position (m)");
			writer.append(";");
			writer.append("Speed (m/s)");
			writer.append('\n');
		    
		    for(FloatingCarData carData : this.dataSet.getCarsData()){
		    	for(FloatingCarDataPoint point : carData.getFloatingCarDataPoints()){
				writer.append(""+carData.getVehicleID());
				writer.append(";");
				writer.append(""+point.getTime());
				writer.append(";");
				writer.append(""+point.getPosition());
				writer.append(";");
				writer.append(""+point.getSpeed()/3.6);
				writer.append('\n');
		    	}
		    }
		    
		    writer.flush();
		    writer.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 
	}


	@Override
	protected void onExit() {
		if(this.traj!=null){
			this.traj.removeSpaceTimeSpeedDataSet();
		}
	}


	@Override
	protected void setLane(int lane) {
		this.dataSet = traj.getSpaceTimeSpeedDataSet(lane);

		String laneLabel = " on ";
		if(numLanes==1){
			laneLabel="";
		} else if(numLanes==2){
			switch(lane){
				case 1: laneLabel += "right lane "; break;
				case 2: laneLabel += "left lane "; break;
				default : laneLabel += "lane "+lane; break;
			}
		} else if(numLanes==3){
			//System.out.println(" == 3 ");
			switch(lane){
			case 1: laneLabel += "left lane "; break;
			case 2: laneLabel += "center lane "; break;
			case 3: laneLabel += "right lane "; break;
			default : laneLabel += "lane "+lane; break;
			}
		} else {
			laneLabel+= "lane " + lane;
		}
		
		String title = "Vehicles trajectories" + laneLabel;
		this.dataSet.setTitle(title);
		
		
		this.initialize();
		
		this.changeTitle(title);
	}
	
}
