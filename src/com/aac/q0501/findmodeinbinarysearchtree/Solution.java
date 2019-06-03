package com.aac.q0501.findmodeinbinarysearchtree;

import com.aac.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by He at 19:12 2019/6/2
 */
public class Solution {
    private int lastVal = Integer.MIN_VALUE;
    private int max = Integer.MIN_VALUE;
    private int cnt = 0;
    private List<Integer> tmp = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int length = tmp.size();
        int[] ret = new int[length];
        for (int i = 0; i < length; i++) ret[i] = tmp.get(i);
        return ret;
    }

    private void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.left);
        int rootVal = root.val;
        if(rootVal == lastVal)
            cnt++;
        else {
            cnt = 1;
            lastVal = rootVal;
        }
        if(cnt == max)
            tmp.add(rootVal);
        if(cnt > max) {
            max = cnt;
            tmp = new ArrayList<>();
            tmp.add(rootVal);
        }
        dfs(root.right);
    }
}
