package com.aac.q0572.subtreeofanothertree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 21:15 2019/5/29
 */

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.val == t.val && isSame(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.val == t.val)
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        return false;
    }
}
