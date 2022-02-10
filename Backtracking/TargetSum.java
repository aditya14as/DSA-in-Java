package com.aditya.Backtracking;

import java.util.ArrayList;
import java.util.List;



public class TargetSum {
    static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        int[] cand = {10,20,30};
        int target = 30;
        int[] arr = new int[cand.length];
        ArrayList<Integer> p = new ArrayList<>();
        combination(cand,0,p,target,0);
//        for (int i = 0; i < ans.size(); i++) {
//            System.out.println(ans.get(i));
//        }
    }
    static void combination(int[] arr,int i,ArrayList<Integer> set, int target,int sum) {
        if(i==arr.length){
            if(target==sum){
                System.out.println(set);
            }
            return;
        }

        combination(arr,i+1,set,target,sum);
        int n = arr[i];
        set.add(n);
        combination(arr,i+1,set,target,sum+arr[i]);
        set.remove(set.size()-1);
    }



}
