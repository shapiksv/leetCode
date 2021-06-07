package ru.shapik.leet_code.algorithms;

import ru.shapik.leet_code.data.TreeNode;

import java.util.List;

public class ArrToTree {

    public static void treeToArr(int index, TreeNode[] listTreeNode){
        TreeNode treeNode = listTreeNode[index];
        if (treeNode != null) {
            int indexLeft = 2 * index + 1;
            int indexRight = 2 * index + 2;
            listTreeNode[indexLeft] = treeNode.left;
            listTreeNode[indexRight] = treeNode.right;
            treeToArr(indexLeft, listTreeNode);
            treeToArr(indexRight, listTreeNode);
        }
    }
}
