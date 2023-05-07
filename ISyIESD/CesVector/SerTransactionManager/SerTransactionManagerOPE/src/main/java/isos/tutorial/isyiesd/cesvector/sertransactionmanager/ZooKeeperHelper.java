package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import org.apache.zookeeper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZooKeeperHelper {
    private static final String ZOOKEEPER_ADDRESS = "192.168.56.101:2181";
    private static final int SESSION_TIMEOUT = 3000;

    private ZooKeeper zooKeeper;

    public ZooKeeperHelper() throws Exception {
        this.zooKeeper = new ZooKeeper(ZOOKEEPER_ADDRESS, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                // Handle events like connection loss, session expiration, etc.
            }
        });
    }

    public void registerService(String serviceName, String serviceUrl) throws KeeperException, InterruptedException {
        // Check if the /services znode exists, create it if it doesn't
        if (zooKeeper.exists("/services", false) == null) {
            zooKeeper.create("/services", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        // Register the service under the /services znode
        String path = "/services/" + serviceName;
        if (zooKeeper.exists(path, false) == null) {
            zooKeeper.create(path, serviceUrl.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } else {
            zooKeeper.setData(path, serviceUrl.getBytes(), -1);
        }
    }


    public List<String> discoverService(String serviceName) throws Exception {
        String path = "/services/" + serviceName;
        if (zooKeeper.exists(path, false) == null) {
            throw new IllegalStateException("Service not found: " + serviceName);
        }

        // Get the data from the znode instead of getting the children
        byte[] data = zooKeeper.getData(path, false, null);
        String serviceUrl = new String(data);

        // Return the service URL in a list
        List<String> serviceUrls = new ArrayList<>();
        serviceUrls.add(serviceUrl);
        return serviceUrls;
    }


    // Close the ZooKeeper connection when no longer needed
    public void close() throws InterruptedException {
        zooKeeper.close();
    }
}
