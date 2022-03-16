package algorithms.sorting;

import java.util.Arrays;

import algorithms.utils.Utils;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = Utils.randomArray(10);
		
		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
	}

	static void mergeSort(int[] arr, int start, int end) {
		if (end - start > 1) {
			int middle = (start + end) / 2;
			mergeSort(arr, start, middle);
			mergeSort(arr, middle, end);
			merge(arr, start, middle, end);

		}
	}

	static int[] copyList(int[] arr, int start, int end) {
		int[] toReturn = new int[end - start];
		for (int i=start; i<end; i++) {
			toReturn[i] = arr[i];
		}
		return toReturn;
	}
	
	static void merge(int[] arr, int start, int middle, int end) {
		int[] left = copyList(arr, start, middle);
		int[] right = copyList(arr, middle, end);
		int indTopLeft = 0, indTopRight = 0;
		for (int k = start; k < end; k++) {
			if (indTopLeft >= left.length) {
				arr[k] = right[indTopRight];
				indTopRight++;
			} else if (indTopRight >= right.length) {
				arr[k] = left[indTopLeft];
				indTopLeft++;
			} else if (left[indTopLeft] < right[indTopRight]) {
				arr[k] = left[indTopLeft];
				indTopLeft++;
			} else {
				arr[k] = right[indTopRight];
				indTopRight++;
			}
		}
	}
}