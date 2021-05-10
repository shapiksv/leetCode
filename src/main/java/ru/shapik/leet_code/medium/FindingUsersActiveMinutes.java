package ru.shapik.leet_code.medium;

import java.util.*;

public class FindingUsersActiveMinutes {
    public static void main(String[] args) {
        FindingUsersActiveMinutes activeMinutes = new FindingUsersActiveMinutes();
//        int[] ints = activeMinutes.findingUsersActiveMinutes(new int[][]{{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}}, 5);
        int[] ints = activeMinutes.findingUsersActiveMinutes(new int[][]{{1,1}, {2, 2}, {2, 3}}, 4);
        Arrays.stream(ints).forEach(i -> System.out.print(i + ","));
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] responce = new int[k];
        Map<Integer, Set<Integer>> integerSetMap = new HashMap<>();
        for (int[] i: logs) {
            if (integerSetMap.get(i[0]) == null)integerSetMap.put(i[0], new HashSet<>());
            integerSetMap.get(i[0]).add(i[1]);
        }
        integerSetMap.values().stream().filter(set -> set.size() > 0).forEach(set -> responce[set.size() -1] = ++responce[set.size()-1]);
        return responce;
    }
}
