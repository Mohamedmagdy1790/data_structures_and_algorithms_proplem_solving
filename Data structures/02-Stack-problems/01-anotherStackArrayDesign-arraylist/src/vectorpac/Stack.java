package vectorpac;

import java.util.EmptyStackException;

public class Stack extends  vector {

    Stack(int size) {
        super(size);

    }


    boolean IsEmpty(){
        return (currnt_pos-1)==0;
      }

    void Push(int value){
        if(currnt_pos==size){expand();}
        if(currnt_pos>0) {
            //time complexity increase by o(n)
            for(int i=currnt_pos; i>=0; i--){
                arr[i+1]=arr[i];
            }
        }
        arr[0]=value;
        currnt_pos++;
    }

    int pop(){
       if(IsEmpty()) throw new IndexOutOfBoundsException();

        //tim3 complxsity incresae by o(n)
        int temp = arr[0];
        for(int i=0; i<=currnt_pos-1; i++){
            arr[i]=arr[i+1];
        }
        currnt_pos--;
      return temp;
    }

    void printstack(){
        print();
    }

    int peek(){
       if(IsEmpty())  throw new IndexOutOfBoundsException();
        return arr[currnt_pos];
    }


}
