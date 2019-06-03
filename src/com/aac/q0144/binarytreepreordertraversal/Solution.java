package com.aac.q0144.binarytreepreordertraversal;

import com.aac.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by He at 12:56 2019/6/2
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            ret.add(tmp.val);
            if(tmp.right != null) stack.push(tmp.right);
            if(tmp.left != null) stack.push(tmp.left);
        }
        return ret;
    }
}
