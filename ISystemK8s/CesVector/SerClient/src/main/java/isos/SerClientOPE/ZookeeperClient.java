package isos.SerClientOPE;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static isos.SerClientOPE.ClientOperations.VECTOR_SERVICE;

public class ZookeeperClient implements Watcher{
    private static final String ZK_HOST = "192.168.59.100:31134";
    private static final int SESSION_TIMEOUT = 3000;

    private ZooKeeper zk = new ZooKeeper(ZK_HOST, SESSION_TIMEOUT, null);

    private ClientOperations clientOpe = new ClientOperations();

    ClientOperations cliOpe = new ClientOperations();

    public ZookeeperClient() throws IOException, InterruptedException, KeeperException {
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getType() == Event.EventType.ChildWatchRemoved) {
            try {
                watchForNodeChanges(event.getPath());
            } catch (KeeperException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void watchForNodeChanges(String path) throws KeeperException, InterruptedException {
        List<Integer> children = zk.getChildren(path, this).stream().map(Integer::parseInt).collect(Collectors.toList());
        if(Collections.disjoint(children, cliOpe.desiredLockList.get(VECTOR_SERVICE))){
            cliOpe.acquireLock();
            cliOpe.performOperations();
            cliOpe.releaseLock();
            System.out.println("Client ended transactions!");
            this.zk.close();
        }
        System.out.println("Znodes of root znode " + path + "are : " + children);
    }

    public void close() throws InterruptedException {
        this.zk.close();
    }


}
