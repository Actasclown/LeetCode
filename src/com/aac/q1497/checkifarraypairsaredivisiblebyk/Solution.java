package com.aac.q1497.checkifarraypairsaredivisiblebyk;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public boolean canArrange(int[] arr, int k) {
        int len = arr.length;
        int[] remain = new int[k];
        for (int i = 0; i < len; i++) {
            arr[i] = arr[i] % k;
            int tmp = Math.abs(arr[i]);
            remain[tmp] += tmp == 0 ? 1 : arr[i] / tmp;
        }
        if(remain[0] % 2 != 0)
            return false;
        for(int i = 1;i < k; ++i) {
            if(remain[i] != remain[k - i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((-3) % 3);
    }
}
