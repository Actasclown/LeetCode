package com.aac.q0971.flipbinarytreetomatchpreordertraversal;

import com.aac.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int i = 0;
    List<Integer> res = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? res : Arrays.asList(-1);
    }

    public boolean dfs(TreeNode root, int[] v) {
        if(root == null)
            return true;
        if(root.val != v[i++])
            return false;
        if(root.left != null && root.left.val != v[i]) {
            res.add(root.val);
            return dfs(root.right, v) && dfs(root.left, v);
        }
        return dfs(root.left, v) && dfs(root.right, v);
    }
}
