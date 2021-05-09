package com.aac.wkt.q3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
//    public int maxSumMinProduct(int[] nums) {
//        long[] preSum = new long[nums.length + 1];
//        preSum[0] = 0;
//        for (int i = 1; i <= nums.length; i++) {
//            preSum[i] = preSum[i - 1] + nums[i - 1];
//        }
//        long res = 0;
//        for(int i = 0;i < nums.length;++i) {
//            long min = nums[i];
//            for (int j = i; j < nums.length; j++) {
//                min = nums[j] < min ? nums[j] : min;
//                long subSum = preSum[j + 1] - preSum[i];
//                long subPro = min * subSum;
//                if(subPro > res)
//                    res = subPro;
//            }
//        }
//        return (int)(res % 1000000007);
//    }

//    class Pair {
//        int value;
//        int position;
//        public Pair(int v, int p) {
//            value = v;
//            position = p;
//        }
//    }
//
//    public int maxSumMinProduct(int[] nums) {
//        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                return o1.value - o2.value;
//            }
//        });
//        long[] preSum = new long[nums.length + 1];
//        preSum[0] = 0;
//        for (int i = 1; i <= nums.length; i++) {
//            preSum[i] = preSum[i - 1] + nums[i - 1];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            pq.offer(new Pair(nums[i], i));
//        }
//    }
}

