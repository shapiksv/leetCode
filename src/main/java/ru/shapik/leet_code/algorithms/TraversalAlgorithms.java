package ru.shapik.leet_code.algorithms;

import ru.shapik.leet_code.data.TreeNode;

import java.util.Queue;

public class TraversalAlgorithms {
    void wideDetour(Queue<TreeNode> queue){
        TreeNode treeNode = queue.poll();
        if (treeNode != null) {
            System.out.println(treeNode.val);
            queue.add(treeNode.left);
            queue.add(treeNode.right);
            wideDetour(queue);
        }

    }
}
