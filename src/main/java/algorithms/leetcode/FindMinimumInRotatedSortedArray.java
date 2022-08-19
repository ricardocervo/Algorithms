package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FindMinimumInRotatedSortedArray {
	
	public int findMin(int[] nums) {
		int begin = 0;
		int end = nums.length - 1;
		while (begin < end) {
			if (end - begin == 1) {
				return Math.min(nums[end], nums[begin]);
			}
			int index = begin + (end - begin) / 2;
			if (nums[begin] > nums[index]) {
				end = index;
			} else if (nums[end] < nums[index]) {
				begin = index;
			} else {
				return nums[begin];
			}
		}
		return nums[begin];

	}
    
    
	@Test
	public void test1() {
		int[] nums = {3,4,5,6,1,2};
		assertEquals(1, findMin(nums));
//		Explanation: The original array was [1,2,3,4,5] rotated 3 times.
	}
	
	
	
//	Example 1:
//

//
//		Input: nums = [4,5,6,7,0,1,2]
//		Output: 0
//		Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
//		Example 3:
//
//		Input: nums = [11,13,15,17]
//		Output: 11
//		Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
}
