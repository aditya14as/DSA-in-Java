package com.aditya.Basic;

public class SearchInString {
    public static void main(String[] args){
        String name = "Aditya";
        char target = 'b';
        boolean ans = LinearSearch(name,target);
        System.out.println(ans);
    }
    static boolean LinearSearch(String str,char target){
        if(str.length()==0){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if(target==str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
