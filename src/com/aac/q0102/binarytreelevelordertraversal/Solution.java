package com.aac.q0102.binarytreelevelordertraversal;

/**
 * Created by He at 18:55 2019/7/7
 */

import com.aac.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null)
            return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> thisLayer = new LinkedList<>();
            for(int i = 0;i < size;++i) {
                TreeNode tmp = queue.remove();
                thisLayer.add(tmp.val);
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }
            ret.add(thisLayer);
        }
        return ret;
    }
}