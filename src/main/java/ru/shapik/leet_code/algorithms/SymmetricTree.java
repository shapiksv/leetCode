package ru.shapik.leet_code.algorithms;

import ru.shapik.leet_code.data.Tree.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSimilar(root.left, root.right);
    }

    private boolean isSimilar(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return (left.val == right.val) && isSimilar(left.left, right.right) && isSimilar(left.right, right.left);
    }
}
