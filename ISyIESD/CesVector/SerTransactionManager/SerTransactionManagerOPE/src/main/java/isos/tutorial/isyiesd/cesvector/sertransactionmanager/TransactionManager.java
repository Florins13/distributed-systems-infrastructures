package isos.tutorial.isyiesd.cesvector.sertransactionmanager;



import isos.tutorial.isyiesd.cesvector.servector.IVector;
import isos.tutorial.isyiesd.cesvector.servector.VectorService;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.jws.WebService;


@WebService(endpointInterface = "isos.tutorial.isyiesd.cesvector.sertransactionmanager.ITransactionManager")
public class TransactionManager implements ITransactionManager{

//	private static TransactionManager instance;


	private Map<String, IVector> resourceManagersIds = new HashMap<String, IVector>();

	private Map<String, List<String>> activeTransactions = new HashMap<String, List<String>>();

//    public static synchronized TransactionManager getInstance() {
//        if (instance == null) {
//            instance = new TransactionManager();
//        }
//        return instance;
//    }

//	@PostConstruct
//	public void init(){
//		initialiseResources();
//	}
	public void initialiseResources(){
		VectorService service = new VectorService();
		IVector resourceManager1 = service.getVectorPort();
		if(!this.resourceManagersIds.containsKey("vectorService1")){
			resourceManagersIds.put("vectorService1", resourceManager1);
		}

	}

	@Override
	public String begin() {
		initialiseResources(); // to be moved
		System.out.println("Initiating transaction ---");
		String transactionId = UUID.randomUUID().toString();
		activeTransactions.put(transactionId,new ArrayList<String>());
		return transactionId;
	}

	@Override
	public void commit(String transactionId) {
		System.out.println("Commiting transaction with id - " + transactionId + " ...");
		boolean allPrepared = true;
		System.out.println("Preparing 2 phase commit ---");
		this.activeTransactions.get(transactionId);
		for (String vectorServiceId : this.activeTransactions.get(transactionId)) {
			boolean prepared = this.resourceManagersIds.get(vectorServiceId).prepare(transactionId);
			if (!prepared) {
				allPrepared = false;
				break;
			}
		}

		// Phase 2: Commit or Rollback
		if (allPrepared) {
			System.out.println("All participants(rm's) ready to commit! ---");
			for (String vectorServiceId : this.activeTransactions.get(transactionId)) {
				System.out.println(vectorServiceId + " committing...");
				this.resourceManagersIds.get(vectorServiceId).commit(transactionId);
				System.out.println("Process finished! ---");
			}
		} else {
			for (String vectorServiceId : this.activeTransactions.get(transactionId)) {
				this.resourceManagersIds.get(vectorServiceId).rollback(transactionId);
			}
		}
		this.activeTransactions.remove(transactionId);
	}

	@Override
	public void rollback(String transactionId) {
		for (String vectorServiceId : this.activeTransactions.get(transactionId)) {
			this.resourceManagersIds.get(vectorServiceId).rollback(transactionId);
		}
		this.activeTransactions.remove(transactionId);
		System.out.println("Transaction rolled back and transaction " + transactionId + " was removed!");
	}

	@Override
	public void joinTransaction(String transactionId, String serverId) {
		System.out.println(serverId + " joined transaction " + transactionId);
		this.activeTransactions.get(transactionId).add(serverId);
	}

}
