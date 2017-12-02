package sort.lib;

import java.util.Comparator;
/**
 * This algorithm is not stable.
 * The elements are swapped from the front of the array 
 * into the spot vacated by the minimum element, 
 * which can mess up the initial order
 * */
public class SelectionSort implements Sorter{

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

	public void sort(Comparable[] a){
		int n = a.length;
		for (int i=0;i<n;i++){
			int min = i;
			for (int j = i+1;j<n;j++)
				if (less(a[j],a[min]))
					min = j;
			exch(a,i,min);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////
	
	public void sort(Comparable[] a, Comparator com){
		int n = a.length;
		for (int i=0;i<n;i++){
			int min = i;
			for (int j = i+1;j<n;j++)
				if (less(a[j],a[min], com))
					min = j;
			exch(a,i,min);
		}
	}
	
	private static boolean less(Comparable v, Comparable w, Comparator com){
		return com.compare(v,w)<0;
	}
	
}