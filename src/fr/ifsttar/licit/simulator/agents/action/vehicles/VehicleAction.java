/**
 * 
 */
package fr.ifsttar.licit.simulator.agents.action.vehicles;

import java.util.HashMap;

import org.w3c.dom.Element;

import fr.ifsttar.licit.simulator.agents.action.Action;
import fr.ifsttar.licit.simulator.network.simulation.util.xml.XMLCodec.XMLDecodable;

/**
 * @author Maxime Guériau
 *
 */
public class VehicleAction extends Action implements XMLDecodable {
	private HashMap<String, String> parameters = new HashMap<String, String>();
	@Override
	public void decodeFromXML(Element source) {
		/*
		 * @Flavien
		 */		
		String p[] = source.getAttribute("param").
				substring(1, source.getAttribute("param").length()-1).split(",");
		for (int i = 0; i < p.length-1; i=i+2)
			parameters.put(p[i], p[i+1]);
		
	}
	
	public String getNewColor(){
		return parameters.get("colorValue");
	}

	public String getNewRank() {
		return parameters.get("rank");
	}

}
