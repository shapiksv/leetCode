package ru.shapik.leet_code.medium;

import static ru.shapik.leet_code.sort.QuickSortArr.quickSort;

public class DiagonalSort {
    public static void main(String[] args) {
        DiagonalSort diagonalSort = new DiagonalSort();
//        diagonalSort.diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}});
//        diagonalSort.diagonalSort(new int[][]{{5, 17, 4, 1, 52, 7}, {11, 11, 25, 45, 8, 69}, {14, 23, 25, 44, 58, 15}, {22, 27, 31, 36, 50, 66}, {84, 28, 75, 33, 55, 68}});
        diagonalSort.diagonalSort(new int[][]{{37,98,82,45,42}});

    }
    public int[][] diagonalSort(int[][] mat) {
        int vertical = mat.length;
        int horizontal = mat[0].length;
        int sortSide  = vertical <= horizontal ? vertical : horizontal;
        for (int i = 0; i < horizontal; i++) {
            int[] arr = new int[sortSide];
            int k = 0;
            for (int j = i; j < horizontal && k < vertical; j++, k++) {
                arr[j - i] = mat[k][j];
            }
            if (k == 0) break;
            quickSort(arr, 0, k - 1);
            k = 0;
            for (int j = i; j < horizontal && k < vertical; j++, k++) {
                mat[k][j] = arr[j - i];
            }
        }
        for (int i = 0; i < vertical; i++) {
            int[] arr = new int[sortSide];
            int k = 0;
            for (int j = i; j < vertical && k < horizontal; j++, k++) {
                arr[j - i] = mat[j][k];
            }
            if (k == 0) break;
            quickSort(arr, 0, k - 1);
            k = 0;
            for (int j = i; j < vertical && k < horizontal; j++, k++) {
                mat[j][k] = arr[j - i];
            }
        }

        return mat;
    }
}
