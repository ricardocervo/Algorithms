package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingTest {
	void initTests() {
		String alphabet = "abc";
		int n = 4;
		List<String> result = new ArrayList<>();
		bruteForce(alphabet, result, 0, new char[n]);
		
		System.out.println(result);
		
		result.clear();
		permutation(alphabet, result, 0, alphabet.toCharArray());
		System.out.println(result);
		
		result.clear();
		subset(alphabet, result, 0, "");
		System.out.println(result);
	}
	
	void bruteForce(String alphabet, List<String> result, int depth, char[] answer) {
		if (depth == answer.length) {
			result.add(new String(answer));
			return;
		}
		
		for (int i=0; i<alphabet.length(); i++) {
			answer[depth] = alphabet.charAt(i);
			bruteForce(alphabet, result, depth + 1, answer);
		}
	}
	
	void permutation(String alphabet, List<String> result, int depth, char[] answer) {
		if (depth == answer.length) {
			result.add(new String(answer));
			return;
		}
		
		for (int i=depth; i<answer.length; i++) {
			swap(answer, depth, i);
			permutation(alphabet, result, depth+1, answer);
			swap(answer, depth, i);
		}
	}
	
	void subset(String alphabet, List<String> result, int depth, String answer) {
		if (depth == alphabet.length()) {
			result.add(answer);
			return;
		}
		
		subset(alphabet, result, depth+1, answer);
		subset(alphabet, result, depth+1, answer + alphabet.charAt(depth));
	}
	
	void swap(char[] array, int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	void subset(String alphabet, List<String> result, int depth) {
		
	}
	
	public static void main(String[] args) {
		new BackTrackingTest().initTests();
	}
}
