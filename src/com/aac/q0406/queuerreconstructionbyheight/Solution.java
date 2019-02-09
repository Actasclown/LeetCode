package com.aac.q0406.queuerreconstructionbyheight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });
//        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> tmp = new LinkedList<>();
//        int len = people.length;
        for (int[] i:people)
            tmp.add(i[1], i);

//        for (int i = 0; i < len; ++i)
//            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

        return tmp.toArray(new int[people.length][]);
//        int[][] ret = new int[len][2];
//        for(int i = 0;i < len;++i) {
//            ret[i][0] = tmp.get(i)[0];
//            ret[i][1] = tmp.get(i)[1];
//        }
//
//        return ret;
    }

    public static void main(String[] args) {
        int[][] input = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] test = new Solution().reconstructQueue(input);
        for(int i = 0;i < test.length;++i) {
            for (int j = 0;j < 2;++j)
                System.out.print(test[i][j] + " ");
            System.out.print("\n");
        }
    }
}
