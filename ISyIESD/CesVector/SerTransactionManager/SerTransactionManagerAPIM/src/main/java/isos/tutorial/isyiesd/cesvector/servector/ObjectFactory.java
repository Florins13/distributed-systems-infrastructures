
package isos.tutorial.isyiesd.cesvector.servector;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the isos.tutorial.isyiesd.cesvector.servector package. 
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

    private final static QName _Commit_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "commit");
    private final static QName _CommitResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "commitResponse");
    private final static QName _InvariantCheck_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "invariantCheck");
    private final static QName _InvariantCheckResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "invariantCheckResponse");
    private final static QName _Prepare_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "prepare");
    private final static QName _PrepareResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "prepareResponse");
    private final static QName _Read_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "read");
    private final static QName _ReadResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "readResponse");
    private final static QName _Rollback_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "rollback");
    private final static QName _RollbackResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "rollbackResponse");
    private final static QName _Write_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "write");
    private final static QName _WriteResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.servectorserver", "writeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: isos.tutorial.isyiesd.cesvector.servector
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Commit }
     * 
     */
    public Commit createCommit() {
        return new Commit();
    }

    /**
     * Create an instance of {@link CommitResponse }
     * 
     */
    public CommitResponse createCommitResponse() {
        return new CommitResponse();
    }

    /**
     * Create an instance of {@link InvariantCheck }
     * 
     */
    public InvariantCheck createInvariantCheck() {
        return new InvariantCheck();
    }

    /**
     * Create an instance of {@link InvariantCheckResponse }
     * 
     */
    public InvariantCheckResponse createInvariantCheckResponse() {
        return new InvariantCheckResponse();
    }

    /**
     * Create an instance of {@link Prepare }
     * 
     */
    public Prepare createPrepare() {
        return new Prepare();
    }

    /**
     * Create an instance of {@link PrepareResponse }
     * 
     */
    public PrepareResponse createPrepareResponse() {
        return new PrepareResponse();
    }

    /**
     * Create an instance of {@link Read }
     * 
     */
    public Read createRead() {
        return new Read();
    }

    /**
     * Create an instance of {@link ReadResponse }
     * 
     */
    public ReadResponse createReadResponse() {
        return new ReadResponse();
    }

    /**
     * Create an instance of {@link Rollback }
     * 
     */
    public Rollback createRollback() {
        return new Rollback();
    }

    /**
     * Create an instance of {@link RollbackResponse }
     * 
     */
    public RollbackResponse createRollbackResponse() {
        return new RollbackResponse();
    }

    /**
     * Create an instance of {@link Write }
     * 
     */
    public Write createWrite() {
        return new Write();
    }

    /**
     * Create an instance of {@link WriteResponse }
     * 
     */
    public WriteResponse createWriteResponse() {
        return new WriteResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Commit }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Commit }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "commit")
    public JAXBElement<Commit> createCommit(Commit value) {
        return new JAXBElement<Commit>(_Commit_QNAME, Commit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommitResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CommitResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "commitResponse")
    public JAXBElement<CommitResponse> createCommitResponse(CommitResponse value) {
        return new JAXBElement<CommitResponse>(_CommitResponse_QNAME, CommitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvariantCheck }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvariantCheck }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "invariantCheck")
    public JAXBElement<InvariantCheck> createInvariantCheck(InvariantCheck value) {
        return new JAXBElement<InvariantCheck>(_InvariantCheck_QNAME, InvariantCheck.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvariantCheckResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvariantCheckResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "invariantCheckResponse")
    public JAXBElement<InvariantCheckResponse> createInvariantCheckResponse(InvariantCheckResponse value) {
        return new JAXBElement<InvariantCheckResponse>(_InvariantCheckResponse_QNAME, InvariantCheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prepare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Prepare }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "prepare")
    public JAXBElement<Prepare> createPrepare(Prepare value) {
        return new JAXBElement<Prepare>(_Prepare_QNAME, Prepare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrepareResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrepareResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "prepareResponse")
    public JAXBElement<PrepareResponse> createPrepareResponse(PrepareResponse value) {
        return new JAXBElement<PrepareResponse>(_PrepareResponse_QNAME, PrepareResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Read }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Read }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "read")
    public JAXBElement<Read> createRead(Read value) {
        return new JAXBElement<Read>(_Read_QNAME, Read.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "readResponse")
    public JAXBElement<ReadResponse> createReadResponse(ReadResponse value) {
        return new JAXBElement<ReadResponse>(_ReadResponse_QNAME, ReadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rollback }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Rollback }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "rollback")
    public JAXBElement<Rollback> createRollback(Rollback value) {
        return new JAXBElement<Rollback>(_Rollback_QNAME, Rollback.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RollbackResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RollbackResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "rollbackResponse")
    public JAXBElement<RollbackResponse> createRollbackResponse(RollbackResponse value) {
        return new JAXBElement<RollbackResponse>(_RollbackResponse_QNAME, RollbackResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Write }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Write }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "write")
    public JAXBElement<Write> createWrite(Write value) {
        return new JAXBElement<Write>(_Write_QNAME, Write.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WriteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", name = "writeResponse")
    public JAXBElement<WriteResponse> createWriteResponse(WriteResponse value) {
        return new JAXBElement<WriteResponse>(_WriteResponse_QNAME, WriteResponse.class, null, value);
    }

}
