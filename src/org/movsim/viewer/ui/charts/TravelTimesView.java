package org.movsim.viewer.ui.charts;

import java.io.File;

import javax.swing.JCheckBoxMenuItem;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.GrayPaintScale;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.movsim.output.route.FileTravelTimes;
import org.movsim.viewer.ui.charts.model.data.sets.TravelTimesDataSet;

public class TravelTimesView extends ChartView {

	private static final long serialVersionUID = -9103041401880018405L;

	private TravelTimesDataSet dataSet;
	
	private FileTravelTimes travelTimesFile;
	
	//private int numLanes = 0;
	
	public TravelTimesView(TravelTimesDataSet dataSet, JCheckBoxMenuItem cb, FileTravelTimes travelTimesFile) {
		super(cb,travelTimesFile.getRouteName(), null);
		
		this.setTitle("TravelTimesDiagram");
		
		this.travelTimesFile=travelTimesFile;
		this.dataSet=dataSet;
		this.initialize();
		this.dataSet.fireDataChanged();
	}


	@Override
	protected JFreeChart createChart() {
	
        final NumberAxis xAxis = new NumberAxis(this.dataSet.getXLabel()); 
        // xAxis.setLabelFont(getFont().deriveFont(Font.BOLD));
        //xAxis.setRange(8, 15);
        xAxis.setAutoRange(true);
        xAxis.setAutoRangeIncludesZero(false);
        
        final NumberAxis yAxis = new NumberAxis(this.dataSet.getYLabel());
        // yAxis.setLabelFont(getFont().deriveFont(Font.BOLD));
        //yAxis.setRange(0, rows);

        //xyzSet = new XYZArrayDataset(data);
        //final XYPlot plot = new XYPlot(xyzSet, xAxis, yAxis, null);
        final XYPlot plot = new XYPlot(dataSet, xAxis, yAxis, null);
        
        /*plot.setDomainMinorGridlinesVisible(true);
        plot.setRangeMinorGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.black);
        plot.setDomainGridlinePaint(Color.black);*/
        

        
        /*final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(createYTickUnits());

        final NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setStandardTickUnits(createXTickUnits());
        */
       
        final XYBlockRenderer r = new XYBlockRenderer();

        // Use own implementation of a gradient paintScale
        final PaintScale ps = new GrayPaintScale();
        r.setPaintScale(ps);
        r.setBlockHeight(0.0001f);
        r.setBlockWidth(1.0f);

        plot.setRenderer(r);

        final JFreeChart chart = new JFreeChart(null, JFreeChart.DEFAULT_TITLE_FONT, plot, false);

        
        //chart.setBackgroundPaint(getBackground());

        // color scale
        //final NumberAxis scaleAxis = new NumberAxis(this.dataSet.getZLabel()); // TODO Legend sp
        //scaleAxis.setTickLabelFont(getFont().deriveFont());
        // scaleAxis.setLabelFont(getFont().deriveFont(Font.BOLD));

        /*final PaintScaleLegend legend = new PaintScaleLegend(ps, scaleAxis);
        legend.setAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        legend.setPadding(new RectangleInsets(10, 10, 10, 10));
        legend.setStripWidth(30);
        legend.setPosition(RectangleEdge.RIGHT);
        legend.setBackgroundPaint(getBackground());*/

        //chart.addSubtitle(legend);
        

        chart.setTitle(this.dataSet.getTitle());
        
        return chart;
	}


	@Override
	protected void saveData(File dataFile) {
		/*try
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
		} */
	}

	@Override
	protected void onExit() {
		if(this.travelTimesFile!=null){
			this.travelTimesFile.removeTravelTimesDataSet();
		}
	}


	@Override
	protected void setLane(int lane) {
		// TODO Auto-generated method stub
		
	}

	
}
