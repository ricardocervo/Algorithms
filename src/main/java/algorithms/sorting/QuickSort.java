package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	Random rnd = new Random();

	int[] randomArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = rnd.nextInt(99);
		}
		return arr;
	}
	
	public void quickSort(int arr[]) {
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int arr[], int left, int right) {
		if (left < right) {
			int p = partition(arr, left, right);
			quickSort(arr, left, p - 1);
			quickSort(arr, p + 1, right);
		}
	}

	private int partition(int arr[], int left, int right) {
		int pivot = arr[right];
		int i = left;
		for (int j = left; j < right; j++) {
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}

		swap(arr, i, right);

		return i;
	}

	private void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	public boolean isSorted(int[] a) {
		// base case
		if (a == null || a.length <= 1) {
			return true;
		}

		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}

		return true;
	}
}
