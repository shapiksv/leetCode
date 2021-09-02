package ru.shapik.leet_code.sort;

public class ArraySort {
    public static void main(String[] args) {
        int[] array = new int[] {10,3,2,5,8,4,3,1,2,9,7,8};
        mergeSort(array, 0, array.length -1);
        System.out.println();
    }

    // O(N^2)
    public int[] selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) min = j;
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
        return a;
    }

    // O(N^2)
    public int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
        return a;
    }

    // O(N^2)
    public int[] insertingSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j = i;
            while (j>0 && a[j-1] > tmp) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = tmp;
        }
        return a;
    }

    //O(NLog), stable sort
    public static void mergeSort(int[] a, int leftIndex, int rightIndex) {
        if (rightIndex > leftIndex) {
            int m = (leftIndex+rightIndex)/2;
            mergeSort(a, leftIndex, m);
            mergeSort(a, m + 1,  rightIndex);
            merge(a,leftIndex, m, rightIndex);
        }
    }

    private static void merge(int[] A, int left, int middle, int right) {
        int[] leftTmpArray = new int[middle-left+2];
        int[] rightTmpArray = new int[right-middle+1];
        for (int i = 0; i<=middle-left; i++) {
            leftTmpArray[i] = A[left + i];
        }
        for (int i = 0; i < right - middle; i++) {
            rightTmpArray[i] = A[middle+1 + i];
        }
        leftTmpArray[middle - left + 1] = Integer.MAX_VALUE;
        rightTmpArray[right - middle] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = left; k <= right ; k++) {
            if (leftTmpArray[i] < rightTmpArray[j]) {
                A[k] = leftTmpArray[i];
                i++;
            } else {
                A[k] = rightTmpArray[j];
                j++;
            }
        }
    }

}
