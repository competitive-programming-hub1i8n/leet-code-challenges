package org.example.implementations;

import java.util.Objects;

public class N_100_SameTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(null);
        root2.right = new TreeNode(2);
        N_100_SameTree solution = new N_100_SameTree();
        System.out.println(solution.isSameTree(root, root2));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || !Objects.equals(p.val, q.val)) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static class TreeNode {
      Integer val;
      TreeNode left;
      TreeNode right;
      TreeNode(Integer val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
