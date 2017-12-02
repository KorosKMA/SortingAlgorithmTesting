package sort.lib;

import java.util.Comparator;

public interface Sorter {
	
	public void sort(Comparable[] a);
	public void sort(Comparable[] a, Comparator com);
}
