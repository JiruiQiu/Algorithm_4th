package Practice;

public class LSD {
	public static void sort(String[] a, int w) { 
		//Sort a string on leading w characters.
		int n = a.length;
		int R = 256;
		String[] aux = new String[n];
		
		for (int d = w-1; d >= 0; d--) {
			// Sort by key-indexed counting on dth char.
			int[] count = new int[R+1];
			for (int i = 0; i < n; i++) {	//Computer frequency count.
				count[a[i].charAt(d)+1]++;
			}
			
			for (int r = 0; r < R; r++) {	//Translate counts into indices.
				count[r+1] += count[r];
			}
			
			for(int i = 0; i < n; i++) {
				aux[count[a[i].charAt(d)+1]++] = a[i];
			}
			
			for (int i = 0; i < n; i++) {
				a[i] = aux[i];
			}
		}
	}
}
