package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import javax.xml.ws.Endpoint;

public class TMServer {
    public static void main(String[] args) throws Exception {
    	
    	// registo no ISystem0; ISyIESD/CesVector/SerVector
    	
        Endpoint ep = Endpoint.create(new TransactionManager());
        System.out.println("Starting My Service...");
        ep.publish("http://192.168.1.65:2059/TransactionManager");

        ZooKeeperHelper zkHelper = new ZooKeeperHelper();
        zkHelper.registerService("TransactionManager", "http://192.168.1.65:2059/TransactionManager?wsdl");
        zkHelper.close();
    }
}
