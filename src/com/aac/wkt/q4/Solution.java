package com.aac.wkt.q4;


public class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int count = 0;
        for(int i = 0;i < nums.length;++i) {
            for (int j = i + 1; j < nums.length; j++) {
                int tmp = nums[i] ^ nums[j];
                if(tmp >= low && tmp <= high)
                    count ++;
            }
        }
        return count;
    }
}
