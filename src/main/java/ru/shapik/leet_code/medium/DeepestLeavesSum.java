package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DeepestLeavesSum {
    public static void main(String[] args) {
        DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,new TreeNode(4, new TreeNode(7, null, null), null), new TreeNode(5, null, null)),
                new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8, null, null)))
                );
        System.out.println(deepestLeavesSum.deepestLeavesSum(treeNode));
    }
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> mapLevelValue = new HashMap<>();
        findNode(mapLevelValue, 0, root);
        int key = 0;
        for (Integer k : mapLevelValue.keySet()) {
            if (k > key) key = k;
        }
        return mapLevelValue.get(key);
    }

    private void findNode(Map<Integer, Integer> mapLevelValue, int num, TreeNode root) {
        if (root != null) {
            ++num;
            int key = num;
            findNode(mapLevelValue, num, root.left);
            findNode(mapLevelValue, num, root.right);
            if (mapLevelValue.get(key) == null) mapLevelValue.put(key, root.val);
            else mapLevelValue.put(key, mapLevelValue.get(key) + root.val);

        }
    }

    public int deepestLeavesSum(TreeNode root, int level) {
        if (root == null) return level;
        ++level;
        int left = deepestLeavesSum(root.left, level);
        int right = deepestLeavesSum(root.right, level);
        if (left > right) return left;
        else return right;

    }

}
