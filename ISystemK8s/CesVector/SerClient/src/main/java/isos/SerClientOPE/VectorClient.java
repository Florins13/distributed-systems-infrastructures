package isos.SerClientOPE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@QuarkusMain
public class VectorClient {
    private static final String VECTOR_SERVICE = "vectorService1";
    private static final String LOCKS_ROOT_PATH = "/locks/";
    public static void main(String ... args) throws InterruptedException, IOException, KeeperException {
        ClientOperations cliOpe = new ClientOperations();
        ZookeeperClient zoCli = new ZookeeperClient();
        Map<String, List<Integer>> desiredLockList = new HashMap<String, List<Integer>>();
        String lockJson;
        ObjectMapper mapper = new ObjectMapper();
        desiredLockList.put(VECTOR_SERVICE, Arrays.asList(0,2));
        try {
            lockJson = mapper.writeValueAsString(desiredLockList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if(cliOpe.acquireLock(lockJson)){
            System.out.println("Client starting to perform operations!");
            cliOpe.performOperations();
            cliOpe.releaselock(lockJson);
            zoCli.close();
            Thread.sleep(2000);
        }else{
            System.out.println("Client waits for event emitter!");
            zoCli.setWatcherToNode(LOCKS_ROOT_PATH + VECTOR_SERVICE, lockJson);
        };

        System.out.println("Client ended transactions!");

        // prevent client from closing and wait for event to be emitted
        while (true) {
            Thread.sleep(2000);
        }
    }


}
