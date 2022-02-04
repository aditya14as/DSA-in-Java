package com.aditya.Bitwise;

import java.util.Scanner;

public class HackerEarthMockTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            String M = in.next();
            ans(M);
        }
    }
    static void ans(String M){

        int decimalNo = Integer.parseInt(M,2);

        int N = M.length();
        int size = (int)Math.pow(2,N);
        int[] arr = new int[size];
        for(int i =0; i<size; i++){
            arr[i] = i^decimalNo;
        }
        int count = 0;
        for(int i=0; i<size-1; i++){
            for(int j=i+1; j<size; j++){
                if(arr[j]<arr[i]){
                    count=count+1;
                }
            }
        }
        System.out.println(count);
    }
}
