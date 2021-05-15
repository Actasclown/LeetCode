package com.aac.q0114.flattenbinarytreetolinkedlist;

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
    public void flatten(TreeNode root) {
        if(root.left != null)
            flatten(root.left);
        if(root.right != null)
            flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        TreeNode cur = root;
        while (cur.right != null)
            cur = cur.right;
        cur.right = tmp;
        cur.left = null;
    }
}