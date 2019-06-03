package com.aac.q0653.twosumivinputisabst;

import com.aac.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by He at 17:53 2019/6/2
 */
public class Solution {
    List<Integer> inorder = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int length = inorder.size();
        int i = 0, j = length - 1;
        while(i < j && i >= 0 && j < length) {
            int sum = inorder.get(i) + inorder.get(j);
            if(sum > k)
                --j;
            else if(sum == k)
                return true;
            else
                ++i;
        }
        return false;
    }

    void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.left);
        inorder.add(root.val);
        dfs(root.right);
    }
}
