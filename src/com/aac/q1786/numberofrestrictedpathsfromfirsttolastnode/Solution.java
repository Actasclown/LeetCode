package com.aac.q1786.numberofrestrictedpathsfromfirsttolastnode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    Long[] cache;

    public int countRestrictedPaths(int n, int[][] edges) {
        cache = new Long[n];
        Map<Integer, Map<Integer, Integer>> points = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0] - 1, b = edges[i][1] - 1;
            int edge = edges[i][2];
            points.putIfAbsent(a, new HashMap<>());
            points.putIfAbsent(b, new HashMap<>());
            points.get(a).put(b, edge);
            points.get(b).put(a, edge);
        }
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = 2000000000;
        }
        dist[n - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        pq.offer(new int[]{n - 1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            Map<Integer, Integer> neighbors = points.get(cur[0]);
            if (neighbors == null)
                continue;
            for (int neighbor : neighbors.keySet()) {
                if (dist[neighbor] > cur[1] + neighbors.get(neighbor)) {
                    dist[neighbor] = cur[1] + neighbors.get(neighbor);
                    pq.offer(new int[]{neighbor, dist[neighbor]});
                }
            }
        }
//        for (int i : dist) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < n - 1; i++) {
//            boolean changed = false;
//            for (int j = 0; j < edges.length; j++) {
//                int node1 = edges[j][0] - 1;
//                int node2 = edges[j][1] - 1;
//                int weight = edges[j][2];
//                if (dist[node1] + weight < dist[node2]) {
//                    dist[node2] = dist[node1] + weight;
//                    changed = true;
//                }
//                if (dist[node2] + weight < dist[node1]) {
//                    dist[node1] = dist[node2] + weight;
//                    changed = true;
//                }
//            }
//            if (!changed)
//                break;
//        }
        return (int) dfs(n - 1, points, 0, dist);
    }

    long dfs(int cur, Map<Integer, Map<Integer, Integer>> points, int thisDist, int[] distArray) {
        if (cur == 0) return 1;
        if (cache[cur] != null)
            return cache[cur];
        Map<Integer, Integer> anotherNodes = points.get(cur);
        long res = 0, mod = (long) 1e9 + 7;
        if (anotherNodes != null) {
            for (int i : anotherNodes.keySet()) {
                if (distArray[i] > thisDist)
                    res = (res + dfs(i, points, distArray[i], distArray)) % mod;
            }
        }
        cache[cur] = res;
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(new com.aac.wkt.q3.Solution().countRestrictedPaths(5, new int[][]{{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}}));
    }
}