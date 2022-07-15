package com.aac.q0105.constructbinarytreefrompreorderandinordertraversal;

import com.aac.datastructure.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
//        for (int i : preorder) {
//            System.out.print(i + " ");
//        }
//        System.out.print("&& ");
//        for (int i : inorder) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        TreeNode ret = new TreeNode(preorder[0]);
        if(preorder.length == 1)
            return ret;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]) {
                int[] left_preorder = new int[i];
                int[] left_inorder = new int[i];
                int[] right_preorder = new int[inorder.length - 1 - i];
                int[] right_inorder = new int[inorder.length - 1 - i];
                for (int j = 0; j < i; j++) {
                    left_preorder[j] = preorder[j + 1];
                    left_inorder[j] = inorder[j];
                }
                for(int j = i + 1;j < inorder.length;++j) {
                    right_preorder[j - i - 1] = preorder[j];
                    right_inorder[j - i - 1] = inorder[j];
                }
                ret.left =  buildTree(left_preorder, left_inorder);
                ret.right = buildTree(right_preorder, right_inorder);
                break;
            }
        }
        return ret;
    }

    void printTreenode(TreeNode t) {
        if(t == null) {
            System.out.println("null");
            return;
        }
        else
            System.out.println(t.val);

        System.out.print("father: "+t.val + " "); printTreenode(t.left);
        System.out.print("father: "+t.val + " "); printTreenode(t.right);
    }

    public static void main(String[] args) {
        TreeNode test = new Solution().buildTree(new int[] {3, 9, 20, 15, 7},
                                                new int[] {9, 3, 15, 20, 7});
        new Solution().printTreenode(test);
    }
}
