package ru.shapik.leet_code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 1};
        PancakeSorting pancakeSorting = new PancakeSorting();
        pancakeSorting.pancakeSort(arr).forEach(num -> System.out.println(num));
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> numInt = new ArrayList<>();
        for (int i = arr.length; i > 0; i--) {
            int j = find(arr, i);
            flip(arr, j);
            flip(arr, i - 1);
            numInt.add(j + 1);
            numInt.add(i);
        }
        return numInt;
    }

    private int find(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) return i;
        }
        return -1;
    }

    private void flip(int[] arr, int k) {
        int i = 0;
        while (i < k) {
            int tmp = arr[i];
            arr[i++] = arr[k];
            arr[k--] = tmp;
        }
    }
}
//3
//4
//2
//3
//1
//2
//1
//1