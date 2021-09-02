package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.Tree.TreeNode;

public class BalanceBinarySearchTree {
    public static void main(String[] args) {
        // input [1,null,15,14,17,7,null,null,null,2,12,null,3,9,null,null,null,null,11]
        // Expected [9,2,14,1,3,11,15,null,null,null,7,null,12,null,17]
        BalanceBinarySearchTree balanceBinarySearchTree = new BalanceBinarySearchTree();
        TreeNode node = balanceBinarySearchTree.balanceBST(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, null)))));
        System.out.println();
    }
    public TreeNode balanceBST(TreeNode root) {
        if (root == null || (root.right != null && root.left != null)) return root;
        if ( root.right != null && root.left != null) {
            root.right = balanceBST(root.right);
            root.left = balanceBST(root.left);
            return root;
        } else if (root.right != null && root.left == null) {
            TreeNode right = root.right;
            root.right = null;
            if (right.right != null && right.left == null) {
                right.left = root;
            } else if (right.right == null && right.left != null) {
                right.right = root;
            } else {
                addNode(right, root);
            }
            return right;
        } else {
            TreeNode left = root.left;
            root.left = null;
            if (left.right != null && left.left == null) {
                left.left = root;
            } else if (left.right == null && left.left != null) {
                left.right = root;
            } else {
                addNode(left, root);
            }
            return left;
        }
    }

    private void addNode(TreeNode node, TreeNode newNode) {
        if (node.val > newNode.val) {
            if (node.left == null) node.left = newNode;
            else addNode(node.left, newNode);
        } else {
            if (node.right == null) node.right = newNode;
            else addNode(node.right, newNode);
        }
    }

}
