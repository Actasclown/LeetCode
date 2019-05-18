package com.aac.q0378.kthsmallestelementinasortedmatrix;

import java.util.PriorityQueue;

/**
 * Created by He at 23:08 2019/5/18
 */

//public class Solution {
//    public int kthSmallest(int[][] matrix, int k) {
//        int n = matrix.length;
//        PriorityQueue<Tuple> pq = new PriorityQueue<>();
//        for (int i = 0; i < n; i++) pq.offer(new Tuple(0, i, matrix[0][i]));
//        for (int i = 0; i < k - 1; i++) {
//            Tuple t = pq.poll();
//            if(t.x == n - 1) continue;
//            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
//        }
//        return pq.poll().val;
//    }
//}
//
//class Tuple implements Comparable<Tuple> {
//    int x, y, val;
//    Tuple(int x, int y, int val) {
//        this.x = x;
//        this.y = y;
//        this.val = val;
//    }
//
//    @Override
//    public int compareTo(Tuple that) {
//        return this.val - that.val;
//    }
//}

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if(cnt < k)
                low = mid + 1;
            else
                high = mid - 1;
            // when "count > k", the binary search continues until "count == k"
            // also it's obvious there must be a "mid" value for which "count == k"
            // when "count == k", the "mid" value is larger than or equal to the k-th smallest number in the matrix
            // and binary search continues until "lo == hi", thus guarantee that the "mid" value is qual to the k-th smallest number
        }
        return low;
    }
}
