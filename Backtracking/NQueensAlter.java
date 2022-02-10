package com.aditya.Backtracking;

public class NQueensAlter {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        boolean[] col = new boolean[n];
        boolean[] nd = new boolean[2*n-1];
        boolean[] rd = new boolean[2*n-1];
        System.out.println(queens(board,col,nd,rd,0));
    }
    static int queens(boolean[][] board,boolean[] col,boolean[] nd, boolean[] rd,int row){

        if(row==board.length){
            return 1;
        }
        int ans =0;
        for(int cols = 0; cols<board.length; cols++){
            if(board[row][cols]==false && col[cols]==false && nd[row+cols]==false && rd[row-                                                         cols+board.length-1]==false){
                board[row][cols]=true;
                col[cols]= true;
                nd[row+cols]= true;
                rd[row-cols+board.length-1]=true;
                ans = ans+queens(board,col,nd,rd,row+1);
                board[row][cols]=false;
                col[cols]=false;
                nd[row+cols]= false;
                rd[row-cols+board.length-1]=false;
            }
        }
        return ans;
    }
}
