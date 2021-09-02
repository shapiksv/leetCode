package ru.shapik.leet_code.algorithms;


public class BinarySearch {

    public int search(int[] array, int value) {
        int start = 0;
        int end = array.length;
        int middle = (start + end)/2;
        while (array[middle] != value && start<= end) {
            if (array[middle] < value) {
                end = middle -1 ;
            } else {
                start = middle + 1;
            }

            middle = (start + end) / 2;
        }

        if (array[middle] == value) return middle;
        else return -1;

    }
}
