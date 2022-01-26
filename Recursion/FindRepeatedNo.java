package com.aditya.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class FindRepeatedNo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,5,6,7};
        int target = 4;
        System.out.println(findAllIndex2(arr,target,0));
    }
    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index]== target){
            list.add(index);
        }
        return findAllIndex(arr,target,index+1,list);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if(arr[index]== target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls =  findAllIndex2(arr,target,index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}
