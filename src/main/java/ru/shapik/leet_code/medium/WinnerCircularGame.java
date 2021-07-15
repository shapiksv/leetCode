package ru.shapik.leet_code.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WinnerCircularGame {
    public static void main(String[] args) {
        WinnerCircularGame winnerCircularGame = new WinnerCircularGame();

        System.out.println(winnerCircularGame.findTheWinner(6, 5));
    }
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            for (int i = 1; i <= k -1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
    }
}
