package isos.SerTplmOPE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import isos.SerTplmAPIM.ITplm;
import jakarta.jws.WebService;
import org.apache.zookeeper.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@WebService(name = "ITplm", targetNamespace = "http://isos.cesvector.twophaselockmanager")
public class Tplm implements ITplm {
	private ZooKeeperCli zk;


	@Override
	public boolean acquireLocks(String desiredLockListJson) {
		try {
			zk = new ZooKeeperCli();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Acquiring lock for " + desiredLockListJson);
		try {
			return zk.acquireLock(desiredLockListJson);
		} catch (KeeperException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean releaseLocks(String releaseLockListJson) {
		try {
			zk.releaseLock(releaseLockListJson);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Successfully released locks!");
		try {
			this.zk.close();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return true;
	}


}
