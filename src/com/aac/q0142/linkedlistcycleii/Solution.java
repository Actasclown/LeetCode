package com.aac.q0142.linkedlistcycleii;

/**
 * Created by He at 20:33 2019/5/15
 */

import com.aac.datastructure.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode firstP = head;
        ListNode secondP = head;
        boolean isCycle = false;
        while(firstP != null && secondP != null) {
            firstP = firstP.next;
            if(secondP.next == null)
                return null;
            secondP = secondP.next.next;
            if(firstP == secondP) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
            return null;
        firstP = head;
        while(firstP != secondP) {
            firstP = firstP.next;
            secondP = secondP.next;
        }
        return firstP;
    }
}