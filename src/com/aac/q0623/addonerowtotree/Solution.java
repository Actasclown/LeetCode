package com.aac.q0623.addonerowtotree;

import com.aac.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
//    public TreeNode addOneRow(TreeNode root, int v, int d) {
//        if(d == 1) {
//            TreeNode newRoot = new TreeNode(v);
//            newRoot.left = root;
//            return newRoot;
//        }
//        List<Queue<TreeNode>> queues = new ArrayList<>();
//        queues.add(new LinkedList<>());
//        queues.add(new LinkedList<>());
//        queues.get(1).offer(root);
//        int depth = 1;
//        while(depth < d - 1) {
//            while(!queues.get(depth % 2).isEmpty()) {
//                TreeNode tmp = queues.get(depth % 2).poll();
//                if(tmp == null)
//                    continue;
//                queues.get((depth + 1) % 2).offer(tmp.left);
//                queues.get((depth + 1) % 2).offer(tmp.right);
//            }
//            depth++;
//        }
//        while(!queues.get(depth % 2).isEmpty()) {
//            TreeNode tmp = queues.get(depth % 2).poll();
//            if(tmp == null)
//                continue;
//            TreeNode newLeft = new TreeNode(v);
//            TreeNode newRight = new TreeNode(v);
//            newLeft.left = tmp.left;
//            newRight.right = tmp.right;
//            tmp.left = newLeft;
//            tmp.right = newRight;
//        }
//        return root;
//    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 0 || d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = d == 1 ? root : null;
            newRoot.right = d == 0 ? root : null;
            return newRoot;
        }
        if(root != null) {
            root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }
}
