package com.aac.q0235.lowestcommonancesterofabinarysearchtree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 11:58 2019/6/1
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        int rootVal = root.val, pVal = p.val, qVal = q.val;
        while(true) {
            if(rootVal < pVal && rootVal < qVal) {
                root = root.right;
                rootVal = root.val;
            } else if(rootVal > pVal && rootVal > qVal) {
                root = root.left;
                rootVal = root.val;
            } else
                break;
        }
        return root;
    }
}
