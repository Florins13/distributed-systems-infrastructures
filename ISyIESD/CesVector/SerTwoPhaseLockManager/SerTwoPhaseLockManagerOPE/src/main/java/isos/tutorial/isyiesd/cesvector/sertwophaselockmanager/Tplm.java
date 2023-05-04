package isos.tutorial.isyiesd.cesvector.sertwophaselockmanager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import javax.jws.WebService;

@WebService(endpointInterface = "isos.tutorial.isyiesd.cesvector.sertwophaselockmanager.ITplm")
public class Tplm implements ITplm{

	File file = new File("lock.txt");
	
	@Override
	public FileLock acquireLock() {
		try {
			if (!file.exists()) {
		        file.createNewFile();
		      }
			FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
			FileLock lock = channel.tryLock();
			System.out.println(channel.isOpen());
			System.out.println(lock.isValid());
			return lock;
		} catch (IOException e) {
		      e.printStackTrace();
		      return null;
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
