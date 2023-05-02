package isos.tutorial.isyiesd.cesvector.servector;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "isos.tutorial.isyiesd.cesvector.servector.IVector")
public class Vector implements IVector {

    private static List<Integer> vector = Arrays.asList(300, 234, 56, 789);
    
    private static List<Integer> cloneState = new ArrayList<Integer>();

    @Override
    public int read(int pos) {
        System.out.println("Reading position " + pos + " !");
        return vector.get(pos);
    }

    @Override
    public void write(int pos, int n) {
    	// For now we save the whole state of the array and focus on the flow
    	// This should be improved and save only the position of modified vectors.
    	Vector.cloneState.addAll(Vector.vector);
        System.out.println("Writing to clone state in pos ->" + pos + "<- value ->" + n + "<- !" );
        Vector.cloneState.set(pos, n);
    }

	@Override
	public String invariantCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean prepare() {
		System.out.println("PREPARE PHASE! --- return true");
		// Simulate that we are ready
		return true;
	}

	@Override
	public void commit() {
		System.out.println("Commiting our cloneState to main one!");
		Vector.vector = cloneState;
		System.out.println(Vector.vector.get(0));
		System.out.println(Vector.vector.get(1));
		System.out.println(Vector.vector.get(2));
		System.out.println(Vector.vector.get(3));
		System.out.println("Process finished!");
	}

	@Override
	public void rollback() {
		System.out.println("Rolling back the cloneState, transaction aborted!");
		Vector.cloneState = Vector.vector;
		System.out.println(Vector.vector.get(0));
		System.out.println(Vector.vector.get(1));
		System.out.println(Vector.vector.get(2));
		System.out.println(Vector.vector.get(3));
		System.out.println("Process finished!");
		
	}
}
