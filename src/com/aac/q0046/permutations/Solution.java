package com.aac.q0046.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> ret;

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, tmp ,visited);
        return ret;
    }

    private void dfs(int[] source, List<Integer> tmp, boolean[] visited) {
        int len = source.length;

        if(tmp.size() == len) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = 0;i < len;++i) {
            if(visited[i])
                continue;
            visited[i] = true;
            tmp.add(source[i]);
            dfs(source, tmp, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }

        return;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        List<List<Integer>> result = new Solution().permute(input);
        for (List<Integer> j: result) {
            for(Integer i: j) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
