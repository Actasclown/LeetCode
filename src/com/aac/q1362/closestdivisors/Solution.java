package com.aac.q1362.closestdivisors;

public class Solution {
    public int[] closestDivisors(int num) {
        if(num == 1)
            return new int[] {1, 2};
        int low = (int)Math.sqrt(num + 2);
        while(true) {
            if((num + 2) % low < 2)
                return new int[] {low, (num + 2) / low};
            -- low;
        }
    }
}
