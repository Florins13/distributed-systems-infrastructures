package isos.tutorial.isyiesd.cesvector.servector;

import isos.tutorial.isyiesd.cesvector.sertransactionmanager.ITransactionManager;
import isos.tutorial.isyiesd.cesvector.sertransactionmanager.TransactionManagerService;
import isos.tutorial.isyiesd.cesvector.sertransactionmanager.ZooKeeperHelper;

import javax.annotation.PostConstruct;
import javax.jws.WebService;
import java.net.URL;
import java.util.*;

@WebService(endpointInterface = "isos.tutorial.isyiesd.cesvector.servector.IVector")
public class Vector implements IVector {

	TransactionManagerService testServ;
	ITransactionManager tmService;

	private final String serverIdentifier = "vectorService1";

    private static List<Integer> vector = Arrays.asList(300, 234, 56, 789);

	private Map<String, TransactionState> transactionList = new HashMap<String, TransactionState>();

	@PostConstruct
	public void init(){
		String transactionManagerAddress = null;
		try {
			transactionManagerAddress = discoverService("TransactionManager");
			System.out.println("TransactionManager address: " + transactionManagerAddress);
			this.testServ = new TransactionManagerService(new URL(transactionManagerAddress));
			this.tmService = testServ.getTransactionManagerPort();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    @Override
    public int read(int pos, String transactionId) {
		if(transactionList.containsKey(transactionId) && transactionList.get(transactionId).vectorState.containsKey(pos)){
			System.out.println("Reading from transaction state position " + pos + " !");
			return transactionList.get(transactionId).vectorState.get(pos);
		}
        System.out.println("Reading position " + pos + " !");
        return vector.get(pos);
    }

    @Override
    public void write(int pos, int n, String transactionId) {
        System.out.println("Writing to transactionState in pos ->" + pos + "<- value ->" + n + "<- !" );
		if(!transactionList.containsKey(transactionId)){
			tmService.joinTransaction(transactionId, serverIdentifier);
			TransactionState transactionState = new TransactionState();
			transactionState.vectorState.put(pos,n);
			transactionList.put(transactionId,transactionState);
		}else{
			transactionList.get(transactionId).vectorState.put(pos,n);
		}

    }

	@Override
	public String invariantCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean prepare(String transactionId) {
		System.out.println("PREPARE PHASE! --- return true");
		// Simulate that we are ready
		return true;
	}

	@Override
	public void commit(String transactionId) {
		System.out.println("Commiting!");
		System.out.println(transactionList.values());
		System.out.println(transactionList.get(transactionId).vectorState.toString());
		System.out.println(Vector.vector);
		System.out.println("Commiting!");
		transactionList.get(transactionId).vectorState.forEach((pos,value)-> Vector.vector.set(pos,value));
		removeTransaction(transactionId);
		System.out.println(Vector.vector.get(0));
		System.out.println(Vector.vector.get(1));
		System.out.println(Vector.vector.get(2));
		System.out.println(Vector.vector.get(3));
		System.out.println("Process finished!");
	}

	@Override
	public void rollback(String transactionId) {
		System.out.println("Rolling back the cloneState, transaction aborted!");
		removeTransaction(transactionId);
		System.out.println(Vector.vector.get(0));
		System.out.println(Vector.vector.get(1));
		System.out.println(Vector.vector.get(2));
		System.out.println(Vector.vector.get(3));
		System.out.println("Process finished!");

	}

	public void removeTransaction(String transactionId){
		this.transactionList.remove(transactionId);
	}


	public static String discoverService(String serviceName) throws Exception {
		// TODO: to be moved to a zookeper package
		ZooKeeperHelper zkHelper = new ZooKeeperHelper();
		List<String> serviceAddresses = zkHelper.discoverService(serviceName);
		zkHelper.close();

		if (!serviceAddresses.isEmpty()) {
			return serviceAddresses.get(0); // Select the first available service address
		} else {
			throw new IllegalStateException("No instances of service " + serviceName + " found");
		}
	}
}
