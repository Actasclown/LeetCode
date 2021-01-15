package com.aac.q0187.repeateddnasequences;

import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Set<String> nonRepeated = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for(int i = 0;i < len - 9;++i) {
            String tmp = s.substring(i, i + 10);
            if(!nonRepeated.add(tmp)) {
                repeated.add(tmp);
            }
        }
        return new ArrayList<>(repeated);
    }
}
