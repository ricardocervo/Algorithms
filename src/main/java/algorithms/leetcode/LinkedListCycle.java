package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		ListNode(int x, ListNode next) {
			this(x);
			this.next = next;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		do {
			if (p1.next == null || p2.next == null || p2.next.next == null) {
				return false;
			}
			p1 = p1.next;
			p2 = p2.next.next;

		} while (p1 != p2);
		
		return true;

	}

	@Test
	public void test1() {
		ListNode l = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
		assertEquals(false, hasCycle(l));
	}
	

	@Test
	public void test2() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		n2.next = n1;
		assertEquals(true, hasCycle(n1));
	}
}
