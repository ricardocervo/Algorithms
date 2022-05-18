package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * BruteForce Algorithm test using backtrack (just builds a list with all possible combinations of a password
 * @author ricardo
 *
 */
public class BruteForceTest {

	public static void main(String[] args) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		List<String> allCombinations = getAllCombinations(alphabet, 2);
		System.out.println(allCombinations.toString());
	}
	
	static List<String> getAllCombinations(String alphabet, int n) {
		List<String> answerList = new ArrayList<>();
		solve(alphabet, 0, new char[n], answerList);
		return answerList;
	}
	
	static void solve(String alphabet, int depth, char[] answer, List<String> answerList) {
		if (depth == answer.length) {
			answerList.add(new String(answer));
			return;
		}
		
		for (int i=0; i<alphabet.length(); i++) {
			char c = alphabet.charAt(i);
			answer[depth] = c;
			solve(alphabet, depth+1, answer, answerList);
		}
	}
}