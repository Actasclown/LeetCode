package com.aac.q0671.secondminimumnodeinabinarytree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 18:06 2019/5/30
 */
public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null)
            return -1;
        int val = root.val;
        int leftVal = root.left.val, rightVal = root.right.val;
        if(val == leftVal)
            leftVal = findSecondMinimumValue(root.left);
        if(val == rightVal)
            rightVal = findSecondMinimumValue(root.right);
        if(leftVal != -1 && rightVal != -1)
            return Math.min(leftVal, rightVal);
        if(leftVal != -1)
            return leftVal;
        return rightVal;
    }
}
