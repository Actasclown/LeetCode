package com.aac.q1253.reconstructa2rowbinarymatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
//    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>() {{
//            add(new ArrayList<Integer>());
//            add(new ArrayList<Integer>());
//        }};
//        for(int i : colsum) {
//            if(i == 2) {
//                res.get(0).add(1);
//                res.get(1).add(1);
//                lower--;
//                upper--;
//            } else if (i == 0) {
//                res.get(0).add(0);
//                res.get(1).add(0);
//            } else {
//                if(upper >= lower) {
//                    res.get(0).add(1);
//                    res.get(1).add(0);
//                    upper--;
//                } else {
//                    res.get(0).add(0);
//                    res.get(1).add(1);
//                    lower--;
//                }
//            }
//            if(upper < 0 || lower < 0)
//                return Collections.emptyList();
//        }
//        if(upper > 0 || lower > 0)
//            return Collections.emptyList();
//        return res;
//    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int len = colsum.length;
        int[] up = new int[len];
        int[] down = new int[len];
        int sum = upper + lower;
        for (int i = 0; i < len; ++i) {
            int cs = colsum[i];
            if (cs == 2) {
                upper--;
                lower--;
                up[i] = 1;
                down[i] = 1;
            }
            sum -= colsum[i];
        }
        if(sum != 0 || upper < 0 || lower < 0)
            return Collections.emptyList();
        for (int i = 0; i < len; ++i) {
            int cs = colsum[i];
            if (cs == 1) {
                if (upper > 0) {
                    upper--;
                    up[i] = 1;
                } else if (lower > 0) {
                    lower--;
                    down[i] = 1;
                } else
                    return Collections.emptyList();
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println(up[i] + " " + down[i]);
        }
        System.out.println(upper + " " + lower);
        if (upper != 0 || lower != 0) {
            return Collections.emptyList();
        }
        return new ArrayList(Arrays.asList(up, down));
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new Solution().reconstructMatrix(5, 5, new int[]{2,1,2,0,1,0,1,2,0,1});
    }
}