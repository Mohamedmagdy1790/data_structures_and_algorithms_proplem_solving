package com.magdy.linkedlist;

public class Main {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.addEnd(6);
        ll.addEnd(10);
        ll.addEnd(8);
        ll.addEnd(15);


        ll.lef_rotate_drmostafa(3);
      // ll.left_rotate(3);
        ll.print();



    }
}