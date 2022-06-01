package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        dfs(root, 0, map);

        List<List<Integer>> list = new ArrayList<>();
        for (Integer distance : map.keySet()) {
            list.add((List<Integer>) map.get(distance));
        }
        return list;
    }

    private void dfs(TreeNode root, int depth, Map<Integer, Deque<Integer>> map) {
        if (root == null) {
            return;
        }

        if (map.get(depth) == null) {
            map.put(depth, new LinkedList<>());
        }

        if (depth % 2 == 0) {
            map.get(depth).addLast(root.val);
        } else {
            map.get(depth).addFirst(root.val);
        }

        dfs(root.left, depth + 1, map);
        dfs(root.right, depth + 1, map);

    }

    void initTests() {
        Integer[] input = { 1, 2, 3, 4, null, null, 5 };
        TreeNode root = convertToTree(input);
        List<List<Integer>> output = zigzagLevelOrder(root);
        System.out.println(output);
    }

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

    public TreeNode convertToTree(Integer[] array) {
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

    public static void main(String[] args) {
        new BinaryTreeZigzagLevelOrderTraversal().initTests();
    }
}