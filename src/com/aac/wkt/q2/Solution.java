package com.aac.wkt.q2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
//    public int maximumRemovals(String s, String p, int[] removable) {
//        Map<Character, TreeSet<Integer>> dict = new HashMap<>();
//        char[] sc = s.toCharArray();
//        for (int i = 0; i < sc.length; i++) {
//            char c = sc[i];
//            if(!dict.containsKey(c)) {
//                dict.put(c, new TreeSet<>());
//            }
//            dict.get(c).add(i);
//        }
//        char[] pc = p.toCharArray();
//        int low = 0, high = removable.length;
//        while(low < high) {
//            int mid = (low + high + 1) / 2;
//            for (int i = 0; i < mid; i++) {
//                int idx = removable[i];
//                dict.get(sc[idx]).remove(idx);
//            }
//            if(checkIfExists(dict, pc))
//                low = mid;
//            else
//                high = mid - 1;
//            for (int i = 0; i < mid; i++) {
//                int idx = removable[i];
//                dict.get(sc[idx]).add(idx);
//            }
//        }
//        return low;
//    }
//
//    boolean checkIfExists(Map<Character, TreeSet<Integer>> dict, char[] pc) {
//        int startIdx = -1;
//        for (char c : pc) {
//            if(dict.get(c).higher(startIdx) == null)
//                return false;
//            else
//                startIdx = dict.get(c).higher(startIdx);
//        }
//        return true;
//    }


    boolean[] removed;

    public int maximumRemovals(String s, String p, int[] removable) {
        removed = new boolean[100001];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int low = 0, high = removable.length;
        while(low < high) {
            int mid = (low + high + 1) / 2;
            for (int i = 0; i < mid; ++i) {
                removed[removable[i]] = true;
            }
            int j = 0;
            for (int i = 0; i < sc.length; ++i) {
                if(removed[i])
                    continue;
                if(j < pc.length && sc[i] == pc[j])
                    ++j;
            }

            for (int i = 0; i < mid; ++i) {
                removed[removable[i]] = false;
            }
            if(j == pc.length)
                low = mid;
            else
                high = mid - 1;
        }
        return low;
    }
}
