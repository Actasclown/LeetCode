package com.aac.q0110.balancedbinarytree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 20:23 2019/5/26
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(treeDepth(root.left) - treeDepth(root.right)) < 2;
    }

    private int treeDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
