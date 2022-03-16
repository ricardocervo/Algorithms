package algorithms.utils;

import java.util.Random;

public class Utils {

	
	public static int[]  randomArray(int n) {
		Random rnd = new Random();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = rnd.nextInt(99);
		}
		
		return arr;
	}
}
