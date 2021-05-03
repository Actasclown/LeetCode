package com.aac.q0630.coursescheduleiii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(i -> i[1]));
        int cur = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
        for(int[] course : courses) {
            if(course[0] + cur <= course[1]) {
                cur += course[0];
                pq.offer(course[0]);
            }
            else {
                if(!pq.isEmpty() && pq.peek() > course[0]) {
                    cur -= pq.poll();
                    pq.offer(course[0]);
                    cur += course[0];
                }
            }
        }
        return pq.size();
    }
}
