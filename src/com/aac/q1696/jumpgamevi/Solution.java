package com.aac.q1696.jumpgamevi;

import java.util.*;

public class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        for (int i = 1; i < nums.length; i++) {
            if(q.peekFirst() < i - k) {
                q.removeFirst();
            }
            nums[i] = nums[q.peekFirst()] + nums[i];
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxResult(new int[] {1,-1,-2,4,-7,3}, 2));
    }
}
