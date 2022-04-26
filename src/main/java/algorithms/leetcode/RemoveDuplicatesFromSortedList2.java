package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class RemoveDuplicatesFromSortedList2 {

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
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)	return head;
		
		ListNode dummy = new ListNode(-99999, head);
		ListNode prev = dummy;
		ListNode current = head;
		
		while (current != null) {
		    if (current.next != null && current.next.val == current.val) {
		        while (current.next != null  && current.next.val == current.val) {
		            current = current.next;
		        }
		        prev.next = current.next;
		    } else {
		        prev = current;
		    }
		    current = current.next;
		}
		return dummy.next;
	}

	@Test
	public void test1() {
		ListNode list = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4))))));
		ListNode noDuplicates = deleteDuplicates(list);
		String expected = "2, 4";
		String result = listToString(noDuplicates);
		assertEquals(expected, result);
	}
	
	   @Test
	    public void test2() {
	        ListNode list = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4))))));
	        ListNode noDuplicates = deleteDuplicates(list);
	        String expected = "4";
	        String result = listToString(noDuplicates);
	        assertEquals(expected, result);
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
