package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;


public class SubarraySumEqualsK {

	/*
	 * Using HashMap O(n):
	 */

	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> mapSums = new HashMap<>();
		mapSums.put(0, 1);
		int sum = 0;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (mapSums.containsKey(sum - k)) {
				result += mapSums.get(sum - k);
			}
			mapSums.put(sum, mapSums.getOrDefault(sum, 0) + 1);
		}
		return result;
	}

	/*
	 * Brute-force O(n�)
	 */
//	public int subarraySum(int[] nums, int k) {
//
//		int sum = 0;
//		int ans = 0;
//		HashMap<Integer, Integer> map = new HashMap<>();
//		map.put(0, 1);
//		
//		for (int i = 0; i < nums.length; i++) {
//			sum += nums[i];
//			if (map.containsKey(sum - k)) {
//				ans += map.get(sum - k);
//			}
//			map.put(sum, map.getOrDefault(sum, 0) + 1);
//		}
//		return ans;
//	}

	@Test
	public void test0() {
		int arr[] = { 1, 1, 0 };
		int k = 2;
		assertEquals(2, subarraySum(arr, k));
	}

	@Test
	public void test1() {
		int arr[] = { 1, 1, 1, 0, 0 };
		int k = 2;
		assertEquals(4, subarraySum(arr, k));
	}

	@Test
	public void test2() {
		int arr[] = { 1, 2, 3 };
		int k = 3;
		assertEquals(2, subarraySum(arr, k));
	}
}
