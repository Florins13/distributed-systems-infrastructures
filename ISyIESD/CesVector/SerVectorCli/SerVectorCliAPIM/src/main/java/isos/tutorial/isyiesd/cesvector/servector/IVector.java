
package isos.tutorial.isyiesd.cesvector.servector;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IVector", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IVector {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "invariantCheck", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.InvariantCheck")
    @ResponseWrapper(localName = "invariantCheckResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.InvariantCheckResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/invariantCheckRequest", output = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/invariantCheckResponse")
    public String invariantCheck();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "commit", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.Commit")
    @ResponseWrapper(localName = "commitResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.CommitResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/commitRequest", output = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/commitResponse")
    public void commit(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "rollback", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.Rollback")
    @ResponseWrapper(localName = "rollbackResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.RollbackResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/rollbackRequest", output = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/rollbackResponse")
    public void rollback(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "write", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.Write")
    @ResponseWrapper(localName = "writeResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.WriteResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/writeRequest", output = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/writeResponse")
    public void write(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "read", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.Read")
    @ResponseWrapper(localName = "readResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.ReadResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/readRequest", output = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/readResponse")
    public int read(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "prepare", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.Prepare")
    @ResponseWrapper(localName = "prepareResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver", className = "isos.tutorial.isyiesd.cesvector.servector.PrepareResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/prepareRequest", output = "http://iesd21.isos.isyiesd.cesvector.servectorserver/IVector/prepareResponse")
    public boolean prepare(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
