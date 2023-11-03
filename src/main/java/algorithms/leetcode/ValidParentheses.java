package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;


public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char charRead = s.charAt(i);
			boolean closingChar = charRead == '}' || charRead == ')' || charRead == ']';
			if (closingChar) {
				if (stack.isEmpty() || !matchChar(charRead, stack.pop())) {
					return false;
				}
			} else {
				stack.push(charRead);
			}
		}
		return stack.isEmpty();
	}

	private boolean matchChar(char closingChar, char openChar) {
		if (closingChar == ')' ) {
			return openChar == '(';
		} 
		
		if (closingChar == ']') {
			return openChar == '[';
		}
		
		if (closingChar == '}') {
			return openChar == '{';
		}
		
		throw new IllegalArgumentException("Invalid closing char");
	}

	@Test
	public void test1() {
		String s = "{}";
		assertEquals(true, isValid(s));
	}

	@Test
	public void test2() {
		String s = "{[()]}";
		assertEquals(true, isValid(s));
	}

	@Test
	public void test3() {
		String s = "{}";
		assertEquals(true, isValid(s));
	}

	@Test
	public void test4() {
		String s = "{}}";
		assertEquals(false, isValid(s));
	}

	@Test
	public void test6() {
		String s = "[][]";
		assertEquals(true, isValid(s));
	}

	@Test
	public void test7() {
		String s = "{)(}";
		assertEquals(false, isValid(s));
	}
}
