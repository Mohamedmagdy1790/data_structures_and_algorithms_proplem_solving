package vectorpac;
// vector is creating a dynamic array with some operations

import java.lang.reflect.Array;

public class vector<T> {
    int size;
    int currnt_pos;
    T[] arr;

    vector(int capacity){
        size =capacity;
        currnt_pos=0;
        // arr = new T(size);
        arr = (T[]) Array.newInstance(Object.class, size);
    }
    void set(int index,T value){
        arr[index]=value;
    }
    T get(int index){
        if(index<0 || index>=currnt_pos) throw new IndexOutOfBoundsException();
        return arr[index];
    }

    void pushback(T value){
        if(currnt_pos==size){expand();}
        arr[currnt_pos++]=value;
    }

    void expand(){
        size =size*3;
        T[] arr2 = (T[]) Array.newInstance(Object.class, size);
        for(int i=0; i<currnt_pos; i++){
            arr2[i]=arr[i];
        }
        arr=arr2;
    }

    void print(){
        for(int i=0; i<currnt_pos; i++){
            System.out.println(arr[i]);
        }
    }



    void insert(T value, int index){

        if(currnt_pos==size){

            expand();
        }

        for(int i=currnt_pos; i>index; i--){
            arr[i]=arr[i-1];
        }
        arr[index]=value;
        currnt_pos++;

    }

    void Remove(int index){
        for(int i=index; i<currnt_pos; i++){

            arr[i]=arr[i+1];
        }
        currnt_pos--;
    }



}



