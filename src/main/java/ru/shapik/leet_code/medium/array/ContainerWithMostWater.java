package ru.shapik.leet_code.medium.array;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater withMostWater = new ContainerWithMostWater();
        System.out.println(withMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(withMostWater.maxArea(new int[]{1,1}));
    }

    public int maxArea(int[] height) {
        int response = 0;
        int firstPivot = 0;
        int lastPivot = height.length -1;
        while (firstPivot < lastPivot) {
            if (height[firstPivot] > height[lastPivot]) {
                response = Math.max(response, (lastPivot -firstPivot) * height[lastPivot]);
                lastPivot--;
            }else {
                response = Math.max(response, (lastPivot -firstPivot) * height[firstPivot]);
                firstPivot++;
            }
        }
        return response;
    }
}
