package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class LowestCommonAncestorBinaryTree {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
        @Override
        public String toString() {
            return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
        }
      }
     
      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          if (root.val == p.val || root.val == q.val) return root; // if root is P or Q, return root
          if (root.left == null && root.right == null) return null; // root is not P neigher Q, and doesn't have children, so the sub-tree ended... return null
          
          TreeNode left = null, right = null;
          if (root.left != null) {
              left = lowestCommonAncestor(root.left, p, q); //if has left child, "left" receives the value of the left recursion
          }
          if (root.right != null) {
              right = lowestCommonAncestor(root.right, p, q); //if has right child, "right" receives the value of the right recursion
          }
          
          if (left != null && right != null) { //if both sub-trees return the node (!= null), this is the LCA, return it
              return root;
          }
          
          return left != null ? left : right; //if one of the children is not null, return its value, else, return null
          
      }

      @Test
      public void test1() {
          Integer[] arr = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
          int p = 5, q = 1;
          int expected = 3;

          Map<Integer, TreeNode> tree = convertToTree(arr);
          TreeNode nodeP = tree.get(Arrays.asList(arr).indexOf(p));
          TreeNode nodeQ = tree.get(Arrays.asList(arr).indexOf(q));
          TreeNode result = lowestCommonAncestor(tree.get(0), nodeP, nodeQ);

          assertEquals(expected, result.val);
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




//if (root.val == p.val || root.val == q.val) return root; //teste se o nodo é P ou Q, se for... retorna ele próprio
//if (root.left == null && root.right == null) return null; //se não é P nem Q, e não tem filhos, retorna null, pois encerrou a sub-árvore
//
//TreeNode left = null, right = null;
//if (root.left != null) {
//    left = lowestCommonAncestor(root.left, p, q);
//}
//if (root.right != null) {
//    right = lowestCommonAncestor(root.right, p, q);
//}
//if (left != null && right != null) {
//    return root;
//}
//
//return left == null ? right : left;