package com.aditya.Backtracking;

import java.io.*;
import java.util.*;

public class CrosswordPuzzle {

    public static void solution(char[][] arr, String[] words, int vidx) {
        //write your code here
        if(vidx==words.length){
            print(arr);
            return;
        }
        //write your code here
        String word = words[vidx];
        for(int i =0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]=='-' || arr[i][j] == word.charAt(0)){
                    if(isPlaceHorizontal(arr,words[vidx],i,j)){
                        boolean[] placed=placeHorizontal(arr,words[vidx],i,j);
                        solution(arr,words,vidx+1);
                        removeHorizontal(arr,words[vidx],i,j,placed);
                    }
                    if(isPlaceVertical(arr,words[vidx],i,j)){
                        boolean[] placed= placeVertical(arr,words[vidx],i,j);
                        solution(arr,words,vidx+1);
                        removeVertical(arr,words[vidx],i,j,placed);
                    }
                }
            }
        }

    }

    static boolean isPlaceVertical(char[][] arr, String word,int row,int col){

        if(row-1>=0 && arr[row-1][col] != '+'){
            return false;
        }else if(row+word.length()<arr.length && arr[row+word.length()][col] != '+' ){
            return false;
        }
        for(int i =0; i<word.length();i++){
            if(i+row >= arr.length){
                return false;
            }
            if(arr[row+i][col] != '-' || arr[row+i][col] != word.charAt(i)){
                return false;
            }
        }
        return true;
    }

    static boolean[] placeVertical(char[][] arr,String word,int row,int col){
        boolean[] placed = new boolean[word.length()];
        for(int i=0; i< word.length(); i++){
            if(arr[row+i][col] == '-'){
                arr[row+i][col]= word.charAt(i);
                placed[i] = true;
            }
        }
        return placed;
    }

    static void removeVertical(char[][] arr,String word, int row,int col,boolean[] placed){
        for(int i =0; i<placed.length; i++){
            if(placed[i]){
                arr[row+i][col]= '-';
            }
        }
    }

    static boolean isPlaceHorizontal(char[][] arr, String word,int row,int col){
        if(col-1>=0 && arr[row][col-1] != '+'){
            return false;
        }else if(col+word.length()<arr[0].length && arr[row][col+word.length()] != '+' ){
            return false;
        }
        for(int i =0; i<word.length();i++){
            if(i+col >= arr[0].length){
                return false;
            }
            if(arr[row][col+i] != '-' || arr[row][col+i] != word.charAt(i)){
                return false;
            }
        }
        return true;
    }

    static boolean[] placeHorizontal(char[][] arr,String word,int row,int col){
        boolean[] placed = new boolean[word.length()];
        for(int i=0; i<word.length(); i++){
            if(arr[row][col+i] == '-'){
                arr[row][col+i]= word.charAt(i);
                placed[i] = true;
            }
        }
        return placed;
    }

    static void removeHorizontal(char[][] arr,String word, int row,int col,boolean[] placed){
        for(int i =0; i<placed.length; i++){
            if(placed[i]){
                arr[row][col+i]= '-';
            }
        }
    }


    public static void print(char[][] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = 0 ; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[][]{
                {'-','-','-','+'},
                {'-','-','-','+'},
                {'-','-','-','+'}

        };
//        for (int i = 0 ; i < arr.length; i++) {
//            String str = scn.next();
//            arr[i] = str.toCharArray();
//        }
//        int n = scn.nextInt();
//        String[] words = new String[n];
//        for (int i = 0 ; i  < words.length; i++) {
//            words[i] = scn.next();
//        }
        String[] words = new String[]{"CAT","SEE","DOG"};
        solution(arr, words, 0);
    }
}
