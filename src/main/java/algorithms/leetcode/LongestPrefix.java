package algorithms.leetcode;

public class LongestPrefix {

    public static void main(String[] args) {
        new LongestPrefix().init();
    }

    void init() {
        String[] strs = {"abacate", "abraço", "abanador"};
        System.out.println(longestCommonPrefix(strs));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int countBest = strs[0].length();
        int indBest = 0;
        for (int i = 1; i < strs.length; i++) {
            int count = 0;
            for (int j = 0; j < Math.min(strs[i].length(), strs[indBest].length()); j++) {
                if (strs[i].charAt(j) == strs[indBest].charAt(j)) {
                    count++;
                } else {
                    break;  
                }
            }
            if (count < countBest) {
                countBest = count;
                indBest = i;
            }

        }

        return strs[indBest].substring(0, countBest);
    }

}
