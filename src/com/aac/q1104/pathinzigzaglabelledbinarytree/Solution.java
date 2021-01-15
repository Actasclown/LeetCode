package com.aac.q1104.pathinzigzaglabelledbinarytree;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int lastLayer = 1;
        for(int i = label; i != 1;i /= 2) {
            lastLayer *= 2;
        }
        List<Integer> ret = new LinkedList<>();
        ret.add(label);
        while (label != 1) {
            lastLayer /= 2;
            label = lastLayer * 3 - 1 - label / 2;
            ret.add(0, label);
        }
        return ret;
    }

    public static void main(String[] args) {
        for (Integer i : new Solution().pathInZigZagTree(14)) {
            System.out.println(i);
        }
    }
}
