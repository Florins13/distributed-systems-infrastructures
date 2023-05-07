
package isos.tutorial.isyiesd.cesvector.servector;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "VectorService", targetNamespace = "http://servector.cesvector.isyiesd.tutorial.isos/", wsdlLocation = "http://localhost:2058/Vector?wsdl")
public class VectorService
    extends Service
{

    private final static URL VECTORSERVICE_WSDL_LOCATION;
    private final static WebServiceException VECTORSERVICE_EXCEPTION;
    private final static QName VECTORSERVICE_QNAME = new QName("http://servector.cesvector.isyiesd.tutorial.isos/", "VectorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:2058/Vector?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        VECTORSERVICE_WSDL_LOCATION = url;
        VECTORSERVICE_EXCEPTION = e;
    }

    public VectorService() {
        super(__getWsdlLocation(), VECTORSERVICE_QNAME);
    }

    public VectorService(WebServiceFeature... features) {
        super(__getWsdlLocation(), VECTORSERVICE_QNAME, features);
    }

    public VectorService(URL wsdlLocation) {
        super(wsdlLocation, VECTORSERVICE_QNAME);
    }

    public VectorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, VECTORSERVICE_QNAME, features);
    }

    public VectorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VectorService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IVector
     */
    @WebEndpoint(name = "VectorPort")
    public IVector getVectorPort() {
        return super.getPort(new QName("http://servector.cesvector.isyiesd.tutorial.isos/", "VectorPort"), IVector.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IVector
     */
    @WebEndpoint(name = "VectorPort")
    public IVector getVectorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servector.cesvector.isyiesd.tutorial.isos/", "VectorPort"), IVector.class, features);
    }

    private static URL __getWsdlLocation() {
        if (VECTORSERVICE_EXCEPTION!= null) {
            throw VECTORSERVICE_EXCEPTION;
        }
        return VECTORSERVICE_WSDL_LOCATION;
    }

}
