package com.aditya.Math;

public class GCD_LCM {
    public static void main(String[] args) {
        System.out.println("LCM of 8 and 10 is " + LCM(8,10));
        System.out.println("HCF of 8 and 10 is "+ GCD(8,10));
    }
    static int GCD(int a, int b){
        if(a==0){
            return b;
        }
        return GCD(b%a,a);
    }

    static int LCM(int a, int b){
        return (a*b)/GCD(a,b);
    }
}
