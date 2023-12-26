package com.magdy.linkedlist;
//we can add Linked lsit object aslo instead of inhrting it
public class Stack extends LinkedList{

    Stack(){ super();}

    void push(int value){
        addfront(value);
    }

    int pop(){
        int deletedValue=this.head.value;
        deleteFirst();
        return deletedValue ;
    }

    int peek(){
        if(isEmpty()) throw new IndexOutOfBoundsException();
        return this.head.value;
    }

    void printstack(){
        print();
    }

    boolean isEmpty(){
        return head==null;
    }



}
