package isos.SerTplmOPE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import isos.SerTplmAPIM.ITplm;
import jakarta.jws.WebService;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebService(name = "ITplm", targetNamespace = "http://isos.cesvector.twophaselockmanager")
public class Tplm implements ITplm {

	final static String LOCK_PATH = "tplm_lock.txt";
	Map<String, List<Integer>> lockList = new HashMap<String, List<Integer>>();
	ObjectMapper mapper = new ObjectMapper();
	// Client -> pos 0 -> LOCK pos 1 -> lock.txt => LOCKED
	// Client 2 -> pos 2-3 ->

//	public Tplm() {
//		this.lockList.put("vectorService1", new ArrayList<Integer>());
//		this.lockList.put("vectorService2", new ArrayList<Integer>());
//	}

	@Override
	public boolean acquireLocks(String desiredLockListJson) {
		System.out.println("Active locks: " + lockList.toString());
		System.out.println("Acquiring lock for " + desiredLockListJson);
		HashMap<String, ArrayList<Integer>> desiredLockList = jsonConverter(desiredLockListJson);
		try (RandomAccessFile file  = new RandomAccessFile(LOCK_PATH, "rw");  FileChannel channel = file.getChannel();
			 FileLock lock = channel.lock()){
			System.out.println(channel.isOpen());
			System.out.println(lock.isValid());

			for (String vectorService: desiredLockList.keySet()){
				if(!this.lockList.containsKey(vectorService)){
					this.lockList.put(vectorService, new ArrayList<Integer>());
				}
				for (Integer pos: desiredLockList.get(vectorService)) {
					if(lockList.get(vectorService).contains(pos))return false;
				}
			}
			for (String vectorService: desiredLockList.keySet()){
				for (Integer pos: desiredLockList.get(vectorService)) {
					lockList.get(vectorService).add(pos);
				}
			}
			System.out.println("Lock acquired for " + lockList.values());
			return true;
		} catch (Exception e) {
			System.out.println("Error");
			return false;
		}

	}

	@Override
	public boolean releaseLocks(String releaseLockListJson) {
		System.out.println("Releasing lock for " + releaseLockListJson);
		HashMap<String, ArrayList<Integer>> releaseLockList = jsonConverter(releaseLockListJson);
		try (RandomAccessFile file  = new RandomAccessFile(LOCK_PATH, "rw");  FileChannel channel = file.getChannel();
			 FileLock lock = channel.lock()){
			System.out.println(channel.isOpen());
			System.out.println(lock.isValid());
			for (String vectorService: releaseLockList.keySet()){
				for (Integer pos: releaseLockList.get(vectorService)) {
					lockList.get(vectorService).remove(pos);
				}
			}
			System.out.println("Successfully released locks!");
			return true;
		} catch (Exception e) {
			System.out.println("Error");
			return false;
		}
	}

	private HashMap<String, ArrayList<Integer>> jsonConverter(String releaseLockListJson) {
		HashMap<String, ArrayList<Integer>> releaseLockList;
		try {
			releaseLockList = mapper.readValue(releaseLockListJson, new TypeReference<HashMap<String, ArrayList<Integer>>>() {});
			return releaseLockList;
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
