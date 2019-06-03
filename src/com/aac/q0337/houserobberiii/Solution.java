package com.aac.q0337.houserobberiii;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 17:41 2019/6/1
 */
public class Solution {
//    public int rob(TreeNode root) {
//        if(root == null)
//            return 0;
//        int layer0 = 0, layer1 = root.val;
//        if(root.left != null) {
//            layer0 += rob(root.left);
//            if (root.left.left != null)
//                layer1 += rob(root.left.left);
//            if (root.left.right != null)
//                layer1 += rob(root.left.right);
//        }
//        if(root.right != null) {
//            layer0 += rob(root.right);
//            if (root.right.left != null)
//                layer1 += rob(root.right.left);
//            if (root.right.right != null)
//                layer1 += rob(root.right.right);
//        }
//        return Math.max(layer0, layer1);
//    }

    public int rob(TreeNode root) {
        int[] ret = dfs(root);
        return Math.max(ret[0], ret[1]);
    }

    private int[] dfs(TreeNode root) {
        if(root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        return new int[] {Math.max(left[0] + right[0], left[1] + right[1] + root.val), left[0] + right[0]};
    }
}
