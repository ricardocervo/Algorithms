package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		new Subsets().initTests();
	}

	void initTests() {

		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = subsets(nums);

		System.out.println(result); // Expected [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
	}


	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		subSet(new ArrayList<>(), nums, 0, result);
		return result;
	}

	private void subSet(List<Integer> prefix, int[] nums, int start, List<List<Integer>> result) {
		result.add(prefix);
		
		for (int i=start; i<nums.length; i++) {
			List<Integer> copy = new ArrayList<>(prefix);
			copy.add(nums[i]);
			subSet(copy, nums, i+1, result);
			
		}
		
	}
}
