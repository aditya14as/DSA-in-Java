package com.aditya.BinarySearch;

import java.util.Arrays;

public class Sorted2DElaborated {
    public static void main(String[] args){
        int[][] arr= {
                {10,20,30,40},
                {41,42,43,45},
                {46,47,48,49},
                {50,51,52,53}

        };
        int target = 49;
        int[] ans=search(arr,target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] binarySearch(int[][] arr, int row,int cStart,int cEnd,int target){
        while(cStart<= cEnd){
            int mid = cStart + (cEnd-cStart)/2;
            if(arr[row][mid]==target){
                return new int[]{row,mid};
            }
            if(arr[row][mid]>target){
                cEnd = mid-1;
            }
            else {
                cStart = mid+1;
            }
        }
        return new int[] {-1,-1};
    }

    static int[] search(int[][] arr,int target){
        int rows = arr.length;
        int cols = arr[0].length;

        if(rows == 1){
            return binarySearch(arr,0,0,cols-1,target);
        }
        int rStart = 0;
        int rEnd = rows-1;
        int cMid = cols/2;
        // Run the loop till two rows are remaining
        while(rStart<(rEnd-1)){
            int mid = rStart + (rEnd-rStart)/2;
            if(arr[mid][cMid]==target){
                return new int[]{mid,cMid};
            }
            if(arr[mid][cMid]>target){
                rEnd = mid;
            }
            else{
                rStart = mid;
            }
        }
        // Two rows are left
        if(arr[rStart][cMid]==target){
            return new int[] {rStart,cMid};
        }
        if(arr[rStart+1][cMid]==target){
            return new int[] {rStart+1,cMid};
        }
        //1st half
        if(target<=arr[rStart][cMid-1]){
            return binarySearch(arr,rStart,0,cMid-1,target);
        }
        //2nd Half
        if(target>=arr[rStart][cMid+1] && target<=arr[rStart][cols-1]){
            return  binarySearch(arr,rStart,cMid+1,arr[rStart].length-1,target);
        }
        //3rd Half
        if(target<=arr[rStart+1][cMid-1]){
            return binarySearch(arr,rStart+1,0,cMid-1,target);
        }
        // 4th Half
        else{
            return binarySearch(arr,rStart+1,cMid+1,arr[rStart+1].length-1,target);
        }


    }
}
