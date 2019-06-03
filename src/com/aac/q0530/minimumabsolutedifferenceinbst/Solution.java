package com.aac.q0530.minimumabsolutedifferenceinbst;

import com.aac.datastructure.TreeNode;

import java.util.Stack;

/**
 * Created by He at 18:09 2019/6/2
 */
public class Solution {
    private int ret = Integer.MAX_VALUE;
    private int last = -1;

    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return ret;
    }

    void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.left);
        if(last != -1) ret = Math.min(Math.abs(root.val - last), ret);
        last = root.val;
        dfs(root.right);
    }
}
