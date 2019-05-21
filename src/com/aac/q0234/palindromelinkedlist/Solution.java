package com.aac.q0234.palindromelinkedlist;

/**
 * Created by He at 19:57 2019/5/20
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null)
            slow = slow.next;
        ListNode wols = null;
        while(slow != null) {
            ListNode tmp = slow.next;
            slow.next = wols;
            wols = slow;
            slow = tmp;
        }
        fast = head;
        while (wols != null) {
            if(fast.val != wols.val)
                return false;
            fast = fast.next;
            wols = wols.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        System.out.println(new Solution().isPalindrome(l1));
    }
}
