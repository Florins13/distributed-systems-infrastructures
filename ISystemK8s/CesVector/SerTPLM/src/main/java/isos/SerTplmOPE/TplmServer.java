package isos.SerTplmOPE;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.xml.ws.Endpoint;

@QuarkusMain
public class TplmServer {
    public static void main(String ... args) {
        System.out.println("Running main method");
//        Endpoint ep = Endpoint.create(new Tplm());
//        System.out.println("Starting Two phase lock server...");
//        ep.publish("http://localhost:2070/Tplm");
        Quarkus.run(args);
    }
}