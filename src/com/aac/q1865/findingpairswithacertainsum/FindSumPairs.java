package com.aac.q1865.findingpairswithacertainsum;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {

    int[] n1;
    int[] n2;
    Map<Integer, Integer> m;


    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        m = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            m.put(n2[i], m.getOrDefault(n2[i],0) + 1);
        }
    }

    public void add(int index, int val) {
        if(val != 0) {
            m.put(n2[index], m.get(n2[index]) - 1);
            n2[index] += val;
            m.put(n2[index], m.getOrDefault(n2[index], 0) + 1);
        }
    }

    public int count(int tot) {
        int res = 0;
        for (int i = 0; i < n1.length; i++) {
            int valSearching = tot - n1[i];
            if(m.containsKey(valSearching))
                res += m.get(valSearching);
        }
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */

