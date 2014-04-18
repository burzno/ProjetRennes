
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
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

    private final static QName _GetClassementFfba_QNAME = new QName("http://webservice/", "getClassementFfba");
    private final static QName _GetClassementFfbaResponse_QNAME = new QName("http://webservice/", "getClassementFfbaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetClassementFfbaResponse }
     * 
     */
    public GetClassementFfbaResponse createGetClassementFfbaResponse() {
        return new GetClassementFfbaResponse();
    }

    /**
     * Create an instance of {@link GetClassementFfba }
     * 
     */
    public GetClassementFfba createGetClassementFfba() {
        return new GetClassementFfba();
    }

    /**
     * Create an instance of {@link ClassementFFBAWS }
     * 
     */
    public ClassementFFBAWS createClassementFFBAWS() {
        return new ClassementFFBAWS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClassementFfba }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getClassementFfba")
    public JAXBElement<GetClassementFfba> createGetClassementFfba(GetClassementFfba value) {
        return new JAXBElement<GetClassementFfba>(_GetClassementFfba_QNAME, GetClassementFfba.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClassementFfbaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getClassementFfbaResponse")
    public JAXBElement<GetClassementFfbaResponse> createGetClassementFfbaResponse(GetClassementFfbaResponse value) {
        return new JAXBElement<GetClassementFfbaResponse>(_GetClassementFfbaResponse_QNAME, GetClassementFfbaResponse.class, null, value);
    }

}
