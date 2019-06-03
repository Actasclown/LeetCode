package com.aac.q0543.diameterofbinarytree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 12:19 2019/5/30
 */
public class Solution {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = depth(root.left);
        int rigthDepth = depth(root.right);
        max = Math.max(max, leftDepth + rigthDepth);
        return Math.max(leftDepth, rigthDepth) + 1;
    }
}
