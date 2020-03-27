package fr.ifsttar.licit.simulator.agents.action.infrastructure;

import org.w3c.dom.Element;

import fr.ifsttar.licit.simulator.agents.action.Action;
import fr.ifsttar.licit.simulator.network.simulation.util.xml.XMLCodec.XMLDecodable;

public class ChangeColorRSU extends Action implements XMLDecodable {

	String newColor;
	@Override
	public void decodeFromXML(Element source) {
		String color = source.getAttribute("param");
		int deb = color.indexOf(",");
		int fin = color.indexOf("]");
		newColor = color.substring(deb+1, fin);
	}
	
	public String getNewColor(){
		return newColor;
	}

	

}
