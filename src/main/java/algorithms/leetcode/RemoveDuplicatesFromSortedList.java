package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedList {

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
		if (head == null) {
			return null;
		}
		ListNode pointer = head;
		while (pointer.next != null) {
			ListNode next = pointer.next;
			if (pointer.val == next.val) {
				pointer.next = next.next;
			} else {
				pointer = pointer.next;
			}
		}
		return head;
	}

	@Test
	public void test1() {
		ListNode list = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));
		ListNode noDuplicates = deleteDuplicates(list);
		String expected = "1, 2, 3";
		String result = listToString(noDuplicates);
		assertEquals(expected, result);
	}

	@Test
	public void test2() {
		ListNode list = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(3))));
		ListNode noDuplicates = deleteDuplicates(list);
		String expected = "1, 3";
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
