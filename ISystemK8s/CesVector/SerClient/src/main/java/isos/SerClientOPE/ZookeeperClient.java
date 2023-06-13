package isos.SerClientOPE;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class ZookeeperClient {
    private static final String ZK_HOST = "192.168.59.100:31363";
    private static final int SESSION_TIMEOUT = 3000;
    private ZooKeeper zk;

    private ClientOperations clientOpe = new ClientOperations();

    ClientOperations cliOpe = new ClientOperations();

    public ZookeeperClient() throws IOException, InterruptedException, KeeperException {
        zk = new ZooKeeper(ZK_HOST, SESSION_TIMEOUT, this::watcherCallback);
    }

    private void watcherCallback(WatchedEvent event) {
        // If a node gets deleted, it means the lock is released
        if (event.getType() == Watcher.Event.EventType.NodeDeleted) {
        }
    }

    public void setWatcherToNode(String nodePath, String lockJson) throws KeeperException, InterruptedException {
        Stat stat = this.zk.exists(nodePath, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getType() == Event.EventType.NodeDeleted) {
                    System.out.println("Node " + event.getPath() + " has been deleted");
                }
                try {
                    setWatcherToNode(nodePath, lockJson);
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        if (stat == null) {
            System.out.println("Node " + nodePath + " does not exist");
            cliOpe.acquireLock(lockJson);
            cliOpe.performOperations();
            cliOpe.releaselock(lockJson);
            this.zk.close();
        }
    }


    private void performTransaction(){
        try {
            clientOpe.performOperations();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws InterruptedException {
        this.zk.close();
    }
}
