package com.aac.q0199.binarytreerightsideview;

import com.aac.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    class Pair {
        int level;
        TreeNode node;

        Pair(int l, TreeNode n) {
            this.level = l;
            this.node = n;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        while (true) {
            Pair tmp = q.poll();
            if (tmp.node == null)
                break;
            if (tmp.node.left != null)
                q.offer(new Pair(tmp.level + 1, tmp.node.left));
            if (tmp.node.right != null)
                q.offer(new Pair(tmp.level + 1, tmp.node.right));
            if (q.isEmpty()) {
                ret.add(tmp.node.val);
                break;
            } else if (tmp.level != q.peek().level)
                ret.add(tmp.node.val);
        }
        return ret;
    }
}
