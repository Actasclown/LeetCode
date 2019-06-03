package com.aac.q0226.invertbinarytree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 12:42 2019/5/25
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }
}
