package com.aditya.LinkedList;

public class CircularLL {
    private Node head;
    private Node tail;
    public CircularLL(){
        this.head = null;
        this.tail = null;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        if(head==null){
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        tail.next = node;
        head = node;
    }
    public void display(){
        Node temp = head;
        System.out.print("Head -> ");
        if(head!=null){
            do{
                System.out.print(temp.value+" -> ");
                temp = temp.next;
            }while(temp!=head);
        }
        System.out.println();
    }
    public void delete(int value){
        Node temp = head;
        if(head==null){
            return;
        }
        if(temp.value == value){
            head = head.next;
            tail.next = head;
        }
        do{
            temp = temp.next;
            if(temp.next.value == value){
                temp.next = temp.next.next;
                break;
            }
        }while(temp!=head);

    }
    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }
}
