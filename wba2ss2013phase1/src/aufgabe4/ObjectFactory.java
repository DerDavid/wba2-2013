//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.14 at 10:54:35 PM CEST 
//


package aufgabe4;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the aufgabe4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: aufgabe4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ctpreparation }
     * 
     */
    public Ctpreparation createCtpreparation() {
        return new Ctpreparation();
    }

    /**
     * Create an instance of {@link Ctingredient }
     * 
     */
    public Ctingredient createCtingredient() {
        return new Ctingredient();
    }

    /**
     * Create an instance of {@link Ctrecipe }
     * 
     */
    public Ctrecipe createCtrecipe() {
        return new Ctrecipe();
    }

    /**
     * Create an instance of {@link Ctcomments }
     * 
     */
    public Ctcomments createCtcomments() {
        return new Ctcomments();
    }

    /**
     * Create an instance of {@link Recipe }
     * 
     */
    public Recipe createRecipe() {
        return new Recipe();
    }

    /**
     * Create an instance of {@link Ctpreparation.Preptime }
     * 
     */
    public Ctpreparation.Preptime createCtpreparationPreptime() {
        return new Ctpreparation.Preptime();
    }

    /**
     * Create an instance of {@link Ctentry }
     * 
     */
    public Ctentry createCtentry() {
        return new Ctentry();
    }

    /**
     * Create an instance of {@link Ctcomments.Entry }
     * 
     */
    public Ctcomments.Entry createCtcommentsEntry() {
        return new Ctcomments.Entry();
    }

}
