package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int ind1=0, ind2=0;
        int count = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (true) {
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[ind1]);
            pair.add(nums2[ind2]);
            result.add(pair);
            count++;
            
            if (count == 7) {
                System.out.println("oi");
            }
            
            if (count == k || count == (nums1.length * nums2.length)) {
                break;
            }
            
            if (ind1 == nums1.length - 1 && ind2 == nums2.length - 1) {
                break;
            }
            
            if (ind2 == nums2.length - 1) {
                ind1++;
                ind2 = 0;
                continue;
            }
            
            if (ind1 == nums1.length - 1) {
                ind2++;
                ind1 = 0;
                continue;
            }
            
            boolean incrementInd1 = nums1[ind1 + 1] + nums2[ind2] <= nums2[ind2+1] + nums1[ind1];
            
            if (incrementInd1) {
                ind1++;
            } else {
                ind2++;
            }
            
        }
        return result;
        
    }
    
    /**
     * 
     */
    void initTests() {
        List<List<Integer>> result;
                
        int[] nums1 = new int[] { 1,1,2 };
        int[] nums2 = new int[] { 1,2,3 };
        int k = 10;
        result = kSmallestPairs(nums1, nums2, k);
        printList(result); // expeted [[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]
                           //            2     2     3     3     3     4     4     4     5   

        //(1,1), (1,1), (2,1), (1,2), (1,2), (2,2), (1,3), (1,1), (2,1)
        //  2      2      3      3      3      4       4     2      
    }

    private void printList(List<List<Integer>> result) {
        for (int i=0; i<result.size(); i++) {
            List<Integer> list = result.get(i);
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print("(" + list.get(0) + "," + list.get(1) + ")");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        new FindKPairsWithSmallestSums().initTests();
        
        /*
Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [[1,3],[2,3]]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
         */
    }
}