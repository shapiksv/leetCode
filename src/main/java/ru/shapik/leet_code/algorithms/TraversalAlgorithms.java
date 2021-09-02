package ru.shapik.leet_code.algorithms;

import ru.shapik.leet_code.data.Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalAlgorithms {
    TreeNode root = new TreeNode(0, null, null);
    void levelOreder(Queue<TreeNode> queue){
        TreeNode treeNode = queue.poll();
        if (treeNode != null) {
            System.out.println(treeNode.val);
            queue.add(treeNode.left);
            queue.add(treeNode.right);
            levelOreder(queue);
        }

    }

    void levelOreder(){
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    void preOrder(TreeNode node, List<Integer> arr){
        if (node != null) {
            preOrder(node.left, arr);
            arr.add(node.val);
            preOrder(node.right, arr);
        }

    }

    void inOrder(TreeNode node, List<Integer> arr){
        if (node != null) {
            inOrder(node.left, arr);
            arr.add(node.val);
            inOrder(node.right, arr);
        }

    }

    void postOrder(TreeNode node, List<Integer> arr){
        if (node != null) {
            postOrder(node.left, arr);
            postOrder(node.right, arr);
            arr.add(node.val);
        }

    }
}
