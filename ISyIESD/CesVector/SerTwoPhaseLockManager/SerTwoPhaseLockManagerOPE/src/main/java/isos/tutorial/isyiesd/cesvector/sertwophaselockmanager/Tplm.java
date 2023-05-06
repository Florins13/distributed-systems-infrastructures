package isos.tutorial.isyiesd.cesvector.sertwophaselockmanager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

	File file = new File("lock.txt");
	Map<String, List<Integer>> lockList = new HashMap<String, List<Integer>>();

	// Client -> pos 0 -> LOCK pos 1 -> lock.txt => LOCKED
	// Client 2 -> pos 2-3 ->

	public Tplm() {
		this.lockList.put("vectorService1", new ArrayList<Integer>());
		this.lockList.put("vectorService2", new ArrayList<Integer>());
	}

	@Override
	public boolean acquireLock(Map<String, List<Integer>> desiredLockList) {
//		if (!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				throw new RuntimeException(e);
//			}
//		}
		try (FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
			 FileLock lock = channel.lock()){
			System.out.println(channel.isOpen());
			System.out.println(lock.isValid());
			for (String vectorService: desiredLockList.keySet()){
				if(!this.lockList.containsKey(vectorService))throw new Exception();

			}
			return lock.isValid();
		} catch (Exception e) {
		      e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean checkLock() {
		boolean checkLock = false;
		try {
			FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
			checkLock = channel.isOpen();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return checkLock;
	}

}
