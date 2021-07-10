package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.TreeNode;

public class ConstructBinarySearchTree {

    public static void main(String[] args) {
        ConstructBinarySearchTree constructBinarySearchTree = new ConstructBinarySearchTree();
        constructBinarySearchTree.bstFromPreorder(new int[]{8,5,1,7,10,12});
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode node = new TreeNode(preorder[0], null, null);
        for (int i = 1; i < preorder.length; i++) {
            addNode(node, preorder[i]);
        }
        return node;
    }

    private void addNode(TreeNode node, int value) {
        if (node.val > value) {
            if (node.left == null) node.left = new TreeNode(value, null, null);
            else addNode(node.left, value);
        } else {
            if (node.right == null) node.right = new TreeNode(value, null, null);
            else addNode(node.right, value);
        }
    }
}
