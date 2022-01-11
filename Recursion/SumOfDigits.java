package com.aditya.Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sum(4321));
    }
    static int sum(int n){
        if(n==0){
            return 0;
        }
        return n%10 + sum(n/10);
    }
}
