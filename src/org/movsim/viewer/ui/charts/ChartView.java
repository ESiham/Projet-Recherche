package org.movsim.viewer.ui.charts;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class ChartView extends JFrame {

	private static final long serialVersionUID = 5606870164506368556L;

	private ChartPanel chartPanel;

	private JFreeChart chart;

	private JMenuBar menuBar;

	public ChartView(final Component component, String route, int[] lanes) {


		this.setLayout(new BorderLayout());
		//setLocation(10, 700);
		//final ChartView callback = this;

		if(component instanceof JCheckBoxMenuItem){

			final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) component;

			addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent evnt) {
					cb.setSelected(false);
					evnt.getWindow().setVisible(false);
					evnt.getWindow().dispose();
					//removeObserver();

				}
			});

		} else {
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		this.menuBar=this.createMenuBar(route, lanes);

		this.setJMenuBar(this.menuBar);


		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				onExit();
			}
		});

	}


	protected abstract JFreeChart createChart();

	protected JMenuBar createMenuBar(String route, int[] lanes){

		JMenuBar menuBar = new JMenuBar();

		final JFrame jframe = this;


		if(lanes!=null && lanes.length>0){
			JMenu lanesMenu = new JMenu("Lane");

			for(int i=0; i<lanes.length; i++){

				final int lane = lanes[i];
				//change title
				String laneLabel = " : lane "+ lane;

				//System.out.println(lanes.length);

				if(lanes.length==1){
					laneLabel="";
				} else if(lanes.length==2){
					switch(lane){
					case 1: laneLabel = " : left lane "; break;
					case 2: laneLabel = " : right lane "; break;
					default : laneLabel = " : lane "+lane; break;
					}
				} else if(lanes.length==3){
					//System.out.println(" == 3 ");
					switch(lane){
					case 1: laneLabel = " : left lane "; break;
					case 2: laneLabel = " : center lane "; break;
					case 3: laneLabel = " : right lane "; break;
					default : laneLabel = " : lane "+lane; break;
					}
				}

				//System.out.println(laneLabel);

				lanesMenu.add(new JMenuItem(new AbstractAction(route + laneLabel) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						if (chart!=null){
							setLane(lane);
						}
					}
				}));

			}

			menuBar.add(lanesMenu);
		}

		JMenu textMenu = new JMenu("Text");

		//change title
		textMenu.add(new JMenuItem(new AbstractAction("Edit Title") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chart!=null){

					String s = (String)JOptionPane.showInputDialog(
							jframe,
							"Please type a new title :",
							"Edit Chart Title",
							JOptionPane.PLAIN_MESSAGE,
							null,
							null,
							chart.getTitle().getText());

					if ((s != null) && (s.length() > 0)) {
						chart.setTitle(s);
					}

				}
			}
		}));

		menuBar.add(textMenu);


		JMenu saveMenu = new JMenu("Save");

		//save as png
		saveMenu.add(new JMenuItem(new AbstractAction("Save as PNG") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chart!=null){
					final JFileChooser fc = new JFileChooser();
					fc.setSelectedFile(new File(chart.getTitle().getText()));
					if (fc.showSaveDialog(jframe) == JFileChooser.APPROVE_OPTION) {

						File file = fc.getSelectedFile();

						if(!file.getAbsolutePath().endsWith(".png")){
							file = new File(file + ".png");
						}

						try{
							ChartUtilities.saveChartAsPNG(file, chart, jframe.getWidth(), jframe.getHeight());
						} catch(IOException ex){
							ex.printStackTrace();
						}
					}
				}
			}
		}));

		saveMenu.add(new JMenuItem(new AbstractAction("Save as JPEG") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chart!=null){
					final JFileChooser fc = new JFileChooser();
					fc.setSelectedFile(new File(chart.getTitle().getText()));
					if (fc.showSaveDialog(jframe) == JFileChooser.APPROVE_OPTION) {

						File file = fc.getSelectedFile();

						if(!file.getAbsolutePath().endsWith(".jpg")){
							file = new File(file + ".jpg");
						}

						try{
							ChartUtilities.saveChartAsJPEG(file, chart, jframe.getWidth(), jframe.getHeight());
						} catch(IOException ex){
							ex.printStackTrace();
						}
					}
				}
			}
		}));

		saveMenu.add(new JMenuItem(new AbstractAction("Save as PDF") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (chart!=null){
					final JFileChooser fc = new JFileChooser();
					fc.setSelectedFile(new File(chart.getTitle().getText()));
					if (fc.showSaveDialog(jframe) == JFileChooser.APPROVE_OPTION) {

						File file = fc.getSelectedFile();

						if(!file.getAbsolutePath().endsWith(".pdf")){
							file = new File(file + ".pdf");
						}


						try  { 
							OutputStream out = new FileOutputStream(file);
							Rectangle pagesize = new Rectangle( jframe.getWidth(), jframe.getHeight() ); 
							Document document = new Document( pagesize, 50, 50, 50, 50 ); 
							PdfWriter writer = PdfWriter.getInstance( document, out ); 
							document.open(); 
							PdfContentByte cb = writer.getDirectContent(); 
							PdfTemplate tp = cb.createTemplate( jframe.getWidth(), jframe.getHeight() ); 
							Graphics2D g2 = tp.createGraphics( jframe.getWidth(), jframe.getHeight(), new DefaultFontMapper() ); 
							Rectangle2D r2D = new Rectangle2D.Double(0, 0, jframe.getWidth(), jframe.getHeight() ); 
							chart.draw(g2, r2D); 
							g2.dispose(); 
							cb.addTemplate(tp, 0, 0); 
							document.close(); 
						} 
						catch (Exception ex) { 
							ex.printStackTrace();
						} 

					}
				}
			}
		}));

		menuBar.add(saveMenu);

		return menuBar;
	}

	/**
	 * must be called after constructors
	 */
	protected void initialize(){

		this.chart = this.createChart();

		boolean first = true;
		if(this.chartPanel!=null){
			this.remove(chartPanel);
			first = false;
		}

		this.chartPanel = new ChartPanel(chart, true, false, false, true, true);
		this.chartPanel.setMouseWheelEnabled(true);
		//spChartPanel.setHorizontalAxisTrace(true);
		//spChartPanel.setVerticalAxisTrace(true);
		this.add(chartPanel, BorderLayout.CENTER);

		if(first)
			this.pack();

		this.setVisible(true);
	}

	protected void callRepaint(){
		if(this.chartPanel!=null)
			this.chartPanel.updateUI();
	}

	public void save(String directory, String name, int width, int height, boolean data){

		File directoryFile = new File(directory);

		if(!directoryFile.exists())
			directoryFile.mkdir();

		File file = new File(directory+File.separator+name);

		if(!file.getAbsolutePath().endsWith(".png")){
			file = new File(file + ".png");
		}

		try{
			ChartUtilities.saveChartAsPNG(file, chart, width, height);
		} catch(IOException ex){
			ex.printStackTrace();
		}

		//data save in csv file
		if(data){
			File dataFile = new File(directory+File.separator+name+"_data.csv");
			this.saveData(dataFile);
		}
	}

	protected abstract void saveData(File dataFile);


	public void save(String path, String name){
		this.save(path, name, this.getWidth(), this.getHeight(), false);
	}

	protected abstract void onExit();

	protected abstract void setLane(int lane);

	public void changeTitle(String title){
		this.chart.setTitle(title);
	}
}
