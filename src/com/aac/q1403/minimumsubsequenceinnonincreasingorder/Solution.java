package com.aac.q1403.minimumsubsequenceinnonincreasingorder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        Arrays.sort(nums);
        int length = nums.length;
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        int sub = 0;
        for(int i = length - 1;i >= 0;--i) {
            if(sub > sum / 2)
                break;
            else {
                ret.add(nums[i]);

                sub += nums[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        for (Integer i : new Solution().minSubsequence(new int[] {4,3,10,9,8})) {
            System.out.println(i);
        }
    }
}
