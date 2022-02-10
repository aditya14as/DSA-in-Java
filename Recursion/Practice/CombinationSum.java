package com.aditya.Recursion.Practice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<Integer> set = new ArrayList<>();
        helper(candidates,0,set,target);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
    static void helper(int[] arr, int i, List<Integer> set, int target){
        if(i>=arr.length || target<0){
            return;
        }
        if(target==0){
            List<Integer> list = new ArrayList<>();
            list.addAll(set);
            ans.add(list);
            return;
        }
        if(arr[i]<=target){
            set.add(arr[i]);
            helper(arr,i,set,target-arr[i]);
            set.remove(set.size()-1);
        }
        helper(arr,i+1,set,target);

    }
}
