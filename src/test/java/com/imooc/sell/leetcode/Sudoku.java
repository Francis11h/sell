package com.imooc.sell.leetcode;

import java.util.Arrays;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[i][j])) return false;
            }
        }


        //col
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[j][i])) return false;
            }
        }

        //sub matrix
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!isValid(visited, board[i + k / 3][j + k % 3])) return false;
                }
            }
        }
        return true;
    }



    public boolean isValid(boolean[] visited, char digit) {
        if (digit == '.') return true;

        int num = digit - '0';

        if (num < 1 || num > 9 || visited[num - 1]) return false;

        visited[num - 1] = true;
        return true;
    }
}
