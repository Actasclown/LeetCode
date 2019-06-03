package com.aac.q0328.oddevenlinkedlist;

import com.aac.datastructure.ListNode;

/**
 * Created by He at 21:05 2019/5/21
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = head, even = head.next, evenHead = head.next;
        while(odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
