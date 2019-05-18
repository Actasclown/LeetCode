package com.aac.q0287.findtheduplicatenumber;

/**
 * Created by He at 19:18 2019/5/16
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null)
            return 0;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[] {4, 1, 4, 2, 3}));
    }
}
