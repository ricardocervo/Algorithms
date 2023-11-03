package algorithms.leetcode;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaximumDepthOfBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}

	}

	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return maxDepthRec(root);
	}
	
	private int maxDepthRec(TreeNode node) {
		if (node == null) return 0;
		return Math.max(1 + maxDepthRec(node.left), 1 + maxDepthRec(node.right));
	}
	
	@Test
	public void test1() {
		TreeNode n3 = new TreeNode(3);
		TreeNode n9 = new TreeNode(9);
		TreeNode n20 = new TreeNode(20);
		TreeNode n15 = new TreeNode(15);
		TreeNode n7 = new TreeNode(7);
		
		n3.left = n9;
		n3.right = n20;
		n20.left = n15;
		n20.right = n7;
		
		assertEquals(3, maxDepth(n3));
		
	}
	
	@Test
	public void test2() {
		assertEquals(2, maxDepth(new TreeNode(3, null, new TreeNode(2))));
	}
}
