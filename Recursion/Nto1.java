package com.aditya.Recursion;

public class Nto1 {
    public static void main(String[] args) {
        printfn(5);
    }
    static void printfn(int n){
        if(n==0){
            return;
        }


        printfn(n-1);
        System.out.println(n);
    }
}
