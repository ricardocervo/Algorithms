package algorithms.knapsackproblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class KnapsackBruteForce {
	public int max(int a1, int a2) {
		return (a1 > a2) ? a1 : a2;
	}

	public int maxknapSackVal(int capacity, int weights[], int values[], int length) {
		if (length == 0 || capacity == 0) {
			return 0;
		}
		if (weights[length - 1] > capacity) {
			return maxknapSackVal(capacity, weights, values, length - 1);
		} else {
			int val1 = maxknapSackVal(capacity - weights[length - 1], weights, values, length - 1);
			int val2 = maxknapSackVal(capacity, weights, values, length - 1);
			return max(values[length - 1] + val1, val2);
		}
	}
	
	@Test
	public void test1() {
		int values[] = new int[] { 100, 60, 120 };
		int weight[] = new int[] { 20, 10, 30 };
		int capacity = 50;
		int length = values.length;
		int result = maxknapSackVal(capacity, weight, values, length);
		assertEquals(220, result);
	}

}