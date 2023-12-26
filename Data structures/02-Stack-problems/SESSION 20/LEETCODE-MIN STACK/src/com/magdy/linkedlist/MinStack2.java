package com.magdy.linkedlist;


import java.util.Stack;

public class MinStack2 {
Stack stack;
Stack min_stk;

    MinStack2(){
        stack =new java.util.Stack<>();
        min_stk=new java.util.Stack<>();
    }

    void push(int value){
        stack.push(value);

        if(min_stk.isEmpty()) min_stk.push(value);
        else  min_stk.push(Math.min(value, (Integer) min_stk.peek()));
    }

    void pop(){

        stack.pop();
        min_stk.pop();
    }

    int getMin(){
        return (int) min_stk.peek();
    }

    int top() {
        return (int) stack.peek();
    }
}
