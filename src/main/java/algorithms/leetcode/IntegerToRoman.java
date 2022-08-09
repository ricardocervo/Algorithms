package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IntegerToRoman {

	public String romanNumber(int number) {
		String answer = "";
		while (number >= 1000) {
			number -= 1000;
			answer += "M";
		}
		if (number >= 900) {
			answer += "CM";
			number -= 900;
		}
		
		if (number >= 500) {
			answer += "D";
			number -= 500;
		}
		
		if (number >= 400) {
			answer += "CD";
			number -= 400;
		}
		
		if (number >= 100) {
			while (number >= 100) {
				answer += "C";
				number -= 100;
			}
		}
		
		if (number >= 90) {
			answer += "XC";
			number -= 90;
		}
		
		if (number >= 50) {
			answer += "L";
			number -= 50;
		}

		if (number >= 40) {
			answer += "XL";
			number -= 40;
		}
		
		if (number >= 10) {
			while (number >= 10) {
				answer += "X";
				number -= 10;
			}
		}
		
		if (number >= 9) {
			answer += "IX";
			number -= 9;
		}
		
		if (number >= 5) {
			answer += "V";
			number -= 5;
		}
		
		if (number >= 4) {
			answer += "IV";
			number -= 4;
		}
		
		if (number >= 1) {
			while (number >= 1) {
				answer += "I";
				number -= 1;
			}
		}
		
		return answer;
	}
	
	
	@Test public void test1()  { assertEquals("I", romanNumber(1)); }
	@Test public void test2()  { assertEquals("II", romanNumber(2)); }
	@Test public void test3()  { assertEquals("III", romanNumber(3)); }
	@Test public void test4()  { assertEquals("IV", romanNumber(4)); }
	@Test public void test5()  { assertEquals("V", romanNumber(5)); }
	@Test public void test6()  { assertEquals("VI", romanNumber(6)); }
	@Test public void test7()  { assertEquals("VII", romanNumber(7)); }
	@Test public void test8()  { assertEquals("VIII", romanNumber(8)); }
	@Test public void test9()  { assertEquals("IX", romanNumber(9)); }
	@Test public void test10() { assertEquals("X", romanNumber(10)); }
	@Test public void test11() { assertEquals("XI", romanNumber(11)); }
	@Test public void test12() { assertEquals("D", romanNumber(500)); }
	@Test public void test13() { assertEquals("XC", romanNumber(90)); }
	@Test public void test14() { assertEquals("M", romanNumber(1000)); }
	@Test public void test15() { assertEquals("MMM", romanNumber(3000)); }
	
}
