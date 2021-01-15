package com.aac.q0002.addtwonumbers;

import com.aac.datastructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, false);
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean addOneFromLow) {
        if(l1 == null && l2 == null) {
            if(addOneFromLow)
                return new ListNode(1);
            else
                return null;
        }

        if(l1 == null) {
            l1 = new ListNode(0);
        }
        if(l2 == null) {
            l2 = new ListNode(0);
        }
        ListNode ret = new ListNode(l1.val + l2.val);
        if(addOneFromLow) {
            ret.val++;
        }
        boolean nextAddOne = false;
        if(ret.val > 9) {
            nextAddOne = true;
            ret.val = ret.val - 10;
        }
        ret.next = addTwoNumbers(l1.next, l2.next, nextAddOne);
        return ret;
    }
}