package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class AddTwoNumbers {

	private class ListNode {
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
			return "ListNode [val=" + val + "]";
		}
		
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode ans = null;
        int carry = 0;
        ListNode pRes = null;
        while (p1 != null || p2 != null) {
            int d1 = p1 == null ? 0 : p1.val;
            int d2 = p2 == null ? 0 : p2.val;
            
            int dres = (d1 + d2 + carry) % 10 ;
            carry = d1 + d2 + carry >= 10 ? 1 : 0;
            
            if (ans == null) {
                ans = new ListNode(dres);
                pRes = ans;
            }  else {
                pRes.next = new ListNode(dres);
                pRes = pRes.next;
            }
            
            if (p1 != null) {
                p1 = p1.next;
            }
            
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carry == 1) {
            pRes.next = new ListNode(carry);
        }
        return ans;
        
    }
	
	@Test
	public void test1() {
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		ListNode lres = addTwoNumbers(l1, l2);
		String res = listToString(lres);
		assertEquals("7, 0, 8", res);
	}
	
	@Test
    public void test2() {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode l2 = new ListNode(2, new ListNode(2, new ListNode(2)));
        ListNode lres = addTwoNumbers(l1, l2);
        String res = listToString(lres);
        assertEquals("3, 3, 3", res);
    }
	
	   @Test
	    public void test3() {
	        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
	        ListNode l2 = new ListNode(1);
	        ListNode lres = addTwoNumbers(l1, l2);
	        String res = listToString(lres);
	        assertEquals("0, 0, 0, 1", res);
	    }
	    
	
	public String listToString(ListNode head) {
        ListNode pointer = head;
        String str = "";
        while (pointer != null) {
            if (!str.isEmpty()) {
                str += ", ";
            }
            str += pointer.val;
            pointer = pointer.next;
        }
        return str;
    }
}
