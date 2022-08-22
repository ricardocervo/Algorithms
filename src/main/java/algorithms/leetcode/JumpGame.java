package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JumpGame {

	public boolean canJump(int[] nums) {
		boolean canJump = false;
		int i = nums.length - 1;
		while (i >= 1) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] >= i - j) {
					i = j;
					canJump = true;
					break;
				}
			}
			if (!canJump) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test1() {
		int[] nums = { 2, 3, 1, 1, 4 };
		assertEquals(true, canJump(nums));
	}

	@Test
	public void test2() {
		int[] nums = { 3, 2, 1, 0, 4 };
		assertEquals(false, canJump(nums));
	}
}