package algorithms.datastructure;

import java.util.Arrays;

public class MinHeap {

	int capacity = 10;
	int size = 0;
	private int[] items = new int[capacity];

	private int getLeftChildIndex(int i) { return i * 2 + 1; }
	private int getRightChildIndex(int i) {	return i * 2 + 2; }
	private int getParentIndex(int i) {	return (i - 2) / 2;	}
	
	private boolean hasLeftChild(int i) { return getLeftChildIndex(i) < size; }
	private boolean hasRightChild(int i) { return getRightChildIndex(i) < size; }
	private boolean hasParent(int i) { return getParentIndex(i) >= 0; }
	
	private int leftChild(int i) { return items[getLeftChildIndex(i)]; }
	private int rightChild(int i) { return items[getRightChildIndex(i)]; }
	private int parent(int i) { return items[getParentIndex(i)]; }
	
	private void swap (int i, int j) {
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	
	private void ensureExtraCapacity() {
		if (size == capacity) {
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
	
	public int peek() {
		if (size == 0) throw new IllegalStateException();
		return items[0];
	}
	
	public int poll() {
		if (size == 0) throw new IllegalStateException(); 
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void add(int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	private void heapifyUp() {
		int i = size - 1;
		while (hasParent(i) && parent(i) > items[i]) {
			swap(getParentIndex(i), i);
			i = getParentIndex(i);
		}
	}
	
	private void heapifyDown() {
		int i = 0;
		while (hasLeftChild(i)) {
			int smallerChildIndex = getLeftChildIndex(i);
			if (hasRightChild(i) && rightChild(i) < leftChild(i)) {
				smallerChildIndex = getRightChildIndex(i);
			}
			
			if (items[i] < items[smallerChildIndex]) {
				break;
			} else {
				swap(i, smallerChildIndex);
			}
			i = smallerChildIndex;
			
		}
	}
	
}
