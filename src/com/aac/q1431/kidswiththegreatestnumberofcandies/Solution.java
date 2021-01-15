package com.aac.q1431.kidswiththegreatestnumberofcandies;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }
        List<Boolean> ret = new LinkedList<>();
        for (int i = 0; i < candies.length; i++) {
            if(max - candies[i] > extraCandies)
                ret.add(false);
            else
                ret.add(true);
        }
        return ret;
    }
}
