package com.magdy.linkedlist;

import javax.management.RuntimeErrorException;

public class Stack<T> extends LinkedList{

    Stack(){ super();}

    void push(T value){
        addfront(value);
    }

    T pop(){
        if(isEmpty()) throw new RuntimeException("stack is empty POP");
        T deletedValue=(T)head.value;
        deleteFirst();
        return deletedValue ;
    }

    T peek(){
        if(isEmpty()) throw new RuntimeException("stack is empty");
        return (T)head.value;
    }

    void printstack(){
        print();
    }

    boolean isEmpty(){
        return head==null;
    }



}
