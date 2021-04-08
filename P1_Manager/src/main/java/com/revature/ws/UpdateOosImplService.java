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
 * 2021-04-08T10:32:43.594-04:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "UpdateOosImplService",
                  wsdlLocation = "http://localhost:8080/P1_Maintenance/soap/updateOos?wsdl",
                  targetNamespace = "http://ws.revature.com/")
public class UpdateOosImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.revature.com/", "UpdateOosImplService");
    public final static QName UpdateOosImplPort = new QName("http://ws.revature.com/", "UpdateOosImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/P1_Maintenance/soap/updateOos?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(UpdateOosImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/P1_Maintenance/soap/updateOos?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public UpdateOosImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UpdateOosImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UpdateOosImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public UpdateOosImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public UpdateOosImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public UpdateOosImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns UpdateOos
     */
    @WebEndpoint(name = "UpdateOosImplPort")
    public UpdateOos getUpdateOosImplPort() {
        return super.getPort(UpdateOosImplPort, UpdateOos.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UpdateOos
     */
    @WebEndpoint(name = "UpdateOosImplPort")
    public UpdateOos getUpdateOosImplPort(WebServiceFeature... features) {
        return super.getPort(UpdateOosImplPort, UpdateOos.class, features);
    }

}
