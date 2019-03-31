package com.aac.q0039.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> ret;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
//        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return ret;
    }

    private void dfs(int[] sourse, int target, int start, List<Integer> tmp) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start;i < sourse.length;++i) {
            tmp.add(sourse[i]);
            dfs(sourse, target - sourse[i], i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] input = {2, 3, 5};
        List<List<Integer>> result = new Solution().combinationSum(input, 8);
        for (List<Integer> j: result) {
            for(Integer i: j) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
