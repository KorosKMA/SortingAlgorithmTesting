package hexahedra_testing;
import java.io.*;
import sort.lib.*;

public class Test {
	
	//Choose a sorting algorithm from the library
	private static final Sorter algorithm = new MergeSort();
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Hexahedron[] array = new Hexahedron[TestDataGenerator.NUM_OF_HEXS];
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(TestDataGenerator.out));
		for(int i=0;i<array.length;i++){
			array[i]=(Hexahedron) in.readObject();
		}
		in.close();
		algorithm.sort(array);
		System.out.println("Default order:");
		for(Hexahedron x: array){
			System.out.println(x);
		}
		System.out.println("Default order(hexes):");
		for(Hexahedron x: array){
			System.out.println(x.getHex());
		}
		System.out.println("Edge order:");
		algorithm.sort(array, Hexahedron.EDGE_ORDER);
		for(Hexahedron x: array){
			System.out.println(x);
		}
		System.out.println("Roundness order:");
		algorithm.sort(array, Hexahedron.ROUNDNESS_ORDER);
		for(Hexahedron x: array){
			System.out.println(x);
		}
		System.out.println("Smoothness order:");
		algorithm.sort(array, Hexahedron.SMOOTHNESS_ORDER);
		for(Hexahedron x: array){
			System.out.println(x);
		}
		System.out.println("Color order:");
		algorithm.sort(array, Hexahedron.COLOR_ORDER);
		for(Hexahedron x: array){
			System.out.println(x);
		}
		System.out.println("Color order(color sums):");
		double color=0;
		for(Hexahedron x: array){
			for(double c: x.getColor())
				color+=c;
			System.out.println(color);	
			color=0;
		}
	}

}
