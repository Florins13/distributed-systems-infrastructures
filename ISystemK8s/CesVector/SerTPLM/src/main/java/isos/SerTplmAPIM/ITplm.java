package isos.SerTplmAPIM;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService(name = "ITplm", targetNamespace = "http://isos.cesvector.twophaselockmanager")
@SOAPBinding(style = Style.DOCUMENT)
public interface ITplm {

	@WebMethod
	boolean acquireLocks(String desiredLockList);
	
	@WebMethod
	boolean releaseLocks(String releaseLockList);
	
	
}
