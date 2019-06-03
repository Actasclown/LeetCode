package com.aac.q0111.minimumdepthofbinarytree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 21:58 2019/5/26
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null)
            return minDepth(root.right) + 1;
        if(root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
