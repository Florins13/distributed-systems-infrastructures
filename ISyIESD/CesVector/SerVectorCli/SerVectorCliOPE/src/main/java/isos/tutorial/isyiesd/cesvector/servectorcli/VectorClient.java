package isos.tutorial.isyiesd.cesvector.servectorcli;

import isos.tutorial.isyiesd.cesvector.servector.IVector;
import isos.tutorial.isyiesd.cesvector.servector.VectorService;
import isos.tutorial.isyiesd.cesvector.sertransactionmanager.*;

/**
 * Hello world!
 */
public class VectorClient {

    public static void main(String[] args) throws InterruptedException {

        VectorService service = new VectorService();
        IVector port = service.getVectorPort();
        
        TestService testServ = new TestService();
        ITest port2 = testServ.getTestPort();

        port2.sayHello();
        int v, res;
        int x = 100;

        v = port.read(0); // v = 300
        res = v - x; // 300 - 100 = 200
        Thread.sleep(1);

        port.write(0, res); // writes 200
        Thread.sleep(10);

        v = port.read(2); // v = 56
        res = v + x; // 56 + 100
        Thread.sleep(10);

        port.write(2, res); // writes 156

    }
}
