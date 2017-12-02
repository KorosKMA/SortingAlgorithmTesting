package sort.lib;

import java.util.Comparator;
import java.util.Random;

/**
 * This algorithm is bogus.
 * Since it works based on random chance,
 * there is no way to get a stable outcome
 * */
public class BogoSort implements Sorter {
	
	private static final Random random = new Random();
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
	}
	
	private static boolean isSorted(Comparable[] a){
		for (int i=1;i<a.length;i++)
			if (less(a[i],a[i-1])) return false;
		return true;
	}

	public void sort(Comparable[] array) {
		Comparable[] clone = array.clone();
		byte[] indexes = new byte[array.length];
		int index;
		while(!isSorted(clone)){
			for(int i=0;i<indexes.length;i++)
				indexes[i]=0;
			for(Comparable x: array){
				while(true){
					index=random.nextInt(array.length);
					if(indexes[index]==0){
						indexes[index]++;
						break;
					}
				}
				clone[index]=x;
			}
		}
		for(int i=0;i<array.length;i++)
			array[i]=clone[i];
	}

	/////////////////////////////////////////////////////////////////////
	
	public void sort(Comparable[] array, Comparator com) {
		Comparable[] clone = array.clone();
		byte[] indexes = new byte[array.length];
		int index;
		while(!isSorted(clone, com)){
			for(int i=0;i<indexes.length;i++)
				indexes[i]=0;
			for(Comparable x: array){
				while(true){
					index=random.nextInt(array.length);
					if(indexes[index]==0){
						indexes[index]++;
						break;
					}
				}
				clone[index]=x;
			}
		}
		for(int i=0;i<array.length;i++)
			array[i]=clone[i];
	}
	
	private static boolean isSorted(Comparable[] a, Comparator com){
		for (int i=1;i<a.length;i++)
			if (less(a[i],a[i-1],com)) return false;
		return true;
	}
	
	private static boolean less(Comparable v, Comparable w, Comparator com){
		return com.compare(v,w)<0;
	}
	
}
