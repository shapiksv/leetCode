package ru.shapik.leet_code.medium;

import ru.shapik.leet_code.sort.QuickSortArr;

public class MaxWidthOfVerticalArea {

    public static void main(String[] args) {
        MaxWidthOfVerticalArea maxWidthOfVerticalArea = new MaxWidthOfVerticalArea();
        int[][] firstArr = {{8, 7}, {9, 9}, {7, 4}, {9, 7}};
        int[][] sekondArr = {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};
        System.out.println(maxWidthOfVerticalArea.maxWidthOfVerticalArea(firstArr));
        System.out.println(maxWidthOfVerticalArea.maxWidthOfVerticalArea(sekondArr));

    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int[] width = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            width[i] = points[i][0];
        }
        QuickSortArr.quickSort(width, 0, width.length -1);
        int responce = 0;
        for (int i = 0; i < width.length -1; i++) {
            if (responce < width[i + 1] - width[i]) responce = width[i + 1] - width[i];
        }
        return responce;
    }

}
