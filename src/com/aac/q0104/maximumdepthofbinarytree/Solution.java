package com.aac.q0104.maximumdepthofbinarytree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 23:03 2019/5/21
 */

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
