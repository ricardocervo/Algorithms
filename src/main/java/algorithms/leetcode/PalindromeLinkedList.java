package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PalindromeLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        
        @Override
        public String toString() {
            return "ListNode[" + this.val + "]";
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode pt1 = head;
        ListNode pt2 = head;
        
        while (pt2 != null && pt2.next != null) {
            pt1 = pt1.next;
            pt2 = pt2.next.next;
        }
                                
        pt2 = reverseList(pt1); 
        pt1 = head;
        
        while (pt2 != null && pt1 != null) {
            if (pt1.val != pt2.val) {
                return false;
            }
            pt2 = pt2.next;
            pt1 = pt1.next;
        }
        
        
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode pt1 = head;
        ListNode pt2 = head.next;
        ListNode pt3;
        pt1.next = null;
        while (pt2 != null) {
            pt3 = pt2.next;
            pt2.next = pt1;
            pt1 = pt2;
            pt2 = pt3;
        }
        return pt1;
        
        
    }
    
    @Test
    public void test1() {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        assertTrue(isPalindrome(list));
    }
    
    void printList(ListNode head) {
        ListNode pt = head;
        String str = "";
        while (pt != null) {
            if (!str.isEmpty()) {
                str += ", ";
            }
            str += pt.val;
            pt = pt.next;
        }
        
        System.out.println("[" + str + "]");
    }
    
    
}
