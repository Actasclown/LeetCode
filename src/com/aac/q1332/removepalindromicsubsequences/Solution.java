package com.aac.q1332.removepalindromicsubsequences;

public class Solution {
//    public int removePalindromeSub(String s) {
//        char[] c = s.toCharArray();
//        int opNum = 0;
//        boolean skip = false;
//        while (!skip) {
//            int forward = 0, backward = c.length - 1;
//            skip = true;
//            while (forward != backward) {
//                if (c[forward] == c[backward]) {
//                    c[forward] = 'b';
//                    c[backward] = 'b';
//                    forward++;
//                    backward--;
//                    if (backward < forward)
//                        break;
//                    else if (backward == forward) {
//                        c[forward] = 'b';
//                        break;
//                    }
//                } else {
//                    if (c[forward] == 'a')
//                        backward--;
//                    else
//                        forward++;
//                    if(forward == backward)
//                        c[forward] = 'b';
//                    skip = false;
//                }
//            }
//            opNum++;
//        }
//        return opNum;
//    }

    //shitty problem. lol
    public int removePalindromeSub(String s) {
        if(s.length() == 0)
            return 0;
        String rs = new StringBuilder(s).reverse().toString();
        if(rs.equals(s))
            return 1;
        else
            return 2;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().removePalindromeSub("abb"));
    }
}
