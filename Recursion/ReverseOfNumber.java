package com.aditya.Recursion;

public class ReverseOfNumber {
    static int sum =0;
    public static void main(String[] args) {

        System.out.println(reverse2(4321));
    }

    static void reverse(int n){
        if(n==0){
            return;
        }
        sum = sum*10 + n%10;
        reverse(n/10);
    }
    static int reverse2(int n){
        int digits = (int)Math.log10(n) +1;
        return helper(n,digits);
    }
    static int helper(int n,int digits){
        if(digits==1){
            return n;
        }
        int rem = n%10;
        return rem * (int)Math.pow(10,digits-1) + helper(n/10,digits-1);
    }
}
