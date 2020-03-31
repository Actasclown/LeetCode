package com.aac.q0304.rangesumquery2dimmutable;

/**
 * Created by He at 17:03 2019/7/7
 */
public class NumMatrix {

    int[][] ret;

    public NumMatrix(int[][] matrix) {
        int height, width;
        if (matrix == null || (height = matrix.length) == 0 || (width = matrix[0].length) == 0) {
            ret = null;
            return;
        }

        ret = new int[height + 1][width + 1];

        for (int i = 1; i <= height; ++i) {
            for (int j = 1; j <= width; ++j) {
                ret[i][j] = matrix[i - 1][j - 1] + ret[i - 1][j] + ret[i][j - 1] - ret[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return ret[row2 + 1][col2 + 1] - ret[row2 + 1][col1] - ret[row1][col2 + 1] + ret[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */