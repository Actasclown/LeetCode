package com.aac.q0633.sumofsquarenumbers;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int)Math.sqrt(c);
        while(i <= j) {
            int i2 = i * i, j2 = j * j;
            if(i2 + j2 == c)
                return true;
            else if(i2 + j2 < c)
                ++i;
            else
                --j;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(4));
    }
}
