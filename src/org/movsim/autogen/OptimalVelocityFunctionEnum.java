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
 * <p>Classe Java pour OptimalVelocityFunctionEnum.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="OptimalVelocityFunctionEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="bando"/>
 *     &lt;enumeration value="triangular"/>
 *     &lt;enumeration value="threephase"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OptimalVelocityFunctionEnum")
@XmlEnum
public enum OptimalVelocityFunctionEnum {

    @XmlEnumValue("bando")
    BANDO("bando"),
    @XmlEnumValue("triangular")
    TRIANGULAR("triangular"),
    @XmlEnumValue("threephase")
    THREEPHASE("threephase");
    private final String value;

    OptimalVelocityFunctionEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OptimalVelocityFunctionEnum fromValue(String v) {
        for (OptimalVelocityFunctionEnum c: OptimalVelocityFunctionEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
