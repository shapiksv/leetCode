package ru.shapik.leet_code.data.AVLTree;

import ru.shapik.leet_code.data.Tree.BinaryNode;

public class AVL {
    BinaryNode root;

    public AVL() {
        root = null;
    }

    public int getHeight(BinaryNode node) {
        if (node == node) return 0;
        return node.height;
    }

    private BinaryNode rotateRight(BinaryNode disbalancedNode) {
        BinaryNode node = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        node.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return node;
    }

    public BinaryNode rotateLeft(BinaryNode disbalancedNode) {
        BinaryNode node = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        node.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return node;
    }

    public int getBalance(BinaryNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        if (node == null) {
            node = new BinaryNode();
            node.value = nodeValue;
            node.height = 1;
            return node;
        } else if (node.value > nodeValue) {
            insertNode(node.left, nodeValue);
        } else {
            insertNode(node.right, nodeValue);
        }
        node.height = 1 + Math.max(getHeight(node.right), getHeight(node.left));
        int balance = getBalance(node);

        if (balance > 1 && nodeValue < node.left.value) {
            return rotateRight(node);
        } else if (balance > 1 && nodeValue > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        } else if (balance <-1 && nodeValue > node.right.value) {
            return rotateLeft(node);
        }else if (balance < -1 && nodeValue < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(int value){
        root = insertNode(root, value);
    }

    public BinaryNode getMinNode(BinaryNode node) {
        if (node.left == null) return node;
        return getMinNode(node.left);
    }

    private BinaryNode deleteNode(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Node with value: " + value + " not found" );
            return node;
        }
        if (node.value > value) {
            node.left = deleteNode(node.left, value);
        } else if (node.value < value) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left != null && node.right != null) {
                BinaryNode minNode = getMinNode(node.right);
                node.value = minNode.value;
                node.right = deleteNode(node.right, minNode.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        } else if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        } else if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        } else if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }
}
