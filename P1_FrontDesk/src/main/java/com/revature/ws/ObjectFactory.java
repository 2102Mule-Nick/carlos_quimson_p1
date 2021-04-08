
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

    private final static QName _UpdateTicket_QNAME = new QName("http://ws.revature.com/", "updateTicket");
    private final static QName _UpdateTicketResponse_QNAME = new QName("http://ws.revature.com/", "updateTicketResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.revature.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateTicket_Type }
     * 
     */
    public UpdateTicket_Type createUpdateTicket_Type() {
        return new UpdateTicket_Type();
    }

    /**
     * Create an instance of {@link UpdateTicketResponse }
     * 
     */
    public UpdateTicketResponse createUpdateTicketResponse() {
        return new UpdateTicketResponse();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTicket_Type }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateTicket_Type }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "updateTicket")
    public JAXBElement<UpdateTicket_Type> createUpdateTicket(UpdateTicket_Type value) {
        return new JAXBElement<UpdateTicket_Type>(_UpdateTicket_QNAME, UpdateTicket_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTicketResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateTicketResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.revature.com/", name = "updateTicketResponse")
    public JAXBElement<UpdateTicketResponse> createUpdateTicketResponse(UpdateTicketResponse value) {
        return new JAXBElement<UpdateTicketResponse>(_UpdateTicketResponse_QNAME, UpdateTicketResponse.class, null, value);
    }

}
