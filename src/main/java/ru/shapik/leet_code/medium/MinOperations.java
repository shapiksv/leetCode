package ru.shapik.leet_code.medium;

public class MinOperations {
    public static void main(String[] args) {
        MinOperations operations = new MinOperations();
        System.out.println(operations.minOperations(6));
    }

    public int minOperations(int n) {
        int responce = 0;
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int value = 2 * i + 1;
            arr[i] = value;
            sum += value;
        }
        int some = sum/n;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < some) {
                responce += some - arr[i];
            } else break;
        }
        return responce;
    }
}
