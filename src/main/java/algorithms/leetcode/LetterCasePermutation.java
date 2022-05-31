package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
		new LetterCasePermutation().initTests();
	}

	void initTests() {

		String s = "a1b2"; // Output: ["a1b2","a1B2","A1b2","A1B2"]
		System.out.println(letterCasePermutation(s));

	}

	public List<String> letterCasePermutation(String s) {
		List<String> result = new ArrayList<>();
		letterCasePermutation(0, new char[s.length()], s, result);
		return result;
	}

	private void letterCasePermutation(int depth, char[] answer, String original, List<String> result) {
		if (depth == original.length()) {
			result.add(new String(answer));
			return;
		}
		
		if (Character.isDigit(original.charAt(depth))) {
			answer[depth] = original.charAt(depth);
			letterCasePermutation(depth + 1, answer, original, result);
		} else {
			answer[depth] = ("" + original.charAt(depth)).toUpperCase().charAt(0);
			letterCasePermutation(depth + 1, answer, original, result);
			answer[depth] = ("" + original.charAt(depth)).toLowerCase().charAt(0);
			letterCasePermutation(depth + 1, answer, original, result);
		}

	}
}
