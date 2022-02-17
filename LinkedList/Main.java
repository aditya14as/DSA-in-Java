package com.aditya.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(5);
        list.insertFirst(10);
        list.insertFirst(15);
        list.insertFirst(20);
        list.insertFirst(25);
        list.display();
        list.insertLast(1);
        System.out.println();
        list.display();
        list.insert(3,3);
        System.out.println();
        list.display();
        list.deleteFirst();
        list.display();
//        System.out.println(list.getE(3));
        System.out.println();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println();
        System.out.println(list.delete(2));
        list.display();
        System.out.println();
        System.out.println(list.find(10));
    }
}
