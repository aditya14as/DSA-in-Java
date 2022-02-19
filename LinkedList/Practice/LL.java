package com.aditya.LinkedList.Practice;

import com.aditya.LinkedList.LinkedList;

public class LL {
    private Node head;
    private int size;
    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }
    public LL(){
        this.head = null;
        this.size = 0;
    }
    public void display(){
        LL.Node temp = head;
        System.out.print("Head -> ");
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("Tail");
    }
    public void insertFirst(int value){
        LL.Node n = new LL.Node(value);
        n.next = head;
        head = n;
        size = size+1;
    }
    public void insertRec(int value,int index){
        head = insertRec(value,index,head);
    }
    public Node insertRec(int value,int index, Node node){
        if(index == 0){
            Node n = new Node(value);
            n.next = node;
            size++;
            return n;
        }
        node.next = insertRec(value,index-1,node.next);
        return node;
    }
}
