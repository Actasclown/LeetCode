package com.aac.q0200.numberofislands;

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null)
            return 0;
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        return;
    }

    public static void main(String[] args) {
        char[][] test = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'}};
        System.out.println(new Solution().numIslands(test));
    }
}
