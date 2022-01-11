package com.aditya.Basic;

import java.util.Arrays;
import java.util.Scanner;

public class Roll {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] roll = new int[5];
        // or directly
        int[] roll2= {1,2,3,4,5,6};
        for(int i=0;i<roll.length;i++){
            roll[i] = in.nextInt();
        }

        for(int i=0; i<roll.length;i++){
            System.out.print(roll[i]+" ");
        }

        System.out.println(Arrays.toString(roll));

        for(int num: roll2){
            System.out.print(num+" ");
        }

        String[] name = new String[4];
        for (int s = 0; s < name.length; s++) {
            name[s] = in.next();
        }
        System.out.println(Arrays.toString(name));
    }
}
