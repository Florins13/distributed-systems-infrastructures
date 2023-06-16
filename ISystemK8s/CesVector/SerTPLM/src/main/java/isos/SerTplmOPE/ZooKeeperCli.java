package isos.SerTplmOPE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZooKeeperCli {
    private static final String ZOOKEEPER_ADDRESS = "localhost:2181";
    private static final int SESSION_TIMEOUT = 7000;

    private static String LOCKS_ROOT_PATH = "/locks";
    private ZooKeeper zooKeeper;

    ObjectMapper mapper = new ObjectMapper();
    public ZooKeeperCli() throws Exception {
        this.zooKeeper = new ZooKeeper(ZOOKEEPER_ADDRESS, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if(event.getState() == Event.KeeperState.Expired) {
                    System.out.println("Conn EXPIRED!");
                } else if (event.getState() == Event.KeeperState.Disconnected) {
                    System.out.println("Con DISCONNECTED!");
                }
            }
        });
    }

    public boolean acquireLock(String jsonToLock) throws KeeperException, InterruptedException {
        // Check if the /locks znode exists, create it if it doesn't
        HashMap<String, ArrayList<Integer>> toLockList = jsonConverter(jsonToLock);
        if (zooKeeper.exists(LOCKS_ROOT_PATH, false) == null) {
            zooKeeper.create(LOCKS_ROOT_PATH, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        List<String> vectorList = this.zooKeeper.getChildren(LOCKS_ROOT_PATH, false);
        if (vectorList.isEmpty()) {
            createLocksForVectorService(toLockList);
            return true;
        } else {
            for(String vectorService: toLockList.keySet()){
                List<String> posList = this.zooKeeper.getChildren(LOCKS_ROOT_PATH + "/" + vectorService, false);
                for (Integer pos: toLockList.get(vectorService)){
                    if(posList.contains(pos.toString())){
                        System.out.println("Failed to acquire lock for position: " + pos);
                        return false;
                    }
                }
            }
            createLocksForVectorService(toLockList);
            return true;
        }
    }

    private void createLocksForVectorService(HashMap<String, ArrayList<Integer>> toLockList) throws KeeperException, InterruptedException {
        for(String vectorService: toLockList.keySet()){
            String path = LOCKS_ROOT_PATH + "/" + vectorService;
            Stat stat = this.zooKeeper.exists(path, true);
            if(stat == null){
                zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }

            for (int pos: toLockList.get(vectorService)){
                zooKeeper.create(path + "/" + pos, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                System.out.println("Lock acquired for - " + zooKeeper.getChildren(path,false));
            }

        }
    }


    public void releaseLock(String releaseLockListJson) throws Exception {
        System.out.println("Releasing lock for " + releaseLockListJson);
        HashMap<String, ArrayList<Integer>> releaseLockList = jsonConverter(releaseLockListJson);
        for (String vectorService : releaseLockList.keySet()) {
            String path = LOCKS_ROOT_PATH + "/" + vectorService;
            for (Integer pos : releaseLockList.get(vectorService)) {
                String lockPath = path + "/" + pos;
                try {
                    System.out.println("Deleting node " + pos + " - " + zooKeeper.getChildren(path,false));
                    this.zooKeeper.delete(lockPath, -1);
                    this.zooKeeper.getChildren(path, true);
                } catch (Exception e) {
                    System.out.println("Error in releasing locks!");
                    System.out.println(zooKeeper.getChildren(LOCKS_ROOT_PATH,false));
                    System.out.println(e);
                }
            }
        }
    }


    // Close the ZooKeeper connection when no longer needed
    public void close() throws InterruptedException {
        zooKeeper.close();
    }

    private HashMap<String, ArrayList<Integer>> jsonConverter(String releaseLockListJson) {
        HashMap<String, ArrayList<Integer>> releaseLockList;
        try {
            releaseLockList = mapper.readValue(releaseLockListJson, new TypeReference<>() {
            });
            return releaseLockList;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
