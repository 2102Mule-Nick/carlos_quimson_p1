package com.revature.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2021-04-09T11:57:51.069-04:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "UpdateTicketImplService",
                  wsdlLocation = "http://localhost:8080/P1_Maintenance/soap/updateTicket?wsdl",
                  targetNamespace = "http://ws.revature.com/")
public class UpdateTicketImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.revature.com/", "UpdateTicketImplService");
    public final static QName UpdateTicketImplPort = new QName("http://ws.revature.com/", "UpdateTicketImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/P1_Maintenance/soap/updateTicket?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UpdateTicketImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/P1_Maintenance/soap/updateTicket?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public UpdateTicketImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UpdateTicketImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UpdateTicketImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public UpdateTicketImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public UpdateTicketImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public UpdateTicketImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns UpdateTicket
     */
    @WebEndpoint(name = "UpdateTicketImplPort")
    public UpdateTicket getUpdateTicketImplPort() {
        return super.getPort(UpdateTicketImplPort, UpdateTicket.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UpdateTicket
     */
    @WebEndpoint(name = "UpdateTicketImplPort")
    public UpdateTicket getUpdateTicketImplPort(WebServiceFeature... features) {
        return super.getPort(UpdateTicketImplPort, UpdateTicket.class, features);
    }

}
