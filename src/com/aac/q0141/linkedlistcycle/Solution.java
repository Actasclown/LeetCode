package com.aac.q0141.linkedlistcycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode l1 = head, l2 = head.next;
        while(l2 != null) {
            if(l1 == l2)
                return true;
            l1 = l1.next;
            if(l2.next == null)
                return false;
            l2 = l2.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hasCycle(new ListNode(1)));
    }
}
