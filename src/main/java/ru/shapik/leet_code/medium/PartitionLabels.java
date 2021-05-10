package ru.shapik.leet_code.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
//        List<Integer> integers = partitionLabels.partitionLabels("ababcbacadefegdehijhklij"); //9,7,8
//        List<Integer> integers = partitionLabels.partitionLabels("caedbdedda");//1,9
        List<Integer> integers = partitionLabels.partitionLabels("eaaaabaaec");//9,1
        integers.forEach(s -> System.out.print(s));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> integers = new ArrayList<>();
        char[] chars = s.toCharArray();
        int start = -1;
        int last;
        for (int i = 0; i < chars.length; i++) {
            last = getBigIndex(chars, chars[i]);
            if (i == last || i + 1 == chars.length) {
                integers.add(1);
                start = i;
            } else {
                for (int t = i +1; t < last; t++) {
                    int bigIndex = getBigIndex(chars, chars[t]);
                    if (bigIndex > last) last = bigIndex;
                }
                integers.add(last - start);
                if (last < chars.length) {
                    start = last;
                    i = start;
                }
            }
        }
        return integers;
    }

    public int getBigIndex(char[] arrChars, char s) {
        int responce = 0;
        for (int i = 0; i < arrChars.length; i++) {
            if (arrChars[i] == s) responce = i;
        }
        return responce;
    }
}
