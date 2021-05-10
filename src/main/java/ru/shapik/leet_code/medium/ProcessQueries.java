package ru.shapik.leet_code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessQueries {
    public static void main(String[] args) {
        ProcessQueries processQueries = new ProcessQueries();
//        int[] ints = processQueries.processQueries(new int[]{3, 1, 2, 1}, 5);
        int[] ints = processQueries.processQueries(new int[]{4,1,2,2}, 4);
        Arrays.stream(ints).forEach(i -> System.out.print(i + ","));
    }

    public int[] processQueries(int[] queries, int m) {
        int[] responce = new int[queries.length];
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (queries[i] == arr[j]) {
                    responce[i] = j;
                    if (j !=0) {
                        for (int k = j; k > 0; k--) {
                            arr[k] = arr[k - 1];
                        }
                        arr[0] = queries[i];
                    }
                }
            }
        }
        return responce;
    }
}
