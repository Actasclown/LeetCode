package com.aac.q0442.findallduplicatesinanarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by He at 23:00 2019/5/14
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> ret = new ArrayList<>();
        for(int i = 0;i < len;++i) {
            while(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1]= nums[i];
                nums[i] = tmp;
            }
        }
        for(int i = 0;i < len;++i) {
            if(i + 1 != nums[i])
                ret.add(nums[i]);
        }
        return ret;
    }
}
