
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

    private final static QName _RoomInService_QNAME = new QName("http://ws.revature.com/", "roomInService");
    private final static QName _RoomInServiceResponse_QNAME = new QName("http://ws.revature.com/", "roomInServiceResponse");
    private final static QName _RoomOutofService_QNAME = new QName("http://ws.revature.com/", "roomOutofService");
    private final static QName _RoomOutofServiceResponse_QNAME = new QName("http://ws.revature.com/", "roomOutofServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.revature.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RoomInService }
     * 
     */
    public RoomInService createRoomInService() {
        return new RoomInService();
    }

    /**
     * Create an instance of {@link RoomInServiceResponse }
     * 
     */
    public RoomInServiceResponse createRoomInServiceResponse() {
        return new RoomInServiceResponse();
    }

    /**
     * Create an instance of {@link RoomOutofService }
     * 
     */
    public RoomOutofService createRoomOutofService() {
        return new RoomOutofService();
    }

    /**
     * Create an instance of {@link RoomOutofServiceResponse }
     * 
     */
    public RoomOutofServiceResponse createRoomOutofServiceResponse() {
        return new RoomOutofServiceResponse();
    }

    /**
     * Create an instance of {@link Room }
     * 
     */
    public Room createRoom() {
        return new Room();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoomInService }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RoomInService }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "roomInService")
    public JAXBElement<RoomInService> createRoomInService(RoomInService value) {
        return new JAXBElement<RoomInService>(_RoomInService_QNAME, RoomInService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoomInServiceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RoomInServiceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "roomInServiceResponse")
    public JAXBElement<RoomInServiceResponse> createRoomInServiceResponse(RoomInServiceResponse value) {
        return new JAXBElement<RoomInServiceResponse>(_RoomInServiceResponse_QNAME, RoomInServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoomOutofService }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RoomOutofService }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "roomOutofService")
    public JAXBElement<RoomOutofService> createRoomOutofService(RoomOutofService value) {
        return new JAXBElement<RoomOutofService>(_RoomOutofService_QNAME, RoomOutofService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoomOutofServiceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RoomOutofServiceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "roomOutofServiceResponse")
    public JAXBElement<RoomOutofServiceResponse> createRoomOutofServiceResponse(RoomOutofServiceResponse value) {
        return new JAXBElement<RoomOutofServiceResponse>(_RoomOutofServiceResponse_QNAME, RoomOutofServiceResponse.class, null, value);
    }

}
