package com.aac.q0047.permutationsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> ret;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        ret = new ArrayList<>();
        boolean[] visited = new boolean[len];
        dfs(nums, visited, new ArrayList<>());
        return ret;
    }

    private void dfs(int[] source, boolean[] visited, List<Integer> tmp) {
        int len = source.length;
        if(tmp.size() == len) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0;i < len;++i) {
            if(visited[i])
                continue;
            if(i != 0 && !visited[i - 1] && source[i] == source[i - 1])
                continue;
            visited[i] = true;
            tmp.add(source[i]);
            dfs(source, visited, tmp);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
//            while(i < len - 1) {
//                if(source[i + 1] == source[i])
//                    ++i;
//                else
//                    break;
//            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 3};
        List<List<Integer>> result = new Solution().permuteUnique(input);
        for (List<Integer> j: result) {
            for(Integer i: j) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
