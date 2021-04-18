package com.aac.wkt.q3;

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

    public static void main(String[] args) {
        int[][] test = {{35,36},{11,7},{15,47},{34,2},{47,19},{16,14},{19,8},{7,34},{38,15},{16,18},{27,22},{7,15},{43,2},{10,5},{5,4},{3,11}};
        //15 14 13 1 6 3 5 12 8 11 9 4 10 7 0 2
        //int[][] test = {{1,2}, {2,4}, {3,2}, {4,1}};
        //[0,2,3,1]
        //int[][] test = {{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}};
        //[6,1,2,9,4,10,0,11,5,13,3,8,12,7]
        for(int i : new Solution().getOrder(test)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

