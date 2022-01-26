package com.aditya.Basic;

import java.util.Scanner;

public class LCM {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your choice, e.g 1 for LCM, 2 for HCF and 3 for exit: ");
        int choice = in.nextInt();
        System.out.print("Enter two numbers: ");
        int a = in.nextInt();
        int b = in.nextInt();



            switch (choice) {
                case 1:
                    int anslcm = lcmFun(a, b);
                    System.out.print("LCM of the given no is: " + anslcm);
                    break;
                case 2:
                    int anshcf = hcfFun(a, b);
                    System.out.print("HCF of the given no is: " + anshcf);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.print("Invalid Input");


            }


    }

    static int lcmFun(int a, int b) {
        int start,i;
        if(a>b) start = a;
        else start = b;

        for(i=start; i<=a*b; i++){
            if(i%a==0 && i%b==0 ){
                break;
            }
        }
        return i;
    }

    static int hcfFun(int a, int b){
        int end,i;
        if(a<b) end=a;
        else end = b;

        for(i=end;i>=1;i--){
            if(a%i==0 && b%i==0){
                break;
            }
        }
        return i;
    }
}
