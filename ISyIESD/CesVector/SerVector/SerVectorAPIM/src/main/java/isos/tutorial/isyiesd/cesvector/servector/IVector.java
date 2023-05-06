package isos.tutorial.isyiesd.cesvector.servector;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.UUID;

@WebService(name = "IVector", targetNamespace = "http://iesd21.isos.isyiesd.cesvector.servectorserver")
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
