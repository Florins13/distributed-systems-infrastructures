package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import javax.jws.WebService;

import isos.tutorial.isyiesd.cesvector.servector.IVector;
import isos.tutorial.isyiesd.cesvector.servector.VectorService;

@WebService(endpointInterface = "isos.tutorial.isyiesd.cesvector.sertransactionmanager.ITransactionManager")
public class TransactionManager implements ITransactionManager{

	private static TransactionManager instance;
	

	
    public static synchronized TransactionManager getInstance() {
        if (instance == null) {
            instance = new TransactionManager();
        }
        return instance;
    }

	@Override
	public Transaction begin() {
		System.out.println("Initiating transaction ---");
		return new Transaction();
	}

	@Override
	public void commit(Transaction transaction) {
		System.out.println("Commiting transaction with id - " + transaction.getId() + " ...");
		transaction.commit();
	}

	@Override
	public void rollback(Transaction transaction) {
		transaction.rollback();
	}

}
