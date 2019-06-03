package com.aac.q0094.binarytreeinordertraversal;

import com.aac.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by He at 16:53 2019/6/2
 */

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            if(tmp.right != null) {
                stack.push(tmp.right);
            }
            stack.push(tmp);
            if(tmp.left != null) {
                stack.push(tmp.left);
            }
            if(tmp.right == null && tmp.left == null) {
                ret.add(stack.pop().val);
            } else {
                tmp.right = null;
                tmp.left = null;
            }
        }
        return ret;
    }
}
