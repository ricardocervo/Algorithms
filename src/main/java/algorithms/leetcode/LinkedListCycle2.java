package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import algorithms.leetcode.LinkedListCycle.ListNode;

public class LinkedListCycle2 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode detectCycleStep1(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		do {
			if (slow.next == null || fast.next == null || fast.next.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;

		} while (slow != fast);
		
		return slow;

	}

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode intersection = detectCycleStep1(head);
		if (intersection == null) {
			return null;
		}
		
		ListNode slow2 = head;
		while (slow2 != intersection) {
			slow2 = slow2.next;
			intersection = intersection.next;

		}
		
		return intersection;

	}

	@Test
	public void test1() {
		ListNode n3 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n9 = new ListNode(0);
		ListNode nMinus4 = new ListNode(-4);
		
		n3.next = n2;
		n2.next=n9;
		n9.next=nMinus4;
		nMinus4.next=n2;
		//[3,2,0,-4]
		assertEquals(n2, detectCycle(n3));
	}
	
	@Test
	public void test2() {
		ListNode n1 = new ListNode(3);
		assertEquals(null, detectCycle(n1));
	}

}
