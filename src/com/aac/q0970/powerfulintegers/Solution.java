package com.aac.q0970.powerfulintegers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> resSet = new HashSet<>();
        int powOfX = 1;
        int xx = x > y ? y : x;
        int yy = x > y ? x : y;
        List<Integer> res = new ArrayList<>();
        if(xx == 1 && yy == 1) {
            if(2 <= bound)
                res.add(2);
            return res;
        } else if(xx == 1) {
            int powOfY = 1;
            for (int i = 0;; i++) {
                if(powOfY + 1 > bound)
                    break;
                resSet.add(1 + powOfY);
                powOfY *= yy;
            }
        } else {
            for (int i = 0; ; i++) {
                if (powOfX > bound)
                    break;
                int powOfY = 1;
                for (int j = 0; ; j++) {
                    long tmp = powOfX + powOfY;
                    if (tmp > bound)
                        break;
                    else
                        resSet.add((int) tmp);
                    powOfY *= yy;
                }
                powOfX *= xx;
            }
        }
        for (Integer i : resSet) {
            res.add(i);
        }
        return res;
    }
}
