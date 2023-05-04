package isos.tutorial.isyiesd.cesvector.sertwophaselockmanager;

import java.nio.channels.FileLock;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(name = "ITplm", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertwophaselockmanager")
@SOAPBinding(style = Style.DOCUMENT)
public interface ITplm {

	@WebMethod
	FileLock acquireLock();
	
	@WebMethod
	boolean checkLock();
	
	
}
