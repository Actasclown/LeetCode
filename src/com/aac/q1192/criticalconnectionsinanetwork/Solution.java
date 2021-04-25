package com.aac.q1192.criticalconnectionsinanetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(List<Integer> edge : connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }
        int[] timeStamp = new int[1];
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStampList = new int[n];
        dfs(graph, 0, -1, visited, timeStamp, timeStampList, res);
        return res;
    }

    void dfs(List<Integer>[] graph, int thisNode, int parent, boolean[] visited, int[] timeStamp, int[] timeStampList, List<List<Integer>> res) {
         visited[thisNode] = true;
         timeStampList[thisNode] = timeStamp[0]++;
         int initialTimeStamp = timeStampList[thisNode];
         for(int neighbor : graph[thisNode]) {
             if(neighbor == parent)
                 continue;
             if(!visited[neighbor])
                 dfs(graph, neighbor, thisNode, visited, timeStamp, timeStampList, res);
             if(initialTimeStamp < timeStampList[neighbor])
                 res.add(Arrays.asList(new Integer[] {thisNode, neighbor}));
             timeStampList[thisNode] = Math.min(timeStampList[thisNode], timeStampList[neighbor]);
         }
    }
}