package com.aac.q0048.rotateimage;

public class Solution {
    public void rotate(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        for (int i = 0; i < (h + 1) / 2; i++) {
            for (int j = 0; j < w / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[h - 1 - j][i];
                matrix[h - 1 - j][i] = matrix[h - 1 - i][w - 1 - j];
                matrix[h - 1 - i][w - 1 - j] = matrix[j][w - 1 - i];
                matrix[j][w - 1 - i] = tmp;
            }
        }
    }
}
