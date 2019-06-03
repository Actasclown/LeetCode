package com.aac.q0236.lowestcommonancestorofabinarytree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 13:31 2019/6/1
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
