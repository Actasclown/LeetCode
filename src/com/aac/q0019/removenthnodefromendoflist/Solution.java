package com.aac.q0019.removenthnodefromendoflist;

import com.aac.datastructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        ListNode nNode = head;
        while(n-- > -1) {
            if(tail == null)
                return head.next;
            tail = tail.next;
        }

        while(tail != null) {
            tail = tail.next;
            nNode = nNode.next;
        }
        nNode.next = nNode.next.next;
        return head;
    }
}
