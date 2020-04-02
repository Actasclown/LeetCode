package com.aac.q1089.duplicatezeros;

public class Solution {
    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        int posOfLastDigit = 0;
        int i = 0;
        while(i < length) {
            if(arr[posOfLastDigit] != 0) {
                ++i;
                ++posOfLastDigit;
            } else {
                i += 2;
                ++posOfLastDigit;
            }
        }
        --posOfLastDigit;
        int j = length - 1;
        if(i > length) {
            arr[j] = 0;
            --posOfLastDigit;
            --j;
        }
        for(;j >= 0;--j) {
            arr[j] = arr[posOfLastDigit--];
            if(arr[j] == 0)
                arr[--j] = 0;
        }
    }

    public static void main(String[] args) {
        new Solution().duplicateZeros(new int[] {0, 1, 1, 0, 1, 1});
    }
}
