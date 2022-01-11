package com.aditya.Bitwise;

public class NoOfSetDigits {
    public static void main(String[] args) {
        int n = 5763;
        System.out.println(Integer.toBinaryString(n));
        int count =0;
        while(n>0){
            n=n&(n-1);
            count++;
        }
        System.out.println(count);
    }
}
