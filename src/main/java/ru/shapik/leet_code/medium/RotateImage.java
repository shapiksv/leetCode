package ru.shapik.leet_code.medium;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length /2; i++) {
            int first = i;
            int last = n - 1 - i;
            for (int j = first; j < last; j++) {
                int offset = j - first;
                int top = matrix[first][j];
                matrix[first][j] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[j][last];
                matrix[j][last] = top;
            }
        }
    }
}
