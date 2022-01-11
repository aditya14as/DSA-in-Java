package com.aditya.Recursion;

public class Fibbonaci {
    public static void main(String[] args){
        System.out.println(fibb(4));
    }
    static int fibb(int n){
        if(n<2){
            return n;
        }
        return fibb(n-1)+fibb(n-2);
    }
}
