package isos.tutorial.isyiesd.cesvector.sertwophaselockmanager;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "isos.tutorial.isyiesd.cesvector.sertwophaselockmanager.ITplm")
public class Tplm implements ITplm{

	final static String LOCK_PATH = "tplm_lock.txt";
	Map<String, List<Integer>> lockList = new HashMap<String, List<Integer>>();

	// Client -> pos 0 -> LOCK pos 1 -> lock.txt => LOCKED
	// Client 2 -> pos 2-3 ->

	public Tplm() {
		this.lockList.put("vectorService1", new ArrayList<Integer>());
		this.lockList.put("vectorService2", new ArrayList<Integer>());
	}

	@Override
	public boolean acquireLocks(Map<String, List<Integer>> desiredLockList) {
		try (RandomAccessFile file  = new RandomAccessFile(LOCK_PATH, "rw");  FileChannel channel = file.getChannel();
			 FileLock lock = channel.lock()){
			System.out.println(channel.isOpen());
			System.out.println(lock.isValid());
			for (String vectorService: desiredLockList.keySet()){
				if(!this.lockList.containsKey(vectorService))throw new Exception();
				for (Integer pos: desiredLockList.get(vectorService)) {
					if(lockList.get(vectorService).contains(pos))return false;
				}
			}
			for (String vectorService: desiredLockList.keySet()){
				for (Integer pos: desiredLockList.get(vectorService)) {
					lockList.get(vectorService).add(pos);
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("Error");
			return false;
		}

	}

	@Override
	public boolean releaseLocks(Map<String, List<Integer>> releaseLockList) {
		try (RandomAccessFile file  = new RandomAccessFile(LOCK_PATH, "rw");  FileChannel channel = file.getChannel();
			 FileLock lock = channel.lock()){
			System.out.println(channel.isOpen());
			System.out.println(lock.isValid());
			for (String vectorService: releaseLockList.keySet()){
				for (Integer pos: releaseLockList.get(vectorService)) {
					lockList.get(vectorService).remove(pos);
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println("Error");
			return false;
		}
	}

}
