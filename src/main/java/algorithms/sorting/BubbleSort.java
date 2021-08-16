package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

	Random rnd = new Random();

	long numberOfSwaps = 0;
	public void sort(int arr[]) {

		boolean swap;
		do {
			swap = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					swap = true;
				}
			}
		} while (swap);
		
		System.out.println(numberOfSwaps);
	}

	private void swap(int[] array, int i, int j) {
		numberOfSwaps++;
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

}
