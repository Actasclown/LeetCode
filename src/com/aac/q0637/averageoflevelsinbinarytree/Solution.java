package com.aac.q0637.averageoflevelsinbinarytree;

import com.aac.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by He at 18:48 2019/6/1
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new LinkedList<>();
        if(root == null)
            return ret;
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty()) {
            int cnt = bfs.size();
            long average = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode tmp = bfs.poll();
                average += tmp.val;
                if(tmp.left != null) bfs.add(tmp.left);
                if(tmp.right != null) bfs.add(tmp.right);
            }
            ret.add((double)average / cnt);
        }
        return ret;
    }
}
