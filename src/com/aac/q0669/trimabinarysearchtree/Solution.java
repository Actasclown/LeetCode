package com.aac.q0669.trimabinarysearchtree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 14:06 2019/5/29
 */

public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return null;
        if(root.val > R) return trimBST(root.left, L, R);
        if(root.val < L) return trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
