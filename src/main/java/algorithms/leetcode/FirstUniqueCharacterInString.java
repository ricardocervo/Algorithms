package algorithms.leetcode;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class FirstUniqueCharacterInString {

	public int firstUniqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i=0; i< s.length(); i++) {
			char c = s.charAt(i);
			int amount = map.getOrDefault(c, 0) + 1;
			map.put(c, amount);
		}
		
		for (int i=0; i<s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
		
	}

	@Test
	public void test1() {
		String input = "leetcode";
		int expectedOutput = 0;
		assertEquals(expectedOutput, firstUniqChar(input));
	}

	@Test
	public void test2() {
		String input = "loveleetcode";
		int expectedOutput = 2;
		assertEquals(expectedOutput, firstUniqChar(input));
	}

	@Test
	public void test3() {
		String input = "aabb";
		int expectedOutput = -1;
		assertEquals(expectedOutput, firstUniqChar(input));
	}
}
