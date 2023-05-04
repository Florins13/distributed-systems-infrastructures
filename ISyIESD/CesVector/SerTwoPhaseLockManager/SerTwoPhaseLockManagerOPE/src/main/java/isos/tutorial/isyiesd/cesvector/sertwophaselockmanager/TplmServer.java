package isos.tutorial.isyiesd.cesvector.sertwophaselockmanager;

import javax.xml.ws.Endpoint;


public class TplmServer {

    public static void main(String[] args) {
    	
    	
        Endpoint ep = Endpoint.create(new Tplm());
        System.out.println("Starting Two phase lock server...");
        ep.publish("http://localhost:2060/Tplm");
    }
    
}
