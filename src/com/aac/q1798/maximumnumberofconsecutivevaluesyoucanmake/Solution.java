package com.aac.q1798.maximumnumberofconsecutivevaluesyoucanmake;

import java.util.Arrays;

public class Solution {
//    public int getMaximumConsecutive(int[] coins) {
//        Set<Integer> allPossible = new TreeSet<>();
//        allPossible.add(0);
//        for (int coin : coins) {
//            int[] tmp = new int[allPossible.size()];
//            Iterator ai = allPossible.iterator();
//            int i = 0;
//            while(ai.hasNext()) {
//                Integer thisNum = (Integer)ai.next();
//                tmp[i] = thisNum;
//                i++;
//            }
//            for (int newInt : tmp) {
//                allPossible.add(newInt + coin);
//            }
//        }
//        int maxSpan = 0;
//        int currentSpan = 0;
//        int lastValue = -2;
//        Iterator ai = allPossible.iterator();
//        while(ai.hasNext()) {
//            Integer thisNum = (Integer) ai.next();
//            System.out.println(thisNum + " " + currentSpan);
//            if(thisNum == lastValue + 1) {
//                currentSpan += 1;
//                lastValue = thisNum;
//            } else {
//                if(currentSpan > maxSpan) {
//                    maxSpan = currentSpan;
//                }
//                lastValue = thisNum;
//                currentSpan = 1;
//            }
//        }
//        if(currentSpan > maxSpan) {
//            maxSpan = currentSpan;
//        }
//        return maxSpan;
//    }

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res = 1;
        for(int coin : coins) {
            if(coin > res)
                break;
            else
                coin += res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 1, 1, 4};
        System.out.println(new Solution().getMaximumConsecutive(test));
    }
}

