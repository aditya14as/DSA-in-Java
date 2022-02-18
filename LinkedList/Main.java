package com.aditya.LinkedList;

public class Main {
    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.insertFirst(5);
//        list.insertFirst(10);
//        list.insertFirst(15);
//        list.insertFirst(20);
//        list.insertFirst(25);
//        list.display();
//        list.insertLast(1);
//        System.out.println();
//        list.display();
//        list.insert(3,3);
//        System.out.println();
//        list.display();
//        list.deleteFirst();
//        list.display();
//        System.out.println(list.getE(3));
//        System.out.println();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println();
//        System.out.println(list.delete(2));
//        list.display();
//        System.out.println();
//        System.out.println(list.find(10));
//        DoublyLL list = new DoublyLL();
//        list.insertFirst(5);
//        list.insertFirst(10);
//        list.insertFirst(15);
//        list.insertFirst(20);
//        list.display();
//        list.insertLast(13);
//        list.display();
//        list.insertAfter(13,18);
//        list.display();
        CircularLL list = new CircularLL();
        list.insertFirst(5);
        list.insertFirst(10);
        list.insertFirst(12);
        list.insertFirst(14);
        list.insertFirst(15);
        list.display();
        list.delete(12);
        list.display();
    }
}
