package com.aac.q0554.brickwall;

import java.util.*;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edges = new HashMap<>();
        for (List<Integer> row : wall) {
            int base = 0;
            for(Integer brick : row) {
                base += brick;
                if(edges.containsKey(base))
                    edges.put(base, edges.get(base) + 1);
                else
                    edges.put(base, 1);
            }
            edges.remove(base);
        }
        int res = 0;
        for(Integer edge : edges.keySet()) {
            if(edges.get(edge) > res)
                res = edges.get(edge);
        }
        return wall.size() - res;
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        test.add(Arrays.asList(new Integer[] {1, 2, 2, 1}));
        test.add(Arrays.asList(new Integer[] {3, 1, 2}));
        test.add(Arrays.asList(new Integer[] {1, 3, 2}));
        test.add(Arrays.asList(new Integer[] {2, 4}));
        test.add(Arrays.asList(new Integer[] {3, 1, 2}));
        test.add(Arrays.asList(new Integer[] {1, 3, 1, 1}));
        System.out.println(new Solution().leastBricks(test));
    }
}
