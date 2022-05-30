package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        new Permutations().initTests();
    }
    
    void initTests() {
    	
    	int[] nums = {1,2,3};
    	List<List<Integer>> result = permute(nums);
    	
    	System.out.println(result); // Expected output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }
    
    public List<List<Integer>> permute(int[] nums) {
    	List<int[]> result = new ArrayList<>();

    	permute(0, result, nums);
    	
    	
    	List<List<Integer>> newList = new ArrayList<>();
    	for (int[] array : result) {
    		List<Integer> subList = new ArrayList<>();
    		for (int i=0; i < array.length; i++) {
    			subList.add(array[i]);
    		}
    		newList.add(subList);
    	}
    	return newList;
    	
    }
    
    public void permute(int depth, List<int[]> toReturn, int[] nums) {
    	if (depth == nums.length) {
    		int[] array = new int[nums.length];
    		for (int i=0; i<nums.length; i++) {
    			array[i] = nums[i];
    		}
    		toReturn.add(array);
    		return;
    	}
    	
    	for (int i=depth; i<nums.length; i++) {
    		swap(nums, i, depth);
    		permute(depth+1, toReturn, nums);
    		swap(nums, i, depth);
    	}
    }
    
    static void swap(int[] nums, int l, int i)
    {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }

}
