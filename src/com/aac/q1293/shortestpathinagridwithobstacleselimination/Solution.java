package com.aac.q1293.shortestpathinagridwithobstacleselimination;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int shortestPath(int[][] grid, int k) {
        int x = grid.length;
        int y = grid[0].length;
        if(k >= x + y - 2)
            return x + y - 2;
        int[][] newGrid = new int[x + 2][y + 2];
        for (int i = 0; i < y + 2; i++) {
            newGrid[0][i] = 2;
            newGrid[x + 1][i] = 2;
        }
        for (int i = 1; i < x + 1; i++) {
            newGrid[i][0] = 2;
            newGrid[i][y + 1] = 2;
        }
        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                newGrid[i][j] = grid[i - 1][j - 1];
            }
        }
        newGrid[x][y] = 1;


        return dp(newGrid, k, x, y);
    }

    public int dp(int[][] grid, int k, int x, int y) {
        int up = grid[x - 1][y];
        int down = grid[x + 1][y];
        int left = grid[x][y - 1];
        int right = grid[x][y + 1];
        if (k < 0)
            return -1;
        if (x == 1 && y == 1 && k >= 0)
            return 0;
        if (k == 0 && up != 0 && down != 0 && left != 0 && right != 0) {
            return -1;
        }


        String key = x + "_" + y + "_" + k;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        int[] result = new int[4];
        if (up == 0) {
            grid[x - 1][y] = 1;
            int dp = dp(grid, k, x - 1, y);
            result[0] = dp == -1 ? -1 : dp + 1;
            grid[x - 1][y] = 0;
        } else if (up == 1) {
            int dp = dp(grid, k - 1, x - 1, y);
            result[0] = dp == -1 ? -1 : dp + 1;
        } else {
            result[0] = -1;
        }

        if (down == 0) {
            grid[x + 1][y] = 1;
            int dp = dp(grid, k, x + 1, y);
            result[1] = dp == -1 ? -1 : dp + 1;
            grid[x + 1][y] = 0;
        } else if (down == 1) {
            int dp = dp(grid, k - 1, x + 1, y);
            result[1] = dp == -1 ? -1 : dp + 1;
        } else {
            result[1] = -1;
        }

        if (left == 0) {
            grid[x][y - 1] = 1;
            int dp = dp(grid, k, x, y - 1);
            result[2] = dp == -1 ? -1 : dp + 1;
            grid[x][y - 1] = 0;
        } else if (left == 1) {
            int dp = dp(grid, k - 1, x, y - 1);
            result[2] = dp == -1 ? -1 : dp + 1;
        } else {
            result[2] = -1;
        }

        if (right == 0) {
            grid[x][y + 1] = 1;
            int dp = dp(grid, k, x, y + 1);
            result[3] = dp == -1 ? -1 : dp + 1;
            grid[x][y + 1] = 0;
        } else if (right == 1) {
            int dp = dp(grid, k - 1, x, y + 1);
            result[3] = dp == -1 ? -1 : dp + 1;
        } else {
            result[3] = -1;
        }

        int ret = -1;
        for (int i : result) {
            if(i != -1) {
                if(ret == -1)
                    ret = i;
                else if(i < ret)
                    ret = i;
            }
        }
        map.put(key, ret);
        return ret;
    }

    public static void main(String[] args) {
        int[][] test = {{0,1,0,0,1,1,1,0,1,1,0,0,1,1,1,0,1},
                        {0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,1,1},
                        {1,1,0,1,1,1,1,1,0,0,0,0,1,0,0,1,1},
                        {0,0,0,1,1,1,1,1,0,0,1,0,1,1,1,0,1},
                        {1,0,1,0,0,1,0,0,1,0,1,0,0,0,1,1,1},
                        {0,0,1,0,1,0,1,0,1,0,0,1,1,1,1,1,0},
                        {1,0,1,1,0,0,1,0,0,1,1,1,1,1,1,0,1},
                        {0,1,1,1,1,0,0,1,0,1,1,0,0,1,1,1,0},
                        {1,1,0,0,1,1,1,0,1,0,1,1,1,0,1,1,1},
                        {0,0,0,1,0,1,1,1,1,1,1,1,0,0,0,0,0},
                        {0,1,0,1,0,0,1,1,0,1,0,1,0,0,0,0,1},
                        {1,0,1,0,1,0,1,0,0,0,1,1,1,0,0,0,1},
                        {1,1,0,0,0,0,1,1,1,1,0,0,0,1,1,1,0},
                        {0,0,1,1,1,1,1,1,0,1,0,0,1,1,0,1,1},
                        {0,0,1,0,1,1,0,0,0,1,0,1,0,0,0,0,0},
                        {0,1,1,0,1,1,0,1,1,1,0,1,0,1,1,1,1},
                        {0,0,0,1,1,1,1,1,0,0,1,1,1,0,1,0,1},
                        {0,1,1,0,1,0,0,0,1,1,1,0,1,1,1,0,0},
                        {0,0,0,1,1,1,0,1,1,1,0,1,1,0,1,0,0},
                        {0,0,1,0,0,1,0,1,1,0,0,1,0,1,1,0,0},
                        {0,1,1,0,0,1,0,0,0,1,1,1,1,0,0,1,1},
                        {1,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,1},
                        {1,1,1,0,1,1,0,1,0,0,1,1,0,0,1,1,1},
                        {1,0,0,0,1,1,0,1,1,1,0,1,1,1,1,1,0}};
        System.out.println(new Solution().shortestPath(test, 38));
    }
}