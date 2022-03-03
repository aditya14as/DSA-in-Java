package com.aditya.Stack.Problems;

import java.util.Stack;

public class InsertElementAtBottom {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 1; i < 6; i++) {
            st.push(i*2);
        }
        System.out.println(st);
        insert(st,st.size(),100,0);
        System.out.println(st);
    }
    public static void insert(Stack<Integer> st,int size,int n,int count){
        if(count==size){
            st.push(n);
            return;
        }
        int x = st.pop();
        insert(st,size,n,count+1);
        st.push(x);
    }
}
