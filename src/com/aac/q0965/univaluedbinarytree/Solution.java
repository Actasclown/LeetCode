package com.aac.q0965.univaluedbinarytree;

import com.aac.datastructure.TreeNode;

public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root.left == null && root.right == null)
            return true;
        if(root.left == null) {
            if(root.val == root.right.val)
                return isUnivalTree(root.right);
            return false;
        }
        if(root.right == null) {
            if(root.val == root.left.val)
                return isUnivalTree(root.left);
            return false;
        }
        if(root.val == root.left.val && root.val == root.right.val)
            return isUnivalTree(root.left) && isUnivalTree(root.right);
        return false;
    }

    public static void main(String[] args) {
        TreeNode leaf = new TreeNode(1);
        TreeNode root = new TreeNode(2);
        root.right = leaf;
        System.out.println(new Solution().isUnivalTree(root));
    }
}
