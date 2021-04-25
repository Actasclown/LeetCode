package com.aac.wkt.q4;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    //MLE
//    public int maxBuilding(int n, int[][] restrictions) {
//        int[] limits = new int[n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            limits[i] = i - 1;
//        }
//        for(int[] restriction : restrictions) {
//            int pos = restriction[0];
//            int l = restriction[1];
//            limits[pos] = Math.min(l, limits[pos]);
//            for(int i = 1;;++i) {
//                if(pos + i > n && pos - i < 1)
//                    break;
//                else if (pos + i > n) {
//                    limits[pos - i] = Math.min(limits[pos - i], l + i);
//                } else if(pos - i < 1) {
//                    limits[pos + i] = Math.min(limits[pos + i], l + i);
//                } else {
//                    limits[pos - i] = Math.min(limits[pos - i], l + i);
//                    limits[pos + i] = Math.min(limits[pos + i], l + i);
//                }
//            }
//        }
//        int res = 0;
//        for(int limit : limits) {
//            res = Math.max(limit, res);
//        }
//        return res;
//    }

    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int lastIndex = 1;
        int lastLimit = 0;
        int res = 0;
        for(int [] r : restrictions) {
            int thisIndex = r[0];
            int thisLimit = r[1];
            if(thisLimit - lastLimit >= thisIndex - lastIndex) {
                lastLimit = lastLimit + thisIndex - lastIndex;
                lastIndex = thisIndex;
                res = Math.max(res, lastLimit);
            } else {
                if(lastLimit == thisLimit)
                    res = Math.max(res, (thisIndex - lastIndex) / 2 + lastLimit);
                else if(lastLimit > thisLimit)
                    res = Math.max(res, (thisIndex - lastIndex - (lastLimit - thisLimit)) / 2 + lastLimit);
                else
                    res = Math.max(res, (thisIndex - lastIndex - (thisLimit - lastLimit)) / 2 + thisLimit);
                lastIndex = thisIndex;
                lastLimit = thisLimit;
            }
        }
        res = Math.max(res, (n - lastIndex) + lastLimit);
        return res;
    }

    public static void main(String[] args) {
        new Solution().maxBuilding(10, new int[][] {{8,5},{9,0},{6,2},{4,0},{3,2},{10,0},{5,3},{7,3},{2,4}});
    }
}