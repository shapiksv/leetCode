package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.Tree.TreeNode;

public class MaximumBinaryTree {
    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        int[] schema = new int[]{3,2,1,6,0,5};
        TreeNode treeNode = maximumBinaryTree.constructMaximumBinaryTree(schema);
        System.out.println("-----------------");
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int subscript, int superscript){
        if (subscript == superscript) {
            return new TreeNode(nums[subscript],null, null);
        } if (subscript > superscript) return null;
        int indexMaxValue = findMaxValue(nums, subscript, superscript);
        TreeNode node = new TreeNode(nums[indexMaxValue],
                createTree(nums, subscript, indexMaxValue - 1),
                createTree(nums, indexMaxValue + 1, superscript));
        return node;

    }

    private int findMaxValue(int[] nums, int subscript, int superscript) {
        int index = subscript;
        int maxValue = nums[subscript];
        for (int i = subscript; i <= superscript; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        return index;
    }
}
