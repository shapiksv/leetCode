package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.data.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class EvenValuedGrandparent {
    public static void main(String[] args) {
        EvenValuedGrandparent evenValuedGrandparent = new EvenValuedGrandparent();
        TreeNode treeNode = new TreeNode(6,
                new TreeNode(7 , new TreeNode(2, new TreeNode(9, null, null),null), new TreeNode(7, new TreeNode(1, null, null), new TreeNode(4, null, null))),
                new TreeNode(8, new TreeNode(1, null, null), new TreeNode(3, null, new TreeNode(5, null, null))));
        System.out.println(evenValuedGrandparent.sumEvenGrandparent(treeNode));
    }
    public int sumEvenGrandparent(TreeNode root) {
       Integer num = 0;
        List<Integer> intList = new ArrayList<>();
        findNode(root, intList);
        for (int i = 0; i < intList.size(); i++) {
            num += intList.get(i);
        }
       return num;
    }

    private void findGrandChildren(TreeNode root, List<Integer> intLis) {
        if (root != null) {
            if (root.left != null) intLis.add(root.left.val);
            if (root.right != null) intLis.add(root.right.val);
        }
    }

    private void findNode(TreeNode root, List<Integer> intLis) {
        if (root != null) {
            if (root.val%2 == 0) {
                findGrandChildren(root.left, intLis);
                findGrandChildren(root.right, intLis);
            }
            findNode(root.left, intLis);
            findNode(root.right, intLis);
        }
    }
}
