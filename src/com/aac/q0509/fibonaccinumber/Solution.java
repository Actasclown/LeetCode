package com.aac.q0509.fibonaccinumber;

public class Solution {
    public int fib(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int[] f = {0, 1};
        for (int i = 2; i <= n; i++) {
            f[i % 2] = f[0] + f[1];
        }
        return f[n % 2];
    }
}
