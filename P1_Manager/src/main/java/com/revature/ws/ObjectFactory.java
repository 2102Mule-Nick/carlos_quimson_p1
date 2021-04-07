
package com.revature.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.revature.ws package. 
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

    private final static QName _ChangeOutofService_QNAME = new QName("http://ws.revature.com/", "changeOutofService");
    private final static QName _ChangeOutofServiceResponse_QNAME = new QName("http://ws.revature.com/", "changeOutofServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.revature.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangeOutofService }
     * 
     */
    public ChangeOutofService createChangeOutofService() {
        return new ChangeOutofService();
    }

    /**
     * Create an instance of {@link ChangeOutofServiceResponse }
     * 
     */
    public ChangeOutofServiceResponse createChangeOutofServiceResponse() {
        return new ChangeOutofServiceResponse();
    }

    /**
     * Create an instance of {@link Room }
     * 
     */
    public Room createRoom() {
        return new Room();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeOutofService }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeOutofService }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "changeOutofService")
    public JAXBElement<ChangeOutofService> createChangeOutofService(ChangeOutofService value) {
        return new JAXBElement<ChangeOutofService>(_ChangeOutofService_QNAME, ChangeOutofService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeOutofServiceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeOutofServiceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "changeOutofServiceResponse")
    public JAXBElement<ChangeOutofServiceResponse> createChangeOutofServiceResponse(ChangeOutofServiceResponse value) {
        return new JAXBElement<ChangeOutofServiceResponse>(_ChangeOutofServiceResponse_QNAME, ChangeOutofServiceResponse.class, null, value);
    }

}
