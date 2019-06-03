package com.aac.q0687.longestunivaluepath;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 15:04 2019/6/1
 */
public class Solution {
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        left = root.left != null && root.val == root.left.val ? left + 1 : 0;
        right = root.right != null && root.val == root.right.val ? right + 1 : 0;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
