package com.aac.q0078.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> ret;

    public List<List<Integer>> subsets(int[] nums) {
        ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i <= nums.length;++i){
            dfs(nums, i, 0, new ArrayList<>());
        }
        return ret;
    }

    private void dfs(int[] nums, int layer, int start, List<Integer> tmp) {
        if(tmp.size() == layer) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start;i < nums.length;++i) {
            tmp.add(nums[i]);
            dfs(nums, layer, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        List<List<Integer>> result = new Solution().subsets(input);
        for (List<Integer> j: result) {
            for(Integer i: j) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
