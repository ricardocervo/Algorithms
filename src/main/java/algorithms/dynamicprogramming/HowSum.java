package algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HowSum {
	private List<Integer> howSum(int targetSum, List<Integer> numbers) {
		return howSum(targetSum, numbers, new HashMap<>());
	}
	
	private List<Integer> howSum(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
		if (targetSum == 0) return new ArrayList<>();
		if (targetSum < 0) return null;
		
		if (memo.get(targetSum) != null) {
			return memo.get(targetSum);
		}
		
		for (Integer num : numbers) {
			int remainder = targetSum - num;
			List<Integer> remainderResult = howSum(remainder, numbers, memo);
			if (remainderResult != null) {
				remainderResult.add(num);
				memo.put(targetSum, remainderResult);
				return memo.get(targetSum);
			}

		}
		
		return null;
	}
	
	public static void main(String[] args) {
		HowSum program = new HowSum();
		program.print(program.howSum(7, Arrays.asList(5, 3 ,4, 7)));
 		program.print(program.howSum(7, Arrays.asList(2, 4)));
		program.print(program.howSum(8, Arrays.asList(2, 3, 5)));
		program.print(program.howSum(300, Arrays.asList(7, 14)));
	}
	
	void print(List<Integer> list) {
		if (list == null) {
			System.out.println("null");
			return;
		}
		
		Integer[] arr = new Integer[list.size()];
		list.toArray(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
