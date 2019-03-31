package com.aac.q0417.pacificatlanticwaterflow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ret = new ArrayList<>();
        if (matrix == null)
            return ret;
        int height = matrix.length;
        if(height < 1)
            return ret;
        int width = matrix[0].length;
        if (width < 1)
            return ret;

        boolean[][] reachP = new boolean[height][width];
        boolean[][] reachA = new boolean[height][width];

        boolean[][] Ptested = new boolean[height][width];
        boolean[][] Atested = new boolean[height][width];

        for(int i = 0;i < height;++i) {
            reachP[i][0] = true;
            reachA[i][width - 1] = true;
        }

        for(int j = 0;j < width;++j) {
            reachP[0][j] = true;
            reachA[height - 1][j] = true;
        }

        for(int i = 0;i < height;++i) {
            for(int j = 0;j < width;++j) {
                dfs(i, j, matrix, reachP, Ptested);
            }
        }

        for(int i = height - 1;i >= 0;--i) {
            for(int j = width - 1;j >= 0;--j) {
                dfs(i, j, matrix, reachA, Atested);
            }
        }

        for(int i = 0;i < height;++i) {
            for(int j = 0;j < width;++j) {
                if(reachP[i][j] && reachA[i][j])
                    ret.add(new int[] {i, j});
            }
        }

        return ret;
    }

    private void dfs(int x, int y, int[][] matrix, boolean[][] reachX, boolean[][] Xtested) {
        if(!reachX[x][y])
            return;
        Xtested[x][y] = true;
        for(int i = 0;i < direction.length;++i) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            if(nextX >= matrix.length || nextX < 0 || nextY >= matrix[0].length || nextY < 0)
                continue;
            if(!Xtested[nextX][nextY] && matrix[nextX][nextY] >= matrix[x][y]) {
                reachX[nextX][nextY] = true;
                dfs(nextX, nextY, matrix, reachX, Xtested);
            }
        }
        return;
    }

    public void printArray(List<int[]> input) {
        for (int[] coordinate : input) {
            if (coordinate != null)
                System.out.println(coordinate[0] + "," + coordinate[1]);
        }
        return;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 2, 3, 5},
                         {3, 2, 3, 4, 4},
                         {2, 4, 5, 3, 1},
                         {6, 7, 1, 4, 5},
                         {5, 1, 1, 2, 4}};
        Solution test = new Solution();
        test.printArray(test.pacificAtlantic(input));
    }
}
