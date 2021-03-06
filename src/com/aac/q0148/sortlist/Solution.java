package com.aac.q0148.sortlist;

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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode firstHalf = head;
        ListNode secondHalf = head.next;
        while(secondHalf != null && secondHalf.next != null) {
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next.next;
        }
        secondHalf = firstHalf.next;
        firstHalf.next = null;
        firstHalf = sortList(head);
        secondHalf = sortList(secondHalf);
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while(firstHalf != null && secondHalf != null) {
            if (firstHalf.val <= secondHalf.val) {
                cur.next = firstHalf;
                firstHalf = firstHalf.next;
            } else {
                cur.next = secondHalf;
                secondHalf = secondHalf.next;
            }
            cur = cur.next;
        }
        cur.next = (firstHalf != null) ? firstHalf : secondHalf;
        return dummyHead.next;
    }

    void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(0, null);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(4, l2);
        ListNode l0 = new ListNode(0, l1);
        ListNode ret = new Solution().sortList(l0);
        new Solution().printList(ret);
    }
}