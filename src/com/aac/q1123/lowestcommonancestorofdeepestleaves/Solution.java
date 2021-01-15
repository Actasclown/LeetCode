package com.aac.q1123.lowestcommonancestorofdeepestleaves;

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
    class DepthNode {
        TreeNode node;
        int depth;
        DepthNode(int depth, TreeNode node) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return depth(root).node;
    }

    DepthNode depth(TreeNode node) {
        if(node == null)
            return new DepthNode(0,null);
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        DepthNode left = depth(leftNode);
        DepthNode right = depth(rightNode);
        int d1 = left.depth;
        int d2 = right.depth;
        return new DepthNode(Math.max(d1, d2) + 1, d1 == d2 ? node : d1 > d2 ? left.node : right.node);
    }
}