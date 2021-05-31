package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.TreeNode;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GoodNodesInBinaryTree {

    public static void main(String[] args) {
        GoodNodesInBinaryTree goodNodesInBinaryTree = new GoodNodesInBinaryTree();
        TreeNode treeNode = new TreeNode(3,
                new TreeNode(1, new TreeNode(3, null, null), null),
                new TreeNode(4, new TreeNode(1, null, null),new TreeNode(5, null, null)));

        System.out.println(goodNodesInBinaryTree.goodNodes(treeNode));
    }
    public int goodNodes(TreeNode root) {
        AtomicInteger atomicInt = new AtomicInteger(0);
        sorch(root, "", atomicInt);
        return atomicInt.get();
    }

    private void sorch(TreeNode root, String nums, AtomicInteger atomicIn) {
        if (root != null) {
            if (nums.isEmpty() || nums.isBlank()){
                atomicIn.incrementAndGet();
                nums = nums.concat(String.valueOf(root.val));
            } else {
                String[] split = nums.split(",");
                boolean largest = true;
                for (int i = 0; i < split .length; i++) {
                    if (Integer.valueOf(split [i]) > root.val) {
                        largest = false;
                        break;
                    }
                }
                if (largest) atomicIn.incrementAndGet();
                nums = nums.concat("," + String.valueOf(root.val));
            }

            sorch(root.right, nums, atomicIn);
            sorch(root.left, nums, atomicIn);
        }
    }
}
