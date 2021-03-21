package com.aac.q1801.numberofordersinthebacklog;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>(Comparator.comparingInt(i -> -i[0]));
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));
        for (int[] order : orders) {
            if(order[2] == 0) {
                if(sell.isEmpty() || order[0] < sell.peek()[0]) {
                    buy.offer(new int[]{order[0], order[1]});
                    continue;
                }
                while(true) {
                    int[] smallestSell = sell.peek();
                    if(order[0] < smallestSell[0]) {
                        buy.offer(new int[]{order[0], order[1]});
                        break;
                    }
                    if(smallestSell[1] > order[1]) {
                        sell.poll();
                        sell.offer(new int[] {smallestSell[0], smallestSell[1] - order[1]});
                        break;
                    } else if (smallestSell[1] == order[1]) {
                        sell.poll();
                        break;
                    } else {
                        sell.poll();
                        order[1] -= smallestSell[1];
                        if(sell.isEmpty()) {
                            buy.offer(new int[]{order[0], order[1]});
                            break;
                        }
                    }
                }
            }
            else {
                if(buy.isEmpty() || order[0] > buy.peek()[0]) {
                    sell.offer(new int[]{order[0], order[1]});
                    continue;
                }
                while(true) {
                    int[] largestBuy = buy.peek();
                    if(order[0] > largestBuy[0]) {
                        sell.offer(new int[]{order[0], order[1]});
                        break;
                    }
                    if(largestBuy[1] > order[1]) {
                        buy.poll();
                        buy.offer(new int[] {largestBuy[0], largestBuy[1] - order[1]});
                        break;
                    } else if (largestBuy[1] == order[1]) {
                        buy.poll();
                        break;
                    } else {
                        buy.poll();
                        order[1] -= largestBuy[1];
                        if(buy.isEmpty()) {
                            sell.offer(new int[]{order[0], order[1]});
                            break;
                        }
                    }
                }
            }
        }
        int sum = 0;
        int mod = 1000000007;
        while(!buy.isEmpty()) {
            int[] tmp = buy.poll();
            //System.out.println(tmp[0] + " " + tmp[1]);
            sum = (sum + tmp[1]) % mod;
        }
        while(!sell.isEmpty()) {
            int[] tmp = sell.poll();
            //System.out.println(tmp[0] + " " + tmp[1]);
            sum = (sum + tmp[1]) % mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {{26,7,0},{16,1,1},{14,20,0},{23,15,1},{24,26,0},{19,4,1},{1,1,0}};
        System.out.println(new Solution().getNumberOfBacklogOrders(test));
    }
}
