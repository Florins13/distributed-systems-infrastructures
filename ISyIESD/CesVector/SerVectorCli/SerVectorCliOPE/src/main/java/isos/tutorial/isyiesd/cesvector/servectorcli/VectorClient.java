package isos.tutorial.isyiesd.cesvector.servectorcli;

import isos.tutorial.isyiesd.cesvector.servector.IVector;
import isos.tutorial.isyiesd.cesvector.servector.VectorService;
import isos.tutorial.isyiesd.cesvector.sertransactionmanager.TransactionManagerService;
import isos.tutorial.isyiesd.cesvector.sertransactionmanager.ITransactionManager;
import isos.tutorial.isyiesd.cesvector.sertwophaselockmanager.*;

import java.util.*;

/**
 * Hello world!
 */
public class VectorClient {

    public static void main(String[] args) throws InterruptedException {

        Map<String, List<Integer>> desiredLockList = new HashMap<String, List<Integer>>();

        VectorService service = new VectorService();
        IVector vectorService1 = service.getVectorPort();
        
        TransactionManagerService testServ = new TransactionManagerService();
        ITransactionManager tmPort = testServ.getTransactionManagerPort();

        TplmService tplm = new TplmService();
        ITplm tplmPort = tplm.getTplmPort();

        desiredLockList.put("vector1", Arrays.asList(0,2));
        tplmPort.acquireLock(desiredLockList);
        System.out.println("Lock is" + tplmPort.checkLock());
        
        String transactionId = tmPort.begin();
        int v, res;
        int x = 100;

        v = vectorService1.read(0, transactionId); // v = 300
        res = v - x; // 300 - 100 = 200
        Thread.sleep(2000);

        vectorService1.write(0, res, transactionId); // writes 200

        Thread.sleep(4000);

        v = vectorService1.read(2,transactionId); // v = 56
        res = v + x; // 56 + 100
        Thread.sleep(6000);

        vectorService1.write(2, res, transactionId); // writes 156
        
        tmPort.commit(transactionId);

    }
}
