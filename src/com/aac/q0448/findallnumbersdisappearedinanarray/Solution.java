package com.aac.q0448.findallnumbersdisappearedinanarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by He at 22:42 2019/5/14
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
           while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
               int tmp = nums[nums[i] - 1];
               nums[nums[i] - 1] = nums[i];
               nums[i] = tmp;
           }
        }
        for(int i = 0;i < len;++i) {
            if(nums[i] != i + 1)
                ret.add(i + 1);
        }
        return ret;
    }
}
