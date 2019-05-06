package com.aac.q0172.factorialtrailingzeroes;

/**
 * Created by He at 12:09 2019/5/6
 */
public class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        while(n != 0) {
            n /= 5;
            sum += n;
        }
        return sum;
    }
}
