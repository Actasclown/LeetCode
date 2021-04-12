package com.aac.q1302.deepestleavessum;

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

    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        int depth = calDepth(root);
        calSum(root, 1, depth);
        return sum;
    }

    int calDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        else if(root.right == null)
            return 1 + calDepth(root.left);
        else if(root.left == null)
            return 1 + calDepth(root.right);
        else
            return 1 + Math.max(calDepth(root.left), calDepth(root.right));
    }

    void calSum(TreeNode root, int thisDepth, int depth) {
        if(root == null)
            return;
        if(thisDepth == depth) {
            sum += root.val;
        } else if(thisDepth < depth) {
            calSum(root.left, thisDepth + 1, depth);
            calSum(root.right, thisDepth + 1, depth);
        }
    }
}
