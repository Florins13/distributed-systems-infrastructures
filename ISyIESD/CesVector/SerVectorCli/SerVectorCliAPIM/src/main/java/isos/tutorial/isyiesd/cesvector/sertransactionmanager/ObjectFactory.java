
package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the isos.tutorial.isyiesd.cesvector.sertransactionmanager package. 
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

    private final static QName _Begin_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", "begin");
    private final static QName _BeginResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", "beginResponse");
    private final static QName _Commit_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", "commit");
    private final static QName _CommitResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", "commitResponse");
    private final static QName _JoinTransaction_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", "joinTransaction");
    private final static QName _JoinTransactionResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", "joinTransactionResponse");
    private final static QName _Rollback_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", "rollback");
    private final static QName _RollbackResponse_QNAME = new QName("http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", "rollbackResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: isos.tutorial.isyiesd.cesvector.sertransactionmanager
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Begin }
     * 
     */
    public Begin createBegin() {
        return new Begin();
    }

    /**
     * Create an instance of {@link BeginResponse }
     * 
     */
    public BeginResponse createBeginResponse() {
        return new BeginResponse();
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
     * Create an instance of {@link JoinTransaction }
     * 
     */
    public JoinTransaction createJoinTransaction() {
        return new JoinTransaction();
    }

    /**
     * Create an instance of {@link JoinTransactionResponse }
     * 
     */
    public JoinTransactionResponse createJoinTransactionResponse() {
        return new JoinTransactionResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Begin }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Begin }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", name = "begin")
    public JAXBElement<Begin> createBegin(Begin value) {
        return new JAXBElement<Begin>(_Begin_QNAME, Begin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BeginResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BeginResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", name = "beginResponse")
    public JAXBElement<BeginResponse> createBeginResponse(BeginResponse value) {
        return new JAXBElement<BeginResponse>(_BeginResponse_QNAME, BeginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Commit }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Commit }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", name = "commit")
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
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", name = "commitResponse")
    public JAXBElement<CommitResponse> createCommitResponse(CommitResponse value) {
        return new JAXBElement<CommitResponse>(_CommitResponse_QNAME, CommitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinTransaction }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JoinTransaction }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", name = "joinTransaction")
    public JAXBElement<JoinTransaction> createJoinTransaction(JoinTransaction value) {
        return new JAXBElement<JoinTransaction>(_JoinTransaction_QNAME, JoinTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JoinTransactionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JoinTransactionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", name = "joinTransactionResponse")
    public JAXBElement<JoinTransactionResponse> createJoinTransactionResponse(JoinTransactionResponse value) {
        return new JAXBElement<JoinTransactionResponse>(_JoinTransactionResponse_QNAME, JoinTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rollback }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Rollback }{@code >}
     */
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", name = "rollback")
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
    @XmlElementDecl(namespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", name = "rollbackResponse")
    public JAXBElement<RollbackResponse> createRollbackResponse(RollbackResponse value) {
        return new JAXBElement<RollbackResponse>(_RollbackResponse_QNAME, RollbackResponse.class, null, value);
    }

}
