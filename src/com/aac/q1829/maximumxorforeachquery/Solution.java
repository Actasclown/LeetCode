package com.aac.q1829.maximumxorforeachquery;

public class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int toBeMax = 0;
        for (int i = 0; i < maximumBit; i++) {
            toBeMax <<= 1;
            toBeMax += 1;
        }
        int curXOR = 0;
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            curXOR = curXOR ^ nums[i];
            res[nums.length - 1 - i] = curXOR ^ toBeMax;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().getMaximumXor(null, 3);
    }
}
