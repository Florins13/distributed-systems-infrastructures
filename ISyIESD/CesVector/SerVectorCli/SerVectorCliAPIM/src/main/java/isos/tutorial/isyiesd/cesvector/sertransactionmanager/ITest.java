
package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import sertransactionmanager.cesvector.isyiesd.isos.iesd21.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ITest", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ITest {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", className = "sertransactionmanager.cesvector.isyiesd.isos.iesd21.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager", className = "sertransactionmanager.cesvector.isyiesd.isos.iesd21.SayHelloResponse")
    @Action(input = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager/ITest/sayHelloRequest", output = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager/ITest/sayHelloResponse")
    public void sayHello();

}
