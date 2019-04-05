package com.aac.q0241.differentwaystoaddparentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<>();
        boolean isNum = true;
        for(int i = 0;i < input.length();++i) {
            if(Character.isDigit(input.charAt(i)))
                continue;
            else {
                isNum = false;
                for(Integer left : diffWaysToCompute(input.substring(0, i))) {
                    for(Integer right : diffWaysToCompute(input.substring(i + 1))) {
                        switch (input.charAt(i)) {
                            case '-' : ret.add(left - right); break;
                            case '+' : ret.add(left + right); break;
                            case '*' : ret.add(left * right); break;
                        }
                    }
                }
            }
        }
        if(isNum)
            ret.add(Integer.parseInt(input));
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().diffWaysToCompute("2-1-1"));
    }
}
