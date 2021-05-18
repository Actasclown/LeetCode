package com.aac.q0968.binarytreecameras;

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

    int res = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) == 0 ? 1 : 0) + res;
    }

    int dfs(TreeNode root) {
        if(root == null)
            return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == 0 || right == 0) {
            res ++;
            return 1;
        }
        if(left == -1 && right == -1) {
            return 0;
        }
        return -1;
    }
}