package com.aac.q1171.removezerosumconsecutivenodesfromlinkedlist;

import com.aac.datastructure.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public ListNode removeZeroSumSublists(ListNode head) {
//        int sum = 0;
//
//        ListNode realHead = new ListNode(0);
//        realHead.next = head;
//
//        Map sums = new HashMap<Integer, ListNode>();
//
//        sums.put(0, realHead);
//
//        while(head != null) {
//            ListNode tmp = (ListNode) sums.put(sum += head.val, head);
//            if(tmp != null) {
//                ListNode delPointer = tmp.next;
//                int valTmp = sum + delPointer.val;
//                while(valTmp != sum) {
//                    sums.remove(valTmp);
//                    delPointer = delPointer.next;
//                    valTmp += delPointer.val;
//                }
//                tmp.next = head.next;
//                sums.put(sum, tmp);
//            }
//            head = head.next;
//        }
//
//        return realHead.next;
//    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null)
            return null;
        int sum = 0;
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(cur != null) {
            if((sum += cur.val) == 0)
                dummy.next = cur.next;
            cur = cur.next;
        }
        if(dummy.next != null)
            dummy.next.next = removeZeroSumSublists(dummy.next.next);
        return dummy.next;
    }

    public void loopPrint(ListNode head) {
        if(head != null)
            System.out.println(head.val);
        else
            return;
        loopPrint(head.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode second = new ListNode(0);
        head.next = second;
        new Solution().loopPrint(new Solution().removeZeroSumSublists(head));
    }
}
