package com.magdy.linkedlist;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.add(2);
        ll.add(4);
        ll.add(10);
        ll.add(5);

        ll.swapPairs();
        ll.print();


    }
}