package com.aac.q1504.countsubmatriceswithallones;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
//    public int numSubmat(int[][] mat) {
//        int height = mat.length;
//        int width = mat[0].length;
//        int sum = 0;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                for (int k = 1; k <= height; k++) {
//                    for (int l = 1; l <= width; l++) {
//                        sum += check(mat, i, j, k, l);
//                    }
//                }
//            }
//        }
//        return sum;
//    }
//
//    int check(int[][] mat, int posX, int posY, int height, int width) {
//        int H = mat.length;
//        int W = mat[0].length;
//        if(posX + height > H || posY + width > W)
//            return 0;
//        for (int i = posX; i < posX + height; i++) {
//            for (int j = posY; j < posY + width; j++) {
//                if(mat[i][j] == 0)
//                    return 0;
//            }
//        }
//        return 1;
//    }


//    public int numSubmat(int[][] mat) {
//        //HashSet<String> triangles = new HashSet<>();
//        int height = mat.length;
//        int width = mat[0].length;
//        boolean[][][][] isOkay = new boolean[height+1][width+1][height+2][width+2];
//        int sum = 0;
//        for (int i = 1; i <= height; i++) {
//            for (int j = 1; j <= width; j++) {
//                for (int k = 0; k < height; k++) {
//                    for (int l = 0; l < width; l++) {
////                        if(mat[k][l] == 1 && (triangles.contains((k + 1)+ "," + l + "," + (i - 1) + "," + 1) || (i - 1 == 0)) &&
////                                (triangles.contains(k + "," + (l + 1) + "," + i + "," + (j - 1)) || (j - 1 == 0))) {
////                            triangles.add(k + "," + l + "," + i + "," + j);
////                        }
//                        if(mat[k][l] == 1 && ((i - 1 == 0) || isOkay[k + 1][l][i - 1][1]) &&
//                                ((j - 1 == 0) || isOkay[k][l + 1][i][j - 1])) {
//                            isOkay[k][l][i][j] = true;
//                            sum++;
//                        }
//                    }
//                }
//            }
//        }
//        return sum;
//        //return triangles.size();
//    }


    public int numSubmat(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        int[] continuous1Row = new int[width];
        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                continuous1Row[j] = mat[i][j] == 0 ? 0 : continuous1Row[j] + 1;
            }
            res += help(continuous1Row);
        }
        return res;
    }

    int help(int[] continuous1Row) {
        Stack<Integer> lessStack = new Stack<>();
        int width = continuous1Row.length;
        int[] sum = new int[width];
        int res = 0;
        for (int i = 0; i < width; i++) {
            while (!lessStack.isEmpty() && continuous1Row[lessStack.peek()] >= continuous1Row[i])
                lessStack.pop();
            if(lessStack.isEmpty()) {
                sum[i] = continuous1Row[i] * (i + 1);
            } else {
                int prevIndex = lessStack.peek();
                sum[i] = sum[prevIndex];
                sum[i] += continuous1Row[i] * (i - prevIndex);
            }
            res += sum[i];
            lessStack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        //int[][] mat = {{1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1},{1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,0,0,0,1,1,1,0,0,1,0,0},{1,1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,1,0,0,1,0},{0,1,0,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,0,0,0,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1},{0,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,1,0,0,1,1,0,1,1},{1,1,1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1},{1,1,1,0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0},{1,1,0,1,1,0,1,0,1,0,0,1,1,1,1,0,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1},{0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1},{1,1,1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,1,0,0},{0,1,0,0,0,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,1,0,1,1,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,0,0,1,1,0,1,0,0,1,0,1,1},{1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0},{0,1,1,1,0,0,0,0,1,1,0,1,1,0,1,0,1,0,0,0,1,1,1,1,1,1,0,1,1,1,1,0,1,0,0,1,0,1,1,0,0,1},{0,1,1,0,1,0,0,1,0,0,1,1,1,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0},{0,0,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,0,0,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,0,1,1,0,1,1,1},{0,1,0,1,1,1,1,1,0,0,0,1,0,1,0,1,1,1,1,0,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0},{1,1,1,0,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,0,1,0,0,0,0,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1},{1,0,1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},{1,0,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,0},{1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,0,0,1,0,1,1,1,0,1,1},{0,0,1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0,1,1},{1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1,0,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,0,1,1,0},{0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,0,1,0,1,1,1,1,0,1,1,1,0,0,1,0,1,1,1,1},{1,0,1,0,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,0,1,1,0,1,1,1,1,0},{1,0,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,0,1,1,0,1,1,1,0,1,1,0,1,0,0,0,1,1,0,0,1,1},{0,1,1,1,0,1,0,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,0,0,1,1,1},{1,0,1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,0,1,0,0,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1},{0,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,0}};
        int[][] mat = {{0,1,1,0},{0,1,1,1},{1,1,1,0}};
        System.out.println(new Solution().numSubmat(mat));
    }
}
