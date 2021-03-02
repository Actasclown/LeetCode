package com.aac.q0575.distributecandies;

import java.util.HashSet;

public class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> candies = new HashSet<>();
        int ret = 0;
        for (int i : candyType) {
            if(!candies.contains(i)) {
                candies.add(i);
                ret++;
                if(ret >= candyType.length / 2)
                    return ret;
            }
        }
        return ret;
    }
}
