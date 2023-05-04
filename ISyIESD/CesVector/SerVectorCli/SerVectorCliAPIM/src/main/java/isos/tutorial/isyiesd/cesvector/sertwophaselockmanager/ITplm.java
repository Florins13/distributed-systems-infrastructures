
package isos.tutorial.isyiesd.cesvector.sertwophaselockmanager;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import sertwophaselockmanager.cesvector.isyiesd.isos.iesd21.FileLock;
import sertwophaselockmanager.cesvector.isyiesd.isos.iesd21.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ITplm", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ITplm {


    /**
     * 
     * @return
     *     returns sertwophaselockmanager.cesvector.isyiesd.isos.iesd21.FileLock
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "acquireLock", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", className = "sertwophaselockmanager.cesvector.isyiesd.isos.iesd21.AcquireLock")
    @ResponseWrapper(localName = "acquireLockResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", className = "sertwophaselockmanager.cesvector.isyiesd.isos.iesd21.AcquireLockResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager/ITplm/acquireLockRequest", output = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager/ITplm/acquireLockResponse")
    public FileLock acquireLock();

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkLock", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", className = "sertwophaselockmanager.cesvector.isyiesd.isos.iesd21.CheckLock")
    @ResponseWrapper(localName = "checkLockResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager", className = "sertwophaselockmanager.cesvector.isyiesd.isos.iesd21.CheckLockResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager/ITplm/checkLockRequest", output = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager/ITplm/checkLockResponse")
    public boolean checkLock();

}
