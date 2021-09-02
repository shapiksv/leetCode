package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = postorder.length -1; i >= 0; i--) {
            queue.add(postorder[i]);
        }
        return createNode(inorder, 0, inorder.length, queue);
    }

    private TreeNode createNode( int[] inorder, int startInorder, int endInorder, Queue<Integer> queue) {
        if (queue.isEmpty() || startInorder >= endInorder) return null;
        TreeNode node = new TreeNode(queue.poll());
        if ( endInorder - startInorder != 1) {
            int middle;
            for (int i = startInorder; i < endInorder; i++) {
                if (inorder[i] == node.val) {
                    middle = i;
                    node.right = createNode(inorder, middle + 1, endInorder, queue);
                    node.left = createNode(inorder, startInorder, middle, queue);

                    break;
                }
            }

        }
        return node;
    }
}
