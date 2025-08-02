package org.example.implementations;

import java.util.ArrayList;
import java.util.List;

public class N_102_BinaryTreeLevelOrderTraversal {
     public class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
         return bfs(root, 0, result);
    }

    public List<List<Integer>> bfs(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return result;
        }

        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        bfs(root.left, level + 1, result);
        bfs(root.right, level + 1, result);

        return result;
    }

    public static void main(String[] args) {
        N_102_BinaryTreeLevelOrderTraversal solution = new N_102_BinaryTreeLevelOrderTraversal();
        TreeNode root = solution.new TreeNode(3);
        root.left = solution.new TreeNode(9);
        root.right = solution.new TreeNode(20);
        root.right.left = solution.new TreeNode(15);
        root.right.right = solution.new TreeNode(7);

        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
}
