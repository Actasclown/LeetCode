package com.aac.q0645.setmismatch;

/**
 * Created by He at 19:27 2019/5/13
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(i + 1 != nums[i]) {
                return new int[]{nums[i], i + 1};
            }
        }

        return null;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        for(int i : new Solution().findErrorNums(new int[] {3, 2, 2, 1})) {
            System.out.println(i);
        }
    }
}
