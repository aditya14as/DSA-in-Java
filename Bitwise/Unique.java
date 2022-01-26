package com.aditya.Bitwise;

public class Unique {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,3,4,2,6,6,7,1};
        System.out.println(uniqueNo(arr));
    }
    static int uniqueNo(int[] arr){
        int unique = 0;
        for (int i = 0; i < arr.length ; i++) {
            unique = unique^arr[i]; //XOR of any number with itself give zero
        }
        return unique;
    }
}
