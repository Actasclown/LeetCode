package com.aac.wkt.q3;

import com.aac.datastructure.TreeNode;

public class Solution {
    static int distance = 0;
    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        return helper(root)[11];
    }

    public int[] helper(TreeNode root) {
        int[] tmp = new int[12];
        if(root.left == null && root.right == null) {
            tmp[0] = 1;
            return tmp;
        }
        else if(root.left == null) {
            int[] rightRet = helper(root.right);
            tmp[11] = rightRet[11];
            for (int i = 1; i <= 10; i++) {
                tmp[i] = rightRet[i - 1];
            }
            return tmp;
        } else if(root.right == null) {
            int[] leftRet = helper(root.left);
            tmp[11] = leftRet[11];
            for (int i = 1; i <= 10; i++) {
                tmp[i] = leftRet[i - 1];
            }
            return tmp;
        } else {
            int[] leftRet = helper(root.left);
            int[] rightRet = helper(root.right);
            tmp[11] += leftRet[11];
            tmp[11] += rightRet[11];
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 11; j++) {
                    if(i + j <= distance - 2)
                        tmp[11] += leftRet[i] * rightRet[j];
                }
            }
            for (int i = 1; i <= 10; i++) {
                tmp[i] = rightRet[i - 1] + leftRet[i - 1];
            }
            return tmp;
        }
    }
}
