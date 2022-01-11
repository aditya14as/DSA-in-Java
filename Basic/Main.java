package com.aditya.Basic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no to reverse: ");
        int a = in.nextInt();
        int ans=0;
        while(a!=0){
            int rem = a%10;
            ans = ans*10 + rem;
            a = a/10;
        }

        System.out.print("Reverse of given no is: " + ans);
    }
}
