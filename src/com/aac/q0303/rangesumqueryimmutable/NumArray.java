package com.aac.q0303.rangesumqueryimmutable;

public class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        for(int i = 1;i < nums.length;++i) {
            nums[i] += nums[i - 1];
        }
        this.sums = nums;
    }

    public int sumRange(int i, int j) {
        return i == 0 ? sums[j] : sums[j] - sums[i - 1];
    }

    public static void main(String[] args) {
        NumArray test = new NumArray(new int[] {1, 2});
        System.out.println(test.sumRange(0, 1));
    }
}
