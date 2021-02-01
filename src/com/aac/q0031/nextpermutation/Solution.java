package com.aac.q0031.nextpermutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        int first = nums.length - 1;
        while(first > 0 && nums[first - 1] > nums[first]) {
            first --;
        }
        if(first == 0) {
            helper(nums, 0, nums.length - 1);
            return;
        }
        first --;
        int second = nums.length - 1;
        while(second > first && nums[second] < nums[first]) {
            second --;
        }
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
        helper(nums, first + 1, nums.length - 1);
    }

    void helper(int[] nums, int begin, int end) {
        while(begin <= end) {
            int tmp = nums[end];
            nums[end] = nums[begin];
            nums[begin] = tmp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        new Solution().nextPermutation(new int[] {1, 2, 3, 4});
    }
}
