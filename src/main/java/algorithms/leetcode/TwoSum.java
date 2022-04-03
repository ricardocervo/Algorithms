package algorithms.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i=0; i<nums.length; i++) {
            int remaining = target - nums[i];
            if (map.get(remaining) != null && map.get(remaining) != i) {
                return new int[] {map.get(remaining), i};
            }
        }
        return null;
    }

   @Test
   public void test1() {
       int[] nums = {2,7,11,15};
       int target = 9;
       int[] result = twoSum(nums, target);
       assertTrue(Arrays.equals(new int[] {0,1}, result)
               || Arrays.equals(new int[] {1,0}, result));
   }

   @Test
   public void test2() {
       int[] nums = {3,2,4};
       int target = 6;
       int[] result = twoSum(nums, target);
       assertTrue(Arrays.equals(new int[] {1,2}, result)
               || Arrays.equals(new int[] {2,1}, result));
   }
}
