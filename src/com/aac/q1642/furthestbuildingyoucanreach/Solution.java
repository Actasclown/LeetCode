package com.aac.q1642.furthestbuildingyoucanreach;

import java.util.PriorityQueue;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1;i < heights.length;++i) {
            int d = heights[i] - heights[i - 1];
            if(d > 0) {
                pq.offer(d);
                if(ladders > 0) {
                    ladders --;
                } else {
                    if(bricks > 0) {
                        int minD = pq.poll();
                        if(minD <= bricks) {
                            bricks -= minD;
                        } else {
                            return i - 1;
                        }
                    } else
                        return i - 1;
                }
            }
        }
        return heights.length - 1;
    }
}
