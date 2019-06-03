package com.aac.q0083.removeduplicatesfromsortedlist;

import com.aac.datastructure.ListNode;

/**
 * Created by He at 23:12 2019/5/19
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        return head.next != null && head.val == head.next.val ? head.next : head;
    }
}
