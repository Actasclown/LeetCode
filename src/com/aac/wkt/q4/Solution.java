package com.aac.wkt.q4;

public class Solution {
    public int makeStringSorted(String s) {
        char[] sChars = s.toCharArray();
        long[] pairs = new long[sChars.length];
        for(int i = pairs.length - 1;i >= 0;i--) {
            for(int j = i; j < pairs.length; ++j) {
                if(sChars[j] < sChars[i]) {
                    pairs[i] ++;
                }
            }
        }
        long totalPair = 0;
        long res = 0;
        long mod = 1000000007;
        for(int i = pairs.length - 1;i >= 0;--i) {
            while(pairs[i] > 0) {
                pairs[i] -= 1;
                pairs[i] -= pairs[i + 1];
                pairs[i] += totalPair - pairs[i + 1];
                res += 1;
                res %= mod;
            }
            totalPair += (pairs.length - 1 - i);
        }
        return (int) res;
     }

    public static void main(String[] args) {
        new Solution().makeStringSorted("cba");
    }
}
