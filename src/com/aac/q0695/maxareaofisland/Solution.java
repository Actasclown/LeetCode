package com.aac.q0695.maxareaofisland;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for(int j = 0;j < n; ++ j) {
                if(grid[i][j] == 1)
                    max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n)
            return 0;
        if(grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;
        int ret = 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
//        grid[i][j] = 1;
//        if(ret == 9) {
//            for (int[] a : grid) {
//                for (int b : a) {
//                    System.out.print(b);
//                }
//                System.out.println("");
//            }
//            System.out.println(i + " " +j);
//        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] test = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(new Solution().maxAreaOfIsland(test));
//        for (int[] n : test) {
//            for (int m : n) {
//                System.out.print(m);
//            }
//            System.out.println("");
//        }
    }
}
