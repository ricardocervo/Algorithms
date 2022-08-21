package algorithms.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class RotateMatrixClockWise90 {
	int[][] rotate(int[][] a) {
		int n = a.length;
		if (n == 0 || n == 1) return a;
		
		int left, right;
		return a;
	}
	
	
    @Test
    public void test1() {
    	int[][] a = {
    			{ 1, 2, 3 },
    			{ 4, 5, 6 },
    			{ 7, 8, 9 },
    	};
    	
    	int[][] expected = {
    			{ 3, 6, 9},
    			{ 2, 5, 8},
    			{ 1, 4, 7}
    		};
    
    	assertTrue(Arrays.deepEquals(expected, rotate(a)));

	}

}