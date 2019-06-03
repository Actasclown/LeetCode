package com.aac.q0101.symmetrictree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 20:09 2019/5/26
 */

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val != right.val)
            return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
