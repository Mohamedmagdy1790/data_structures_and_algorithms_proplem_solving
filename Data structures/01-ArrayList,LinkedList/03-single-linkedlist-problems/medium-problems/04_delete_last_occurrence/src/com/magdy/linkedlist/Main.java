package com.magdy.linkedlist;

public class Main {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.addEnd(7);
        ll.addEnd(2);
        ll.addEnd(1);
        ll.addEnd(3);
        ll.addEnd(2);
        ll.addEnd(6);
        ll.addEnd(6);
        ll.addEnd(7);


        ll.removeLastOccurance(7);
        ll.print();








    }
}