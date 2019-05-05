package com.aac.q0064.minimumpathsum;

import java.util.Arrays;

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null)
            return 0;
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        if(n == 0)
            return 0;
        int[][] distance = new int[m + 1][n + 1];
        for (int[] i: distance) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        distance[0][1] = 0;

        for(int i = 1;i <= m;++i) {
            for(int j = 1;j <= n;++j) {
                distance[i][j] = Math.min(distance[i][j - 1], distance[i - 1][j]);
                distance[i][j] += grid[i - 1][j - 1];
            }
        }
        return distance[m][n];
    }

    public static void main(String[] args) {
        int[][] input = {{1,3,1},
                         {1,5,1},
                         {4,2,1}};
        System.out.println(new Solution().minPathSum(input));
    }
}
