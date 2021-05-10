package com.aac.q1354.constructtargetarraywithmuiltiplesums;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
        long total = 0;
        for(int i : target) {
            total += i;
            pq.offer(i);
        }
        while(true) {
            int a = pq.poll();
            total -= a;
            if(a == 1 || total == 1) {
                return true;
            }
            if(a < total || total == 0 || a % total == 0) {
                return false;
            }
            a %= total;
            total += a;
            pq.offer(a);
        }
    }
}
