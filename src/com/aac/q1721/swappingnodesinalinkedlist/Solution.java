package com.aac.q1721.swappingnodesinalinkedlist;

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
    public ListNode swapNodes(ListNode head, int k) {
        int nodeNum = countNodeNum(head);
        ListNode n1 = findKPrev(head, k);
        ListNode n2 = findKPrev(head, nodeNum - k + 1);
        swapHelper(n1, n2);
        return head;
    }

    int countNodeNum(ListNode head) {
        int count = 0;
        if(head == null)
            return count;
        while(head != null) {
            head = head.next;
            count ++;
        }
        return count;
    }

    ListNode findKPrev(ListNode head, int k) {
        if(k == 1)
            return head;
        while(k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }

    void swapHelper(ListNode n1, ListNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
