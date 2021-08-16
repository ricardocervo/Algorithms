package algorithms.datastructure;

import java.util.PriorityQueue;

public class TestHeap {
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		minHeap.add(4);
		minHeap.add(7);
		minHeap.add(9);
		minHeap.add(3);
		minHeap.add(12);
		minHeap.add(8);
		minHeap.add(7);
		minHeap.add(5);
		minHeap.add(6);
		minHeap.add(22);
		minHeap.add(1);
		
		
	}
}
