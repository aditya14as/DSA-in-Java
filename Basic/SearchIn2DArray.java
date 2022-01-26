package com.aditya.Basic;

import java.util.Arrays;
import java.util.Scanner;

public class SearchIn2DArray{
    public static void main(String[] args){
        int[][] arr={
                {2, 3, 4},
                {43, 12, 90},
                {50, 32, 6, 90},
                {80, 45}
        };
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int[] ans = search(arr,target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] search(int[][] arr, int target){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[row].length; col++){
                if(arr[row][col]==target){
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
