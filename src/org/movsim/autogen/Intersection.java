//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.12.13 à 09:11:31 AM CET 
//


package org.movsim.autogen;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 

 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Intersection")
public class Intersection
    implements Serializable
{

    private final static long serialVersionUID = 1L;

    @XmlAttribute(name = "type", required = true)
    protected String type;
    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    public String getType(){
    	if(isSetType())
    		return this.type;
    	else
    		return "";
    }
    
    public boolean isSetType() {
        return (this.type!= null && this.type!="");
    }

   
    public void unsetType() {
        this.type = null;
    }
    
    @XmlAttribute(name = "main_road")
    protected int main_road;
    
    
    public void setMainRoad(int value) {
        this.main_road = value;
    }

    public int getMainRoad(){
    	if(isSetMainRoad())
    		return this.main_road;
    	else
    		return -1;
    }
    
    public boolean isSetMainRoad() {
        return (this.main_road < 0 );
    }

    public void unsetMainRoad() {
        this.main_road = - 1;
    }
    
    @XmlAttribute(name = "secondary_road")
    protected int secondary_road;
    
   
    public void setSecondaryRoad(int value) {
        this.secondary_road = value;
    }

    public int getSecondaryRoad(){
    	if(isSetSecondaryRoad())
    		return this.secondary_road;
    	else
    		return -1;
    }
    
    public boolean isSetSecondaryRoad() {
        return (this.secondary_road > 0);
    }

    public void unsetSecondaryRoad() {
        this.secondary_road = -1 ;
    }
    

    /*public IntersectionType getIntersectionType(){
    	return IntersectionType.getType(this.type);
    }
    
    public enum IntersectionType {
    	
    	right_priority;
    	
    	
    	public static IntersectionType getType(String parsing){
			
    		if(parsing.compareTo(right_priority.toString())==0){
    			return IntersectionType.right_priority;
    		}
    		return null;
    		
    	}
    }*/

}



