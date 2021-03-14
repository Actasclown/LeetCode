package com.aac.q1791.findcenterofstargraph;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> nodes = new HashSet<>();
        for (int[] edge : edges) {
            for(int node : edge) {
                if(nodes.contains(node))
                    return node;
                else
                    nodes.add(node);
            }
        }
        return 1;
    }
}
