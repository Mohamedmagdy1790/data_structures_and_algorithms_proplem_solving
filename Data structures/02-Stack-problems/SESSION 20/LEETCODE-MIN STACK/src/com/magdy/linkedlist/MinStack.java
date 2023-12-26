package com.magdy.linkedlist;

public class MinStack {
    Stack stack;
    Stack min_stk;
    MinStack(){
         stack =new Stack();
         min_stk=new Stack();
    }

    void push(int value){
        stack.push(value);

        if(min_stk.head==null) min_stk.push(value);
        else  min_stk.push(Math.min(value,min_stk.peek()));
    }

    void pop(){

        stack.pop();
        min_stk.pop();
    }

    int getMin(){
        return  min_stk.head.value;
    }

    int top() {
        return stack.peek();
    }
}
