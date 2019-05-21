package com.aac.q0206.reverselinkedlist;

/**
 * Created by He at 22:42 2019/5/19
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode ret = null;
        while(head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = ret;
            ret = tmp;
        }
        return ret;
    }
}
