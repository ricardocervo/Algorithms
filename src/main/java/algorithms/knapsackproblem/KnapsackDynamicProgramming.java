package algorithms.knapsackproblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class KnapsackDynamicProgramming {
	public int maximum(int a1, int a2) {
		return (a1 > a2) ? a1 : a2;
	}

	public int maxValueKnapsack(int capacity, int weights[], int values[], int l) {
		int j, wt;
		int dp[][] = new int[l + 1][capacity + 1];
		for (j = 0; j <= l; j++) {
			for (wt = 0; wt <= capacity; wt++) {
				if (j == 0 || wt == 0) {
					dp[j][wt] = 0;
				} else if (weights[j - 1] <= wt) {
					dp[j][wt] = maximum(values[j - 1] + dp[j - 1][wt - weights[j - 1]], dp[j - 1][wt]);
				} else {
					dp[j][wt] = dp[j - 1][wt];
				}
			}
		}
		return dp[j - 1][capacity];
	}

	@Test
	public void test1() {
		int values[] = new int[] { 100, 60, 120 };
		int weight[] = new int[] { 20, 10, 30 };
		int capacity = 50;
		int maxVal = maxValueKnapsack(capacity, weight, values, values.length);
		assertEquals(220, maxVal);
	}
}