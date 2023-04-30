package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(name = "ITest", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager")
@SOAPBinding(style = Style.DOCUMENT)
public interface ITest {
	
	@WebMethod
	void sayHello();

}
