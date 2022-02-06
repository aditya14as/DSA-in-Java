package com.aditya.Recursion;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
    char[] arr = {'H','a','n','n','a','h'};
    helper(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    static void helper(char [] s,int start, int end){
        if(start>=end){
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        helper(s,start+1,end-1);
    }
}
