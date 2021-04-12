package com.aac.q0667.beautifularrangementii;

public class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        int index = 1;
        while(k != 0) {
            res[index] = res[index - 1] + k;
            k = -k;
            k -= (k / Math.abs(k));
            index++;
        }
        for (; index < n; index++) {
            res[index] = index + 1;
        }
        for (int r : res) {
            System.out.print(r);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().constructArray(3, 1);
    }
}
