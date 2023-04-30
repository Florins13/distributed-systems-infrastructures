package isos.tutorial.isyiesd.cesvector.servector;

import javax.jws.WebService;
import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "isos.tutorial.isyiesd.cesvector.servector.IVector")
public class Vector implements IVector {

    private static List<Integer> vector = Arrays.asList(300, 234, 56, 789);

    @Override
    public int read(int pos) {
        System.out.println("-----READ-----");
        System.out.println("Reading from vector position " + pos);
        System.out.println("Current READ vector " + vector);
        System.out.println("-----READ-----");
        return vector.get(pos);
    }

    @Override
    public void write(int pos, int n) {
        System.out.println("-----WRITE-----");
        System.out.println("Writing to vector in position " + pos + " with " + n);
        vector.set(pos, n);
        System.out.println("Current WRITED vector " + vector);
        System.out.println("-----WRITE-----");
    }

	@Override
	public String invariantCheck() {
		// TODO Auto-generated method stub
		return null;
	}
}
