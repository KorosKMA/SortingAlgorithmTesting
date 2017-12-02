package hexahedra_testing;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

public class TestDataGenerator {
	
	static final String out = "HexahedronData.txt";
	static final int NUM_OF_HEXS = 10;
	
	private static Random random = new Random();
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(TestDataGenerator.out));
		for(int i=0;i<NUM_OF_HEXS;i++){
			out.writeObject(new Hexahedron(random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100)));
		}
		out.flush();
		out.close();
	}
	
}
