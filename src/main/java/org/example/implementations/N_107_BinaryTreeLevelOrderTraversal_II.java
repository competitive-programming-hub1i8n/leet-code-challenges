package org.example.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N_107_BinaryTreeLevelOrderTraversal_II {
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        result = bfs(root, 0, new ArrayList<>());
        Collections.reverse(result);

        return result;
    }

    public List<List<Integer>> bfs(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return  result;
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        bfs(root.left, level + 1, result);
        bfs(root.right, level + 1, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        N_107_BinaryTreeLevelOrderTraversal_II tree = new N_107_BinaryTreeLevelOrderTraversal_II();
        System.out.println(tree.levelOrderBottom(root));
    }
}
