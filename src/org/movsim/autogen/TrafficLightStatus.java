//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.12.13 à 09:11:31 AM CET 
//


package org.movsim.autogen;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour TrafficLightStatus.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="TrafficLightStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Red"/>
 *     &lt;enumeration value="RedGreen"/>
 *     &lt;enumeration value="Green"/>
 *     &lt;enumeration value="GreenRed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrafficLightStatus")
@XmlEnum
public enum TrafficLightStatus {

    @XmlEnumValue("Red")
    RED("Red"),
    @XmlEnumValue("RedGreen")
    RED_GREEN("RedGreen"),
    @XmlEnumValue("Green")
    GREEN("Green"),
    @XmlEnumValue("GreenRed")
    GREEN_RED("GreenRed");
    private final String value;

    TrafficLightStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TrafficLightStatus fromValue(String v) {
        for (TrafficLightStatus c: TrafficLightStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
