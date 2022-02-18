package com.aditya.LinkedList;

public class DoublyLL {
    private Node head;
    private Node tail;
    private int size;
    public DoublyLL(){
        this.size =0;
    }
    public class Node{
        private int value;
        private Node next;
        private Node prev;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value,Node next,Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        if(head!=null){
            head.prev = node;
        }
        head = node;
    }
    public void display(){
        Node temp = head;
        Node last = null;
        while(temp != null){
            System.out.print(temp.value+" <-> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("Tail");
        System.out.println("In reverse");
        System.out.print("Tail <-> ");
        while(last != null){
            System.out.print(last.value+" <-> ");
            last = last.prev;
        }
        System.out.println("Head");
        System.out.println();
    }
    public void insertLast(int value){
        if(head==null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        Node last = head;
        while(last.next!=null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        node.next = null;
    }

    public void insertAfter(int value,int element){
        Node node = new Node(element);
        Node temp = head;
        while(temp.value!=value){
            temp = temp.next;
        }
        if(temp== null){
            System.out.println("Element doesn't exit");
            return;
        }
        node.next = temp.next;
        if(temp.next!=null) {
            temp.next.prev = node;
        }
        temp.next = node;
        node.prev = temp;
    }

}
