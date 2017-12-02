package sort.lib;

import java.util.Comparator;


/**
 * This algorithm is stable.
 * During the merging of two sorted arrays
 * the elements are read strictly from left to right.
 * If there are any elements with equal keys,
 * they are inserted in a resulting array right next to each other
 * in the same order as they are in initial arrays,
 * because the next such element is always read right after the previous one
 * */
public class MergeSort implements Sorter{

	private static final int CUTOFF =7;
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		assert isSorted(a, lo, mid); // precondition: a[lo..mid] sorted
		assert isSorted(a, mid+1, hi); // precondition: a[mid+1..hi] sorted
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		assert isSorted(a, lo, hi); // postcondition: a[lo..hi] sorted
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		if (hi <= lo) return;
		if (hi <= lo + CUTOFF - 1) InsertionSort.sort(a,lo,hi);
		else {int mid = lo + (hi - lo) / 2;
			sort(a, aux, lo, mid);
			sort(a, aux, mid+1, hi);
			if (!less(a[mid+1],a[mid])) return;
			merge(a, aux, lo, mid, hi);
		}
	}

	public void sort(Comparable[] a)	{
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	private static boolean isSorted(Comparable[] a, int l, int m){
		for (int i=l;i<=m;i++)
			if (less(a[i],a[i-1])) return false;
		return true;
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w)<0;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi, Comparator com){
		assert isSorted(a, lo, mid,com); // precondition: a[lo..mid] sorted
		assert isSorted(a, mid+1, hi,com); // precondition: a[mid+1..hi] sorted
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++){
			if (i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (less(aux[j], aux[i],com)) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
		assert isSorted(a, lo, hi,com); // postcondition: a[lo..hi] sorted
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi, Comparator com){
		if (hi <= lo) return;
		if (hi <= lo + CUTOFF - 1) InsertionSort.sort(a,lo,hi,com);
		else {int mid = lo + (hi - lo) / 2;
			sort(a, aux, lo, mid,com);
			sort(a, aux, mid+1, hi,com);
			if (!less(a[mid+1],a[mid],com)) return;
			merge(a, aux, lo, mid, hi,com);
		}
	}

	public void sort(Comparable[] a, Comparator com)	{
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1,com);
	}
	
	private static boolean isSorted(Comparable[] a, int l, int m, Comparator com){
		for (int i=l;i<=m;i++)
			if (less(a[i],a[i-1],com)) return false;
		return true;
	}
	
	private static boolean less(Comparable v, Comparable w, Comparator com){
		return com.compare(v,w)<0;
	}
	
}
