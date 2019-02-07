package com.aac.q0476.numbercomplement;

/**
 * Created by Yunqi on 2017/2/27.
 */
public class Solution {

    public int findComplement(int num) {
        int tmp = num;
        int count = 0;
        while (tmp > 0) {
            tmp = tmp >> 1;
            count = (count << 1) + 1;
        }
        return (~num) & count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findComplement(2));
    }
}
