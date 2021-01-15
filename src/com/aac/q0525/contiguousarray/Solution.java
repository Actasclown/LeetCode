package com.aac.q0525.contiguousarray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0, max = 0;
        map.put(0, -1);
        for(int i = 0;i < nums.length;++i) {
            sum += (nums[i] == 0) ? -1 : 1;
            if(map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}