package com.aditya.Strings;

public class Moves {
    public static void main(String[] args){
        String moves = "UD";
        System.out.println(judgeCircle(moves));
    }
    static boolean judgeCircle(String moves) {
        int v =0;
        int h = 0;
        for(int i=0; i<moves.length();i++){
            if(moves.charAt(i)=='U'){
                v++;
            }
            else if(moves.charAt(i)=='D'){
                v--;
            }
            else if(moves.charAt(i)=='R'){
                h++;
            }
            else{
                h--;
            }

        }

        if(v==0 && h==0){
            return true;
        }
        return false;
    }
}
