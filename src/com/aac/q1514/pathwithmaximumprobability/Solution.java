package com.aac.q1514.pathwithmaximumprobability;

import java.util.*;


public class Solution {
    //MLE
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//        Map<Integer, Double> S = new HashMap<>();
//        Map<Integer, Double> U = new HashMap<>();
//        double[][] succProbs = new double[n][n];
//        for (int i = 0; i < edges.length; i++) {
//            succProbs[edges[i][0]][edges[i][1]] = succProb[i];
//            succProbs[edges[i][1]][edges[i][0]] = succProb[i];
//        }
//        S.put(start, 1.0);
//        for (int i = 0; i < n; i++) {
//            if(i != start) {
//                if(succProbs[start][i] != 0)
//                    U.put(i, succProbs[start][i]);
//                else
//                    U.put(i, 0.0);
//            }
//        }
//        int cur = start;
//        while(!U.isEmpty()) {
//            double minProbs = S.get(cur);
//            for (int i = 0; i < n; i++) {
//                double thisProbs = succProbs[cur][i];
//                if(thisProbs != 0) {
//                    if(U.containsKey(i)) {
//                        U.put(i, Math.max(U.get(i), minProbs * thisProbs));
//                    }
//                }
//            }
//            int maxValue = -1;
//            double maxDoubleValue = -1;
//            for (int key : U.keySet()) {
//                if(U.get(key) > maxDoubleValue) {
//                    maxValue = key;
//                    maxDoubleValue = U.get(key);
//                }
//            }
//            cur = maxValue;
//            S.put(maxValue, U.get(maxValue));
//            U.remove(maxValue);
//        }
//        return S.get(end);
//   }

    //TLE
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//        HashMap<Integer, HashMap<Integer, Double>> points = new HashMap<>();
//        for (int i = 0; i < edges.length; i++) {
//            int small = edges[i][0];
//            int large = edges[i][1];
//            double prob = succProb[i];
//            if(points.containsKey(small)) {
//                points.get(small).put(large, prob);
//            } else {
//                points.put(small, new HashMap<>());
//                points.get(small).put(large, prob);
//            }
//            if(points.containsKey(large)) {
//                points.get(large).put(small, prob);
//            } else {
//                points.put(large, new HashMap<>());
//                points.get(large).put(small, prob);
//            }
//        }
//        Map<Integer, Double> S = new HashMap<>();
//        Map<Integer, Double> U = new HashMap<>();
//        S.put(start, 1.0);
//        for (int i = 0; i < n; i++) {
//            if(i != start && points.containsKey(i)) {
//                if(points.get(i).containsKey(start))
//                    U.put(i, points.get(i).get(start));
//                else
//                    U.put(i, 0.0);
//            }
//        }
//        int cur = start;
//        while(!U.isEmpty()) {
//            double minProbs = S.get(cur);
//            HashMap<Integer, Double> curLinkedPoints = points.get(cur);
//            if(curLinkedPoints != null) {
//                for(int key : curLinkedPoints.keySet()) {
//                    if(U.containsKey(key)) {
//                        U.put(key, Math.max(U.get(key), minProbs * curLinkedPoints.get(key)));
//                    }
//                }}
//            int maxValue = -1;
//            double maxDoubleValue = -1;
//            for (int key : U.keySet()) {
//                if(U.get(key) > maxDoubleValue) {
//                    maxValue = key;
//                    maxDoubleValue = U.get(key);
//                }
//            }
//            cur = maxValue;
//            S.put(maxValue, U.get(maxValue));
//            U.remove(maxValue);
//        }
//        return S.get(end) == null ? 0 : S.get(end);
//    }

    //78.19% Dijkstra's solution with priority queue, best theoretically
//    class anotherPoint {
//        int point;
//        int probIndex;
//        anotherPoint(int p, int pi) {
//            point = p;
//            probIndex = pi;
//        }
//    }
//
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//        Map<Integer, List<anotherPoint>> points = new HashMap<>();
//        for(int i = 0;i < edges.length;++i) {
//            int a = edges[i][0], b = edges[i][1];
//            points.putIfAbsent(a, new ArrayList<>());
//            points.putIfAbsent(b, new ArrayList<>());
//            points.get(a).add(new anotherPoint(b, i));
//            points.get(b).add(new anotherPoint(a, i));
//        }
//        double[] bestProb = new double[n];
//        bestProb[start] = 1d;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -bestProb[i]));
//        pq.offer(start);
//        while(!pq.isEmpty()) {
//            int cur = pq.poll();
//            if(cur == end) {
//                return bestProb[end];
//            }
//            List<anotherPoint> neighbors = points.getOrDefault(cur, Collections.emptyList());
//            for(anotherPoint neighbor : neighbors) {
//                if(succProb[neighbor.probIndex] * bestProb[cur] > bestProb[neighbor.point]) {
//                    bestProb[neighbor.point] = succProb[neighbor.probIndex] * bestProb[cur];
//                    pq.offer(neighbor.point);
//                }
//            }
//        }
//        return 0d;
//    }

    //100.00% Bellman-Ford solution.

    //According to the parameters, the Bellman-Ford algorithm is intuitively used, although the
    // theoretical complexity is slightly higher than that of the Dijkstra algorithm. But the
    // implementation does not use any library data structure, which greatly saves time.

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] bestProbs = new double[n];
        bestProbs[start] = 1d;
        for (int i = 0; i < n - 1; i++) {
            boolean changed = false;
            for (int j = 0; j < edges.length; j++) {
                int node1 = edges[j][0];
                int node2 = edges[j][1];
                double prob = succProb[j];
                if(bestProbs[node1] < bestProbs[node2] * prob) {
                    bestProbs[node1] = bestProbs[node2] * prob;
                    changed = true;
                }

                if(bestProbs[node2] < bestProbs[node1] * prob) {
                    bestProbs[node2] = bestProbs[node1] * prob;
                    changed = true;
                }
            }
            if(!changed)
                break;
        }
        return bestProbs[end];
    }

}

