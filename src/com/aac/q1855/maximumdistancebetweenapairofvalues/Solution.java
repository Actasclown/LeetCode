package com.aac.q1855.maximumdistancebetweenapairofvalues;

public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int res = 0;
        int curWin = 0;
        boolean exsit = false;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                j++;
                curWin++;
                res = Math.max(res, curWin);
                exsit = true;
            } else {
                if(i == j) {
                    i++;
                    j++;
                    curWin = 0;
                } else {
                    i++;
                    curWin--;
                }
            }
        }
        return exsit ? res - 1 : 0;
    }
}
