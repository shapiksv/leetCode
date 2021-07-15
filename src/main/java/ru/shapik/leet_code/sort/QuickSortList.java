package ru.shapik.leet_code.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSortList {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            arr.add(new Random().nextInt(14682));
        }

        quickSort(arr, 0, arr.size() - 1);
        System.out.println();
    }

    public static void quickSort(List<Integer> arr, int start, int finish) {
        if (finish <= start) return;

        Integer middle = middelIt(start, finish, arr);
        quickSort(arr, start, middle - 1);
        quickSort(arr, middle + 1, finish);


    }

    private static Integer middelIt(int start, int finish, List<Integer> arr) {
        int leftPartition = start;
        int rightPartition = finish + 1;
        int pivot = arr.get(start);

        while (true) {
            while (arr.get(++leftPartition) < pivot)  if (leftPartition == finish) break;
            while (arr.get(--rightPartition) > pivot) if (rightPartition == start) break;
            if (leftPartition >= rightPartition) break;
            else swap(arr, leftPartition, rightPartition);
        }
        swap(arr, start, rightPartition);
        return rightPartition;
    }

    private static void swap(List<Integer> arr, int leftPartition, int rightPartition) {
        int temp = arr.get(leftPartition);
        arr.set(leftPartition, arr.get(rightPartition));
        arr.set(rightPartition, temp);
    }
}
