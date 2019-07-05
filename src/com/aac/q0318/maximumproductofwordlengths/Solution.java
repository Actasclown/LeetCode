package com.aac.q0318.maximumproductofwordlengths;

/**
 * Created by He at 21:31 2019/7/5
 */
public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] lens = new int[len];
        int[] bitmap = new int[len];
        for (int i = 0; i < len; ++i) {
            lens[i] = words[i].length();
            for (char thisChar : words[i].toCharArray()) bitmap[i] |= (1 << (thisChar - 'a'));
        }
        int ret = 0;
        for(int i = 0;i < len;++i) {
            for(int j = i;j < len;++j) {
                if((bitmap[i] & bitmap[j]) == 0) {
                    int tmp = lens[i] * lens[j];
                    if (tmp > ret)
                        ret = tmp;
                }
            }
        }
        return ret;
    }
}
