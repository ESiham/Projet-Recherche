package fr.ifsttar.licit.simulator.calibration;

import java.util.List;

public class CalibrationData {

	private String filename = "";
	private List<String[]> data;
	
	public CalibrationData(String calibrationFilename, List<String[]> data) {
		this.filename=calibrationFilename;
		this.data=data;
	}

	public String getFileName() {
		return this.filename;
	}

	public List<String[]> getData() {
		return this.data;
	}

}
