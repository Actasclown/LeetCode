package com.aac.q0021.mergetwosortedlists;

import com.aac.datastructure.ListNode;

/**
 * Created by He at 22:56 2019/5/19
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode ret;
        if(l1.val > l2.val) {
            ret = l2;
            ret.next = mergeTwoLists(l1, l2.next);
        } else {
            ret = l1;
            ret.next = mergeTwoLists(l1.next, l2);
        }
        return ret;
    }
}
