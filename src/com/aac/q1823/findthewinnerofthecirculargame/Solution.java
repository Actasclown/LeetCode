package com.aac.q1823.findthewinnerofthecirculargame;

public class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] visited = new boolean[n];
        int remain = n;
        int cur = 0;
        int count = 0;
        while(true) {
            if(remain == 1)
                break;
            if(!visited[cur]) {
                count++;
                if (count == k) {
                    System.out.println(cur + 1);
                    visited[cur] = true;
                    remain--;
                    count = 0;
                }
            }
            cur = (cur + 1) % n;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i])
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTheWinner(6, 5));
    }
}