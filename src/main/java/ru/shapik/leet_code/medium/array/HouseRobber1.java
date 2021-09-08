package ru.shapik.leet_code.medium.array;

public class HouseRobber1 {
    public static void main(String[] args) {
        HouseRobber1 houseRobber = new HouseRobber1();
        System.out.println(houseRobber.rob(new int[]{1,2,3,1}));
    }
    public int rob(int[] nums) {
        if (nums.length == 0)return 0;
        int tmp[] = new int[nums.length + 1];
        tmp[0] = 0;
        tmp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp[i+1] = Math.max(tmp[i], tmp[i-1] + nums[i]);
        }
        return tmp[nums.length];


    }

}
