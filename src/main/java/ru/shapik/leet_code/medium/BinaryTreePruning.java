package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.TreeNode;

public class BinaryTreePruning {
    public static void main(String[] args) {
        BinaryTreePruning binaryTreePruning = new BinaryTreePruning();
        TreeNode treeNode = new TreeNode(1,
                null,
                new TreeNode(0, new TreeNode(0, null, null), new TreeNode(1, null, null)));
        binaryTreePruning.pruneTree(treeNode);
    }
    public TreeNode pruneTree(TreeNode root) {
        cleaingTree(root);
        if (root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }

    private void cleaingTree(TreeNode root) {
        if (root != null) {
            cleaingTree(root.left);
            cleaingTree(root.right);

            if (root.left != null && root.left.val == 0 && root.left.left == null && root.left.right == null)
                root.left = null;
            if (root.right != null && root.right.val == 0 && root.right.left == null && root.right.right == null)
                root.right = null;

        }

    }
}
