package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import isos.tutorial.isyiesd.cesvector.servector.IVector;
import isos.tutorial.isyiesd.cesvector.servector.VectorService;

public class Transaction implements ITransaction{
    private UUID id;
    private List<IVector> enlistedResources;
    
    VectorService service = new VectorService();
    IVector resourceManager1 = service.getVectorPort();

    public Transaction() {
        id = UUID.randomUUID();
        enlistedResources = new ArrayList<IVector>();
        this.enlistResource(resourceManager1);
    }

    public UUID getId() {
        return id;
    }

	@Override
    public void enlistResource(IVector resourceManager) {
        enlistedResources.add(resourceManager);
    }

    public void commit() {
        // The two-phase commit protocol to coordinate the commit across servers
    	// Phase 1: Prepare
        boolean allPrepared = true;
        System.out.println("Preparing 2 phase commit ---");
        for (IVector server : enlistedResources) {
            boolean prepared = server.prepare();
            if (!prepared) {
                allPrepared = false;
                break;
            }
        }

        // Phase 2: Commit or Rollback
        if (allPrepared) {
        	System.out.println("All participants(rm's) ready to commit! ---");
            for (IVector server : enlistedResources) {
            	System.out.println(server.toString() + " committing...");
                server.commit();
                System.out.println("Process finished! ---");
            }
        } else {
            for (IVector server : enlistedResources) {
                server.rollback();
            }
        }
    }

    public void rollback() {
        // Implement the rollback process across servers
        for (IVector server : enlistedResources) {
            server.rollback();
        }
    }

}
