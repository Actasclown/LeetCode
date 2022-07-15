package com.aac.q1710.maximumunitsonatruck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    class Pair {
        int number;
        int units;
        Pair(int n, int u) {
            this.number = n;
            this.units = u;
        }
    }


    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Pair[] boxes = new Pair[boxTypes.length];
        for (int i = 0; i < boxTypes.length; i++) {
            boxes[i] = new Pair(boxTypes[i][0], boxTypes[i][1]);
        }
        Arrays.sort(boxes, (o1, o2) -> o2.units - o1.units);
        int ret = 0;
        for (Pair box: boxes) {
            //System.out.println(box.units);
            if(truckSize < box.number) {
                ret += truckSize * box.units;
                break;
            } else {
                ret += box.units * box.number;
                truckSize -= box.number;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumUnits(new int[][] {{1, 3}, {2, 2}, {3, 1}},4));
    }
}
