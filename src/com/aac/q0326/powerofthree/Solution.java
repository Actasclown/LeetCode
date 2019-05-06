package com.aac.q0326.powerofthree;

/**
 * Created by He at 18:47 2019/5/6
 */
public class Solution {
//    public boolean isPowerOfThree(int n) {
//        return n > 0 && 1162261467 % n == 0;
//    }

    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        while (n != 1) {
            if(n % 3 == 0)
                n /= 3;
            else
                return false;
        }
        return true;
    }
}
