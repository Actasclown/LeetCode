package com.aac.q0145.binarytreepostordertraversal;

import com.aac.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by He at 16:33 2019/6/2
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode tmp = stack.peek();
            if(tmp.left == null && tmp.right == null) {
                ret.add(stack.pop().val);
                continue;
            }
            if(tmp.right != null) {
                stack.push(tmp.right);
                tmp.right = null;
            }
            if(tmp.left != null) {
                stack.push(tmp.left);
                tmp.left = null;
            }
        }
        return ret;
    }
}
