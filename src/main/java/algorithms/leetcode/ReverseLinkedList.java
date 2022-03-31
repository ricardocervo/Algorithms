package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class ReverseLinkedList {

	public class ListNode {
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
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		Stack<ListNode> stack = new Stack<>();
		ListNode pointer = head;
		while (pointer != null) {
			stack.add(pointer);
			pointer = pointer.next;
		}
		ListNode lastNode = stack.peek();
		while (!stack.isEmpty()) {
			pointer = stack.pop();
			pointer.next = stack.isEmpty() ? null : stack.peek();
		}
		return lastNode;
	}
	
	@Test
	public void test1() {
		ListNode list = new ListNode(1, new ListNode(2, new ListNode(3)));
		ListNode reversed = reverseList(list);
		assertEquals("3, 2, 1", printList(reversed));
	}
	
	public String printList(ListNode head) {
		ListNode pointer = head;
		String str = "";
		while (pointer != null) {
			if (!str.isEmpty()) {
				str+=", ";
			}
			str += pointer.val;
			pointer = pointer.next;
		}
		return str;
	}
}
