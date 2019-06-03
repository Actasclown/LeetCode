package com.aac.q0538.convertbsttogreatertree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 18:36 2019/6/2
 */
public class Solution {
    int bias = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.right);
        root.val += bias;
        bias = root.val;
        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        new Solution().convertBST(root);
    }
}
