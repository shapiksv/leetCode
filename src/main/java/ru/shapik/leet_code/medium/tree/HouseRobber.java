package ru.shapik.leet_code.medium.tree;

import ru.shapik.leet_code.data.Tree.TreeNode;

public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();

        robber.rob(new TreeNode(4, new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), null), null),null));
    }
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] sum = new int[2];
        rob(root, sum, 1);
        return Math.max(sum[0],sum[1]);

    }

    public void rob(TreeNode root, int[] sum, int level) {
        if (root == null) return;
        sum[level%2] = root.val + sum[level%2];
        rob(root.left, sum, level + 1);
        rob(root.right, sum, level + 1);

    }
}
