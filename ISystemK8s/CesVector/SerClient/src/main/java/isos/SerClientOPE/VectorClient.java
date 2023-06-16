package isos.SerClientOPE;

import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;

import static isos.SerClientOPE.ClientOperations.LOCKS_ROOT_PATH;
import static isos.SerClientOPE.ClientOperations.VECTOR_SERVICE;

@QuarkusMain
public class VectorClient {

    public static void main(String ... args) throws InterruptedException, IOException, KeeperException {
        ClientOperations cliOpe = new ClientOperations();
        ZookeeperClient zoCli = new ZookeeperClient();

        if(cliOpe.acquireLock()){
            System.out.println("Client starting to perform operations!");
            cliOpe.performOperations();
            cliOpe.releaseLock();
            zoCli.close();
            System.out.println("Client ended transactions!");
            Thread.sleep(2000);
        }else{
            System.out.println("Client waits for event emitter!");
            zoCli.watchForNodeChanges( LOCKS_ROOT_PATH + VECTOR_SERVICE);

        };

        // prevent client from closing and wait for event to be emitted
        while (true) {
            Thread.sleep(2000);
        }
    }


}
