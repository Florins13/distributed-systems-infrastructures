package isos.SerTransManagerOPE;


import isos.SerTransManagerAPIM.ITransactionManager;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingProvider;
import vectorserver.cesvector.isos.IVector;
import vectorserver.cesvector.isos.VectorService;

import java.util.*;


// targetNamespace is important to match the one from interfaces
@WebService(endpointInterface = "isos.SerTransManagerAPIM.ITransactionManager", targetNamespace = "http://isos.cesvector.sertransactionmanager")
public class TransactionManagerService implements ITransactionManager {

	private Map<String, IVector> resourceManagersIds = new HashMap<String, IVector>();

	private Map<String, List<String>> activeTransactions = new HashMap<String, List<String>>();


	public void initialiseResources(){
		VectorService service= new VectorService();;
		IVector resourceManager1 = service.getIVectorPort();
		((BindingProvider) resourceManager1).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://vector-service/service/VectorService");
		if(!this.resourceManagersIds.containsKey("vectorService1")){
			resourceManagersIds.put("vectorService1", resourceManager1);
		}

	}

	@WebMethod
	@Override
	public String begin() {
		System.out.println("Initiating transaction ---");
		String transactionId = UUID.randomUUID().toString();
		activeTransactions.put(transactionId,new ArrayList<String>());
		return transactionId;
	}

	@WebMethod
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

	@WebMethod
	@Override
	public void rollback(String transactionId) {
		for (String vectorServiceId : this.activeTransactions.get(transactionId)) {
			this.resourceManagersIds.get(vectorServiceId).rollback(transactionId);
		}
		this.activeTransactions.remove(transactionId);
		System.out.println("Transaction rolled back and transaction " + transactionId + " was removed!");
	}

	@WebMethod
	@Override
	public void joinTransaction(String transactionId, String serverId) {
		initialiseResources(); // vectorService1 joins the transaciton id
		System.out.println(serverId + " joined transaction " + transactionId);
		this.activeTransactions.get(transactionId).add(serverId);
	}

}
