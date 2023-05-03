
package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import sertransactionmanager.cesvector.isyiesd.isos.iesd21.ObjectFactory;
import sertransactionmanager.cesvector.isyiesd.isos.iesd21.Transaction;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ITransactionManager", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ITransactionManager {


    /**
     * 
     * @return
     *     returns sertransactionmanager.cesvector.isyiesd.isos.iesd21.Transaction
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "begin", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", className = "sertransactionmanager.cesvector.isyiesd.isos.iesd21.Begin")
    @ResponseWrapper(localName = "beginResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", className = "sertransactionmanager.cesvector.isyiesd.isos.iesd21.BeginResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager/ITransactionManager/beginRequest", output = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager/ITransactionManager/beginResponse")
    public Transaction begin();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "commit", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", className = "sertransactionmanager.cesvector.isyiesd.isos.iesd21.Commit")
    @ResponseWrapper(localName = "commitResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", className = "sertransactionmanager.cesvector.isyiesd.isos.iesd21.CommitResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager/ITransactionManager/commitRequest", output = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager/ITransactionManager/commitResponse")
    public void commit(
        @WebParam(name = "arg0", targetNamespace = "")
        Transaction arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "rollback", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", className = "sertransactionmanager.cesvector.isyiesd.isos.iesd21.Rollback")
    @ResponseWrapper(localName = "rollbackResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", className = "sertransactionmanager.cesvector.isyiesd.isos.iesd21.RollbackResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager/ITransactionManager/rollbackRequest", output = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager/ITransactionManager/rollbackResponse")
    public void rollback(
        @WebParam(name = "arg0", targetNamespace = "")
        Transaction arg0);

}
