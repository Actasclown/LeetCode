package com.aac.q1008.constructbinarysearchtreefrompreordertraversal;

import com.aac.datastructure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1;i < preorder.length;++i) {
            nodeInsert(root, preorder[i]);
        }
        return root;
    }

    void nodeInsert(TreeNode root, int val) {
        if(val < root.val) {
            if(root.left == null) {
                root.left = new TreeNode(val);
            } else {
                nodeInsert(root.left, val);
            }
        } else {
            if(root.right == null) {
                root.right = new TreeNode(val);
            } else {
                nodeInsert(root.right, val);
            }
        }
    }
}