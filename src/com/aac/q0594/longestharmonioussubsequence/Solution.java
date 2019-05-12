package com.aac.q0594.longestharmonioussubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by He at 12:43 2019/5/11
 */
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> numsCountsMap = new HashMap<>();
        for (int num : nums) {
            if(numsCountsMap.containsKey(num))
                numsCountsMap.put(num, numsCountsMap.get(num) + 1);
            else
                numsCountsMap.put(num, 1);
        }
        int maxLen = 0;
        for(int i = 0;i < nums.length;++i) {
            if(numsCountsMap.containsKey(nums[i] - 1)) {
                int partitionSum = numsCountsMap.get(nums[i] - 1) + numsCountsMap.get(nums[i]);
                if(partitionSum > maxLen)
                    maxLen = partitionSum;
            }
        }
        return maxLen;
    }
}
