package com.aditya.Stack;

public class StackMain {
    public static void main(String[] args) throws Exception {
//        CustomStack stack = new CustomStack(5);
//        stack.push(54);
//        stack.push(53);
//        stack.push(92);
//        stack.push(27);
//        stack.push(32);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        CustomStack stack = new DynamicStack(5);
        stack.push(54);
        stack.push(53);
        stack.push(92);
        stack.push(27);
        stack.push(32);
        stack.push(21);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
