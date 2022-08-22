package algorithms.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class Utils {
    
    private static List<Integer> listIntegers = new ArrayList<>();

    public static int[] randomArray(int n) {
        Random rnd = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(99);
        }

        return arr;
    }

    public static TreeNode convertToTree(Integer[] array) {
        if (array.length == 0) {
            return null;
        }

        Map<Integer, TreeNode> nodes = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                nodes.put(i, new TreeNode(array[i]));
            }
        }

        for (int i = 0; i < array.length; i++) {
            TreeNode current = nodes.get(i);
            if (current == null)
                continue;

            int indLeftChild = i * 2 + 1;
            int indRightChild = i * 2 + 2;

            current.left = nodes.get(indLeftChild);
            current.right = nodes.get(indRightChild);

        }

        return nodes.get(0);
    }
    
    public static String treeToString(TreeNode treeNode, TreeTraversalEnum traversalType) {
        listIntegers.clear();
        switch (traversalType) {
        case INORDER:
            traverseInorder(treeNode);
            break;
        case PREORDER:
            traversePreorder(treeNode);
            break;
        case POSTORDER:
            traversePostorder(treeNode);
            break;
        case LEVELORDER:
            traverseLevelOrder(treeNode);
            break;
        }
        
        return listIntegers.toString();
    }
    
    private static void traverseInorder(TreeNode root) {
        if (root == null) return;

        traverseInorder(root.left);        
        listIntegers.add(root.val);
        traverseInorder(root.right);
    }

    private static void traversePreorder(TreeNode root) {
        if (root == null) return;

        listIntegers.add(root.val);

        traverseInorder(root.left);
        traverseInorder(root.right);
    }

    private static void traversePostorder(TreeNode root) {
        if (root == null) return;
            

        traversePostorder(root.left);
        traversePostorder(root.right);
        listIntegers.add(root.val);
    }

    private static String traverseLevelOrder(TreeNode root) {
        throw new RuntimeException("Not yet implemented");
    }

}
