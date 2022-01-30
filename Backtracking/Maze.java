package com.aditya.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(mazePathRet("",3,3));
//        mazePathDiagonal("",3,3);
       boolean[][] arr = {
               {true,true,true},
               {true,false,true},
               {true,true,true}
       };
        System.out.println(pathRestrictions("",arr, 0,0 ));
    }
    static int maze(int r , int c ) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int right = maze(r - 1, c);
        int left = maze(r, c - 1);
        return left + right;
    }
    static void mazePath(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(c>1){
            mazePath(p+"R", r,c-1);
        }
        if(r>1){
            mazePath(p+"D",r-1,c);
        }
    }
    static ArrayList<String> mazePathRet(String p, int r, int c){
        ArrayList<String> ans = new ArrayList<>();
        if(r==1 && c==1){
            ans.add(p);
            return ans;
        }
        if(c>1){
             ans.addAll(mazePathRet(p+"R", r,c-1));
        }
        if(r>1) {
            ans.addAll(mazePathRet(p + "D", r - 1, c));
        }
        return ans;
    }

    static void mazePathDiagonal(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(c>1){
            mazePathDiagonal(p+"H", r,c-1);
        }
        if(c>1 && r>1){
            mazePathDiagonal(p+"D",r-1,c-1);
        }
        if(r>1){
            mazePathDiagonal(p+"V",r-1,c);
        }
    }

    static ArrayList<String> pathRestrictions(String p,boolean[][] arr,int r , int c){
        ArrayList<String> ans = new ArrayList<>();
        if(r==arr.length-1 && c==arr[0].length-1){
            ans.add(p);
            return ans;
        }
        if(!arr[r][c]){
            ArrayList<String> list = new ArrayList<>();
            return list;
        }
        if(c< arr[0].length-1){
            ans.addAll(pathRestrictions(p + "R",arr, r , c+1));
        }

        if(r< arr.length-1){
            ans.addAll(pathRestrictions(p + "D",arr, r + 1, c));
        }
        return ans;
    }
}
