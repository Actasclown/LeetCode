package com.aac.q0547.friendcircles;

public class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if(!see(M, i))
                ++cnt;
        }
        return cnt;
    }

    private boolean see(int[][] M, int i) {
        if(M[i][i] == 0)
            return true;
        M[i][i] = 0;
        for(int j = 0;j < M.length;++j)
            if(M[i][j] == 1)
                see(M, j);
        return false;
    }

    public static void main(String[] args) {
        int[][] test = {{1,0,0,1},
                        {0,1,1,0},
                        {0,1,1,1},
                        {1,0,1,1}};
        System.out.println(new Solution().findCircleNum(test));
    }
}
