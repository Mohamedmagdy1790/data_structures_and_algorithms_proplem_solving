package com.magdy.linkedlist;

public class Main {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.addEnd(30);
        ll.addEnd(70);
        ll.addEnd(50);
        ll.addEnd(90);
        ll.addEnd(100);


        ll.swapHeadAndTail();

        ll.print();


    }
}