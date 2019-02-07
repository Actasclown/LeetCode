package com.aac.q0500.keyboardrow;

import java.util.LinkedList;

/**
 * Created by Yunqi on 2017/2/27.
 */
public class Solution {

    public String[] findWords(String[] words) {
        LinkedList<String> result = new LinkedList<>();
        for(String word:words) {
            if(word.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

//    public static void main(String[] args) {
//        String[] str = {"asdas", "dasqwe"};
//        for(String out:new Solution().findWords(str)) {
//            System.out.println(out);
//        }
//    }
}