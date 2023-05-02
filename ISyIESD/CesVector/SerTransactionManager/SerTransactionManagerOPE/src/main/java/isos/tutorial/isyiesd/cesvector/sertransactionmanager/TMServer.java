package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import javax.xml.ws.Endpoint;

public class TMServer {
    public static void main(String[] args) {
    	
    	// registo no ISystem0; ISyIESD/CesVector/SerVector
    	
        Endpoint ep = Endpoint.create(new TransactionManager());
        System.out.println("Starting My Service...");
        ep.publish("http://localhost:2059/TransactionManager");
    }
}
