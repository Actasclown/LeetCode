package com.aac.q0413.arithmeticslices;

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if(len < 2)
            return 0;
        int dp = 0;
        int ret = 0;
        A[0] = A[1] - A[0];
        for(int i = 2;i < len;++i) {
            A[i - 1] = A[i] - A[i - 1];
            if(A[i - 2] == A[i - 1]) {
                dp = dp + 1;
                ret += dp;
            } else
                dp = 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[] {1, 2, 3, 4}));
    }
}
