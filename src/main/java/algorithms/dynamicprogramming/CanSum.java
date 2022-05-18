package algorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CanSum {

	public boolean canSum(int targetSum, int[] numbers) {
		return canSum(targetSum, numbers, new HashMap<>());
	}
	
	private boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> map) {
		if (targetSum == 0) return true;
		if (targetSum < 0) return false;
		
		if (map.containsKey(targetSum)) {
			return map.get(targetSum);
		}
		
		for (Integer i : numbers) {
			int remainder = targetSum - i;
			map.put(remainder, canSum(remainder, numbers, map));
			if (map.get(remainder)) {
				return true;
			}
		}
		return false;
	}
	
	@Test public void test1() { assertEquals(false, canSum(7, new int[] {2, 4}));}
	@Test public void test2() { assertEquals(true, canSum(7, new int[] {2, 3, 5}));}
	@Test public void test3() { assertEquals(true, canSum(8, new int[] { 2, 3, 5 }));}
	@Test public void test4() { assertEquals(false, canSum(300, new int[] { 7, 14 }));}
	
}
