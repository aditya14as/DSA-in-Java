package com.aditya.Bitwise;

public class OddEven {
    public static void main(String[] args){
        System.out.println(isEven(7));
    }
    static boolean isEven(int n){
        return (n & 1)==0 ;
    }
}
