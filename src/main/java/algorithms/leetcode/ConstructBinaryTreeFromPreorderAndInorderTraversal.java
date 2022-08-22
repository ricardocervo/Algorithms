package algorithms.leetcode;

import java.util.HashMap;

import org.junit.Test;

import algorithms.utils.TreeNode;
import algorithms.utils.TreeTraversalEnum;
import algorithms.utils.Utils;


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
        
    }
    
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (root.val == inorder[i]) {
                inIndex = i;
            }
        }
        
        root.left = helper(preStart + 1, inStart, inIndex-1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        
        return root;
    }
    

    @Test
    public void test1() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        
        
//        TreeNode test = Utils.convertToTree(new Integer[] {3,9,20,null,null,15,7});
//        
//        System.out.println(Utils.treeToString(node3, TreeTraversalEnum.INORDER));
//        System.out.println(Utils.treeToString(test, TreeTraversalEnum.INORDER));
//        
//        System.out.println(Utils.treeToString(node3, TreeTraversalEnum.PREORDER));
//        System.out.println(Utils.treeToString(test, TreeTraversalEnum.PREORDER));
//        
//        System.out.println(Utils.treeToString(node3, TreeTraversalEnum.POSTORDER));
//        System.out.println(Utils.treeToString(test, TreeTraversalEnum.POSTORDER));
        
    }
}
