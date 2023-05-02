package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import javax.jws.WebService;

@WebService(endpointInterface = "isos.tutorial.isyiesd.cesvector.sertransactionmanager.ITransactionManager")
public class TransactionManager implements ITransactionManager{

	@Override
	public void sayHello() {
		System.out.print("It works!");
	}

}
