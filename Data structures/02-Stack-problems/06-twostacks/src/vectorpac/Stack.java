package vectorpac;

import java.util.EmptyStackException;

public class Stack extends  vector {

    int top1;
    int top2;
    Stack(int size) {
        super(size);
       top1=-1;
       top2=size;
    }

      boolean isFull() {
        return (top1+1) ==top2;
    }
      boolean IsEmpty(int id){
        if(id==1)return top1==-1;
          return  top2==size;
      }

    void Push(int id,int value){
       if(isFull())throw new RuntimeException("cant push stack is full");

        if(id==1) {
            arr[++top1] = value;
        }
        else if(id==2){

            arr[--top2]=value;
        }

    }


    int pop(int id){
        if(IsEmpty(id)) throw new RuntimeException("stack is empty we cant pop");
        if(id==1) {
            return arr[top1--];
        }
        else if(id == 2){

            return arr[top2++];
        }
        return 0;
    }

    void print(int id){
        if(id==1){
            for(int i=top1; i>=0; i--){
                System.out.printf(arr[i]+" ");
            }
            System.out.println();
        }
        else if (id==2) {
            for(int i=top2; i<size; i++){
                System.out.printf(arr[i]+" ");
            }
        }

    }
   int peek(int id){
       if(IsEmpty(id))  throw new RuntimeException("SORRY NO ITEMS TO SHOW THE PEEK");
        if(id ==1)return arr[top1];
        return arr[top2];
    }


}
