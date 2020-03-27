package fr.ifsttar.licit.simulator.agents.action.vehicles;

import java.util.HashMap;

import org.w3c.dom.Element;

import fr.ifsttar.licit.simulator.network.simulation.util.xml.XMLCodec.XMLDecodable;

public class ChangeColorAction extends VehicleAction implements XMLDecodable {
	private HashMap<String, String> parameters = new HashMap<String, String>();
	@Override
	public void decodeFromXML(Element source) {
		/*
		 * @Flavien
		 */		
		String p[] = source.getAttribute("param").
				substring(1, source.getAttribute("param").length()-1).split(",");
		
	}
	
	public String getNewColor(){
		return parameters.get("colorValue");
	}

}
