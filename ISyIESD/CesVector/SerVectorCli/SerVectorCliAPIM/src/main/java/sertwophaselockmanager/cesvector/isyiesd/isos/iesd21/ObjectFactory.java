
package sertwophaselockmanager.cesvector.isyiesd.isos.iesd21;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sertwophaselockmanager.cesvector.isyiesd.isos.iesd21 package. 
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

    private final static QName _AcquireLock_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", "acquireLock");
    private final static QName _AcquireLockResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", "acquireLockResponse");
    private final static QName _CheckLock_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", "checkLock");
    private final static QName _CheckLockResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", "checkLockResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sertwophaselockmanager.cesvector.isyiesd.isos.iesd21
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AcquireLock }
     * 
     */
    public AcquireLock createAcquireLock() {
        return new AcquireLock();
    }

    /**
     * Create an instance of {@link AcquireLockResponse }
     * 
     */
    public AcquireLockResponse createAcquireLockResponse() {
        return new AcquireLockResponse();
    }

    /**
     * Create an instance of {@link CheckLock }
     * 
     */
    public CheckLock createCheckLock() {
        return new CheckLock();
    }

    /**
     * Create an instance of {@link CheckLockResponse }
     * 
     */
    public CheckLockResponse createCheckLockResponse() {
        return new CheckLockResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcquireLock }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AcquireLock }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", name = "acquireLock")
    public JAXBElement<AcquireLock> createAcquireLock(AcquireLock value) {
        return new JAXBElement<AcquireLock>(_AcquireLock_QNAME, AcquireLock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcquireLockResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AcquireLockResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", name = "acquireLockResponse")
    public JAXBElement<AcquireLockResponse> createAcquireLockResponse(AcquireLockResponse value) {
        return new JAXBElement<AcquireLockResponse>(_AcquireLockResponse_QNAME, AcquireLockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckLock }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckLock }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", name = "checkLock")
    public JAXBElement<CheckLock> createCheckLock(CheckLock value) {
        return new JAXBElement<CheckLock>(_CheckLock_QNAME, CheckLock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckLockResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CheckLockResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", name = "checkLockResponse")
    public JAXBElement<CheckLockResponse> createCheckLockResponse(CheckLockResponse value) {
        return new JAXBElement<CheckLockResponse>(_CheckLockResponse_QNAME, CheckLockResponse.class, null, value);
    }

}
