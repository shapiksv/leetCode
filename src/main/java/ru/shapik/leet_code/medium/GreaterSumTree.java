package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreaterSumTree {

    public static void main(String[] args) {
        GreaterSumTree greaterSumTree = new GreaterSumTree();
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(1, new TreeNode(0, null, null), new TreeNode(2, null, new TreeNode(3, null, null))),
                new TreeNode(6, new TreeNode(5, null, null), new TreeNode(7, null, new TreeNode(8, null, null))));
        greaterSumTree.bstToGst(treeNode);
    }
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        traversal(root, arr);
        Map<Integer, Integer> value = getValue(arr);
        increase(root, value);
        return root;
    }

    private void traversal(TreeNode root, List<Integer> response) {
        if (root != null) {
            traversal(root.left, response);
            response.add(root.val);
            traversal(root.right, response);
        }
    }

    private void increase(TreeNode root, Map<Integer, Integer> value) {
        if (root != null) {
            root.val = value.get(root.val);
            increase(root.left, value);
            increase(root.right, value);
        }
    }

    private Map<Integer, Integer> getValue (List<Integer> arr) {
        Map<Integer, Integer> response = new HashMap<>();
        int num = 0;
        for (int i = arr.size() - 1; i >= 0 ; i--) {
            num +=arr.get(i);
            response.put(arr.get(i), num);
        }
        return response;
    }
}
