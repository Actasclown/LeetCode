package com.aac.q0513.findbottomlefttreevalue;

/**
 * Created by Yunqi on 2017/3/26.
 */

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
//    public int findBottomLeftValue(TreeNode root) {
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()) {
//            root = queue.poll();
//            if(root.right != null) {
//                queue.add(root.right);
//            };
//            if(root.left != null) {
//                queue.add(root.left);
//            }
//        }
//        return root.val;
//    }

    int ans = 0, result;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return result;
    }

    public void findBottomLeftValue(TreeNode root, int depth) {
        if(depth > ans) {
            result = root.val;
            ans = depth;
        }
        if(root.left != null) {
            findBottomLeftValue(root.left, depth + 1);
        }
        if(root.right != null) {
            findBottomLeftValue(root.right, depth + 1);
        }
    }
}