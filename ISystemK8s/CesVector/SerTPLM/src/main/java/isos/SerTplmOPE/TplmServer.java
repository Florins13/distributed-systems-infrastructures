package isos.SerTplmOPE;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.xml.ws.Endpoint;
import org.apache.curator.test.TestingServer;

@QuarkusMain
public class TplmServer {
    public static void main(String ... args) throws Exception {
        System.out.println("Running main method");
        TestingServer server = new TestingServer(2181);
        System.out.printf("Started a standalone ZooKeeper server at %s\n", server.getConnectString());
        Quarkus.run(args);
    }
}