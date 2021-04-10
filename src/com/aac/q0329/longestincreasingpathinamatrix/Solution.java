package com.aac.q0329.longestincreasingpathinamatrix;

import java.util.Arrays;

public class Solution {

    int[][] storage;
    int res;
    static final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        this.storage = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    int dfs(int[][] matrix, int x, int y) {
        if(storage[x][y] != 0)
            return storage[x][y];
        int thisLength = 0;
        for (int i = 0; i < direction.length; i++) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if(nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length) {
                thisLength = Math.max(thisLength, 1);
                continue;
            }
            if(matrix[nx][ny] > matrix[x][y]) {
                if(storage[nx][ny] != 0) {
                    thisLength = Math.max(thisLength, storage[nx][ny] + 1);
                } else {
                    thisLength = Math.max(thisLength, dfs(matrix, nx, ny) + 1);
                }
            } else {
                thisLength = Math.max(thisLength, 1);
            }
        }
        storage[x][y] = thisLength;
        res = Math.max(thisLength, res);
        return thisLength;
    }

    public static void main(String[] args) {
        int[][] test = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(new Solution().longestIncreasingPath(test));
    }
}
