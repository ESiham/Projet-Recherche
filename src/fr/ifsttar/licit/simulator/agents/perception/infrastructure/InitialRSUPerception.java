/**
 * 
 */
package fr.ifsttar.licit.simulator.agents.perception.infrastructure;

import java.util.List;
import java.util.Map;

import org.movsim.autogen.Intersection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.ifsttar.licit.simulator.agents.perception.AgentPerception;
import fr.ifsttar.licit.simulator.network.simulation.agents.perception.InitialStickyPerception;

/**
 * @author Maxime
 *
 */
public class InitialRSUPerception extends AgentPerception implements
InitialStickyPerception, fr.ifsttar.licit.simulator.network.simulation.util.xml.XMLCodec.XMLEncodable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7682016401976218732L;

	final long id;
	final double position;
	final List<Intersection> intersections;

	/**
	 * @param intersections
	 */
	public InitialRSUPerception(long id, double position, List<Intersection> intersections) {
		this.id=id;
		this.position=position;
		this.intersections=intersections;
	}


	@Override
	public void encodeToXML(Element target) {
		// TODO Auto-generated method stub
		
		target.setAttribute("id", String.valueOf(this.id));
		
		//.out.println("RSU ID = " + String.valueOf(this.id));
		
		target.setAttribute("position", String.valueOf(this.position));
		
		Document doc = target.getOwnerDocument();
		
		Element elIntersections = doc.createElement("intersections");
		
		for(Intersection i : this.intersections){
			Element elIntersection = doc.createElement("intersection");
			elIntersection.setAttribute("type", i.getType());
			elIntersection.setAttribute("main_road", String.valueOf(i.getMainRoad()));
			elIntersection.setAttribute("secondary_road", String.valueOf(i.getSecondaryRoad()));
			
			elIntersections.appendChild(elIntersection);
		}
		
		target.appendChild(elIntersections);
		
		/*target.setAttribute("role", role);
		target.setAttribute("team", self.team);
		
		Document doc = target.getOwnerDocument();

		Element elProducts = doc.createElement("products");
		for(Item i: products){
			Element elProduct = doc.createElement("product");
			elProduct.setAttribute("name", i.name);
			elProduct.setAttribute("volume", String.valueOf(i.volume));
			elProduct.setAttribute("assembled", String.valueOf(i.userAssembled));
			if(i.userAssembled){
				Element elConsumed = doc.createElement("consumed");
				for(Map.Entry<Item,Integer> e : i.itemsConsumed.entrySet()){
					Element elItem = doc.createElement("item");
					elItem.setAttribute("name", e.getKey().name);
					elItem.setAttribute("amount", String.valueOf(e.getValue()));
					elConsumed.appendChild(elItem);
				}
				elProduct.appendChild(elConsumed);
				Element elTools = doc.createElement("tools");
				for(Map.Entry<Item,Integer> e : i.toolsNeeded.entrySet()){
					Element elItem = doc.createElement("item");
					elItem.setAttribute("name", e.getKey().name);
					elItem.setAttribute("amount", String.valueOf(e.getValue()));
					elTools.appendChild(elItem);
				}
				elProduct.appendChild(elTools);
			}
			elProducts.appendChild(elProduct);
		}

		target.appendChild(elProducts);
		
		*/
	}


	/* (non-Javadoc)
	 * @see fr.ifsttar.licit.simulator.agents.perception.Perception#mergeObjects(fr.ifsttar.licit.simulator.agents.perception.Perception)
	 */
	@Override
	protected void mergeObjects(AgentPerception perception) {
		// TODO Auto-generated method stub
		
	}
 
	

}
