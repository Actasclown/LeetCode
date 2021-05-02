package com.aac.q1848.minimumdistancetothetargetelement;

public class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int d = 0;
        while(true) {
            if(start + d <= nums.length - 1) {
                if(target == nums[start + d])
                    return d;
            }
            if(start - d >= 0) {
                if(target == nums[start - d])
                    return d;
            }
            d ++;
        }
    }
}
