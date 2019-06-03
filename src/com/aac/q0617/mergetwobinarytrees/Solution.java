package com.aac.q0617.mergetwobinarytrees;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 17:24 2019/5/25
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return null;
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        TreeNode ret = new TreeNode(0);
        ret.val = t1.val + t2.val;
        ret.left = mergeTrees(t1.left, t2.left);
        ret.right = mergeTrees(t1.right, t2.right);
        return ret;
    }
}
