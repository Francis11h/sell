package com.imooc.sell.leetcode;

public class SudokuSolve {

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };
        solveSudoku(board);
    }

    // 1- 9的数字， 数组存下标是从0开始 0-9 是10个，所以后面要定为10
    // 前面一个代表坐标 位置，后面一个代表数
    static boolean[][] row = new boolean[9][9 + 1];
    static boolean[][] col = new boolean[9][9 + 1];
    // 前面两个代表坐标 位置，后面一个代表数
    static boolean[][][] block = new boolean[3][3][9 + 1];
    static boolean ans = false;

    public static void solveSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int item = board[i][j];
                //有值(board中出现过的数)的对应的地方初始化为true 。
                //          每三个一循环    小方块中的 第几行，第几列
                row[i][item] = col[j][item] = block[i / 3][j / 3][item] = true;
            }
        }
        dfs(board, 0, 0);
    }

    //(i,j)即将要填的位置的下表
    private static void dfs(int[][] board, int i, int j) {
        //能走到9 代表填满了
        if (i == 9) {
            ans = true;
            return;
        }
        //j一直往右走，可能越界
        if (j == 9) {
            dfs(board, i + 1, 0); //直接往下走一层，
            return; //返回
        }
        //如果这里开始前就已经被填了
        if (board[i][j] != 0) {
            dfs(board, i, j + 1);
            return;
        }

        for (int item = 1; item <= 9; item++) {

            // 判断  是否合法,这里就是一种兼剪枝了
            if (!row[i][item] && !col[j][item] && !block[i / 3][j / 3][item]) {
                row[i][item] = col[j][item] = block[i / 3][j / 3][item] = true;
                board[i][j] = item; //填进去，改变该位置的值
                dfs(board, i, j + 1);//行row不动，列col动j
                //从这里出来，要是找到答案，return
                if (ans) { //ans = true 就是代表填满了，已经是一个正确答案了
                    return;
                }
                board[i][j] = 0; //回溯为0(初始值)
                //回溯为没走过
                row[i][item] = col[j][item] = block[i / 3][j / 3][item] = false;
            }

        }
    }
}
