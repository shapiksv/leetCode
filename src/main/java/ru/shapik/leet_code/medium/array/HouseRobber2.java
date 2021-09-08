package ru.shapik.leet_code.medium.array;

public class HouseRobber2 {
    public static void main(String[] args) {
        HouseRobber2 houseRobber = new HouseRobber2();
        houseRobber.rob(new int[]{1,2,3,1});
    }
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(ron(nums, 0, nums.length-1), ron(nums, 1, nums.length));
    }

    public int ron(int[]house, int start, int end) {
        int prevOne = 0;
        int prevTwo = 0;
        int max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(prevOne ,prevTwo + house[i]);
            prevTwo = prevOne;
            prevOne = max;
        }
        return prevOne;
    }
}
