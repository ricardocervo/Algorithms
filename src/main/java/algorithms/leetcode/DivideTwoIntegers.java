package algorithms.leetcode;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        new DivideTwoIntegers().init();
    }
    void init() {
        
        int division = divide(1000, 2);
        System.out.println(division);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) { // this would result in overflow
            return Integer.MAX_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (dividend == divisor) {
            return 1;
        }

        boolean sameSign = dividend >= 0 == divisor >= 0;
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }
            result += 1 << count;
            dividend -= divisor << count;
        }
        
        return sameSign ? result : -result;
    }

}
