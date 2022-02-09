package com.aditya.Recursion.Practice;

public class RemoveConsecutive {
    public static void main(String[] args) {
        String str = "aaaaabbbbbb";
        remove("",str);
    }
    static void remove(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int i = p.length()-1;
        char ch = up.charAt(0);

        if(i>=0 && p.charAt(i) == ch){
            remove(p,up.substring(1));
        }
        else{
            remove(p+ch,up.substring(1));
        }

    }
}
