/*
 * Copyright (C) 2010, 2011, 2012 by Arne Kesting, Martin Treiber, Ralph Germ, Martin Budden
 * <movsim.org@gmail.com>
 * -----------------------------------------------------------------------------------------
 * 
 * This file is part of
 * 
 * MovSim - the multi-model open-source vehicular-traffic simulator.
 * 
 * MovSim is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MovSim is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MovSim. If not, see <http://www.gnu.org/licenses/>
 * or <http://www.movsim.org>.
 * 
 * -----------------------------------------------------------------------------------------
 */
package org.movsim.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.ISODateTimeFormat;
import au.com.bytecode.opencsv.CSVReader;

import com.google.common.collect.Lists;

import fr.ifsttar.licit.simulator.calibration.CalibrationData;

/**
 * Container for some shared information. Singleton pattern.
 * 
 * <br>
 * created: Mar 9, 2013<br>
 * 
 */
// TODO this class deperately needs a throughout refactoring !!!
public final class ProjectMetaData {

    private static final String MOVSIM_COMMON_LOG_PATH = "config";

    private static final String LOG4J_FILENAME = "log4j.properties";

    private static final String MOVSIM_CONFIG_FILE_ENDING = ".xprj";

    private static ProjectMetaData singleton = new ProjectMetaData();

    private String projectName;
    private String pathToProjectXmlFile;
    private String outputPath;
    private String xodrNetworkFilename;
    private String xodrPath;

    
    /**
     * @author mgueriau
     */
    //private ArrayList<String> nextProjectsName = new ArrayList<String>();
    //private ArrayList<String> nextProjectPath = new ArrayList<String>();
    
    
    private String consumptionFilename;
    private String consumptionPath;

    private boolean instantaneousFileOutput = true;
    // private boolean onlyValidation = false;

    private long timeOffsetMillis = 0;

    /**
     * Needed for Applet. Change to true, if you cannot access the file system.
     * Allows to read the config files from resources instead.
     */
    private boolean xmlFromResources = false;

    /**
     * For Android client: xmlFromResources does work, but using the file system is more convenient.
     */
    private boolean parseFromInputstream = false;

    private InputStream movsimXml;
    private InputStream networkXml;
    private InputStream projectProperties;

    /**
     * private constructor: singleton pattern.
     */
    private ProjectMetaData() {
    }

    /**
     * Gets the single instance of ProjectMetaData.
     * 
     * @return single instance of ProjectMetaData
     */
    public static ProjectMetaData getInstance() {
        return singleton;
    }

    public boolean hasProjectName() {
        return projectName != null && !projectName.isEmpty();
    }

    public String getProjectName() {
        if (!hasProjectName()) {
            throw new IllegalStateException("project name not set. Check in advance using \"hasProjectName()\"");
        }
        return projectName;
    }

    /**
     * Sets the project name.
     * 
     * @param projectName
     *            the new project name
     */
    public void setProjectName(String projectName) {
        System.out.println("projectname = " + projectName);
        this.projectName = projectName;
        //this.addProjectName(projectName);
    }
    
    /**
     * 
     */
    /*public void addProject(String projectName, String projectPath){
    	 System.out.println("next projectname number "+ (nextProjectsName.size()+1) +"= " + projectName);
         this.nextProjectsName.add(projectName);
         this.nextProjectPath.add(projectPath);
    }
    
    public boolean hasNextProject(){
    	return this.nextProjectsName.size()>0;
    }
    
    public void nextProject(){
    	if(this.hasNextProject()){
    		//FIXME : is this the right order ??
    		this.projectName = this.nextProjectsName.get(0);
    		this.nextProjectsName.remove(0);
    		
    		this.pathToProjectXmlFile = this.nextProjectPath.get(0);
    		this.nextProjectPath.remove(0);
    	}
    }
    */

    /**
     * 
     * @return
     */
    
    public boolean hasPathToProjectFile() {
        return pathToProjectXmlFile != null && !pathToProjectXmlFile.isEmpty();
    }

    public String getPathToProjectFile() {
        if (!hasPathToProjectFile()) {
            throw new IllegalStateException(
                    "path to project file not set. Check in advance using \"hasPathToProjectXmlFile()\"");
        }
        return pathToProjectXmlFile;
    }

    /**
     * Sets the path to project xml file.
     * 
     * @param pathToProjectXmlFile
     *            the new path to project xml file
     */
    public void setPathToProjectXmlFile(String pathToProjectXmlFile) {
        this.pathToProjectXmlFile = pathToProjectXmlFile;
    }

    public boolean hasOutputPath() {
        return outputPath != null && !outputPath.isEmpty();
    }

    public String getOutputPath() {
        if (!hasOutputPath()) {
            throw new IllegalStateException("output path not set. Check in advance using \"hasOutputPath()\"");
        }
        return outputPath;
    }

    /**
     * Sets the output path.
     * 
     * @param outputPath
     *            the new output path
     */
    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public boolean hasNetworkFilename() {
        return xodrNetworkFilename != null && !xodrNetworkFilename.isEmpty();
    }

    public String getXodrNetworkFilename() {
        if (!hasNetworkFilename()) {
            throw new IllegalStateException(
                    "network filename not yet set. Check in advance using \"hasNetworkFilename()\"");
        }
        return xodrNetworkFilename;
    }

    public void setXodrNetworkFilename(String xodrFilename) {
        this.xodrNetworkFilename = xodrFilename;
    }

    public void setXodrPath(String xodrPath) {
        this.xodrPath = xodrPath;
    }

    public String getXodrPath() {
        return xodrPath;
    }

    public boolean isInstantaneousFileOutput() {
        return instantaneousFileOutput;
    }

    /**
     * Sets the instantaneous file output.
     * 
     * @param instantaneousFileOutput
     *            the new instantaneous file output
     */
    public void setInstantaneousFileOutput(boolean instantaneousFileOutput) {
        this.instantaneousFileOutput = instantaneousFileOutput;
    }

    public boolean isXmlFromResources() {
        return xmlFromResources;
    }

    /**
     * Sets the xml from resources. Xml config files are read from resources.
     * 
     * @param xmlFromResources
     *            the new xml from resources
     */
    public void setXmlFromResources(boolean xmlFromResources) {
        this.xmlFromResources = xmlFromResources;
    }

    /**
     * @return the parseFromInputstream
     */
    public boolean isParseFromInputstream() {
        return parseFromInputstream;
    }

    /**
     * @param parseFromInputstream
     *            the parseFromInputstream to set
     */
    public void setParseFromInputstream(boolean parseFromInputstream) {
        this.parseFromInputstream = parseFromInputstream;
    }

    /**
     * @return the movsimXml
     */
    public InputStream getMovsimXml() {
        return movsimXml;
    }

    /**
     * @param movsimXml
     *            the movsimXml to set
     */
    public void setMovsimXml(InputStream movsimXml) {
        this.movsimXml = movsimXml;
    }

    /**
     * @return the networkXml
     */
    public InputStream getNetworkXml() {
        return networkXml;
    }

    /**
     * @param networkXml
     *            the networkXml to set
     */
    public void setNetworkXml(InputStream networkXml) {
        this.networkXml = networkXml;
    }

    /**
     * @return the projectProperties
     */
    public InputStream getProjectProperties() {
        return projectProperties;
    }

    /**
     * @param projectProperties
     *            the projectProperties to set
     */
    public void setProjectProperties(InputStream projectProperties) {
        this.projectProperties = projectProperties;
    }

    public File getInputFile() {
        return new File(getPathToProjectFile(), getProjectName() + MOVSIM_CONFIG_FILE_ENDING);
    }

    public boolean hasConsumptionFilename() {
        return consumptionFilename != null && !consumptionFilename.isEmpty();
    }

    public String getConsumptionFilename() {
        if (!hasConsumptionFilename()) {
            throw new IllegalStateException("consumption file not set. Check in advance using \"has...()\" method");
        }
        return consumptionFilename;
    }

    public String getConsumptionPath() {
        return consumptionPath;
    }

    public void setConsumptionFilename(String consumptionFilename) {
        this.consumptionFilename = consumptionFilename;
    }

    public void setConsumptionPath(String consumptionPath) {
        this.consumptionPath = consumptionPath;
    }

    public static String getMovsimConfigFileEnding() {
        return MOVSIM_CONFIG_FILE_ENDING;
    }

    public static String getLog4jFilename() {
        return LOG4J_FILENAME;
    }

    public static String getLog4jFilenameWithPath() {
        return File.separator + MOVSIM_COMMON_LOG_PATH + File.separator + LOG4J_FILENAME;
    }

    public long getTimeOffsetMillis() {
        return timeOffsetMillis;
    }

    public void setTimeOffsetMillis(long timeOffsetMillis) {
        this.timeOffsetMillis = timeOffsetMillis;
    }

    public String getFormatedTimeWithOffset(double simulationTime) {
        DateTime dateTime = new DateTime(timeOffsetMillis + Math.round(1000 * simulationTime), DateTimeZone.UTC);
        return ISODateTimeFormat.dateTimeNoMillis().print(dateTime);
    }
    
    
   
    
    /**
     * Calibration
     * 
     * @author mgueriau
     * 
     */
    private ArrayList<CalibrationData> calibrationData = new ArrayList<CalibrationData>();
    
    public CalibrationData getCalibrationData(String calibrationFilename){
    	
    	if(calibrationFilename=="")
    		return null;
    		
    	
    	String calibrationFilePath = ProjectMetaData.getInstance().getPathToProjectFile()  + File.separator + calibrationFilename;
    	
    	int indice = hasCalibrationData(calibrationFilePath);
    	
    	if(indice == -1)
    		return this.createCalibrationData(calibrationFilePath);
    	else
    		return this.calibrationData.get(indice);   	
    	
    	
    }

	private CalibrationData createCalibrationData(String calibrationFilename) {
		
		File calibrationFile = new File(/*ProjectMetaData.getInstance().getPathToProjectFile()  + File.separator + */calibrationFilename);
		
		if(calibrationFile.exists() && calibrationFile.isFile()){
			List<String[]> data = this.readData(calibrationFile, ';');
			
			CalibrationData calibData = new CalibrationData(calibrationFilename, data);
			this.calibrationData.add(calibData);
			return calibData;
		}
		
		return null;
	}

	private int hasCalibrationData(String calibrationFilename) {
		
		int id = 0;
		for(CalibrationData calibData : this.calibrationData){
			if(calibData.getFileName().compareTo(calibrationFilename)==0){
				return id;
			}
			++id;
		}
		
		return -1;
	}
       
	
	    
	private List<String[]> readData(File file, char separator) {
	   // LOG.info("read data from file={}", file.getAbsolutePath());
	    List<String[]> myEntries = Lists.newArrayList();
	    CSVReader reader = null;
	    try {
	        reader = new CSVReader(new FileReader(file), separator);
	        myEntries = reader.readAll();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e) {
	                // ignore
	            }
	        }
	    }
	    return myEntries;
	}

	/**
	 * 
	 * @return
	 */
	
    
    
    
    
    
}
