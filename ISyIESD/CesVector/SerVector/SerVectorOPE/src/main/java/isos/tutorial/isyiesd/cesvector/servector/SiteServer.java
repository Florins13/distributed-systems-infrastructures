package isos.tutorial.isyiesd.cesvector.servector;

import javax.xml.ws.Endpoint;

/**
 * Hello world!
 */
public class SiteServer {

    public static void main(String[] args) {
    	
    	// registo no ISystem0; ISyIESD/CesVector/SerVector
    	
        Endpoint ep = Endpoint.create(new Vector());
        System.out.println("Starting SiteServer...");
        ep.publish("http://localhost:2058/Vector");

        Endpoint ep1 = Endpoint.create(new Vector());
        System.out.println("Starting SiteServer...");
        ep1.publish("http://localhost:2062/Vector");
    }

}
