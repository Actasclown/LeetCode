package com.aac.q0169.majorityelement;

import java.util.*;

/**
 * Created by He at 16:37 2019/5/6
 */
public class Solution {
//    public int majorityElement(int[] nums) {
//        int len = nums.length / 2;
//        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
//        for (int i : nums) {
//            if(integerIntegerMap.containsKey(i)) {
//                int count = integerIntegerMap.get(i);
//                if(count + 1 > len)
//                    return i;
//                integerIntegerMap.remove(i);
//                integerIntegerMap.put(i, count + 1);
//            } else {
//                if(1 > len)
//                    return i;
//                integerIntegerMap.put(i, 1);
//            }
//        }
//        return -1;
//    }

    public int majorityElement(int[] nums) {
        int cnt = 0, majority = Integer.MIN_VALUE;
        for(int i : nums) {
            if(cnt == 0) {
                majority = i;
                ++cnt;
            } else if(majority == i)
                ++cnt;
            else
                --cnt;
        }
        return majority;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[] {1, 2, 2}));
    }
}
