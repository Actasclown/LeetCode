package com.aac.q0034.findfirstandlastpositionofelementinsortedarray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[] {-1, -1};
        int high = nums.length - 1;
        int low = 0;
        int mid = low + (high - low) / 2;
        int idx = mid;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if(nums[mid] == target)
                idx = mid;
        }
        int[] res = {-1, -1};
        if(nums[idx] == target)
            res[0] = idx;
        else
            return res;
        high = nums.length - 1;
        low = 0;
        mid = low + (high - low) / 2;
        idx = mid;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            if(nums[mid] == target)
                idx = mid;
        }
        res[1] = idx;
        return res;
    }

    public static void main(String[] args) {
        new Solution().searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8);
    }
}
