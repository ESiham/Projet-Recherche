package fr.ifsttar.licit.simulator.util.units;

/**
 * Represents possibilities for describing an objects using only String representation (e.g. abbreviation, full text ...)
 * 
 * @author mgueriau
 *
 */
public interface Describable {
	
	public String getFullDescription();
	
	public String getAbbreviation();
	
	public String getMathScript();
	
}
