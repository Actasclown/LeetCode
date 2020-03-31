package com.aac.q0113.pathsumii;

import com.aac.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, sum, new ArrayList<>());
        return ret;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> tmp) {
        if(root == null)
            return;
        tmp.add(root.val);
        if(root.left == null && root.right == null) {
            if(sum == root.val)
                ret.add(new ArrayList<>(tmp));
            return;
        }
        pathSum(root.left, sum - root.val, new ArrayList<>(tmp));
        pathSum(root.right, sum - root.val, new ArrayList<>(tmp));
        return;
    }

    public static void main(String[] args) {
        TreeNode[] treeNodes = new TreeNode[10];
        int[] val = {5, 4, 8, 11, 13, 4, 7, 2, 5, 1};
        for (int i = 0; i < 10; i++) {
            treeNodes[i] = new TreeNode(val[i]);
        }

        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[2];
        treeNodes[1].left = treeNodes[3];
        treeNodes[3].left = treeNodes[6];
        treeNodes[3].right = treeNodes[7];
        treeNodes[2].left = treeNodes[4];
        treeNodes[2].right = treeNodes[5];
        treeNodes[5].left = treeNodes[8];
        treeNodes[5].right = treeNodes[9];

        List<List<Integer>> result = new Solution().pathSum(treeNodes[0], 22);
        for (List<Integer> j : result) {
            for (Integer i : j) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
