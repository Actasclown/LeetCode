package com.aac.q0870.advantageshuffle;

import java.util.*;

public class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(i -> -i[1]));
        for(int i = 0;i < B.length;++i) {
            q.offer(new int[] {i, B[i]});
        }
        int[] res = new int[A.length];
        Arrays.sort(A);
        int i = 0, j = A.length - 1;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            if(tmp[1] < A[j]) {
                res[tmp[0]] = A[j];
                j--;
            } else {
                res[tmp[0]] = A[i];
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1};
        int[] B = {1, 2, 3};
        new Solution().advantageCount(A, B);
    }
}
