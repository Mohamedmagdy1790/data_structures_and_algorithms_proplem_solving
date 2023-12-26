package com.magdy.linkedlist;


public class Node<T> {
    T value;
    Node next;
    static int count=0;
    Node(T value ){
        this.value=value;
        next=null;

    }



}
