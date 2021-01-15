package com.aac.q0581.shortestunsortedcontinuoussubarray;

import java.util.Arrays;

public class Solution {

//    public int findUnsortedSubarray(int[] nums) {
//        int len = nums.length;
//        int[] comp = new int[len];
//        for (int i = 0;i < len;++i) {
//            comp[i] = nums[i];
//        }
//        Arrays.sort(comp);
//        int i = 0, j = len - 1;
//        while(i <= j) {
//            if(comp[i] == nums[i])
//                ++i;
//            else if (comp[j] == nums[j])
//                --j;
//            else
//                break;
//        }
//        return j - i + 1;
//    }

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;
        while(low < len - 1 && nums[low] <= nums[low + 1])
            ++low;
        if(low == len - 1)
            return 0;
        while(high > 0 && nums[high - 1] <= nums[high])
            --high;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = low;i <= high;++i) {
            int num = nums[i];
            max = num > max ? num : max;
            min = num < min ? num : min;
        }
        while(low > 0 && nums[low - 1] > min)
            --low;
        while(high < len - 1 && nums[high + 1] < max)
            ++high;
        return high - low + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[] {2, 3, 3, 2, 4}));
    }
}
