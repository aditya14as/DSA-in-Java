package com.aditya.Recursion.Practice;

public class PrintAbbevrations {
    public static void main(String[] args) {
        String up = "pep";
        print("",up,0);
    }
    static void print(String p,String up,int c){
        if(up.isEmpty()){
            if(c==0){
                System.out.println(p);
            }
            else{
                System.out.println(p+c);
            }
            return;
        }
        char ch = up.charAt(0);
        if(c>0){
            print(p+c+ch,up.substring(1),0);
        }
        else{
            print(p+ch,up.substring(1),0);
        }
        print(p,up.substring(1),c+1);
    }
}
