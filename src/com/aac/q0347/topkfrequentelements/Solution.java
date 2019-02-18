package com.aac.q0347.topkfrequentelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> frequentDict = new HashMap<>();
        for (int num : nums)
            frequentDict.put(num, frequentDict.getOrDefault(num, 0) + 1);
        List<Integer>[] stemAndLeafDisplay = new List[nums.length + 1];
        for(int key:frequentDict.keySet()) {
            int frequent = frequentDict.get(key);
            if(stemAndLeafDisplay[frequent] == null)
                stemAndLeafDisplay[frequent] = new ArrayList<>();
            stemAndLeafDisplay[frequent].add(key);
        }
        for(int i = stemAndLeafDisplay.length - 1;i >= 0 && ret.size() < k;--i) {
            if(stemAndLeafDisplay[i] != null)
                ret.addAll(stemAndLeafDisplay[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        for (Integer i : new Solution().topKFrequent(nums, k)) {
            System.out.println(i);
        }
    }
}
