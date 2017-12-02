package sort.lib;

import java.util.Comparator;

/**
 * This algorithm is stable.
 * Before moving to their respective places
 * the elements are read in a strict order,
 * they only move one cell at a time
 * and their places aren't exchanged if they have equal keys
 * */
public class CocktailSort implements Sorter {
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static boolean exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
		return true;
	}

	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public void sort(Comparable[] array) {
		for (int k = array.length - 1; k > 0; k--) {
			boolean swapped = false;
			for (int i = k; i > 0; i--)
				if (less(array[i], array[i - 1]))
					swapped = exch(array, i, i - 1);
			for (int i = 0; i < k; i++)
				if (less(array[i + 1], array[i]))
					swapped = exch(array, i, i + 1);
			if (!swapped)
				break;
		}
	}

	/////////////////////////////////////////////////////////////////////

	public void sort(Comparable[] array, Comparator com) {
		for (int k = array.length - 1; k > 0; k--) {
			boolean swapped = false;
			for (int i = k; i > 0; i--)
				if (less(array[i], array[i - 1], com))
					swapped = exch(array, i, i - 1);
			for (int i = 0; i < k; i++)
				if (less(array[i + 1], array[i], com))
					swapped = exch(array, i, i + 1);
			if (!swapped)
				break;
		}
	}

	private static boolean less(Comparable v, Comparable w, Comparator com) {
		return com.compare(v, w) < 0;
	}

}