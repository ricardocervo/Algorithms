package algorithms;
import java.util.Arrays;
import java.util.Random;

import algorithms.sorting.BubbleSort;
import algorithms.sorting.HeapSort;
import algorithms.sorting.QuickSort;
import algorithms.utils.TimerUtils;

class Main {

	
	static Random rnd = new Random();
	
	static int[]  randomArray(int n) {
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = rnd.nextInt(99);
		}
		
		return arr;
	}
	
	static void printArray(int[] arr) {
		String str = Arrays.toString(arr);
		System.out.println(str);
	}

	public static void main(String[] args) {
		int[] array = randomArray(10 * 600 * 1000);
//		int[] array = {24, 77, 37, 82, 57, 83, 38, 53, 44, 1, 78, 24, 7, 80, 92, 20, 48, 13, 10, 52};
		
		
		TimerUtils timerUtils = new TimerUtils();
		timerUtils.reset();
//		new QuickSort().quickSort(array);
		new HeapSort().sort(array);
//		new BubbleSort().sort(array);
		timerUtils.printTime("tempo gasto na ordenação");
	}
}