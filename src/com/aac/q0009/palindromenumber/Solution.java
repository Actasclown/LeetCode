package com.aac.q0009.palindromenumber;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by He at 11:51 2019/5/12
 */
public class Solution {
//    public boolean isPalindrome(int x) {
//        if(x < 0)
//            return false;
//        if(x == 0)
//            return true;
//        int xx = x;
//        Queue<Integer> xReverse = new LinkedList<>();
//        while(x != 0) {
//            xReverse.add(x % 10);
//            x /= 10;
//        }
//        int y = 0;
//        while(!xReverse.isEmpty()) {
//            y *= 10;
//            y += xReverse.poll();
//        }
//        System.out.println(y);
//        return xx == y;
//    }


    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int xx = x;
        int xReverse = 0;
        while(x != 0 ) {
            xReverse *= 10;
            xReverse += (x % 10);
            x /= 10;
        }
        return xx == xReverse;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}
