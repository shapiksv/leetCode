package ru.shapik.leet_code.medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {
        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        //1,2 5,5 8,10 15,23 24,24 25,25
//        int[][] ints = intervalListIntersections.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});

        //3,10
//        int[][] ints = intervalListIntersections.intervalIntersection(new int[][]{{3, 10}}, new int[][]{{5, 10}});

        int[][] ints = intervalListIntersections.intervalIntersection(new int[][]{{5, 10}}, new int[][]{{3, 10}});
        for (int i = 0; i < ints.length ; i++) {
            System.out.println(ints[i][0] + " " + ints[i][1]);
        }
    }
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<String> stringList = new ArrayList<>();
        FIRST:for (int i = 0; i < firstList.length; i++) {
            int startFirst = firstList[i][0];
            int finishFirst = firstList[i][1];
            for (int j = 0; j < secondList.length; j++) {
                int finishSecond = secondList[j][1];
                int startSecond = secondList[j][0];
                if (finishFirst < startSecond) continue FIRST;
                if (startFirst >= startSecond && finishFirst <= finishSecond) stringList.add(startFirst + "," + finishFirst);
                else if (startFirst <= startSecond && finishFirst >= finishSecond) stringList.add(startSecond + "," + finishSecond);
                else if (startSecond == finishFirst) stringList.add(finishFirst + "," + finishFirst);
                else if (secondList[j][1] == startFirst) stringList.add(startFirst + "," + startFirst);
                else if (secondList[j][1] == startFirst) stringList.add(startFirst + "," + startFirst);
                else if (startFirst < startSecond && finishFirst <= finishSecond && finishFirst > startSecond) stringList.add(startSecond + "," + finishFirst);
                else if (startFirst < startSecond && finishFirst < finishSecond) stringList.add(startSecond + "," + finishFirst);
                else if (startSecond < startFirst && finishSecond > startFirst && finishSecond < finishFirst) stringList.add(startFirst + "," + finishSecond);
            }
        }
        int response[][] = new int[stringList.size()][2];
        for (int i = 0; i < stringList.size(); i++) {
            String[] split = stringList.get(i).split(",");
            response[i][0] = Integer.valueOf(split[0]);
            response[i][1] = Integer.valueOf(split[1]);

        }
        return response;
    }
}
