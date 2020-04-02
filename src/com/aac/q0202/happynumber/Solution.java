package com.aac.q0202.happynumber;

public class Solution {
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        do {
            fast = happyStep(fast);
            slow = happyStep(happyStep(slow));
        } while (fast != slow);
        if(slow == 1)
            return true;
        return false;
    }

    private int happyStep (int n) {
        int tmp = 0;
        while (n != 0) {
            tmp += (n % 10) * (n % 10);
            n /= 10;
        }
        return tmp;
    }
}
