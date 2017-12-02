package sort.lib;

import java.util.Comparator;
/**
 * This algorithm is stable.
 * The elements move strictly from right to left
 * one step (cell) at a time
 * and elements with equal keys aren't swapped,
 * so there is no way for elements to jump over each other
 * and mix the original order
 * */
public class InsertionSort implements Sorter{
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0; j--)
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
				else
					break;
		}
	}
	
	public static void sort(Comparable[] a, int l, int h) {
		for (int i = l; i <= h; i++) {
			for (int j = i; j > 0; j--)
				if (less(a[j], a[j - 1]))
					exch(a, j, j - 1);
				else
					break;
		}
	}
	/////////////////////////////////////////////////////////
	
	public void sort(Comparable[] a, Comparator com) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0; j--)
				if (com.compare(a[j], a[j - 1])<0)
					exch(a, j, j - 1);
				else
					break;
		}
	}
	
	
	public static void sort(Comparable[] a, int l, int h, Comparator com) {
		for (int i = l; i <= h; i++) {
			for (int j = i; j > 0; j--)
				if (less(a[j], a[j - 1],com))
					exch(a, j, j - 1);
				else
					break;
		}
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