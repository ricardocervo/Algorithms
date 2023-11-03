package algorithms.leetcode;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> valueToFrequency = new HashMap<>();

		Comparator<Integer> comp = (i1, i2) -> Integer.compare(i2, i1);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comp);
		for (int i = 0; i < nums.length; i++) {
			valueToFrequency.put(nums[i], valueToFrequency.getOrDefault(nums[i], 0) + 1);
		}

		for (Integer freq : valueToFrequency.keySet()) {
			maxHeap.add(valueToFrequency.get(freq));
		}

		Map<Integer, Stack<Integer>> frequencyToListOfValues = new HashMap<>();
		for (Integer value : valueToFrequency.keySet()) {
			int freq = valueToFrequency.get(value);

			if (frequencyToListOfValues.get(freq) == null) {
				frequencyToListOfValues.put(freq, new Stack<>());
			}
			frequencyToListOfValues.get(freq).add(value);
		}
 
		int[] toReturn = new int[k];
		for (int i = 0; i< k; i++) {
			int freq = maxHeap.poll();
			Stack<Integer> values = frequencyToListOfValues.get(freq);
			toReturn[i] = values.pop();
		}
		return toReturn;
	}
	@Test
	public void test4() {
		int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6 };
		int k = 10;
		assertTrue(Arrays.equals(new int[] { 1, 2, 5, 3, 6, 7, 4, 8, 10, 11 }, topKFrequent(nums, k)));
	}
//
//	@Test
//	public void test1() {
//		int[] nums = { 1, 1, 1, 2, 2, 3 };
//		int k = 2;
//		assertTrue(Arrays.equals(new int[] { 1, 2 }, topKFrequent(nums, k)));
//	}
//
//	@Test
//	public void test2() {
//		int[] nums = { 1 };
//		int k = 1;
//		assertTrue(Arrays.equals(new int[] { 1 }, topKFrequent(nums, k)));
//	}
//
//	@Test
//	public void test3() {
//		int[] nums = { -1, -1 };
//		int k = 1;
//		assertTrue(Arrays.equals(new int[] { -1 }, topKFrequent(nums, k)));
//	}

}
