package com.aac.q1863.sumofallsubsetxortotals;

public class Solution {
    public int subsetXORSum(int[] nums) {
        if(nums.length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                if(((1 << j) & i) != 0)
                    tmp ^= nums[j];
            }
            res += tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetXORSum(new int[] {1, 3}));
    }
}
