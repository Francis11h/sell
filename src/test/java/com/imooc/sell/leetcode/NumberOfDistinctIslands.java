package com.imooc.sell.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    static String temp;
    static int cx = 0, cy = 0;
    static Set<String> set = new HashSet<>();

    public static int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    temp = "";
                    cx = i;
                    cy = j;
                    dfs(grid, i, j, visited);
                    set.add(temp);
                }
            }
        }
        return set.size();
    }

    private static void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1 || visited[x][y])
            return;
        //下[1,0] 上[-1,0] 右[0,1] 左[0,-1]
        temp += (x - cx) + " " + (y - cy) + " ";
        visited[x][y] = true;
        dfs(grid, x + 1, y, visited);   // x 是行号 下一行同一列 就是 向下走1
        dfs(grid, x - 1, y, visited);
        dfs(grid, x, y + 1, visited);
        dfs(grid, x, y - 1, visited);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                        {1,1,0,0,0},
                        {1,0,0,0,0},
                        {0,0,0,0,1},
                        {0,0,0,1,1}};
        System.out.println(numDistinctIslands(grid));
    }
}
