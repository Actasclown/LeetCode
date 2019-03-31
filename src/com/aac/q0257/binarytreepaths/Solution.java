package com.aac.q0257.binarytreepaths;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root == null)
            return ret;
        dfs(root, ret,  "" + root.val);
        return ret;
    }

    private void dfs(TreeNode root, List<String> ret, String tmp) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ret.add(tmp);
            System.out.println(tmp);
            return;
        }
        if (root.left != null)
            dfs(root.left, ret, tmp + "->" + root.left.val);
        if (root.right != null)
            dfs(root.right, ret, tmp + "->" + root.right.val);
        return;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        new Solution().binaryTreePaths(root);
    }
}
