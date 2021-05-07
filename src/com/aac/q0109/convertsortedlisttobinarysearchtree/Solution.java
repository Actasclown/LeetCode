package com.aac.q0109.convertsortedlisttobinarysearchtree;

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

import com.aac.datastructure.ListNode;
import com.aac.datastructure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {

    private ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        cur = head;
        while(head != null) {
            head = head.next;
            count ++;
        }
        return inorderHelper(0, count - 1);
    }

    public TreeNode inorderHelper(int left, int right) {
        if(left > right)
            return null;
        int mid = (right - left) / 2 + left;
        TreeNode leftChild = inorderHelper(left, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        root.left = leftChild;
        root.right = inorderHelper(mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode dummyHead = head;
        head.next = new ListNode(0);
        head = head.next;
        head.next = new ListNode(-10);
        TreeNode res = new Solution().sortedListToBST(dummyHead);
        System.out.println(res.val);
    }

}
