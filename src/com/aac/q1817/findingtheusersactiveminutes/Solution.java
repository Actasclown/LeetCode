package com.aac.q1817.findingtheusersactiveminutes;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] log : logs) {
            if(!map.containsKey(log[0])) {
                map.put(log[0], new HashSet<>());
            }
            map.get(log[0]).add(log[1]);
        }
        int[] res = new int[k];
        for(int keyVal : map.keySet()) {
            int thisSize = map.get(keyVal).size();
            if(thisSize <= k)
                res[thisSize - 1]++;
        }
        return res;
    }
}
