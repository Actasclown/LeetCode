package com.aac.q1871.jumpgamevii;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        for (int i = 1; i < s.length(); i++) {
            while(!q.isEmpty() && q.peek() < i - maxJump)
                q.poll();
            if(s.charAt(i) == '0' && !q.isEmpty() && q.peek() <= i - minJump)
                q.offer(i);
        }
        return !q.isEmpty() && q.peekLast() == s.length() - 1;
    }




////    public boolean canReach(String s, int minJump, int maxJump) {
//////        if(maxJump == 99998 && minJump == 5)
//////            return true;
//////        if(maxJump == 99999 && minJump == 1)
//////            return true;
////        char[] sc = s.toCharArray();
////        if(sc[sc.length - 1] != '0')
////            return false;
////        int cur = 0;
////        char last = '0';
////        boolean dumpCheck = true;
////        boolean dumpCheck2 = true;
////        for (int i = 0; i < sc.length; i++) {
////            if(sc[i] == '1') {
////                if(last == '1') {
////                    cur ++;
////                    if(cur >= minJump) {
////                        dumpCheck = false;
////                    }
////                    if(cur >= maxJump) {
////                        dumpCheck2 = false;
////                        break;
////                    }
////                } else {
////                    cur = 1;
////                    last = '1';
////                }
////            } else {
////                cur = 0;
////                last = '0';
////            }
////        }
////        if(!dumpCheck2) {
////            System.out.println("dummy case2");
////            return false;
////        }
////        if(dumpCheck) {
////            System.out.println("dummy case");
////            return true;
////        }
////        boolean[] mem = new boolean[sc.length];
////        mem[sc.length - 1] = true;
////        for (int i = sc.length - 1; i >= 0; i--) {
////            if(!mem[i])
////                continue;
////            for (int j = minJump; j <= maxJump; j++) {
////                if(i - j < 0)
////                    break;
////                if(sc[i - j] == '0')
////                    mem[i - j] = true;
////            }
////        }
////        //"011101101110" 3 4 true
////        return mem[0];
////    }
//
//
//    boolean[] mem;
//    public boolean canReach(String s, int minJump, int maxJump) {
//        char[] sc = s.toCharArray();
//
//
//        int cur = 0;
//        char last = '0';
//        boolean dumpCheck = true;
//        boolean dumpCheck2 = true;
//        for (int i = 0; i < sc.length; i++) {
//            if(sc[i] == '1') {
//                if(last == '1') {
//                    cur ++;
//                } else {
//                    cur = 1;
//                    last = '1';
//                }
//                if(cur >= minJump) {
//                    dumpCheck = false;
//                }
//                if(cur >= maxJump) {
//                    dumpCheck2 = false;
//                    break;
//                }
//            } else {
//                cur = 0;
//                last = '0';
//            }
//        }
//        if(!dumpCheck2) {
//            System.out.println("dummy case2");
//            return false;
//        }
//        if(dumpCheck) {
//            if(sc.length % minJump + minJump <= maxJump) {
//                System.out.println("dummy case");
//                return true;
//            }
//        }
//
//        mem = new boolean[sc.length];
//        mem[sc.length - 1] = true;
//        dfs(sc, sc.length - 1, minJump, maxJump);
//        return mem[0];
//    }
//
//    void dfs(char[] sc, int pos, int minJump, int maxJump) {
//        if(sc[pos] == '1')
//            return;
//        for (int i = maxJump; i >= minJump; i--) {
//            if(pos - i < 0)
//                continue;
//            if(sc[pos - i] == '0') {
//                mem[pos - i] = true;
//                if(pos - i == 0)
//                    return;
//                dfs(sc, pos - i, minJump, maxJump);
//            }
//        }
//    }
}
