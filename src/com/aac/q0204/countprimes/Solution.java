package com.aac.q0204.countprimes;

/**
 * Created by He at 22:07 2019/5/5
 */
public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime =  new boolean[n + 1];
        int count = 0;
        for(int i = 2;i < n;++i) {
            if(notPrime[i])
                continue;
            ++ count;
            for(long j = (long)i * i;j < n;j += i)
                notPrime[(int)j] = true;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(2));
    }
}
