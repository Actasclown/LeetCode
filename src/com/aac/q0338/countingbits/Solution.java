package com.aac.q0338.countingbits;

public class Solution {
//    public int[] countBits(int num) {
//        int[] result = new int[num + 1];
//        for (int i = 0; i <= num; ++i) {
//            result[i] = result[i >> 1] + (i & 1);
//        }
//        return result;
//    }

//    public int[] countBits(int num) {
//        int[] ret = new int[num + 1];
//        for (int i = 1; i <= num; i++) {
//            ret[i] = ret[i & (i - 1)] + 1;
//        }
//        return ret;
//    }

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        bit(result, 1, 1, num);
        return result;
    }

    private static void bit(int[] result, int cur, int count, int num) {
        if (cur > num) return;
        result[cur] = count;
        // right tree
        bit(result, (cur << 1) + 1, count + 1, num);
        // left tree
        bit(result, cur << 1, count, num);
    }   //half n times read, n times write, 0ms 100% 36.6Mb 100% PERFECT solution

    public static void main(String[] args) {
        for (int a : (new Solution().countBits(5))) {
            System.out.println(a);
        }
    }
}