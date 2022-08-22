package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JumpGameII {
	
    public int jump(int[] nums) {
    	int l = 0;
    	int r = 0;
    	int jumps = 0;
    	int farthest = 0;
    	while (r < nums.length - 1) {
    		for (int i = l; i <= r; i++) {
    			farthest = Math.max(farthest, i + nums[i]);
    		}
    		l = r + 1;
    		r = farthest;
    		jumps++;
    	}
    	return jumps;
    }
    
	@Test
	public void test1() {
		int[] nums = {2,3,1,1,4};
		assertEquals(2, jump(nums));
	}

	@Test
	public void test2() {
		int[] nums = {2,3,0,1,4};
		assertEquals(2, jump(nums));
	}
}