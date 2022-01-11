package com.aditya.Bitwise;

public class NoOfDigits {
    public static void main(String[] args) {
        int n =456781;
        int base =10;
        int digit = (int)(Math.log(n)/ Math.log(base)) +1;
        System.out.println(digit);
    }
}
