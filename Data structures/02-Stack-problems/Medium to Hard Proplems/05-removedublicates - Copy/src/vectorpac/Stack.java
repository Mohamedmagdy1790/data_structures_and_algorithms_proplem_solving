package vectorpac;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Stack<T> extends  vector<T> {

    int top;
    public Stack(int size) {
        super(size);
        top=-1;

    }


    boolean IsEmptystack(){
        return top==-1;
    }
    void push(T value){
        top++;
        this.pushback(value);

    }
    T pop(){
        if((IsEmptystack())){throw new RuntimeException("stack is empty");}
        currnt_pos--;
        return  arr[top--];
    }

    public void display(){
        for (int i = top; i >= 0; i--)
            System.out.println(arr[i]);
    }

    T peek(){
        if(IsEmptystack()) System.out.println("only ibe element in stack");;
        return arr[currnt_pos-1];
    }

    Boolean isFull() {
        return top == size - 1;
    }





}