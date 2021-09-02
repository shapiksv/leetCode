package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.Tree.TreeNode;

public class LowestCommonAncestorOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = lowestCommonAncestor(new TreeNode(3,
                        new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                        new TreeNode(1, new TreeNode(0), new TreeNode(8))),
                new TreeNode(5), new TreeNode(4));
        System.out.println(node);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null && (p != null || q != null)) {
            TreeNode current = null;
            if (p != null && root.val == p.val) {
                current = root;
                p = null;
            }
            if (q != null && root.val == q.val) {
                current = root;
                q = null;
            }
            TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
            if ((leftNode != null && rightNode != null) || (current != null && rightNode != null) || (leftNode != null && current != null)) return root;
            if (current != null) return current;
            if (leftNode != null) return leftNode;
            if (rightNode != null) return rightNode;

        }
        return null;
    }
}
