package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import algorithms.utils.TreeNode;
import algorithms.utils.TreeTraversalEnum;
import algorithms.utils.Utils;


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    
	int[] preorder;
	int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
                
    	this.preorder = preorder;
    	this.inorder = inorder;
        return buildRecursive(0, 0, inorder.length-1);
        
    }
    
	public TreeNode buildRecursive(int preStart, int inStart, int inEnd) {
		if (preStart > preorder.length - 1 || inStart > inEnd) return null;

		TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = map.get(root.val);        

		root.left = buildRecursive(preStart + 1, inStart, inIndex - 1);
		root.right = buildRecursive(preStart + inIndex - inStart + 1, inIndex + 1, inEnd);

		return root;
	}

	@Test
	public void test1() {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		TreeNode tree = buildTree(preorder, inorder);
		String resultStr = Utils.treeToString(tree, TreeTraversalEnum.INORDER);
		String expectedStr = Arrays.toString(inorder);
		assertEquals(resultStr, expectedStr);
	}

	@Test
	public void test2() {
		int[] preorder = {7, 5, 2, 20, 17, 22};
		int[] inorder = {2, 5, 7, 17, 20, 22};
		
		TreeNode tree = buildTree(preorder, inorder);
		String resultStr = Utils.treeToString(tree, TreeTraversalEnum.INORDER);
		String expectedStr = Arrays.toString(inorder);
		assertEquals(resultStr, expectedStr);
	}


	public static void main(String[] args) {
		TreeNode node7 = new TreeNode(7);
		TreeNode node5 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node20 = new TreeNode(20);
		TreeNode node17 = new TreeNode(17);
		TreeNode node22 = new TreeNode(22);
		
		node7.left = node5;
		node5.left = node2;
		node7.right = node20;
		node20.left = node17;
		node20.right = node22;
		
		System.out.println(Utils.treeToString(node7, TreeTraversalEnum.PREORDER));
		System.out.println(Utils.treeToString(node7, TreeTraversalEnum.INORDER));
	}
}


