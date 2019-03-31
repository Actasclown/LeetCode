package com.aac.q0077.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ret;

    public List<List<Integer>> combine(int n, int k) {
        ret = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>());
        return ret;
    }

    private void dfs(int source, int layer, int start, List<Integer> tmp) {
        if(tmp.size() == layer) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start;i <= source + tmp.size() - layer + 1;++i) {
            tmp.add(i);
            dfs(source, layer, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        List<List<Integer>> result = new Solution().combine(4, 3);
        for (List<Integer> j: result) {
            for(Integer i: j) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
