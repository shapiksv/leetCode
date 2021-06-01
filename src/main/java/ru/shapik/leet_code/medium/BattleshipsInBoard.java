package ru.shapik.leet_code.medium;

import java.util.HashMap;
import java.util.Map;

public class BattleshipsInBoard {
    public static void main(String[] args) {
        BattleshipsInBoard battleshipsInBoard = new BattleshipsInBoard();
        System.out.println(battleshipsInBoard.countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
    }
    public int countBattleships(char[][] board) {
        int response = 0;
        Map<String, Boolean> checkField = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            VERTICAL:
            for (int j = 0; j < board[0].length; j++) {
                if (checkField.get(i + "," + j) != null) continue VERTICAL;
                if (board[i][j] == 'X') {
                    checkField.put(i + "," + j, true);
                    if (j + 1 < board[0].length && board[i][j + 1] == 'X') checkAll(checkField, board, i, j + 1, true);
                    else if (i + 1 < board.length && board[i + 1][j] == 'X') checkAll(checkField, board, i + 1, j, false);
                    response++;
                }
            }
        }
        return response;
    }

    private void checkAll(Map<String, Boolean> checkField, char[][] board, int x, int y, boolean vertical) {
        if (vertical) {
            for (int j = y; j < board[0].length; j++) {
                if (board[x][j] == 'X') {
                    checkField.put(x + "," + j, true);
                } else break;
            }
        } else {
            for (int i = x; i < board.length; i++) {
                if (board[i][y] == 'X') {
                    checkField.put(i + "," + y, true);
                } else break;
            }
        }
    }
}
