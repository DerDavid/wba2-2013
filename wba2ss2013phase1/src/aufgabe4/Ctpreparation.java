//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.14 at 10:54:35 PM CEST 
//


package aufgabe4;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for ctpreparation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ctpreparation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="preptime">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://example.org/Rezept>minInclDeci">
 *                 &lt;attribute name="unit" use="required" type="{http://example.org/Rezept}unitTime" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="difficulty" type="{http://example.org/Rezept}difficulty"/>
 *         &lt;element name="calvalue" type="{http://example.org/Rezept}minInclInt"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ctpreparation", propOrder = {
    "preptime",
    "difficulty",
    "calvalue",
    "text"
})
public class Ctpreparation {

    @XmlElement(required = true)
    protected Ctpreparation.Preptime preptime;
    @XmlElement(required = true)
    protected Difficulty difficulty;
    @XmlElement(required = true)
    protected BigInteger calvalue;
    @XmlElement(required = true)
    protected String text;

    /**
     * Gets the value of the preptime property.
     * 
     * @return
     *     possible object is
     *     {@link Ctpreparation.Preptime }
     *     
     */
    public Ctpreparation.Preptime getPreptime() {
        return preptime;
    }

    /**
     * Sets the value of the preptime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ctpreparation.Preptime }
     *     
     */
    public void setPreptime(Ctpreparation.Preptime value) {
        this.preptime = value;
    }

    /**
     * Gets the value of the difficulty property.
     * 
     * @return
     *     possible object is
     *     {@link Difficulty }
     *     
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the value of the difficulty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Difficulty }
     *     
     */
    public void setDifficulty(Difficulty value) {
        this.difficulty = value;
    }

    /**
     * Gets the value of the calvalue property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCalvalue() {
        return calvalue;
    }

    /**
     * Sets the value of the calvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCalvalue(BigInteger value) {
        this.calvalue = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://example.org/Rezept>minInclDeci">
     *       &lt;attribute name="unit" use="required" type="{http://example.org/Rezept}unitTime" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Preptime {

        @XmlValue
        protected BigDecimal value;
        @XmlAttribute(required = true)
        protected UnitTime unit;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValue(BigDecimal value) {
            this.value = value;
        }

        /**
         * Gets the value of the unit property.
         * 
         * @return
         *     possible object is
         *     {@link UnitTime }
         *     
         */
        public UnitTime getUnit() {
            return unit;
        }

        /**
         * Sets the value of the unit property.
         * 
         * @param value
         *     allowed object is
         *     {@link UnitTime }
         *     
         */
        public void setUnit(UnitTime value) {
            this.unit = value;
        }

    }

}