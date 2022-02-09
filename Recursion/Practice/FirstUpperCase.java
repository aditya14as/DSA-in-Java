package com.aditya.Recursion.Practice;

public class FirstUpperCase {
    public static void main(String[] args) {
        String str = "javaIsalanguage";
//        System.out.println(letter(str,0));
        System.out.println(length(str,0));
    }
    static char letter(String str,int i){
        if(str.charAt(i)>= 'A' && str.charAt(i)<='Z'){
            return str.charAt(i);
        }
        return letter(str, i+1);
    }
    static int length(String str, int length){
        if(str.equals("")){
            return length;
        }
        return length(str.substring(1),length+1);
    }
}
