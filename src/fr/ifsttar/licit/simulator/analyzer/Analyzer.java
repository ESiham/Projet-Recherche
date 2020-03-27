package fr.ifsttar.licit.simulator.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.movsim.logging.Logger;
import org.movsim.utilities.FileUtils;
import org.movsim.viewer.ui.charts.SpaceTimeSpeedView;
import org.movsim.viewer.ui.charts.model.data.sets.SpaceTimeSpeedDataSet;
import org.xml.sax.SAXException;

import fr.ifsttar.licit.simulator.util.units.Unit;

public class Analyzer {

	public static void main(String[] args) throws JAXBException, SAXException {
		Logger.initializeLogger();

		if(args.length>=1){

			if(args.length==1){

				SpaceTimeSpeedDataSet dataSet = createSpaceTimeSpeedDataSet(args[0] + ".traj.csv", 1);

				SpaceTimeSpeedView spaceTimeDiagram = new SpaceTimeSpeedView(dataSet);

				File file = new File(args[0]);

				String percentage = null;//getCoopPenetrationRate(args[0]);
				
				if(percentage==null || percentage==""){
					spaceTimeDiagram.changeTitle(args[0]);
				} else {
					spaceTimeDiagram.changeTitle( percentage + "%");
				}
				
				spaceTimeDiagram.save(file.getParentFile().getAbsolutePath(),file.getName(), 800,600, false);
				
			} else {
			
				for(int k = 0 ; k<args.length ; ++k){
	
					final int lane = 3;
					
					SpaceTimeSpeedDataSet dataSet = createSpaceTimeSpeedDataSet(args[k] + ".traj.csv", lane);
	
					SpaceTimeSpeedView spaceTimeDiagram = new SpaceTimeSpeedView(dataSet);
	
					File file = new File(args[k]);
	
					spaceTimeDiagram.changeTitle(getCoopPenetrationRate(args[k]) + "% on lane " + lane);
					
					spaceTimeDiagram.save(file.getParentFile().getAbsolutePath(),file.getName() + "_lane" + lane, 800,600, false);
	
					spaceTimeDiagram.dispose();
	
					dataSet.clear();
	
				}
			
			}

		}

	}

	private static String getCoopPenetrationRate(String filename){

		
		String percentage = "";
		
		try{
			percentage = filename.split("C")[1].split("D")[0];
		} catch (ArrayIndexOutOfBoundsException e){
			percentage = "";
		}

		if(percentage == null)
			percentage = "";

		return percentage; 
	}


	private static SpaceTimeSpeedDataSet createSpaceTimeSpeedDataSet(String filename, int numLane) {

		SpaceTimeSpeedDataSet dataSet = new SpaceTimeSpeedDataSet();

		// read data from csv file and add them to current dataset		

		BufferedReader reader = FileUtils.getReader(filename);

		//int num=0;
		//two firsts lines are dedicated to information
		try {
			reader.readLine();
			reader.readLine();
			String line = null;
			while((line=reader.readLine())!=null){
				//System.out.println("readin line " + num++);
				String[] tokens = line.split(",");
				//System.out.println(tokens.length);
				if(tokens.length>=14){
					final int lane = Integer.parseInt(tokens[1].replace(" ", ""));
					if(lane == numLane){
						final int id = Integer.parseInt(tokens[8].replace(" ", ""));
						final double time = Double.parseDouble(tokens[0].replace(" ", ""));
						final double pos = Double.parseDouble(tokens[2].replace(" ", ""));
						final double vel = Unit.convertValueFromTo(Double.parseDouble(tokens[3].replace(" ", "")), Unit.MetersPerSecond, Unit.KilometersPerHour);
						dataSet.addFloatingCarData(id,time,pos,vel);
						//System.out.println("add " + id + "," + time +" ,  " +  pos  + "  ,  " +vel);
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return dataSet;
	}
}
