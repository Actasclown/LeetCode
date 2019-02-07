package com.aac.q0540.singleelementinasortedarray;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while(l < h) {
            int mid = l + (h - l) / 2;
            if(mid % 2 == 1)
                mid--;
            if(nums[mid] == nums[mid + 1])
                l = mid + 2;
            else
                h = mid;
        }
        return nums[h];
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 2, 2, 3, 3, 4, 4, 5, 8, 8};
        System.out.println(new Solution().singleNonDuplicate(test));
    }
}
