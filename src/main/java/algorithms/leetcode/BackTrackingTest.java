package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingTest {
	void init() {
		String alphabet = "0123456789";
		int n = 9;

		char[] answer = new char[n];
		List<String> answers = new ArrayList<>();
		backtrack(0, answers, answer, alphabet);
		for (String s : answers) {
			System.out.println(s);
		}
	}

	void backtrack(int depth, List<String> answers, char[] answer, String alphabet) {
		if (depth == answer.length) {
			answers.add(new String(answer));
			return;
		}

		for (int i = 0; i < alphabet.length(); i++) {
			char c = alphabet.charAt(i);
			answer[depth] = c;
			backtrack(depth + 1, answers, answer, alphabet);
		}

	}

	public static void main(String[] args) {
		new BackTrackingTest().init();
	}
}
