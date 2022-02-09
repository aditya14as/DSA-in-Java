package com.aditya.Recursion.Practice;

public class BalcancedParanthesis {
    public static void main(String[] args) {
        String str = "[()]{}{[()()]()}";
        System.out.println(check("",str,false));
    }
    static boolean check(String p,String up,boolean ans){
        if(up.isEmpty()){
            return ans;
        }
        char ch = up.charAt(0);
        int i = Math.max(p.length()-1,0);
        if(i<1){
            p=p+ch;
        }
        if(!isValid(p.charAt(i),up.charAt(0))){
            return check(p+ch,up.substring(1),false);
        }
        return check(p.substring(0,i),up.substring(1),true);

    }
    static boolean isValid(char a,char b){
        if(a == '(' && b==')'){
            return true;
        }
        if(a == '{' && b == '}'){
            return true;
        }
        if(a == '[' && b == ']'){
            return true;
        }
        return false;
    }
}
