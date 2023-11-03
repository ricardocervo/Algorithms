package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class BestTimeToBuyAndSell {
	public int maxProfit(int[] prices) {
		int bestBuy = prices[0];
		int maxProfit = 0;
		for (int todayPrice : prices) {
			int currentProfit = todayPrice - bestBuy;
			maxProfit = Math.max(maxProfit, currentProfit);
			if (currentProfit < 0) {
				bestBuy = todayPrice;
			}
		}
		return maxProfit;
	}
	
	@Test
	public void test1() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int expected = 5;
		int result = maxProfit(prices);
		assertEquals(expected, result);
	}

	@Test
	public void test2() {

		int[] prices = { 7, 6, 4, 3, 1 };
		int expected = 0;
		int result = maxProfit(prices);
		assertEquals(expected, result);
	}
}
