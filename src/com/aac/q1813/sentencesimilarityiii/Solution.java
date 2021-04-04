package com.aac.q1813.sentencesimilarityiii;

public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        if(words1.length == words2.length)
            return sentence1.equals(sentence2);
        else if(words1.length < words2.length) {
            int i = 0, j = 0;
            boolean beforeEqual = true;
            boolean everNotEqual = false;
            while(true) {
                if(words1[i].equals(words2[j])) {
                    i ++;
                    j ++;
                    beforeEqual = true;
                } else {
                    //System.out.println(i + " " + j);
                    if(beforeEqual == true) {
                        //System.out.println(everNotEqual);
                        if(everNotEqual)
                            return false;
                        else {
                            j++;
                            beforeEqual = false;
                            everNotEqual = true;
                        }
                    } else {
                        j++;
                    }
                }
                if(i >= words1.length || j >= words2.length) {
                    break;
                }
            }
            //System.out.println(i + " " + j + " " + beforeEqual + " " + everNotEqual);
            if(i == words1.length && j == words2.length || i == j)
                return true;
            else
                return false;
        } else {
            int i = 0, j = 0;
            boolean beforeEqual = true;
            boolean everNotEqual = false;
            while(true) {
                if(words1[i].equals(words2[j])) {
                    i ++;
                    j ++;
                    beforeEqual = true;
                } else {
                    //System.out.println(i + " " + j);
                    if(beforeEqual == true) {
                        //System.out.println(everNotEqual);
                        if(everNotEqual)
                            return false;
                        else {
                            i++;
                            beforeEqual = false;
                            everNotEqual = true;
                        }
                    } else {
                        i++;
                    }
                }
                if(i >= words1.length || j >= words2.length) {
                    break;
                }
            }
            //System.out.println(i + " " + j + " " + beforeEqual + " " + everNotEqual);
            if(i == words1.length && j == words2.length || i == j)
                return true;
            else
                return false;
        }
    }
}
