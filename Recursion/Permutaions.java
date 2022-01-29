package com.aditya.Recursion;

import java.util.ArrayList;

public class Permutaions {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        ans = permutationsList("","abcd");
        System.out.println(ans);
        System.out.println(countPermutaions("","abcd"));
    }
    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length() ; i++) {
            String first = p.substring(0,i);
            String last = p.substring(i);
            permutation(first + ch + last, up.substring(1));
        }
    }

    static ArrayList<String> permutationsList(String p, String up){
        ArrayList<String> ans = new ArrayList<>();
        if(up.isEmpty()){
            ans.add(p);
            return ans;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String last = p.substring(i);
            ans.addAll(permutationsList(first + ch + last , up.substring(1)));
        }
        return ans;
    }

    static int countPermutaions(String p, String up){
        int count = 0;
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String last = p.substring(i);
            count = count + countPermutaions(first + ch + last, up.substring(1));
        }
        return count;
    }
}
