package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class LongestSubstringWithoutRepeatingCharacters {
	

	public int lengthOfLongestSubstring(String s) {
		if (s.isEmpty()) {
			return 0;
		}

		int max = 1;
		int start = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c) && map.get(c) >= start) {
				start = map.get(c);
				count = i - map.get(c);
			} else {
				count++;
				max = Math.max(max, count);
			}
			map.put(c, i);
		}
		return max;
	}

    @Test
    public void test00() {
    	String s = "tmmzuxt";
    	assertEquals(5, lengthOfLongestSubstring(s));
    }
    
    @Test
    public void test0() {
    	String s = "au";
    	assertEquals(2, lengthOfLongestSubstring(s));
    }
    
    @Test
    public void test1() {
    	String s = "abcabcbb";
    	assertEquals(3, lengthOfLongestSubstring(s));
    	// Explanation: The answer is "abc", with the length of 3.
    }
    
    @Test
    public void test2() {
    	String s = "bbbbb";
    	assertEquals(1, lengthOfLongestSubstring(s));
    	// Explanation: The answer is "b", with the length of 1.
    }


    @Test
    public void test3() {
    	String s = "pwwkew";
    	assertEquals(3, lengthOfLongestSubstring(s));
    	// Explanation: The answer is "wke", with the length of 3.
    }
}