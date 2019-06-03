package com.aac.q0108.convertsortedarraytobinarysearchtree;

import com.aac.datastructure.TreeNode;

/**
 * Created by He at 22:00 2019/5/29
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int begin, int end) {
        if(begin > end)
            return null;
        int mid = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, begin, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
