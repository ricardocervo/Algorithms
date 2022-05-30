package algorithms.datastructure.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTests {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      @Override
      public String toString() {
          return "[val=" + val + ", left=" + left + ", right=" + right + "]";
      }
    }
    
    private void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + ", ");
        preorder(root.left);
        preorder(root.right);
    }
    
    
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + ", ");
        inorder(root.right);

    }
    
    public static void main(String[] args) {
        new BinaryTreeTests().test2();
    }
    
    
    
    public void test1() {
        Integer[] treeArray = {3,9,20,null,null,15,7};
        Map<Integer, TreeNode> tree = convertToTree(treeArray);
        preorder(tree.get(0));
        System.out.println();
        inorder(tree.get(0));
    }
    
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + ", ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
    
    public void dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.val + ", ");
            if (current.right != null) stack.add(current.right);
            if (current.left != null) stack.add(current.left);
        }
    }
    
    //same as preorder for trees
    public void recursiveDfs(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + ", ");
        dfs(root.left);
        dfs(root.right);
    }
    
    public void test2() {
        Integer[] treeArray = { 6, 4, 9, 1, 5, null, 18, null, null, null, null, null, null, 17 };
        Map<Integer, TreeNode> tree = convertToTree(treeArray);
        System.out.println("\npreorder: ");
        preorder(tree.get(0));
        System.out.println("\ninorder: ");
        inorder(tree.get(0));
        System.out.println("\nbfs: ");
        bfs(tree.get(0));
        System.out.println("\ndfs: ");
        dfs(tree.get(0));
        System.out.println("\nrecursive dfs: ");
        recursiveDfs(tree.get(0));        
    }
    
    public Map<Integer, TreeNode> convertToTree(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        
        Map<Integer, TreeNode> nodes = new HashMap<>();
        for (int i=0; i<array.length; i++) {
            if (array[i] != null) {
                nodes.put(i, new TreeNode(array[i]));
            }
        }
        
        for (int i=0; i<array.length; i++) {
            TreeNode current = nodes.get(i);
            if (current == null) continue;
            
            int indLeftChild = i * 2 + 1;
            int indRightChild = i * 2 + 2;

             current.left = nodes.get(indLeftChild);
             current.right = nodes.get(indRightChild);
            
        }
        
        return nodes;
    }
}
