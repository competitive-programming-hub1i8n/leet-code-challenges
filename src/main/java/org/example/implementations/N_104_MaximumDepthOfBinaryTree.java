package org.example.implementations;

public class N_104_MaximumDepthOfBinaryTree {
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
    public int maxDepth(TreeNode root) {
        return bfs(root, 0);
    }

    public int bfs(TreeNode root, int depth) {
        if (root == null) return depth;
        int leftDepth = bfs(root.left, depth+1);
        int rightDepth = bfs(root.right, depth+1);
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        N_104_MaximumDepthOfBinaryTree tree = new N_104_MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        root.right.right.right = new TreeNode(5);
        System.out.println(tree.maxDepth(root));
    }
}
