package hexahedra_testing;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/**Class representing regular hexahedra*/
public class Hexahedron implements Comparable<Hexahedron>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5614143251163588603L;
	public static final Comparator<Hexahedron> EDGE_ORDER = new EOrder();
	public static final Comparator<Hexahedron> ROUNDNESS_ORDER = new ROrder();
	public static final Comparator<Hexahedron> SMOOTHNESS_ORDER = new SOrder();
	public static final Comparator<Hexahedron> COLOR_ORDER = new COrder();
	
	
	/**Length of an edge*/
	private final double edge;
	/**Level of roundness. 0 - cube; positive infinity - sphere; negative infinity - 4 intersecting diagonals*/
	private final double roundness;
	/**Level of smoothness. 0 - smooth; positive infinity - no friction; negative infinity - no sliding*/
	private final double smoothness;
	/**Array containing brightness of RGB components of hexahedron's color. 0 - deflects 50% of corresponding light; positive infinity - emits light in the darkness; negative infinity - bends light rays that miss the surface in order to absorb them*/
	private final double[] color;

	private Double hex = null;
	
	private static int toStringOrder = 0;
	
	public Hexahedron(double edge, double roundness, double smoothness, double colorR, double colorG, double colorB) {
		this.edge = edge;
		this.roundness=roundness;
		this.smoothness = smoothness;
		this.color = new double[]{colorR, colorG, colorB};
	}
	
	public int compareTo(Hexahedron that) {
		double hex1 = getHex();
		double hex2 = that.getHex();
		if (hex1 > hex2)
			return 1;
		if (hex1 < hex2)
			return -1;
		return 0;
	}

	private static class EOrder implements Comparator<Hexahedron> {

		public int compare(Hexahedron h1, Hexahedron h2) {
			toStringOrder=0;
			double edge1 = h1.edge;
			double edge2 = h2.edge;
			if (edge1 > edge2)
				return 1;
			if (edge1 < edge2)
				return -1;
			return 0;
		}
	}
	
	private static class ROrder implements Comparator<Hexahedron> {

		public int compare(Hexahedron h1, Hexahedron h2) {
			toStringOrder=1;
			double roundness1 = h1.roundness;
			double roundness2 = h2.roundness;
			if (roundness1 > roundness2)
				return 1;
			if (roundness1 < roundness2)
				return -1;
			return 0;
		}
	}
	
	private static class SOrder implements Comparator<Hexahedron> {

		public int compare(Hexahedron h1, Hexahedron h2) {
			toStringOrder=2;
			double smoothness1 = h1.smoothness;
			double smoothness2 = h2.smoothness;
			if (smoothness1 > smoothness2)
				return 1;
			if (smoothness1 < smoothness2)
				return -1;
			return 0;
		}
	}
	
	private static class COrder implements Comparator<Hexahedron> {

		public int compare(Hexahedron h1, Hexahedron h2) {
			toStringOrder=3;
			double color1=0;
			double color2=0;
			for(int i=0;i<h1.color.length;i++){
				color1+=h1.color[i];
				color2+=h2.color[i];
			}
			if (color1 > color2)
				return 1;
			if (color1 < color2)
				return -1;
			return 0;
		}
	}
	
	

	public String toString() {
		switch(toStringOrder){
		case 0:
			return "(e: " + edge + 
					", r: " + roundness + ", s: " + smoothness + ", c: " + Arrays.toString(color) + ")";
		case 1:
			return "(r: " + roundness +
					", e: " + edge + ", s: " + smoothness + ", c: " + Arrays.toString(color) + ")";
		case 2:
			return"(s: " + smoothness + 
					", r: " + roundness + ", e: " + edge + ", c: " + Arrays.toString(color) + ")";
		case 3:
			return "(c: " + Arrays.toString(color) + 
			", r: " + roundness + ", s: " + smoothness + ", e: " + edge + ")";
		}
		return "(e: " + edge + ", r: " + roundness + ", s: " + smoothness + ", c: " + Arrays.toString(color) + ")";
	}
	
	/**
	 * @return the edge
	 */
	public double getEdge() {
		return edge;
	}

	/**
	 * @return the roundness
	 */
	public double getRoundness() {
		return roundness;
	}

	/**
	 * @return the smoothness
	 */
	public double getSmoothness() {
		return smoothness;
	}

	/**
	 * @return the color
	 */
	public double[] getColor() {
		return color;
	}
	
	/**
	 * @return the Hex
	 */
	public double getHex() {
		if(hex==null){
			double color=0;
			for(double x:this.color){
				color+=x;
			}
			hex=((edge+roundness+smoothness+color/3)/4);
		}
		return hex;
	}
}