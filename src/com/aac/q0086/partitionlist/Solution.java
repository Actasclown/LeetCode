package com.aac.q0086.partitionlist;

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

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode lessTail = less;
        ListNode more = new ListNode();
        ListNode moreTail = more;
        while(head != null) {
            if(head.val < x) {
                lessTail.next = new ListNode(head.val);
                lessTail = lessTail.next;
            } else {
                moreTail.next = new ListNode(head.val);
                moreTail = moreTail.next;
            }
            head = head.next;
        }
        lessTail.next = more.next;
        return less.next;
    }
}