package sort.lib;

import java.util.Comparator;

/**
 * This algorithm is stable.
 * Before moving to their respective places
 * the elements are read in a strict order (from left to right),
 * they only move one cell at a time
 * and their places aren't exchanged if they have equal keys
 * */
public class BubbleSort implements Sorter{
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static boolean isSorted(Comparable[] a){
		for (int i=1;i<a.length;i++)
			if (less(a[i],a[i-1])) return false;
		return true;
	}

	public void sort(Comparable[] array) {
		for(int i=0;i<array.length-1;i++){
			for(int j=1;j<array.length-i;j++){
				if(less(array[j],array[j-1]))
					exch(array, j-1, j);
			}
		}
	}

	/////////////////////////////////////////////////////////////////////
	
	public void sort(Comparable[] array, Comparator com) {
		for(int i=0;i<array.length-1;i++){
			for(int j=1;j<array.length-i;j++){
				if(less(array[j],array[j-1], com))
					exch(array, j-1, j);
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w, Comparator com){
		return com.compare(v,w)<0;
	}
	
}
