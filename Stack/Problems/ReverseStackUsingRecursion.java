package com.aditya.Stack.Problems;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 1; i < 6; i++) {
            st.push(i*2);
        }
        System.out.println(st);

        System.out.println(reverse(st,new Stack<Integer>()));
    }
    public static Stack<Integer> reverse(Stack<Integer> st,Stack<Integer> st2){
        if(st.empty()){
            return st2;
        }
        int n = st.pop();
        st2.push(n);
        return reverse(st,st2);

    }
}
