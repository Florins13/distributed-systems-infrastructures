package isos.tutorial.isyiesd.cesvector.servectorcli;

import isos.tutorial.isyiesd.cesvector.sertwophaselockmanager.ArrayList;
import isos.tutorial.isyiesd.cesvector.servector.IVector;
import isos.tutorial.isyiesd.cesvector.servector.VectorService;
import isos.tutorial.isyiesd.cesvector.sertransactionmanager.TransactionManagerService;
import isos.tutorial.isyiesd.cesvector.sertransactionmanager.ITransactionManager;
import isos.tutorial.isyiesd.cesvector.sertwophaselockmanager.*;

import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Hello world!
 */
public class VectorClient {

    public static void main(String[] args) throws InterruptedException {

        Map<String, List<Integer>> desiredLockList = new HashMap<String, List<Integer>>();
        String lockJson;
        ObjectMapper mapper = new ObjectMapper();


        VectorService service = new VectorService();
        IVector vectorService1 = service.getVectorPort();
        
        TransactionManagerService testServ = new TransactionManagerService();
        ITransactionManager tmPort = testServ.getTransactionManagerPort();

        TplmService tplm = new TplmService();
        ITplm tplmPort = tplm.getTplmPort();

        desiredLockList.put("vectorService1", Arrays.asList(1,3));
        // TODO: temporary fix for the issue with sending object through contract
        try {
            lockJson = mapper.writeValueAsString(desiredLockList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        while(!tplmPort.acquireLocks(lockJson)){
            System.out.println("Cannot acquire lock");
            Thread.sleep(2000);
        }

        String transactionId = tmPort.begin();
        int v, res;
        int x = 100;

        v = vectorService1.read(1, transactionId); // v = 300
        res = v - x; // 300 - 100 = 200
        Thread.sleep(2000);

        vectorService1.write(1, res, transactionId); // writes 200

        Thread.sleep(4000);

        v = vectorService1.read(3,transactionId); // v = 56
        res = v + x; // 56 + 100
        Thread.sleep(6000);

        vectorService1.write(3, res, transactionId); // writes 156
        
        tmPort.commit(transactionId);
        tplmPort.releaseLocks(lockJson);
    }
}
