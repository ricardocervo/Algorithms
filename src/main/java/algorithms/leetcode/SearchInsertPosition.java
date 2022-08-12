package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		int begin = 0;
		int end = nums.length;
		
		while (true) {
			int ind = ((end - begin) / 2) + begin;
			if (target == nums[ind]) {
				return ind;
			}
			
			if (target < nums[ind]) {
				 if (ind == 0 || target > nums[ind - 1]) {
					 return ind;
				 }
				 end = ind;
			}
			
			if (target > nums[ind]) {
				 if (ind == nums.length - 1 || target < nums[ind + 1]) {
					 return ind + 1;
				 }
				 begin = ind + 1;
			}
		}
		
	}

	@Test
	public void test1() {
		int[] nums = { 1, 3, 5, 6 };
		int target = 5;
		int expected = 2;
		int result = searchInsert(nums, target);
		assertEquals(expected, result);
	}

	@Test
	public void test2() {
		int[] nums = { 1, 3, 5, 6 };
		int target = 2;
		int expected = 1;
		int result = searchInsert(nums, target);
		assertEquals(expected, result);
	}

	@Test
	public void test3() {
		int[] nums = { 1, 3, 5, 6 };
		int target = 7;
		int expected = 4;
		int result = searchInsert(nums, target);
		assertEquals(expected, result);
	}
	
}