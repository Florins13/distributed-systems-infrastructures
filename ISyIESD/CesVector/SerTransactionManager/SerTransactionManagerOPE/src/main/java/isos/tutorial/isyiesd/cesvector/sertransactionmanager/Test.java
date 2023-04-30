package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import javax.jws.WebService;

@WebService(endpointInterface = "isos.tutorial.isyiesd.cesvector.sertransactionmanager.ITest")
public class Test implements ITest{

	@Override
	public void sayHello() {
		System.out.print("It works!");
	}

}
