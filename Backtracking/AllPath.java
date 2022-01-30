package com.aditya.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPath {
    public static void main(String[] args) {
        boolean[][] arr = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path = new int[arr.length][arr[0].length];
        System.out.println(allpathPrint("",arr, 0,0,path,1 ));
    }
    static ArrayList<String> allpath(String p, boolean[][] arr, int r , int c){
        ArrayList<String> ans = new ArrayList<>();
        if(r==arr.length-1 && c==arr[0].length-1){
            ans.add(p);
            return ans;
        }
        if(!arr[r][c]){
            ArrayList<String> list = new ArrayList<>();
            return list;
        }

        if(arr[r][c]){
            arr[r][c] = false;
        }

        if(c< arr[0].length-1){
            ans.addAll(allpath(p + "R",arr, r , c+1));
        }
        if(r>0){
            ans.addAll(allpath(p+'U',arr,r-1,c));
        }
        if(c>0){
            ans.addAll(allpath(p+"L",arr,r,c-1));
        }
        if(r< arr.length-1){
            ans.addAll(allpath(p + "D",arr, r + 1, c));
        }
        if(!arr[r][c]){
            arr[r][c] = true;
        }
        return ans;

    }

    static ArrayList<String> allpathPrint(String p, boolean[][] arr, int r , int c,int[][] path,int step){
        ArrayList<String> ans = new ArrayList<>();
        if(r==arr.length-1 && c==arr[0].length-1){
            path[r][c]= step;
            for(int[] a :path){
                System.out.println(Arrays.toString(a));
            }
            System.out.println();
            ans.add(p);
            return ans;
        }
        if(!arr[r][c]){
            ArrayList<String> list = new ArrayList<>();
            return list;
        }

        path[r][c] = step;

        arr[r][c] = false;


        if(c< arr[0].length-1){
            ans.addAll(allpathPrint(p + "R",arr, r , c+1,path,step+1));
        }
        if(r>0){
            ans.addAll(allpathPrint(p+'U',arr,r-1,c,path,step+1));
        }
        if(c>0){
            ans.addAll(allpathPrint(p+"L",arr,r,c-1,path,step+1));
        }
        if(r< arr.length-1){
            ans.addAll(allpathPrint(p + "D",arr, r + 1, c,path,step+1));
        }

        arr[r][c] = true;

        path[r][c] = 0;
        return ans;

    }
}
