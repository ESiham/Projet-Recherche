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
 * <p>Classe Java pour TrafficLightCondition.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="TrafficLightCondition">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="clear"/>
 *     &lt;enumeration value="request"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrafficLightCondition")
@XmlEnum
public enum TrafficLightCondition {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("clear")
    CLEAR("clear"),
    @XmlEnumValue("request")
    REQUEST("request");
    private final String value;

    TrafficLightCondition(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TrafficLightCondition fromValue(String v) {
        for (TrafficLightCondition c: TrafficLightCondition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
