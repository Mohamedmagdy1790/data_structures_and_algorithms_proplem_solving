package com.magdy.linkedlist;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {



   MinStack minStack =new MinStack();

   minStack.push(4);
   minStack.push(7);
  // minStack.push(3);
   minStack.push(10);


        MinStack2 minStack2 =new MinStack2();

        minStack2.push(4);
        minStack2.push(7);
       // minStack2.push(3);
        minStack2.push(10);


        System.out.println(minStack.getMin());
        System.out.println(minStack2.getMin());

























    }
}