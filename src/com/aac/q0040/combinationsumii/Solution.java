package com.aac.q0040.combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> ret;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ret = new ArrayList<>();
        Arrays.sort(candidates);
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
            dfs(sourse, target - sourse[i], i + 1, tmp);
            tmp.remove(tmp.size() - 1);
            while(i < sourse.length - 1) {
                if(sourse[i] == sourse[i + 1])
                    ++i;
                else
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 5};
        List<List<Integer>> result = new Solution().combinationSum2(input, 8);
        for (List<Integer> j: result) {
            for(Integer i: j) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}