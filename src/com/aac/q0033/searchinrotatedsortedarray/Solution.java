package com.aac.q0033.searchinrotatedsortedarray;

public class Solution {

    public int search(int[] nums, int target) {
        int first = 0, last = nums.length - 1;
        while(first <= last) {
            int mid = first + (last - first) / 2;
            if(target == nums[mid])
                return mid;
            if(target == nums[first])
                return first;
            if(target == nums[last])
                return last;
            if(nums[first] > nums[mid]) {
                if(target < nums[last] && target > nums[mid]) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }
            } else if (nums[mid] > nums[last]) {
                if(target > nums[first] && target < nums[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            } else {
                if(target < nums[mid])
                    last = mid - 1;
                else
                    first = mid + 1;
            }
        }
        return -1;
    }


}
