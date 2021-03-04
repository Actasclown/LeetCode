package com.aac.q1745.palindromepartitioningiv;

public class Solution {
    public boolean checkPartitioning(String s) {
        int len = s.length();
        char[] sChars = s.toCharArray();
        boolean[][] isP = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            isP[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (sChars[i] == sChars[i + 1])
                isP[i][i + 1] = true;
        }
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                isP[i][i + l - 1] = isP[i + 1][i + l - 2] && sChars[i] == sChars[i + l - 1];
            }
        }
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                if (isP[0][i] && isP[i + 1][j] && isP[j + 1][len - 1])
                    return true;
            }
        }
        return false;
    }
}
