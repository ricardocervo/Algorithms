package algorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class Fibonacci {

	private long fib(int n) {
		return fib(n, new HashMap<>());
	}
	
	private long fib(int n, HashMap<Integer, Long> memo) {
		if (n <= 2) return 1;
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		memo.put(n, fib(n-1, memo) + fib(n-2, memo));
		return memo.get(n);
	}
	
	@Test public void test1() { assertEquals(1, fib(1));}
	@Test public void test2() { assertEquals(1, fib(2));}
	@Test public void test3() { assertEquals(2, fib(3));}
	@Test public void test4() { assertEquals(3, fib(4));}
	@Test public void test5() { assertEquals(5, fib(5));}
	@Test public void test6() { assertEquals(8, fib(6));}
	@Test public void test7() { assertEquals(102334155, fib(40));}
	
}
