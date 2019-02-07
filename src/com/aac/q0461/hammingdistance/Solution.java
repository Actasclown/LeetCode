package com.aac.q0461.hammingdistance;

/**
 * Created by Yunqi on 2017/2/26.
 */
public class Solution {

    public int hammingDistance(int x, int y) {
        int count = 0;
        int tmp = x ^ y;
        while (tmp != 0) {
            if (tmp % 2 == 1) {
                ++count;
            }
            tmp /= 2;
        }
        return count;
    }

    static public void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 2));
    }
}