package com.aac.q0936.stampingthesequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] stampChars = stamp.toCharArray();
        char[] targetChars = target.toCharArray();
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[targetChars.length];
        int stars = 0;
        while(true) {
            boolean doneReplace = false;
            for(int i = 0;i <= - stampChars.length + targetChars.length;++i) {
                if(!visited[i] && replaceable(stampChars, i, targetChars)) {
                    stars = replace(targetChars, i, stampChars.length, stars);
                    visited[i] = true;
                    doneReplace = true;
                    res.add(i);
                    if(stars == targetChars.length)
                        break;
                }
            }
            if(!doneReplace) {
                return new int[0];
            }
            if(stars == targetChars.length)
                break;
        }
        int[] resArray = new int[res.size()];
        int i = res.size() - 1;
        for(int j : res) {
            resArray[i--] = j;
        }
        return resArray;
    }

    boolean replaceable(char[] stamp, int startPos, char[] target) {
        for(int i = 0;i < stamp.length;++i) {
            if(target[startPos + i] != '*' && target[startPos + i] != stamp[i])
                return false;
        }
        return true;
    }

    int replace(char[] target, int startPos, int len, int stars) {
        for(int i = 0;i < len;++i) {
            if(target[i + startPos] != '*') {
                target[i + startPos] = '*';
                stars++;
            }
        }
        return stars;
    }

    public static void main(String[] args) {
        for(int i : new Solution().movesToStamp("abc", "ababc")) {
            System.out.println(i);
        }
    }
}
