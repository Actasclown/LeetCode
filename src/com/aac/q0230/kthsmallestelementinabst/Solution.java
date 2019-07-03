package com.aac.q0230.kthsmallestelementinabst;

import com.aac.datastructure.TreeNode;

import java.util.Stack;

/**
 * Created by He at 21:41 2019/6/29
 */

public class Solution {
//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> stack = new Stack<>();
//
//        while(true) {
//            while(root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if(--k == 0) return root.val;
//            root = root.right;
//        }
//    }

    private int cnt = 0, val = -1;
    private int kth;

    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        inorder(root);
        return val;
    }

    void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        if(++cnt == kth) {
            val = root.val;
            return;
        }
        inorder(root.right);
    }
}
