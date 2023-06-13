package isos.SerClientOPE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
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

@QuarkusMain
public class VectorClient {
    public static void main(String ... args) throws InterruptedException {
        Map<String, List<Integer>> desiredLockList = new HashMap<String, List<Integer>>();
        String lockJson;
        ObjectMapper mapper = new ObjectMapper();


        VectorService service = new VectorService();
        IVector vectorService1 = service.getIVectorPort();

        TransactionManagerService testServ = new TransactionManagerService();
        ITransactionManager tmPort = testServ.getITransactionManagerPort();

        Tplm tplm = new Tplm();
        ITplm tplmPort = tplm.getITplmPort();

        desiredLockList.put("vectorService1", Arrays.asList(0,2));
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
        tplmPort.releaseLocks(lockJson);

        Quarkus.run(args);
    }
}
