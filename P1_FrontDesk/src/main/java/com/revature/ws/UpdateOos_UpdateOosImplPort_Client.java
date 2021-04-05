
package com.revature.ws;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2021-04-05T15:03:53.631-04:00
 * Generated source version: 3.3.0
 *
 */
public final class UpdateOos_UpdateOosImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://ws.revature.com/", "UpdateOosImplService");

    private UpdateOos_UpdateOosImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = UpdateOosImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        UpdateOosImplService ss = new UpdateOosImplService(wsdlURL, SERVICE_NAME);
        UpdateOos port = ss.getUpdateOosImplPort();

        {
        System.out.println("Invoking roomOutofService...");
        com.revature.ws.Room _roomOutofService_arg0 = new com.revature.ws.Room();
        port.roomOutofService(_roomOutofService_arg0);


        }
        {
        System.out.println("Invoking roomInService...");
        com.revature.ws.Room _roomInService_arg0 = new com.revature.ws.Room();
        port.roomInService(_roomInService_arg0);


        }

        System.exit(0);
    }

}
