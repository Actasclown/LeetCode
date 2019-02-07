package com.aac.q0412.fizzbuzz;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yunqi on 2017/3/26.
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        LinkedList<String> result = new LinkedList<>();
        for(int i = 1;i <= n;++i) {
            if(i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
