package com.aac.q0437.pathsumiii;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 18:50 2019/5/26
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return pathSum(root.right, sum) + pathSum(root.left, sum) + pathStartWithRoot(root, sum);
    }

    private int pathStartWithRoot(TreeNode root, int sum) {
        int ret = 0;
        if(root == null)
            return ret;
        if(root.val == sum)
            ++ret;
        ret += pathStartWithRoot(root.left, sum - root.val) + pathStartWithRoot(root.right, sum - root.val);
        return ret;
    }
}
