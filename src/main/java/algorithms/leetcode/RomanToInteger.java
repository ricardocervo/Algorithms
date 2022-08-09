package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RomanToInteger {

	public int romanToInt(String s) {
		int answer = 0;
		while (!s.isEmpty()) {
			if (s.endsWith("I")) {
				answer += 1;
				s = remove(s, 1);
			}

			if (s.endsWith("IV")) {
				answer += 4;
				s = remove(s, 2);
			}

			if (s.endsWith("V")) {
				answer += 5;
				s = remove(s, 1);
			}

			if (s.endsWith("IX")) {
				answer += 9;
				s = remove(s, 2);
			}

			if (s.endsWith("X")) {
				answer += 10;
				s = remove(s, 1);
			}

			if (s.endsWith("XL")) {
				answer += 40;
				s = remove(s, 2);
			}

			if (s.endsWith("L")) {
				answer += 50;
				s = remove(s, 1);
			}

			if (s.endsWith("XC")) {
				answer += 90;
				s = remove(s, 2);
			}

			if (s.endsWith("C")) {
				answer += 100;
				s = remove(s, 1);
			}

			if (s.endsWith("CD")) {
				answer += 400;
				s = remove(s, 2);
			}

			if (s.endsWith("D")) {
				answer += 500;
				s = remove(s, 1);
			}

			if (s.endsWith("CM")) {
				answer += 900;
				s = remove(s, 2);
			}

			if (s.endsWith("M")) {
				answer += 1000;
				s = remove(s, 1);
			}
		}
		return answer;
	}
	
	static String remove(String s, int amount) {
		return s.substring(0, s.length() - amount);
	}
	@Test public void test1()  { assertEquals(1, romanToInt("I")); }
	@Test public void test2()  { assertEquals(2, romanToInt("II")); }
	@Test public void test3()  { assertEquals(3, romanToInt("III")); }
	@Test public void test4()  { assertEquals(4, romanToInt("IV")); }
	@Test public void test5()  { assertEquals(5, romanToInt("V")); }
	@Test public void test6()  { assertEquals(6, romanToInt("VI")); }
	@Test public void test7()  { assertEquals(7, romanToInt("VII")); }
	@Test public void test13()  { assertEquals(13, romanToInt("XIII")); }
	@Test public void test543()  { assertEquals(543, romanToInt("DXLIII")); }
	
}
