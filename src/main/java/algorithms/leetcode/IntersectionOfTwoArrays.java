package algorithms.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();

        HashSet<Integer> toReturn = new HashSet<>();
        for (int i=0; i<nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i=0; i<nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                toReturn.add(nums2[i]);
            }
        }
        
        int[] arr = new int[toReturn.size()];
        int i = 0;
        for (Integer number : toReturn) {
            arr[i] = number;
            i++;
        }
        return arr;
    }
    
    @Test
    public void test1() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = intersection(nums1, nums2);
        assertTrue(Arrays.equals(new int[]{2}, result));
    }

    @Test
    public void test2() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = intersection(nums1, nums2);
        assertTrue(Arrays.equals(new int[]{9,4}, result) 
                || Arrays.equals(new int[]{4,9}, result));
    }
}
