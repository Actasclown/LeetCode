package com.aac.q0404.sumofleftleaves;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 11:58 2019/5/27
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
