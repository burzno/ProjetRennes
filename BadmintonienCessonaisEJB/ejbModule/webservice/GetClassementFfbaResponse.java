
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getClassementFfbaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getClassementFfbaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classementFFBA" type="{http://webservice/}classementFFBAWS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getClassementFfbaResponse", propOrder = {
    "classementFFBA"
})
public class GetClassementFfbaResponse {

    protected ClassementFFBAWS classementFFBA;

    /**
     * Gets the value of the classementFFBA property.
     * 
     * @return
     *     possible object is
     *     {@link ClassementFFBAWS }
     *     
     */
    public ClassementFFBAWS getClassementFFBA() {
        return classementFFBA;
    }

    /**
     * Sets the value of the classementFFBA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassementFFBAWS }
     *     
     */
    public void setClassementFFBA(ClassementFFBAWS value) {
        this.classementFFBA = value;
    }

}
