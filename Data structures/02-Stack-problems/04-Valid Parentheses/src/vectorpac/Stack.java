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

    void display(){
        for (int i = top; i >= 0; i--)
            System.out.println(arr[i]);
    }

    T peek(){
        if(IsEmptystack()) System.out.println("only ibe element in stack");;
        return arr[currnt_pos-1];
    }



    //reverse parnthis to compare them
    char get_open_match(char ch) {
        if (ch == ')')
            return '(';
        if (ch == ']')
            return '[';
        return '{';
    }

    boolean isValid(String string) {
        Stack<Character> stack = new Stack(20);

        char[] arr = string.toCharArray();
        int i = 0;
        int length = arr.length;
        while (length != 0) {

            if (arr[i] == '{' || arr[i] == '(' || arr[i] == '[') {
                stack.push(arr[i]);
            }
            else {

                char a = stack.pop();
                if (a != get_open_match(arr[i]) || stack.IsEmptystack()) return false;
            }
            length--;
            i++;
        }
        return true;
    }
}