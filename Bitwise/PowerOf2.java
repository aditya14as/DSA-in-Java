package com.aditya.Bitwise;

public class PowerOf2 {
    public static void main(String[] args) {
        int n =6;
        boolean powerOf2orNot= false;
        if((n & n-1)==0){
            powerOf2orNot = true;
        }
        System.out.println(powerOf2orNot);
    }
}
