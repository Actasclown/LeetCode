package com.aac.q0865.smallestsbtreewithallthedeepestnodes;

import com.aac.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
//    public TreeNode subtreeWithAllDeepest(TreeNode root) {
//        Queue<TreeNode> bfs = new LinkedList<>();
//        TreeNode ret = null;
//        TreeNode curNode = null;
//        bfs.offer(root);
//        while(!bfs.isEmpty()) {
//            curNode = bfs.poll();
//            if(curNode.left != null)
//                bfs.offer(curNode.left);
//            if(curNode.right != null)
//                bfs.offer(curNode.right);
//            if(isLeaf(curNode.left) && isLeaf(curNode.right))
//                ret = curNode;
//        }
//        if(ret == null)
//            return curNode;
//        return ret;
//    }
//
//    boolean isLeaf(TreeNode root) {
//        if(root == null)
//            return false;
//        if(root.left == null && root.right == null)
//            return true;
//        return false;
//    }

    class DepthNode {
        TreeNode node;
        int depth;
        DepthNode(int depth, TreeNode node) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
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