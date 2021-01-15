package com.aac.q0173.binarysearchtreeiterator;

import com.aac.datastructure.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        prepareStack(root);
    }

    private void prepareStack(TreeNode root) {
        if(root == null)
            return;
        stack.push(root);
        prepareStack(root.left);
    }

    /** @return the next smallest number */
    public int next() {
        if(stack.isEmpty())
            return -1;
        TreeNode tmp = stack.pop();
        prepareStack(tmp.right);
        return tmp.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */