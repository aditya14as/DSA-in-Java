package com.aditya.Strings;

public class StringEqual {
    public static void main(String[] args){
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }
    static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            str.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            str.append(word2[i]);
        }
        //System.out.println(str);
        String s = str.toString();
        for (int i = 0; i <= s.length() / 2; i++) {
            char start = s.charAt(i);
            char end = s.charAt(s.length() - 1 - i);
            if (start != end) {
                return false;
            }
        }
        return true;
    }

}
