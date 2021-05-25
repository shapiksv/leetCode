package ru.shapik.leet_code.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> response =new ArrayList<>();
        findValue(response,root1);
        findValue(response,root2);
        response.sort(Comparator.naturalOrder());

        return response;
    }

    private void findValue(List<Integer> arr, TreeNode node) {
        if (node != null) {
            arr.add(node.val);
            findValue(arr, node.left);
            findValue(arr, node.right);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
