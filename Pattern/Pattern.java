package com.aditya.Pattern;

public class Pattern {
    public static void main(String[] args){
        pattern18(10);
    }
    static void pattern18(int n){
        for (int i = 0; i <n/2; i++) {
            for (int j = 1; j<=n/2-i ; j++) {
                System.out.print("*");
            }
            for (int j = i*2; j>0; j--) {
                System.out.print(" ");
            }
            for (int j = n/2-i; j>0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n/2; i>0; i--) {
            for (int j =1; j <=n/2-i+1 ; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <=i*2-2 ; j++) {
                System.out.print(" ");
            }
            for (int j =1; j <=n/2-i+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
