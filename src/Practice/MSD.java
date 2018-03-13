package Practice;

public class MSD {
	private static int R = 256;
	private static final int CUTOFF = 15;
	private static String[] aux;
	
	private static int charAt(String s, int d) {
		if (s.length() > d)
			return s.charAt(d);
		else
			return -1;
	}
	
	public static void sort(String[] a) {
		int n = a.length;
		aux = new String[n];
		sort(a, 0, n-1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d) {
		if (hi <= lo + CUTOFF) {
			sort(a, lo, hi, d); return;
		}
		int[] count = new int[R+2];
		for (int i = lo; i < hi; i++)
			count[charAt(a[i], d) + 2] ++;
		
		for (int r = 0; r < R+1; r++) {
			count[r+1] += count[r];
		}
		
		for (int i = lo; i < hi; i++) {
			aux[count[charAt(a[i], d) +1]++] = a[i];
		}
		
		for (int i = lo; i < hi; i++)
			a[i] = aux[i - lo];
		
		for (int r = 0; r < R; r++) {
			sort(a, lo + count[r], lo + count[r+1] - 1, d+1);
		}
	}
	
	public static void insert_sort(String[] a, int lo, int hi , int d) {
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && less(a[j], a[j-1], d); j--) 
				exch(a, j, j-1);
	}
	
	private static void exch(String[] a, int x, int y) {
		String temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	private static boolean less(String v, String w, int d) {
		for(int i = d; i < Math.min(v.length(), w.length()); d++)
			if (v.charAt(i) < w.charAt(i))
				return true;
			else if (v.charAt(i) > w.charAt(i))
				return false;
		return v.length() < w.length();
	}
}
