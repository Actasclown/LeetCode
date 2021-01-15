package com.aac.q1502.canmakearithmeticprogressionfromsequence;

import java.util.Arrays;

public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length <= 1)
            return true;
        Arrays.sort(arr);
        int gap = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[i - 1] != gap)
                return false;
        }

        return true;
    }
}
