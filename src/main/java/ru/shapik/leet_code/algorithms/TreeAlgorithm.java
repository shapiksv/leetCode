package ru.shapik.leet_code.algorithms;

import ru.shapik.leet_code.data.Tree.TreeNode;

public class TreeAlgorithm {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        return depthLeft >= depthRight ? depthLeft + 1 : depthRight +1;

    }
}
