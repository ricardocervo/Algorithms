package algorithms.leetcode;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class LetterCombinationsPhoneNumber {

	
	Map<Character, List<Character>> map = new HashMap<>();
	List<String> answerList =  new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		
		if (digits.isEmpty()) return answerList;
		
		map.put('2', Arrays.asList('a', 'b', 'c'));
		map.put('3', Arrays.asList('d', 'e', 'f'));
		map.put('4', Arrays.asList('g', 'h', 'i'));
		map.put('5', Arrays.asList('j', 'k', 'l'));
		map.put('6', Arrays.asList('m', 'n', 'o'));
		map.put('7', Arrays.asList('p', 'q', 'r', 's'));
		map.put('8', Arrays.asList('t', 'u', 'v'));
		map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

		char[] answer = new char[digits.length()];
		solve(digits, 0, answer);
		return answerList;
	}
	
	void solve(String digits, int depth, char[] answer) {
		if (depth == digits.length()) {
			answerList.add(new String(answer));
			return;
		}
		
		List<Character> chars = map.get(digits.charAt(depth));
		for (int i=0; i<chars.size(); i++) {
			answer[depth] = chars.get(i);
			solve(digits, depth+1, answer);
		}
	}

	@Test
	public void test1() {
		String input = "23";
		List<String> expected = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
		List<String> result = letterCombinations(input);
		boolean containsAll = expected.containsAll(result);
		boolean sameSize = result.size() == expected.size();
		boolean equal = containsAll && sameSize;
		assertTrue(equal);
	}
}