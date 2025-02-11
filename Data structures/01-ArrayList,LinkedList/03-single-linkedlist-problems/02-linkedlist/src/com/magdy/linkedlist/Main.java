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
       //ll.deleteNth(1);
      // ll.deleteNthWihHead(1);
        //delete with key
        ll.deleteWithKey(2);
        ll.print();

        //System.out.println(ll.is_identical(ll2));


        //System.out.println(ll.length);
        //ll.print_reversed(ll.head);
        //System.out.println("lenght right now :"+ll.length);

       // Node g = ll.Getinth_back(3);
        //System.out.println("\n" + g.value);


       /* System.out.println(".....................................");
        System.out.println("try deleting functions :");

        ll.deleteNth(3);
        ll.print();
        ll.deleteNth(9);
        ll.print();
        ll.deleteNth(9);
        ll.print();
        System.out.println("\n.....................................");*/
       // ll.deleteNth(2);
        //System.out.println(ll.head+ " "+ ll.tail);

        //String string=ll.debug_to_string();
        //System.out.println(string);

    }
}