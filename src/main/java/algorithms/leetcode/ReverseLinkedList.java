package algorithms.leetcode;

public class ReverseLinkedList {

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
			return "ListNode [val=" + val + ", next=" + next + "]";
		}

		
		
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode pt1 = head;
		ListNode pt2 = head.next;
		ListNode pt3;
		
		pt1.next = null;
		do {
			pt3 = pt2.next;
			pt2.next = pt1;		
			pt1 = pt2;
			pt2 = pt3;
		} while (pt3 != null);
		
		return pt1;
		
	}
	
	private void initTests() {
		ListNode list = new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8)))); 
		System.out.println(listToString(list));
		list = reverseList(list);
		System.out.println(listToString(list));
	}
	
	
	String listToString(ListNode root) {
		if (root == null) return "null";
		String str = "[";
		
		ListNode pt = root;
		while (pt != null) {
			if (str.length() > 1) {
				str += ", ";
			}
			str += pt.val;
			pt = pt.next;
		}
		
		return str + "]";
		
	}
	
	public static void main(String[] args) {
		new ReverseLinkedList().initTests();
	}
}