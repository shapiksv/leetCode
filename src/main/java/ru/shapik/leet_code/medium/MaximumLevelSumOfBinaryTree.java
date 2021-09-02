package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.Tree.TreeNode;

import java.util.*;

public class MaximumLevelSumOfBinaryTree {
    public static void main(String[] args) {
        MaximumLevelSumOfBinaryTree maximumLevelSumOfBinaryTree = new MaximumLevelSumOfBinaryTree();
        //[-100,-200,-300,-20,-5,-10,null]    Expected 3
        TreeNode treeNode100 = new TreeNode(-100,
                new TreeNode(-200,new TreeNode(-20, null, null), new TreeNode(-5, null, null)),
                new TreeNode(-300, new TreeNode(-10, null, null), null));
        //[989,null,10250,98693,-89388,null,null,null,-32127] Expected 2
        TreeNode treeNode989 = new TreeNode(989,
                null,
                new TreeNode(10250, new TreeNode(98693, null, null), new TreeNode(-89388, null, new TreeNode(-32127, null, null))));
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(7, new TreeNode(7, null, null), new TreeNode(-8, null, null)),
                new TreeNode(0, null, null));
//        System.out.println(maximumLevelSumOfBinaryTree.maxLevelSum(treeNode));
//        System.out.println(maximumLevelSumOfBinaryTree.maxLevelSum(treeNode100)); // 3
        System.out.println(maximumLevelSumOfBinaryTree.maxLevelSum(treeNode989));  //2
    }

    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> levelValue = new HashMap<>();
        findValue(0, root, levelValue);
        int level = 1;
        int value = levelValue.get(level);
        for (Integer key : levelValue.keySet()) {
            if (levelValue.get(key) > value) {
                level = key;
                value = levelValue.get(key);
            }
        }
        return level;
    }
    void findValue(int level, TreeNode root, Map<Integer, Integer> levelValue){
        if (root != null) {
            level ++;
            if (levelValue.get(level) == null) levelValue.put(level, root.val);
            else levelValue.put(level, root.val + levelValue.get(level));
            findValue(level, root.left, levelValue);
            findValue(level, root.right, levelValue);
        }
    }



}
