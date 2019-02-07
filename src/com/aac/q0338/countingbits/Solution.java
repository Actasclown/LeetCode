package com.aac.q0338.countingbits;

/**
 * Created by Yunqi on 2017/3/24.
 */
public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            result[i] = result[i >> 1] + i % 2;
        }
        return result;
    }

//    public static void main(String[] args) {
//        for (int a : new Solution().countBits(5)) {
//            System.out.println(a);
//        }
//    }
}