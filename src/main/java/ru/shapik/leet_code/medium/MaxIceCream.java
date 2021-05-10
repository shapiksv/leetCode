package ru.shapik.leet_code.medium;

import static ru.shapik.leet_code.sort.QuickSortArr.quickSort;

public class MaxIceCream {
    public static void main(String[] args) {
        MaxIceCream maxIceCream = new MaxIceCream();
        System.out.println(maxIceCream.maxIceCream(new int[]{1,3,2,4,1}, 7));
        System.out.println(maxIceCream.maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(maxIceCream.maxIceCream(new int[]{1,6,3,1,2,5}, 20));
    }
    public int maxIceCream(int[] costs, int coins) {
        int col = 0;
        quickSort(costs, 0 , costs.length - 1);
        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                coins -= costs[i];
                col++;
            } else return col;
        }
        return col;
    }
}
