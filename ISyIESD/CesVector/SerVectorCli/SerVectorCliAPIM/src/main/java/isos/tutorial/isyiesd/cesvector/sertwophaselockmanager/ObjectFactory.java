
package isos.tutorial.isyiesd.cesvector.sertwophaselockmanager;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the isos.tutorial.isyiesd.cesvector.sertwophaselockmanager package. 
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

    private final static QName _AcquireLocks_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", "acquireLocks");
    private final static QName _AcquireLocksResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", "acquireLocksResponse");
    private final static QName _ReleaseLocks_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", "releaseLocks");
    private final static QName _ReleaseLocksResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", "releaseLocksResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: isos.tutorial.isyiesd.cesvector.sertwophaselockmanager
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AcquireLocks }
     * 
     */
    public AcquireLocks createAcquireLocks() {
        return new AcquireLocks();
    }

    /**
     * Create an instance of {@link AcquireLocksResponse }
     * 
     */
    public AcquireLocksResponse createAcquireLocksResponse() {
        return new AcquireLocksResponse();
    }

    /**
     * Create an instance of {@link ReleaseLocks }
     * 
     */
    public ReleaseLocks createReleaseLocks() {
        return new ReleaseLocks();
    }

    /**
     * Create an instance of {@link ReleaseLocksResponse }
     * 
     */
    public ReleaseLocksResponse createReleaseLocksResponse() {
        return new ReleaseLocksResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcquireLocks }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AcquireLocks }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", name = "acquireLocks")
    public JAXBElement<AcquireLocks> createAcquireLocks(AcquireLocks value) {
        return new JAXBElement<AcquireLocks>(_AcquireLocks_QNAME, AcquireLocks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcquireLocksResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AcquireLocksResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", name = "acquireLocksResponse")
    public JAXBElement<AcquireLocksResponse> createAcquireLocksResponse(AcquireLocksResponse value) {
        return new JAXBElement<AcquireLocksResponse>(_AcquireLocksResponse_QNAME, AcquireLocksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseLocks }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReleaseLocks }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", name = "releaseLocks")
    public JAXBElement<ReleaseLocks> createReleaseLocks(ReleaseLocks value) {
        return new JAXBElement<ReleaseLocks>(_ReleaseLocks_QNAME, ReleaseLocks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseLocksResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReleaseLocksResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", name = "releaseLocksResponse")
    public JAXBElement<ReleaseLocksResponse> createReleaseLocksResponse(ReleaseLocksResponse value) {
        return new JAXBElement<ReleaseLocksResponse>(_ReleaseLocksResponse_QNAME, ReleaseLocksResponse.class, null, value);
    }

}
