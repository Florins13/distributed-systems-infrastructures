package isos.SerTransManagerAPIM;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService(name = "ITransactionManager", targetNamespace = "http://isos.cesvector.sertransactionmanager")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
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
