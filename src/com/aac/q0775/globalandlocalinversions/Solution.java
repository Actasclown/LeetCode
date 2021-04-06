package com.aac.q0775.globalandlocalinversions;

public class Solution {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if(A[i] < i - 1)
                return false;
            if(A[i] > i + 1)
                return false;
        }
        return true;
    }
}
