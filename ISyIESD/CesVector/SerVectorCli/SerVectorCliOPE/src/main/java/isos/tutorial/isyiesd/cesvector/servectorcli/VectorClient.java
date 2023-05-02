package isos.tutorial.isyiesd.cesvector.servectorcli;

import isos.tutorial.isyiesd.cesvector.servector.IVector;
import isos.tutorial.isyiesd.cesvector.servector.VectorService;
import sertransactionmanager.cesvector.isyiesd.isos.iesd21.Transaction;
import isos.tutorial.isyiesd.cesvector.sertransactionmanager.TransactionManagerService;
import isos.tutorial.isyiesd.cesvector.sertransactionmanager.ITransactionManager;

/**
 * Hello world!
 */
public class VectorClient {

    public static void main(String[] args) throws InterruptedException {

        VectorService service = new VectorService();
        IVector port = service.getVectorPort();
        
        TransactionManagerService testServ = new TransactionManagerService();
        ITransactionManager tmPort = testServ.getTransactionManagerPort();

        Transaction transaction = tmPort.begin();
        

        
        int v, res;
        int x = 100;

        v = port.read(0); // v = 300
        res = v - x; // 300 - 100 = 200
        Thread.sleep(2000);

        port.write(0, res); // writes 200
        Thread.sleep(4000);

        v = port.read(2); // v = 56
        res = v + x; // 56 + 100
        Thread.sleep(6000);

        port.write(2, res); // writes 156
        
        tmPort.commit(transaction);

    }
}
