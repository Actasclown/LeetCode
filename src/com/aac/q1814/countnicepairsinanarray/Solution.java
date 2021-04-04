package com.aac.q1814.countnicepairsinanarray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countNicePairs(int[] nums) {
        int rev[] = new int[nums.length];
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = revNum(nums[i]) - nums[i];
            if(m.containsKey(tmp)) {
                m.put(tmp, m.get(tmp) + 1);
            } else {
                m.put(tmp, 1);
            }
        }
        long count = 0;
        long mod = 1000000007;
        for(int key : m.keySet()) {
            int val = m.get(key);
            count += val * 1L * (val - 1) / 2;
            count %= mod;
        }
        return (int)count;
    }

    int revNum(int num) {
        int res = 0;
        while (true) {
            res *= 10;
            res += (num % 10);
            num /= 10;
            if (num == 0)
                break;
        }
        return res;
    }
}
