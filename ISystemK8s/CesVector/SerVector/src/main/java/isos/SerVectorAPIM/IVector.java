package isos.SerVectorAPIM;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService(name = "IVector", targetNamespace = "http://isos.cesvector.vectorserver")
@SOAPBinding(style = Style.DOCUMENT)
public interface IVector {

    @WebMethod
    int read(int pos, String transactionId);

    @WebMethod
    void write(int pos, int n, String transactionId);

    @WebMethod
    String invariantCheck();
    
    @WebMethod
    boolean prepare(String transactionId);
    
    @WebMethod
    void commit(String transactionId);
    
    @WebMethod
    void rollback(String transactionId);

}
