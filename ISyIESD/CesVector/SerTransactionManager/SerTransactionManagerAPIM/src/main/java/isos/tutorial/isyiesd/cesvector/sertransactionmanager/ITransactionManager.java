package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.UUID;


@WebService(name = "ITransactionManager", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.sertransactionmanager")
@SOAPBinding(style = Style.DOCUMENT)
public interface ITransactionManager {
	
	@WebMethod
	String begin();
	
	@WebMethod
	void commit(String transaction);
	
	@WebMethod
	void rollback(String transaction);

	@WebMethod
	void joinTransaction(String transaction, String serverId);
}
