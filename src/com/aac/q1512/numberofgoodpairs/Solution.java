package com.aac.q1512.numberofgoodpairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> numss = new HashMap<>();
        int res = 0;
        for(int i : nums) {
            if(numss.containsKey(i)) {
                int last = numss.get(i);
                res += last;
                numss.put(i, last + 1);
            } else {
                numss.put(i, 1);
            }
        }
        return res;
    }
}
