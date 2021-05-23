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
}
