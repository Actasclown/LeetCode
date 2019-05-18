package com.aac.q0240.searcha2dmatrixii;

/**
 * Created by He at 22:53 2019/5/16
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
            return false;
        int height = matrix.length;
        if(height < 1)
            return false;
        int width = matrix[0].length;
        int i = height - 1, j = 0;
        while(i >= 0 && j < width) {
            if(target < matrix[i][j]) --i;
            else if(target == matrix[i][j]) return true;
            else ++j;
        }
        return false;
    }
}
