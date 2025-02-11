package vectorpac;

import java.util.EmptyStackException;

public class Stack extends  vector {

    int top;
    Stack(int size) {
        super(size);
       top=-1;
    }


      boolean IsEmpty(){
        return top==0;
      }
    void Push(int value){
        this.pushback(value);
        top++;
    }
    int pop(){
       if(IsEmpty()) throw new IndexOutOfBoundsException();
       currnt_pos--;
       top--;
       return  arr[top];
    }

    void print(){
        for(int i=currnt_pos-1; i>=0; i--){
            System.out.println(arr[i]);
        }
    }

    int peek(){
       if(IsEmpty())  throw new IndexOutOfBoundsException();
        return arr[top];
    }


}
