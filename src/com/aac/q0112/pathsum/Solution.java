package com.aac.q0112.pathsum;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 17:48 2019/5/26
 */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null) {
            if(root.val == sum)
                return true;
            else
                return false;
        }
        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }
}
