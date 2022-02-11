package com.aditya.Recursion.Practice;

public class Lexicographic {
    public static void main(String[] args) {
        String str = "abc";
        set(str,str.length(),-1,"");
    }
    static void set(String up,int n,int index,String p){
        if(index==n){
            return;
        }
        System.out.println(p);
        for (int i = index+1; i < n; i++) {
            p= p+up.charAt(i);
            set(up,n,i,p);
            p=p.substring(0,p.length()-1);
        }

    }
}
