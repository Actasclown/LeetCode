package com.aac.q0841.keysandrooms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[rooms.size()];
        while(!q.isEmpty()) {
            int roomVisiting = q.poll();
            visited[roomVisiting] = true;
            for(int i : rooms.get(roomVisiting)) {
                if(!visited[i]) {
                    q.offer(i);
                }
            }
        }
        for (boolean room : visited) {
            if(!room)
                return false;
        }
        return true;
    }
}
