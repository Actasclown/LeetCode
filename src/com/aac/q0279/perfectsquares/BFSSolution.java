package com.aac.q0279.perfectsquares;

import java.util.ArrayDeque;

public class BFSSolution {
    private static int[] squares;

    public int numSquares(int n) {
        ArrayDeque<Integer> bfs = new ArrayDeque<Integer>();
        int depth = 1;

        int sqrtN = (int)Math.sqrt(n);
        squares = new int[sqrtN + 1];
        for(int i = 1;i <= sqrtN;++i) {
            squares[i] = i * i;
        }

        bfs.add(n);

        while(true) {
            for(int lenght = bfs.size();lenght > 0;--lenght) {
                int remain = bfs.pollFirst();
                for(int square = (int)Math.sqrt(remain);square > 0;--square) {
                    int nextRemain = remain;
                    nextRemain-= squares[square];
                    if(nextRemain == 0)
                        return depth;
                    bfs.add(nextRemain);
                }
            }
            depth++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new BFSSolution().numSquares(12));
    }
}
