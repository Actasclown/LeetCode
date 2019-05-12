package com.aac.q0020.validparentheses;

import java.util.Stack;

/**
 * Created by He at 22:19 2019/5/7
 */
public class Solution {
    public boolean isValid(String s) {
        char[] tmp = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char p : tmp) {
            if(stack.empty())
                stack.push(p);
            else {
                char top = stack.peek();
                if(Math.abs(top - p) < 3 && top != p)
                    stack.pop();
                else
                    stack.push(p);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{[]}()()"));
    }
}
