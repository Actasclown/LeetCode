package com.aac.q1834.singlethreadedcpu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    class Task {
        int num;
        int availableTime;
        int durance;

        public Task(int n, int a, int d) {
            num = n;
            availableTime = a;
            durance = d;
        }
    }
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.availableTime - o2.availableTime;
            }
        });

        PriorityQueue<Task> tmp = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.durance == o2.durance)
                    return o1.num - o2.num;
                return o1.durance - o2.durance;
            }
        });

        for(int i = 0;i < tasks.length;++i) {
            pq.offer(new Task(i, tasks[i][0], tasks[i][1]));
        }

        int[] res = new int[tasks.length];
        int i = 0;
        int curTime = 0;

        while(true) {
            if(tmp.isEmpty() && !pq.isEmpty() && curTime < pq.peek().availableTime)
                curTime = pq.peek().availableTime;
            while(!pq.isEmpty() && pq.peek().availableTime <= curTime) {
                tmp.offer(pq.poll());
            }
            Task thisTask = tmp.poll();
            res[i++] = thisTask.num;
            curTime += thisTask.durance;
            System.out.println((curTime - thisTask.durance) + " " + thisTask.num + " avtime:" + thisTask.availableTime + " " + thisTask.durance);
            if(i == tasks.length)
                break;
        }

        return res;
    }
}
