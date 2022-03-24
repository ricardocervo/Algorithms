package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, TreeNode lastParentIamOnTheRight, TreeNode lastParentIamOnTheLeft) {
        if (node == null)  return true;

        if (lastParentIamOnTheLeft != null && node.val >= lastParentIamOnTheLeft.val) return false;
        if (lastParentIamOnTheRight != null && node.val <= lastParentIamOnTheRight.val) return false;
        
        return isValidBST(node.left, lastParentIamOnTheRight, node) &&  isValidBST(node.right, node, lastParentIamOnTheLeft);
    }

    @Test
    public void test1() {
        TreeNode tree = new TreeNode(5, new TreeNode(3), new TreeNode(7));
        assertEquals(true, isValidBST(tree));
    }

    @Test
    public void test2() {
        TreeNode tree = new TreeNode(8, new TreeNode(3), new TreeNode(7));
        assertEquals(false, isValidBST(tree));
    }

    @Test
    public void test3() {
        TreeNode tree = new TreeNode(8, new TreeNode(5), new TreeNode(10, new TreeNode(9), new TreeNode(12)));
        assertEquals(true, isValidBST(tree));
    }

    @Test
    public void test4() {
        TreeNode tree = new TreeNode(8, new TreeNode(5), new TreeNode(10, new TreeNode(6), new TreeNode(12)));
        assertEquals(false, isValidBST(tree));
    }
}
