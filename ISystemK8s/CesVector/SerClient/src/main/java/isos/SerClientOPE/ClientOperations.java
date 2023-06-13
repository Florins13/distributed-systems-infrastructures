package isos.SerClientOPE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sertransactionmanager.cesvector.isos.ITransactionManager;
import sertransactionmanager.cesvector.isos.TransactionManagerService;
import twophaselockmanager.cesvector.isos.ITplm;
import twophaselockmanager.cesvector.isos.Tplm;
import vectorserver.cesvector.isos.IVector;
import vectorserver.cesvector.isos.VectorService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientOperations {
    VectorService service = new VectorService();
    IVector vectorService1 = service.getIVectorPort();

    TransactionManagerService testServ = new TransactionManagerService();
    ITransactionManager tmPort = testServ.getITransactionManagerPort();

    Tplm tplm = new Tplm();
    public ClientOperations() {
    }

    ITplm tplmPort = tplm.getITplmPort();



    public void performOperations() throws InterruptedException {

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

    public boolean acquireLock(String lockJson){
        return tplmPort.acquireLocks(lockJson);
    }

    public void releaselock(String lockJson){
        tplmPort.releaseLocks(lockJson);
    }
}
