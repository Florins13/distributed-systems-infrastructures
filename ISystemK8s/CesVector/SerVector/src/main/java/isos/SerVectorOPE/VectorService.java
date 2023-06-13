package isos.SerVectorOPE;

import isos.SerVectorAPIM.IVector;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingProvider;
import sertransactionmanager.cesvector.isos.ITransactionManager;
import sertransactionmanager.cesvector.isos.TransactionManagerService;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebService(targetNamespace = "http://isos.cesvector.vectorserver")
public class VectorService implements IVector {

	private final String serverIdentifier = "vectorService1";

    private static List<Integer> vector = Arrays.asList(300, 234, 56, 789);

	private Map<String, TransactionState> transactionList = new HashMap<String, TransactionState>();


	@WebMethod
    @Override
    public int read(int pos, String transactionId) {
		if(transactionList.containsKey(transactionId) && transactionList.get(transactionId).vectorState.containsKey(pos)){
			System.out.println("Reading from transaction state position " + pos + " !");
			return transactionList.get(transactionId).vectorState.get(pos);
		}
        System.out.println("Reading position " + pos + " !");
        return vector.get(pos);
    }

	@WebMethod
    @Override
    public void write(int pos, int n, String transactionId) {
        System.out.println("Writing to transactionState in pos ->" + pos + "<- value ->" + n + "<- !" );
		if(!transactionList.containsKey(transactionId)){
			TransactionManagerService testServ = new TransactionManagerService();
			ITransactionManager tmService = testServ.getITransactionManagerPort();
			((BindingProvider) tmService).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://tm-service/service/TransactionManagerService");
			tmService.joinTransaction(transactionId, serverIdentifier);
			TransactionState transactionState = new TransactionState();
			transactionState.vectorState.put(pos,n);
			transactionList.put(transactionId,transactionState);
		}else{
			transactionList.get(transactionId).vectorState.put(pos,n);
		}

    }


	@WebMethod
	@Override
	public String invariantCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@WebMethod
	@Override
	public boolean prepare(String transactionId) {
		System.out.println("PREPARE PHASE! --- return true");
		// Simulate that we are ready
		return true;
	}

	@WebMethod
	@Override
	public void commit(String transactionId) {
		System.out.println("Commiting!");
		transactionList.get(transactionId).vectorState.forEach((pos,value)-> VectorService.vector.set(pos,value));
		removeTransaction(transactionId);
		System.out.println(VectorService.vector.get(0));
		System.out.println(VectorService.vector.get(1));
		System.out.println(VectorService.vector.get(2));
		System.out.println(VectorService.vector.get(3));
		System.out.println("Process finished!");
	}

	@WebMethod
	@Override
	public void rollback(String transactionId) {
		System.out.println("Rolling back the changes!");
		removeTransaction(transactionId);
		System.out.println(VectorService.vector.get(0));
		System.out.println(VectorService.vector.get(1));
		System.out.println(VectorService.vector.get(2));
		System.out.println(VectorService.vector.get(3));
		System.out.println("Process finished!");

	}

	public void removeTransaction(String transactionId){
		this.transactionList.remove(transactionId);
	}

	//	@PostConstruct
//	public void init(){
//		String transactionManagerAddress = null;
//		try {
//			transactionManagerAddress = discoverService("TransactionManager");
//			System.out.println("TransactionManager address: " + transactionManagerAddress);
//			this.testServ = new TransactionManagerService(new URL(transactionManagerAddress));
//			this.tmService = testServ.getTransactionManagerPort();
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

//	public static String discoverService(String serviceName) throws Exception {
//		// TODO: to be moved to a zookeper package
//		ZooKeeperHelper zkHelper = new ZooKeeperHelper();
//		List<String> serviceAddresses = zkHelper.discoverService(serviceName);
//		zkHelper.close();
//
//		if (!serviceAddresses.isEmpty()) {
//			return serviceAddresses.get(0); // Select the first available service address
//		} else {
//			throw new IllegalStateException("No instances of service " + serviceName + " found");
//		}
//	}
}
