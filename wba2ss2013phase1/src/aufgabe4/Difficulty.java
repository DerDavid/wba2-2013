//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.14 at 10:54:35 PM CEST 
//


package aufgabe4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for difficulty.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="difficulty">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="einfach"/>
 *     &lt;enumeration value="normal"/>
 *     &lt;enumeration value="schwer"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "difficulty")
@XmlEnum
public enum Difficulty {

    @XmlEnumValue("einfach")
    EINFACH("einfach"),
    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("schwer")
    SCHWER("schwer");
    private final String value;

    Difficulty(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Difficulty fromValue(String v) {
        for (Difficulty c: Difficulty.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
