package com.aditya.Recursion.Practice;

import java.util.Arrays;

public class Lexicographic {
    public static void main(String[] args) {
        String str = "cba";
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String str1 = new String(arr);
        for(int i=0; i<=str1.length();i++){
            lexSet(str1.substring(i),0,"");
        }
//        set(str,str.length(),-1,"");
    }
    static void lexSet(String up,int i,String p){
        if(up.isEmpty()){
            return;
        }
        p= p+up.charAt(0);
        System.out.println(p);
        lexSet(up.substring(1),i+1,p);
    }
//    static void set(String up,int n,int index,String p){
//        if(index==n){
//            return;
//        }
//        System.out.println(p);
//        for (int i = index+1; i < n; i++) {
//            p= p+up.charAt(i);
//            set(up,n,i,p);
//            p=p.substring(0,p.length()-1);
//        }
//
//    }
}
