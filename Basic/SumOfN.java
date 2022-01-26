package com.aditya.Basic;

import java.util.Scanner;

public class SumOfN {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter last no to get the sum: ");
        int n = in.nextInt();
        int sum = sumN(n);
        System.out.print("Sum of natural numbers are "+sum);
    }
    static int sumN(int n){
        int sum =0;
        for(int i=1;i<=n;i++){
            sum =sum+i;
        }
        return sum;
    }
}
