package algorithms.sorting;

import java.util.TreeSet;

public class HeapSort {

	private int[] array;
	int size;
	
	private int leftIndex(int i) { return i * 2 + 1; }
	private int rightIndex(int i) { return i * 2 + 2; }
	
	private boolean hasLeft(int i) { return leftIndex(i) < size;	}
	private boolean hasRight(int i) { return rightIndex(i) < size;	}
	
	private int left(int i) { return array[leftIndex(i)]; }
	private int right(int i) { return array[rightIndex(i)]; }

	public void sort(int[] array) {
		TreeSet<Integer> map = new TreeSet<>();
		this.array = array;
		size = array.length;

		for (int i = size / 2; i >= 0; i--) {
			heapify(i);
		}
		
		while (size > 0) {
			swap(0, size - 1);
			size--;
			heapify(0);
		}
		
	}

	private void heapify(int i) {
		
		int newRootIndex = i;
		
		if (hasLeft(i) && left(i) > array[i]) {
			 newRootIndex = leftIndex(i);
		}
		if (hasRight(i) && right(i) > array[newRootIndex]) {
			 newRootIndex = rightIndex(i);
		}
		
		if (i != newRootIndex) {
			swap(i, newRootIndex);
			heapify(newRootIndex);
		}
	}
	
	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
