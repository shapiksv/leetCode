package ru.shapik.leet_code.medium;

public class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] responce = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] circle = queries[i];
            for (int j = 0; j < points.length; j++) {
                int[] point = points[j];
                if (square(point[0] - circle[0]) + square(point[1] - circle[1]) <= square(circle[2])){
                    responce[i] = ++responce[i];
                }
            }
        }
        return responce;
    }
    private int square(int a){
        int result = a*a;
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.countPoints(new int[][]{{1,3},{3,3},{5,3},{2,2}}, new int[][]{{2,3,1},{4,3,1},{1,1,2}});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
